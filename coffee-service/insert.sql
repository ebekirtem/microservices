DO $$
DECLARE
    employee_first_names TEXT[] := ARRAY['John', 'Jane', 'Mike', 'Emily', 'Alice', 'Bob', 'David', 'Sarah', 'Chris', 'Megan'];
    employee_last_names TEXT[] := ARRAY['Doe', 'Smith', 'Johnson', 'Davis', 'Williams', 'Brown', 'Miller', 'Wilson', 'Taylor', 'Anderson'];
    positions TEXT[] := ARRAY['Developer', 'Manager', 'Designer', 'Analyst', 'Consultant', 'Administrator', 'Engineer', 'Architect', 'Director', 'Specialist'];

    random_first_name TEXT;
    random_last_name TEXT;
    random_position TEXT;
    random_salary NUMERIC(10,2);
BEGIN
    FOR i IN 1..1000000 LOOP  -- 1.000.000 kayıt ekleyecek.
        -- Havuzdan rastgele bir isim, soyisim ve pozisyon seç
        random_first_name := employee_first_names[(random() * array_length(employee_first_names, 1) + 1)::INT];
        random_last_name := employee_last_names[(random() * array_length(employee_last_names, 1) + 1)::INT];
        random_position := positions[(random() * array_length(positions, 1) + 1)::INT];

        -- 3000 ile 8000 arasında rastgele bir maaş oluştur
        random_salary := round((random() * 5000 + 3000)::numeric, 2);

        -- Veri ekle
        INSERT INTO employees (id, first_name, last_name, position, salary)
        VALUES (gen_random_uuid(), random_first_name, random_last_name, random_position, random_salary);
    END LOOP;
END $$;
