<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:urn="urn:SOAPAPI">
    <soapenv:Header/>
    <soapenv:Body>
        <urn:login>
            <userName>${USER_NAME}</userName>
            <password>${PASSWORD}</password>
        </urn:login>
    </soapenv:Body>
</soapenv:Envelope>