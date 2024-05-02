CREATE OR REPLACE PACKAGE SAC_BRG_IF_PKG
    AUTHID CURRENT_USER
AS

    --OPR302 : Freight Accrual SAKUARA Monthly I/F
    --Run through EAI from SKUARA on 3WD
    PROCEDURE SAC_FRT_ACCL_IF_PRC
    (
            EXE_YYYYMM      IN  VARCHAR2
        ,   OUT_YN          OUT VARCHAR2
        ,   OUT_RESULT      OUT VARCHAR2
    );

    --OPR303 : Freight Deferral SAKUARA Monthly I/F
    --Run through EAI from SKUARA on 3WD
    PROCEDURE SAC_FRT_DEFR_IF_PRC
    (
            EXE_YYYYMM      IN  VARCHAR2
        ,   OUT_YN          OUT VARCHAR2
        ,   OUT_RESULT      OUT VARCHAR2
    );

    --OPR304 : Freight Deferral Report Monthly SAKUARA I/F
    --Run through EAI from SKUARA on 3WD
    PROCEDURE SAC_FRT_DEFR_RPT_IF_PRC
    (
            EXE_YYYYMM      IN  VARCHAR2
        ,   OUT_YN          OUT VARCHAR2
        ,   OUT_RESULT      OUT VARCHAR2
    );

    --OPR306 : Cost Accrual SAKUARA Monthly I/F
    --Run through EAI from SKUARA on 3WD
    PROCEDURE SAC_COST_ACCL_IF_PRC
    (
            EXE_YYYYMM      IN  VARCHAR2
        ,   OUT_YN          OUT VARCHAR2
        ,   OUT_RESULT      OUT VARCHAR2
    );

    --OPR309 : Freight Accrual Detail Monthly SAKUARA I/F
    --Run through EAI from SKUARA on 3WD
    PROCEDURE SAC_FRT_ACCL_DTL_IF_PRC
    (
            EXE_YYYYMM      IN  VARCHAR2
        ,   OUT_YN          OUT VARCHAR2
        ,   OUT_RESULT      OUT VARCHAR2
    );

    --OPR310 : Freight Deferral Detail Monthly SAKUARA I/F
    --Run through EAI from SKUARA on 3WD
    PROCEDURE SAC_FRT_DEFR_DTL_IF_PRC
    (
            EXE_YYYYMM      IN  VARCHAR2
        ,   OUT_YN          OUT VARCHAR2
        ,   OUT_RESULT      OUT VARCHAR2
    );

    FUNCTION GET_AMT_PRECISION
    (
            pi_curr_cd      IN  VARCHAR2
    ) RETURN NUMBER;

    FUNCTION GET_DAYS_CALC
    (
            pi_to_dt        IN  DATE
        ,   pi_fm_dt        IN  DATE
    ) RETURN NUMBER;
    
    FUNCTION GET_DTX_DIR_CD
    (
            pi_slan_cd      IN VARCHAR2
        ,   pi_vvd_cd       IN VARCHAR2
    )   RETURN VARCHAR2;

    FUNCTION GET_PERIOD_CLS_FLG
    (
            pi_mdl_cd       IN VARCHAR2
        ,   pi_prd_yrmon    IN VARCHAR2
    )   RETURN VARCHAR2;

    FUNCTION GET_STMT_CD_CONV
    (
            pi_conv_tp      IN VARCHAR2
        ,   pi_src_cd       IN VARCHAR2
    )   RETURN VARCHAR2;

    PROCEDURE INSERT_TMP_FRT_ACCL
    (
            pi_doc_dt       IN  VARCHAR2
        ,   pi_div_seq      IN  NUMBER
        ,   pi_frt_accl_r   IN  SAC_FRT_ACCL_IF%ROWTYPE
    );

    PROCEDURE INSERT_TMP_FRT_DEFR
    (
            pi_doc_dt       IN  VARCHAR2
        ,   pi_div_seq      IN  NUMBER
        ,   pi_frt_defr_r   IN  SAC_FRT_DEFR_IF%ROWTYPE
    );

    PROCEDURE INSERT_TMP_CST_ACCL
    (
            pi_doc_dt       IN  VARCHAR2
        ,   pi_div_seq      IN  NUMBER
        ,   pi_cst_accl_r   IN  SAC_COST_ACCL_IF%ROWTYPE
    );

END SAC_BRG_IF_PKG;
/
CREATE OR REPLACE PACKAGE BODY SAC_BRG_IF_PKG
AS
    --OPR302 : Freight Accrual SAKUARA Monthly I/F
    --Run through EAI from SKUARA on 3WD
    PROCEDURE SAC_FRT_ACCL_IF_PRC
    (
            EXE_YYYYMM      IN  VARCHAR2
        ,   OUT_YN          OUT VARCHAR2
        ,   OUT_RESULT      OUT VARCHAR2
    )
    IS
        V_LINE_CNT_SET      NUMBER          :=  700;      --Restriction to have number of lines in 1 sequence no more than 700 lines
        J_PRCS              NUMBER          :=  SAC_BRG_IF_PKG.GET_AMT_PRECISION('JPY');
        U_PRCS              NUMBER          :=  SAC_BRG_IF_PKG.GET_AMT_PRECISION('USD');
        CUR_MON             DATE            :=  TO_DATE(EXE_YYYYMM, 'YYYYMM');
        V_PRM               VARCHAR2(6)     :=  TO_CHAR(ADD_MONTHS(CUR_MON, -1), 'YYYYMM');
        V_PRM_E             VARCHAR2(8)     :=  TO_CHAR(LAST_DAY(ADD_MONTHS(CUR_MON, -1)), 'YYYYMMDD');
        V_PRC_NM            VARCHAR2(50)    :=  'SAC_FRT_ACCL_IF_PRC';
        MOD_NAME            VARCHAR2(10)    :=  'ACCRUAL';
      --REVGL               VARCHAR2(20)    :=  '7001000000';   --Freight-Container     : Credit Account Number
        RECGL               VARCHAR2(20)    :=  '5060000000';   --Outstanding Freight   : Debit Account Number
        SUPGL               VARCHAR2(20)    :=  '540ZZ00000';   --Suspence Account Number
        
        DIV_SEQ             NUMBER          :=  0;
        TMP_SEQ             NUMBER          :=  0;
        TTL_SEQ             NUMBER          :=  0;

        USER_CALL_EX        EXCEPTION;
        FRT_ACCL_R          SAC_FRT_ACCL_IF%ROWTYPE;
    BEGIN
        --check whether AR period is open or not
        IF GET_PERIOD_CLS_FLG('AR', V_PRM) = 'N' THEN
            OUT_RESULT := V_PRM || ' AR Period still open.';
            RAISE USER_CALL_EX;
        END IF;
        
        -- Uploaded Data Dup Delete
        DELETE  FROM SAC_FRT_ACCL_IF WHERE DOC_DT = V_PRM_E;        
        COMMIT;

        --Divding seqNo setup data Temp insert...
        ---------------------------------------------------------------------------------------------------------------------------------
        FOR L_FRT_ACCL IN 
        (
            SELECT  XXX_5.*
              --,   DENSE_RANK()      OVER (PARTITION BY CMP,DTP,CUR ORDER BY CMP,DTP,CUR,GRP_NM,GRP_DIV_SQ)   AS TMPSQ_5
                ,   LAG(GRP_DIV_SQ,1) OVER (PARTITION BY CMP,DTP,CUR ORDER BY CMP,DTP,CUR,GRP_NM,GRP_DIV_SQ)   AS BF_GRP_DIV_SQ          
            FROM
            (
                SELECT  XXX_4.*
                    ,   DENSE_RANK() OVER (PARTITION BY CMP,DTP,CUR,GRP_NM ORDER BY CEIL(GRP_SQ/V_LINE_CNT_SET)) AS GRP_DIV_SQ
                FROM
                (
                    SELECT  XXX_3.*
                        ,   ROW_NUMBER() OVER (PARTITION BY CMP,DTP,CUR,GRP_NM ORDER BY RWSQ    )   AS GRP_SQ
                        ,   COUNT(*)     OVER (PARTITION BY CMP,DTP,CUR,GRP_NM ORDER BY GRP_NM  )   AS GRP_CT
                    FROM
                    (
                        SELECT  XXX_2.*
                            ,   DECODE(SAMT,0,TMPSQ, TMPSQ+1) AS GRP_NM
                        FROM
                        (
                            SELECT  XXX_1.*
                                ,   LAG(SAMT,1)             OVER (PARTITION BY CMP,DTP,CUR ORDER BY RWSQ) AS BAMT          
                                ,   SUM(DECODE(SAMT,0,1,0)) OVER (PARTITION BY CMP,DTP,CUR ORDER BY RWSQ) AS TMPSQ
                            FROM
                            (
                                SELECT  XXX.*
                                    ,   SUM(DECODE(TX,NULL,-1,1)*DAMT) OVER (PARTITION BY CMP,DTP,CUR ORDER BY RWSQ) AS SAMT
                                FROM
                                (
                                    SELECT  ROW_NUMBER() OVER (PARTITION BY CMP,DTP,CUR ORDER BY CMP,DTP,CUR,CTRN,PSK,TX,CTR,GLA,CUSN,PTR,AACT,IKY1,IKY2,CTRN,APL,ADT,VSL,VVL,BZRF) AS RWSQ
                                        ,   CMP     AS CMP  ,   DTP     AS DTP  ,   CUR     AS CUR  ,   CTRN    AS CTRN ,   PSK         AS PSK     
                                        ,   TX      AS TX   ,	CTR     AS CTR	,	GLA     AS GLA  ,   CUSN    AS CUSN ,	PTR         AS PTR	
                                        ,	AACT    AS AACT ,   IKY1    AS IKY1 ,   IKY2    AS IKY2 ,   CTRN    AS CTRN1,	APL         AS APL
                                        ,	ADT     AS ADT  ,	VSL     AS VSL  ,	VVL     AS VVL  ,	BZRF    AS BZRF ,   SUM(LAMT)   AS LAMT, SUM(DAMT) AS DAMT            
                                    FROM
                                    (
                                        SELECT 	'1000'                                                  AS  CMP  
                                            ,   'HA'                                                    AS  DTP  
                                            ,   CURR_CD                                                 AS  CUR  
                                            ,   ''                                                      AS  IKY1    
                                            ,   ''                                                      AS  IKY2 
                                            ,   CUST_NUM                                                AS  CTRN 
                                            ,   LOCL_AMT                                                AS  LAMT 
                                            ,   DOCU_AMT                                                AS  DAMT        
                                            , 	DECODE(L, '1','01'    	,   '50'                    )   AS  PSK                        
                                            , 	DECODE(L, '1',NULL    	,   TAX_CD                  )   AS  TX        
                                            , 	DECODE(L, '1',NULL    	,   PFIT_CTR                )   AS  CTR                        
                                            , 	DECODE(L, '1',NULL    	,   GL_ACT                  )   AS  GLA
                                            ,   DECODE(L, '1',CUST_NUM	,   NULL                    )   AS  CUSN                  
                                            , 	DECODE(L, '1',NULL    	,   PFIT_CTR                )   AS  PTR                      
                                            , 	DECODE(L, '1',RECGL   	,   NULL                    )   AS  AACT      
                                            , 	DECODE(L, '1',PFIT_CTR	,   NULL                    )   AS  BZRF          
                                            , 	DECODE(L, '1',NULL    	,   ACT_PLC                 )   AS  APL                     
                                            , 	DECODE(L, '1',NULL    	,   SUBSTR(ACT_DT,1,6)||'01')   AS  ADT                      
                                            , 	DECODE(L, '1',NULL    	,   DX_VSL                  )   AS  VSL                             
                                            , 	DECODE(L, '1',NULL      ,   DX_VSL||DX_VOY||DX_DIR  )   AS  VVL                                
                                        FROM
                                        (
                                            SELECT  X.CURR_CD                                                                               AS  CURR_CD
                                                ,   CASE WHEN SUBSTR(POL_CD,1,2)='JP' OR SUBSTR(POD_CD,1,2)='JP' THEN 'B0' ELSE 'D0' END    AS  TAX_CD
                                                ,   ROUND(X.LOCL_AMT    , J_PRCS   )	                                                    AS  LOCL_AMT
                                                ,   ROUND(X.TJ_AMT      , U_PRCS    )                                                       AS  DOCU_AMT
                                                ,   (SELECT MODI_COST_CTR_CD FROM MDM_TRADE MT WHERE MT.TRD_CD = X.TRD_CD)                  AS  PFIT_CTR
                                                ,   X.IF_CUST_CD                                                                            AS  CUST_NUM
                                                ,   (SELECT MODI_LOC_CD FROM MDM_LOCATION WHERE LOC_CD = X.POL_CD)                          AS  ACT_PLC
                                                ,   TO_CHAR(X.POL_ETD_DT, 'YYYYMMDD')                                                       AS  ACT_DT
                                                ,   (SELECT MODI_VSL_CD FROM MDM_VSL_CNTR WHERE VSL_CD = SUBSTR(X.VVD_CD,1,4))              AS  DX_VSL
                                                ,   SUBSTR(X.VVD_CD,6,3)                                                                    AS  DX_VOY
                                                ,   SAC_BRG_IF_PKG.GET_DTX_DIR_CD(X.SLAN_CD, X.VVD_CD)                                      AS  DX_DIR
                                                ,   X.GL_ACCT_NO                                                                            AS  GL_ACT                                
                                            FROM    SAC_FRT_ACCL_PRE_IF X
                                            WHERE   EXE_YRMON   = V_PRM                                             --Accrual data that extracted by ETL Job in monthly    
                                              AND   POL_ETD_DT <= TO_DATE(V_PRM_E||'235959', 'YYYYMMDDHH24MISS')    --sailing date <= EndofMonth
                                        ) A, (SELECT LEVEL AS L FROM DUAL CONNECT BY LEVEL <= 2) B
                                    )
                                    GROUP BY CMP,DTP,CUR,CTRN,PSK,TX,CTR,GLA,CUSN,PTR,AACT,IKY1,IKY2,CTRN,APL,ADT,VSL,VVL,BZRF 
                                ) XXX
                            ) XXX_1
                        ) XXX_2
                    ) XXX_3
                ) XXX_4
            ) XXX_5
            ORDER BY CMP,DTP,CUR,RWSQ
        ) 
        LOOP
            IF L_FRT_ACCL.RWSQ = 1 THEN
                DIV_SEQ := DIV_SEQ + 1;
                TMP_SEQ := 1;
                TTL_SEQ := 0;
            ELSE
                IF L_FRT_ACCL.SAMT = 0 THEN
                    IF TMP_SEQ > V_LINE_CNT_SET THEN    --If Total Cnt of Dr&Cr Relation set > LineSetCnt Then Next SeqNo. Dividing
                        DIV_SEQ := DIV_SEQ + 1;
                        TMP_SEQ := 1;
                        TTL_SEQ := 0;
                    ELSE
                        NULL;
                    END IF;
                ELSE
                    IF L_FRT_ACCL.BAMT = 0 THEN     -- Dr&Cr Set of previous is End 
                        IF TTL_SEQ+L_FRT_ACCL.GRP_CT > V_LINE_CNT_SET THEN  -- If Count of Previous Dr&Cr Relation Set + Count of Current Dr&Cr Set > LineSetCnt Then Next SeqNo. Divding
                            DIV_SEQ := DIV_SEQ + 1;
                            TMP_SEQ := 1;
                            TTL_SEQ := 0;
                        ELSE
                            IF L_FRT_ACCL.GRP_DIV_SQ < L_FRT_ACCL.BF_GRP_DIV_SQ THEN --Previous 차대변 set의 라인설정값에 걸려 다음 SeqNo로 분리된 row와 현재 차대변 set와는 분리한다,
                                DIV_SEQ := DIV_SEQ + 1;
                                TMP_SEQ := 1;
                                TTL_SEQ := 0;
                            END IF;
                        END IF;
                    ELSE
                        IF TMP_SEQ > V_LINE_CNT_SET THEN    --If Dr&Cr Relation Set of Current > LineSetCnt then Next SeqNo. Dividing
                            DIV_SEQ := DIV_SEQ + 1;
                            TMP_SEQ := 1;
                            TTL_SEQ := 0; 
                        END IF;
                    END IF;
                END IF;
            END IF;
            
            --INSERT Statment...
            FRT_ACCL_R.ACCT_CO_CD               :=  L_FRT_ACCL.CMP;
            FRT_ACCL_R.IF_DOC_TP_CD             :=  L_FRT_ACCL.DTP;
            FRT_ACCL_R.CURR_CD               	:=  L_FRT_ACCL.CUR;     
            FRT_ACCL_R.CTRT_NO                  :=  L_FRT_ACCL.CTRN; 
            FRT_ACCL_R.PST_KEY_CD               :=  L_FRT_ACCL.PSK;      
            FRT_ACCL_R.VAT_TAX_CD               :=  L_FRT_ACCL.TX;       
            FRT_ACCL_R.COST_CTR_CD              :=  L_FRT_ACCL.CTR;  
            FRT_ACCL_R.GL_ACCT_NO               :=  L_FRT_ACCL.GLA;  
            FRT_ACCL_R.CUST_NO                  :=  L_FRT_ACCL.CUSN; 
            FRT_ACCL_R.PFITCTR_CD               :=  L_FRT_ACCL.PTR; 
            FRT_ACCL_R.ALTN_ACCT_NO             :=  L_FRT_ACCL.AACT; 
            FRT_ACCL_R.ACT_PLC_CD               :=  L_FRT_ACCL.APL;  
            FRT_ACCL_R.ACT_DT                   :=  L_FRT_ACCL.ADT;   
            FRT_ACCL_R.VSL_CD                   :=  L_FRT_ACCL.VSL;      
            FRT_ACCL_R.VVL_CD                   :=  L_FRT_ACCL.VVL;     
            FRT_ACCL_R.BIZ_PRNR_REF_KEY_CD1     :=  L_FRT_ACCL.BZRF;  
            FRT_ACCL_R.LOCL_AMT                 :=  L_FRT_ACCL.LAMT; 
            FRT_ACCL_R.DOC_AMT                  :=  L_FRT_ACCL.DAMT;
            
            INSERT_TMP_FRT_ACCL(pi_doc_dt => V_PRM_E, pi_div_seq => DIV_SEQ, pi_frt_accl_r => FRT_ACCL_R);

            TMP_SEQ := TMP_SEQ +1;
            TTL_SEQ := TTL_SEQ +1;
        END LOOP; 
        ---------------------------------------------------------------------------------------------------------------------------------------------------

        ---------------------------------------------------------------------------------------------------------------------------------------------------
        INSERT INTO SAC_FRT_ACCL_IF
        (
                FRT_IF_SEQ              --1
            ,   IF_SEQ_NO
            ,   ACCT_CO_CD
            ,   IF_DOC_TP_CD
            ,   DOC_DT                  --5
            ,   PST_DT
            ,   REF_DOC_NO
            ,   DOC_HDR_CD
            ,   CURR_CD
            ,   PST_KEY_CD              --10
            ,   VAT_TAX_CD
            ,   LOCL_AMT
            ,   DOC_AMT
            ,   COST_CTR_CD
            ,   GL_ACCT_NO              --15
            ,   CUST_NO
            ,   PFITCTR_CD
            ,   ALTN_ACCT_NO
            ,   BIZ_PRNR_REF_KEY_CD1
            ,   CTRT_NO                 --20
            ,   CTRT_TP_CD
            ,   ACT_PLC_CD
            ,   ACT_DT
            ,   VSL_CD
            ,   VVL_CD                  --25
            ,   CRE_USR_ID
            ,   CRE_DT
            ,   UPD_USR_ID
            ,   UPD_DT         
            ,   IF_FLG                  --30
        )
        SELECT	SAC_FRT_IF_SEQ.NEXTVAL                                  AS  FRT_IF_SEQ                      --01    FRT_IF_SEQ          
            ,	SEQ_NO                     					            AS  IF_SEQ_NO   					--      Sequence Number                                      
            ,	CO_CD                        							AS  ACCT_CO_CD						--      Company Code                                         
            ,	DOCTP	                    							AS  IF_DOC_TP_CD					--      Document Type                                        
            ,	V_PRM_E                                                 AS  DOC_DT                          --05    Document Date in Document                             
            ,	V_PRM_E        								            AS  PST_DT				            --      Posting Date in the Document                         
            ,	SEQ_NO                    						        AS  REF_DOC_NUM	                    --      Reference Document Number                            
            ,	'OPR302' || TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS')        AS  DOC_HDR_TXT                     --      Document Header Text                                 
            ,	CURR                        					        AS  CURR_CD 						--      Currency Key                                         
            ,	PSK                         							AS	PST_KEY_CD						--10    Posting Key                                           
            ,	TXCD         											AS  VAT_TAX_CD                      --      Tax on Sales/Purchases Code                          
            ,	AMOUNT_IN_LOCAL_CURRENCY                                AS  LOCAL_AMT						--      Amount in local currency                             
            ,	AMOUNT_IN_DOCUMENT_CURRENCY         					AS  DOCU_AMT    					--      Amount in document currency                          
            ,	COST_CENTER                         					AS	COST_CTR_CD						--      Cost Center                                          
            ,	GL_ACCOUNT_NUMBER                   					AS  GL_ACCT_NO						--15    G/L Account Number                                    
            ,   CUSTOMER_NUMBER1                                        AS  CUST_NO                         --      Customer Number1
            ,	PROFIT_CENTER                       					AS	PFITCTR_CD						--      Profit Center                                        
            ,	ALTN_ACCT_NUMBER_COMPANY_CODE                           AS  ALTN_ACCT_NO      	            --      Alternative account number in company code                        
            ,	BUSINESS_PARTNER_REF_KEY1                               AS  BIZ_PRNR_REF_KEY_CD1			--      Business partner reference key                       
            ,	CONTRACT_NUMBER                     					AS  CTRT_NO							--20    Contract Number                                      
            ,	CONTRACT_TYPE                                           AS  CTRT_TP_CD     	                --      Contract Type                                        
            ,	ACTIVITY_PLACE                      					AS	ACT_PLC_CD						--      Activity Place                                       
            ,	ACTIVITY_DATE                       					AS	ACT_DT							--      Activity Date                                        
            ,	VESSEL                              					AS	VSL_CD							--      Vessel                                      
            ,	VVL                                 					AS	VVL_CD						    --25    VVL
            , 	'SYSTEM'                                                AS  CRE_USR_ID              		--      CRE_USR_ID                                                                                               
            , 	SYSDATE                             					AS  CRE_DT							--      CRE_DT                                                                             
            , 	'SYSTEM'                            					AS  UPD_USR_ID						--      UPD_USR_ID                                                                                                                  
            , 	SYSDATE                             					AS  UPD_DT							--      UPD_DT                                                                                                                
            , 	'N'                                 					AS  IF_FLG							--30    IF_FLG                                                                                                                   
        FROM
        (
            SELECT  DECODE(PSK, '50','CR', 'DR') AS DR_CR_FLG
                ,   XXXXXX.*
            FROM
            ( 
                SELECT  IF_SEQ_NO                                           AS  SEQ_NO
                    ,   ACCT_CO_CD                                          AS  CO_CD
                    ,   IF_DOC_TP_CD                                        AS  DOCTP
                    ,   CURR_CD                                             AS  CURR                
                    ,   DECODE(L, '1',LOCL_AMT              ,   ABS(T1) )   AS  AMOUNT_IN_LOCAL_CURRENCY 
                    ,   DECODE(L, '1',DOC_AMT               ,   ABS(T2) )   AS  AMOUNT_IN_DOCUMENT_CURRENCY 
                    ,   DECODE(L, '1',PST_KEY_CD            ,   SUP_PSK )   AS  PSK        
                    ,   DECODE(L, '1',VAT_TAX_CD            ,   NULL    )   AS  TXCD                        
                    ,   DECODE(L, '1',COST_CTR_CD           ,   NULL    )   AS  COST_CENTER                 
                    ,   DECODE(L, '1',GL_ACCT_NO            ,   SUPGL   )   AS  GL_ACCOUNT_NUMBER           
                    ,   DECODE(L, '1',CUST_NO               ,   NULL    )   AS  CUSTOMER_NUMBER1            
                    ,   DECODE(L, '1',PFITCTR_CD            ,   'Z900'  )   AS  PROFIT_CENTER               
                    ,   DECODE(L, '1',ALTN_ACCT_NO          ,   NULL    )   AS  ALTN_ACCT_NUMBER_COMPANY_CODE   
                    ,   DECODE(L, '1',BIZ_PRNR_REF_KEY_CD1  ,   NULL    )   AS  BUSINESS_PARTNER_REF_KEY1   
                    ,   DECODE(L, '1',CTRT_NO               ,   NULL    )   AS  CONTRACT_NUMBER
                    ,   DECODE(L, '1','Z'                   ,   NULL    )   AS  CONTRACT_TYPE
                    ,   DECODE(L, '1',ACT_PLC_CD            ,   NULL    )   AS  ACTIVITY_PLACE              
                    ,   DECODE(L, '1',ACT_DT                ,   V_PRM_E )   AS  ACTIVITY_DATE               
                    ,   DECODE(L, '1',VSL_CD                ,   NULL    )   AS  VESSEL                      
                    ,   DECODE(L, '1',VVL_CD                ,   NULL    )   AS  VVL
                    ,   DECODE(L, '1','N'                   ,   'Y'     )   AS  SUP_ACCT_FLG
                FROM
                (
                    SELECT  DECODE(ROW_SEQQ, 1,(CASE WHEN T2<0 THEN '50' WHEN T2>0 THEN '40' ELSE '' END), '') AS SUP_PSK
                        ,   XXXXX.*
                    FROM
                    (
                        SELECT  SUM(DECODE(PST_KEY_CD,'01',-1,1)*LOCL_AMT)  OVER (PARTITION BY IF_SEQ_NO ORDER BY IF_SEQ_NO)  AS T1
                            ,   SUM(DECODE(PST_KEY_CD,'01',-1,1)*DOC_AMT)   OVER (PARTITION BY IF_SEQ_NO ORDER BY IF_SEQ_NO)  AS T2
                            ,   ROW_NUMBER()                                OVER (PARTITION BY IF_SEQ_NO ORDER BY IF_SEQ_NO)  AS ROW_SEQQ
                            ,   XXXX.*
                        FROM
                        (
                            SELECT  TMPACCL.*
                            FROM    SAC_FRT_ACCL_IF TMPACCL
                            WHERE   ERP_IF_ERR_RSN = 'TEMP'
                              AND   IF_FLG = 'E'
                              AND   DOC_DT = V_PRM_E
                            ORDER BY FRT_IF_SEQ
                        ) XXXX
                    ) XXXXX
                ) AA, (SELECT LEVEL AS L FROM DUAL CONNECT BY LEVEL <= 2) BB
            ) XXXXXX
            WHERE   PSK IS NOT NULL
            ORDER BY SEQ_NO, DR_CR_FLG DESC, SUP_ACCT_FLG
        )
        --WHERE   NVL(AMOUNT_IN_LOCAL_CURRENCY, AMOUNT_IN_DOCUMENT_CURRENCY) > 0
        ;
        ---------------------------------------------------------------------------------------------------------------------------------------------------
        
        OUT_YN := 'Y';
        OUT_RESULT := SQL%ROWCOUNT || ' Freight Accrual Data Created.';
        
        COMMIT;
        
        --TEMP DATA DELETE...
        DELETE  SAC_FRT_ACCL_IF 
        WHERE   ERP_IF_ERR_RSN = 'TEMP' 
          AND   IF_FLG = 'E'
          AND   DOC_DT = V_PRM_E;
        
        COMMIT;

    EXCEPTION
        WHEN USER_CALL_EX THEN
            ROLLBACK;
            SCO_ERR_LOG_PRC('SAC_BRG_IF_PKG.'||V_PRC_NM, OUT_RESULT, EXE_YYYYMM, MOD_NAME);
            OUT_YN := 'N';
        WHEN OTHERS THEN
            ROLLBACK;
            SCO_ERR_LOG_PRC('SAC_BRG_IF_PKG.'||V_PRC_NM, SQLERRM, EXE_YYYYMM, MOD_NAME);
            OUT_YN := 'N';
            OUT_RESULT := SQLERRM;
    END SAC_FRT_ACCL_IF_PRC;

    --OPR303 : Freight Deferral SAKUARA Monthly I/F
    --Run through EAI from SKUARA on 3WD
    PROCEDURE SAC_FRT_DEFR_IF_PRC
    (
            EXE_YYYYMM      IN  VARCHAR2
        ,   OUT_YN          OUT VARCHAR2
        ,   OUT_RESULT      OUT VARCHAR2
    )
    IS
        V_LINE_CNT_SET      NUMBER          :=  700;  --Restriction to have number of lines in 1 sequence no more than 700 lines
        J_PRCS              NUMBER          :=  SAC_BRG_IF_PKG.GET_AMT_PRECISION('JPY');
        U_PRCS              NUMBER          :=  SAC_BRG_IF_PKG.GET_AMT_PRECISION('USD');
        CUR_MON             DATE            :=  TO_DATE(EXE_YYYYMM, 'YYYYMM');
        V_PRM               VARCHAR2(6)     :=  TO_CHAR(ADD_MONTHS(CUR_MON, -1), 'YYYYMM');
        V_PRM_E             VARCHAR2(8)     :=  TO_CHAR(LAST_DAY(ADD_MONTHS(CUR_MON, -1)), 'YYYYMMDD');
        V_PRC_NM            VARCHAR2(50)    :=  'SAC_FRT_DEFR_IF_PRC';
        MOD_NAME            VARCHAR2(10)    :=  'ACCRUAL';
      --REVGL               VARCHAR2(20)    :=  '7001000000';   --Freight-Container
        OTSGL               VARCHAR2(20)    :=  '5060000100';   --Outstanding Freight
        RCVGL               VARCHAR2(20)    :=  '6220100050';   --Revenue received in advance
        SUPGL               VARCHAR2(20)    :=  '540ZZ00000';   --Suspence Account Number
        
        DIV_SEQ             NUMBER          :=  0;
        TMP_SEQ             NUMBER          :=  0;
        TTL_SEQ             NUMBER          :=  0;

        USER_CALL_EX        EXCEPTION;
        FRT_DEFR_R          SAC_FRT_DEFR_IF%ROWTYPE;
    BEGIN
        --check whether AR period is open or not
        IF GET_PERIOD_CLS_FLG('AR', V_PRM) = 'N' THEN
            OUT_RESULT := V_PRM || ' AR Period still open.';
            RAISE USER_CALL_EX;
        END IF;

        -- Uploaded Data Dup Delete
        DELETE  FROM SAC_FRT_DEFR_IF WHERE DOC_DT = V_PRM_E;        
        COMMIT;
        
        --Divding seqNo setup data Temp insert...
        ---------------------------------------------------------------------------------------------------------------------------------
        FOR L_FRT_DEFR IN 
        (
            SELECT  XXX_5.*
              --,   DENSE_RANK()      OVER (PARTITION BY CMP,DTP,CUR ORDER BY CMP,DTP,CUR,GRP_NM,GRP_DIV_SQ)   AS TMPSQ_5
                ,   LAG(GRP_DIV_SQ,1) OVER (PARTITION BY CMP,DTP,CUR ORDER BY CMP,DTP,CUR,GRP_NM,GRP_DIV_SQ)   AS BF_GRP_DIV_SQ          
            FROM
            (
                SELECT  XXX_4.*
                    ,   DENSE_RANK() OVER (PARTITION BY CMP,DTP,CUR,GRP_NM ORDER BY CEIL(GRP_SQ/V_LINE_CNT_SET)) AS GRP_DIV_SQ
                FROM
                (
                    SELECT  XXX_3.*
                        ,   ROW_NUMBER() OVER (PARTITION BY CMP,DTP,CUR,GRP_NM ORDER BY RWSQ    )   AS GRP_SQ
                        ,   COUNT(*)     OVER (PARTITION BY CMP,DTP,CUR,GRP_NM ORDER BY GRP_NM  )   AS GRP_CT
                    FROM
                    (
                        SELECT  XXX_2.*
                            ,   DECODE(SAMT,0,TMPSQ, TMPSQ+1) AS GRP_NM
                        FROM
                        (
                            SELECT  XXX_1.*
                                ,   LAG(SAMT,1)             OVER (PARTITION BY CMP,DTP,CUR ORDER BY RWSQ) AS BAMT          
                                ,   SUM(DECODE(SAMT,0,1,0)) OVER (PARTITION BY CMP,DTP,CUR ORDER BY RWSQ) AS TMPSQ
                            FROM
                            (
                                SELECT  XXX.*
                                    ,   SUM(DECODE(TX,'F0',-1,1)*DAMT) OVER (PARTITION BY CMP,DTP,CUR ORDER BY RWSQ) AS SAMT
                                FROM
                                (
                                    SELECT  ROW_NUMBER() OVER (PARTITION BY CMP,DTP,CUR ORDER BY CMP,DTP,CUR,CTRN,DECODE(TX,'F0',1,2),TX,CTR,GLA,CUSN,PTR,AACT,IKY1,IKY2,CTRN,APL,ADT,VSL,VVL) AS RWSQ
                                        ,	CMP     AS CMP  ,   DTP     AS DTP  ,   CUR     AS CUR  ,	CTRN        AS CTRN     ,   PSK         AS PSK         
                                        ,	TX      AS TX   ,	CTR     AS CTR  ,	GLA     AS GLA  ,   CUSN        AS CUSN     ,	PTR         AS PTR     
                                        ,	AACT    AS AACT ,   IKY1    AS IKY1 ,   IKY2    AS IKY2 ,	CTRN        AS CTRN1    ,	APL         AS APL                   
                                        ,	ADT     AS ADT  ,	VSL     AS VSL  ,   VVL     AS VVL  ,	SUM(LAMT)   AS LAMT     ,	SUM(DAMT)   AS DAMT
                                    FROM
                                    (
                                        SELECT 	'1000'                                                                                          AS  CMP  
                                            ,   'HB'                                                                                            AS  DTP  
                                            , 	CURR_CD                                                                                         AS  CUR  
                                            ,   ''                                                                                              AS  CUSN    
                                            , 	PFITCTR_CD                                                                                      AS  PTR  
                                            ,   ''                                                                                              AS  AACT 
                                            , 	''                                                                                              AS  IKY1 
                                            ,   ''                                                                                              AS  IKY2
                                            ,   CTRT_NO                                                                                         AS  CTRN                    
                                            , 	DECODE(CURR_CD, 'JPY',NULL, ROUND((DEFER_DYS/TTL_DYS)*LOCL_AMT, J_PRCS)                     )   AS  LAMT           
                                            , 	ROUND((DEFER_DYS/TTL_DYS)*DOC_AMT, DOCU_AMT_PRCS                                            )   AS  DAMT
                                            , 	DECODE(L, '1',DECODE(TP, 'AT',DECODE(PSK,'50','40','50'), '40') ,   DECODE(TP,'AT',PSK,'50'))   AS  PSK                        
                                            , 	DECODE(L, '1',VAT_TAX_CD                                        ,   'F0'                    )	AS  TX        
                                            , 	DECODE(L, '1',COST_CTR_CD                                       ,   NULL                    )	AS  CTR                        
                                            , 	DECODE(L, '1',GL_ACCT_NO                                        ,   DEFERR_GL_ACCT_NO       )	AS  GLA
                                            , 	DECODE(L, '1',ACT_PLC_CD                                        ,   NULL                    )	AS  APL                     
                                            , 	DECODE(L, '1',SUBSTR(ACT_DT,1,6)||'01'                          ,   NULL                    )	AS  ADT                      
                                            , 	DECODE(L, '1',VSL_CD                                            ,   NULL                    )	AS  VSL                             
                                            , 	DECODE(L, '1',VVL_CD                                            ,   NULL                    )   AS  VVL                                
                                        FROM
                                        (   
                                            -- 1. Accrual Data
                                            SELECT  'AL'                                                                                    AS  TP
                                                ,   AC.CURR_CD                                                                              AS  CURR_CD
                                                ,   '50'                                                                                    AS  PSK
                                                ,   CASE WHEN SUBSTR(POL_CD,1,2)='JP' OR SUBSTR(POD_CD,1,2)='JP' THEN 'B0' ELSE 'D0' END    AS  VAT_TAX_CD
                                                ,   NVL(ROUND(LOCL_AMT  , J_PRCS    ), 0)                                                   AS  LOCL_AMT
                                                ,   NVL(ROUND(TJ_AMT    , U_PRCS    ), 0)                                                   AS  DOC_AMT
                                                ,   (SELECT MODI_COST_CTR_CD FROM MDM_TRADE MT WHERE MT.TRD_CD = AC.TRD_CD)                 AS	COST_CTR_CD
                                                ,   AC.GL_ACCT_NO                                                                           AS	GL_ACCT_NO
                                                ,   OTSGL                                                                                   AS  DEFERR_GL_ACCT_NO
                                                ,   (SELECT MODI_COST_CTR_CD FROM MDM_TRADE MT WHERE MT.TRD_CD = AC.TRD_CD)                 AS	PFITCTR_CD 
                                                ,   IF_CUST_CD                                                                              AS	CTRT_NO    
                                                ,   (SELECT MODI_LOC_CD FROM MDM_LOCATION WHERE LOC_CD = AC.POL_CD)                         AS	ACT_PLC_CD 
                                                ,   TO_CHAR(POL_ETD_DT, 'YYYYMMDD')                                                         AS	ACT_DT     
                                                ,   (SELECT MODI_VSL_CD FROM MDM_VSL_CNTR WHERE VSL_CD = SUBSTR(AC.VVD_CD,1,4))             AS	VSL_CD     
                                                ,   (SELECT MODI_VSL_CD FROM MDM_VSL_CNTR WHERE VSL_CD = SUBSTR(AC.VVD_CD,1,4))
                                                    || SUBSTR(VVD_CD,6,3) || SAC_BRG_IF_PKG.GET_DTX_DIR_CD(AC.SLAN_CD, AC.VVD_CD)           AS	VVL_CD     
                                                ,   SAC_BRG_IF_PKG.GET_DAYS_CALC(POD_ETA_DT ,   POL_ETD_DT  )                               AS  TTL_DYS
                                                ,   SAC_BRG_IF_PKG.GET_DAYS_CALC(POD_ETA_DT ,   CUR_MON     )                               AS  DEFER_DYS
                                                ,   U_PRCS                                                                                  AS  DOCU_AMT_PRCS
                                            FROM    SAC_FRT_ACCL_PRE_IF     AC   
                                            WHERE   EXE_YRMON   = V_PRM                                             --Freight Accrual for current month.
                                              AND   POL_ETD_DT <= TO_DATE(V_PRM_E||'235959', 'YYYYMMDDHH24MISS')    --sailing date <= End of Month
                                              AND   POD_ETA_DT >=  TO_DATE(EXE_YYYYMM||'01', 'YYYYMMDD')            --Bookings, {ETA of Last POD} ≥ {End of Month*}
                                            --AND   TRD_CD IN ('TPT', 'TAT', 'AET', 'OCT', 'IAT', 'LAA')
                                            UNION ALL
                                            -- 2. Actual Data
                                            SELECT  'AT'                                                                                    AS  TP
                                                ,   CUR                    																    AS  CURR_CD
                                                ,   POSTING_KEY                  								    					    AS  PSK
                                                ,   TX                     																    AS  VAT_TAX_CD
                                                ,   ROUND(TMP_AMT*SAC_GET_GL_XCH_RT_FNC(1,TO_CHAR(POL_ETD,'YYYYMMDD'),CUR,'JPY'), J_PRCS)   AS  LOCL_AMT
                                                ,   ABS(TMP_AMT)               						                					    AS  DOC_AMT
                                                ,   CTR                 																    AS  COST_CTR_CD
                                                ,   GLA                  																    AS  GL_ACCT_NO
                                                ,   DEFR_GL_ACCT       										        					    AS  DEFERR_GL_ACCT_NO
                                                ,   PTR                 																    AS  PFITCTR_CD
                                                ,   CRTN                  																    AS  CTRT_NO
                                                ,   APL                 										    					    AS  ACT_PLC_CD
                                                ,   ADT                   										    					    AS  ACT_DT
                                                ,   VSL                     															    AS  VSL_CD
                                                ,   VVL                     															    AS  VVL_CD
                                                ,   SAC_BRG_IF_PKG.GET_DAYS_CALC(POD_ETA ,  POL_ETD )               					    AS  TTL_DYS
                                                ,   SAC_BRG_IF_PKG.GET_DAYS_CALC(POD_ETA ,  CUR_MON )               					    AS  DEFER_DYS
                                                ,   SAC_BRG_IF_PKG.GET_AMT_PRECISION(CUR)                           					    AS  DOCU_AMT_PRCS
                                            FROM 
                                            (
                                                SELECT  AAA.*
                                                    ,   CASE--2nd, 3rd case does not occur on business?
                                                            WHEN PSK1 = '50' AND PSK2 = '50' THEN CASE WHEN DIFF_1>=0 THEN DECODE(L, '1','50', '50') ELSE DECODE(L, '1','40', '50') END  
                                                            WHEN PSK1 = '40' AND PSK2 = '40' THEN CASE WHEN DIFF_1>=0 THEN DECODE(L, '1','40', '40') ELSE DECODE(L, '1','50', '40') END
                                                            WHEN PSK1 = '50' AND PSK2 = '40' THEN DECODE(L, '1','50', '40')                                                         
                                                            WHEN PSK1 = '40' AND PSK2 = '50' THEN DECODE(L, '1','40', '50')                                                      
                                                        END                                                                                             AS POSTING_KEY
                                                    ,   CASE 
                                                            WHEN RCV_AMT = 0 THEN DECODE(L, '1',ABS(DAMT_TTL), 0) 
                                                            ELSE
                                                                CASE--2nd, 3rd case does not occur on business?  
                                                                    WHEN PSK1 = '50' AND PSK2 = '50' THEN  DECODE(L, '1',ABS(DIFF_1), ABS(RCV_AMT)) 
                                                                    WHEN PSK1 = '40' AND PSK2 = '40' THEN  DECODE(L, '1',ABS(DIFF_1), ABS(RCV_AMT))   
                                                                    WHEN PSK1 = '50' AND PSK2 = '40' THEN  DECODE(L, '1',ABS(DIFF_2), ABS(RCV_AMT))  
                                                                    WHEN PSK1 = '40' AND PSK2 = '50' THEN  DECODE(L, '1',ABS(DIFF_2), ABS(RCV_AMT))   
                                                                END
                                                        END                                                                                             AS TMP_AMT
                                                    ,   CASE WHEN RCV_AMT = 0 THEN DECODE(L, '1',OTSGL, '') ELSE DECODE(L, '1',OTSGL, RCVGL) END        AS DEFR_GL_ACCT
                                                FROM
                                                (
                                                    SELECT  ZZZ.*
                                                        ,   CASE WHEN DAMT_TTL >=0 THEN '50' ELSE '40' END  AS PSK1
                                                        ,   CASE WHEN RCV_AMT  >=0 THEN '50' ELSE '40' END  AS PSK2
                                                        ,   ABS(DAMT_TTL) - ABS(RCV_AMT)                    AS DIFF_1
                                                        ,   ABS(DAMT_TTL) + ABS(RCV_AMT)                    AS DIFF_2
                                                    FROM
                                                    (
                                                        SELECT  ZZ.*
                                                            ,   SUM(MK*DOC_AMT) OVER (PARTITION BY BL,CUR,CTR,PTR,GLA,APL,ADT,VSL,VVL,CRTN)                   AS DAMT_TTL
                                                            ,   DENSE_RANK()    OVER (PARTITION BY BL,CUR,CTR,PTR,GLA,APL,ADT,VSL,VVL,CRTN ORDER BY UDT DESC) AS ROW_RNK
                                                            ,   ROW_NUMBER()    OVER (PARTITION BY BL,CUR,CTR,PTR,GLA,APL,ADT,VSL,VVL,CRTN ORDER BY UDT DESC) AS ROW_NUM
                                                        FROM
                                                        (
                                                            SELECT  BL_NO       AS BL       ,   CURR_CD     AS CUR      ,   PST_KEY_CD                      AS PSK      
                                                                ,   VAT_TAX_CD  AS TX       ,   COST_CTR_CD AS CTR      ,   PFITCTR_CD                      AS PTR     
                                                                ,   GL_ACCT_CD  AS GLA      ,   CTRT_NO     AS CRTN     ,   UPD_DT                          AS UDT    
                                                                ,   ACT_PLC_CD  AS APL      ,   ACT_DT      AS ADT      ,   DECODE(PST_KEY_CD,'50',1,-1)    AS MK    
                                                                ,   LOCL_AMT    AS LCL_AMT  ,   TJ_AMT      AS DOC_AMT  ,   RCV_IN_ADV_REV_AMT              AS RCV_AMT  
                                                                ,   VSL_CD      AS VSL      ,   VVD_CD      AS VVL   
                                                                ,   POL_ETD_DT  AS POL_ETD  ,   POD_ETA_DT  AS POD_ETA 
                                                            FROM    SAC_FRT_ACT_PRE_IF
                                                            WHERE   EXE_YRMON   = V_PRM                                             --Deferred data that extracted by ETL Job in monthly
                                                              AND   GL_DT      <= V_PRM_E                                           --posting date is less than or equal to previous month end date 
                                                              AND   POL_ETD_DT <= TO_DATE(V_PRM_E||'235959', 'YYYYMMDDHH24MISS')    --Bookings, {Sailing Date} ≤{End of Month*}
                                                              AND   POD_ETA_DT >= TO_DATE(EXE_YYYYMM||'01', 'YYYYMMDD')             --Bookings, {ETD of Last POD} ≥{End of Month*}
                                                            --AND   TRD_CD IN ('TPT', 'TAT', 'AET', 'OCT', 'IAT', 'LAA')
                                                        ) ZZ
                                                    ) ZZZ
                                                    WHERE   ROW_RNK = 1
                                                      AND   ROW_NUM = 1
                                                      AND   (DAMT_TTL <> 0 OR RCV_AMT <> 0)       -- minus inovoice도 추출하도록 수정 (DAMT_TTL > 0 OR RCV_AMT > 0)
                                                ) AAA, (SELECT LEVEL AS L FROM DUAL CONNECT BY LEVEL <= 2) BBB 
                                            ) ZZZZ
                                            WHERE   TMP_AMT > 0
                                        ) A, (SELECT LEVEL AS L FROM DUAL CONNECT BY LEVEL <= 2) B
                                    )
                                    GROUP BY CMP,DTP,CUR,CTRN,PSK,TX,CTR,GLA,CUSN,PTR,AACT,IKY1,IKY2,CTRN,APL,ADT,VSL,VVL
                                ) XXX
                            ) XXX_1
                        ) XXX_2
                    ) XXX_3
                ) XXX_4
            ) XXX_5
            ORDER BY CMP,DTP,CUR,RWSQ
        ) 
        LOOP
            IF L_FRT_DEFR.RWSQ = 1 THEN
                DIV_SEQ := DIV_SEQ + 1;
                TMP_SEQ := 1;
                TTL_SEQ := 0;
            ELSE
                IF L_FRT_DEFR.SAMT = 0 THEN
                    IF TMP_SEQ > V_LINE_CNT_SET THEN    --Total Cnt of Dr&Cr set > LineSetCnt --> Next SeqNo. Dividing
                        DIV_SEQ := DIV_SEQ + 1;
                        TMP_SEQ := 1;
                        TTL_SEQ := 0;
                    ELSE
                        NULL;
                    END IF;
                ELSE
                    IF L_FRT_DEFR.BAMT = 0 THEN     -- Dr&Cr set relation of previousRow is OK
                        IF TTL_SEQ+L_FRT_DEFR.GRP_CT > V_LINE_CNT_SET THEN  --Count of Previous Dr&Cr Set + Count ofCurrent DR&CR Set > LineSetCnt ---> Next SeqNo. Divding
                            DIV_SEQ := DIV_SEQ + 1;
                            TMP_SEQ := 1;
                            TTL_SEQ := 0;
                        ELSE
                            IF L_FRT_DEFR.GRP_DIV_SQ < L_FRT_DEFR.BF_GRP_DIV_SQ THEN --Previous 차대변 set의 라인설정값에 걸려 다음 SeqNo로 분리된 row와 현재 차대변 set와는 분리한다,
                                DIV_SEQ := DIV_SEQ + 1;
                                TMP_SEQ := 1;
                                TTL_SEQ := 0;
                            END IF;
                        END IF;
                    ELSE
                        IF TMP_SEQ > V_LINE_CNT_SET THEN    --Current Dr&Cr set relation >  LineSetCnt --> Next SeqNo. Dividing
                            DIV_SEQ := DIV_SEQ + 1;
                            TMP_SEQ := 1;
                            TTL_SEQ := 0; 
                        END IF;
                    END IF;
                END IF;
            END IF;
            
            --INSERT Statment...
            FRT_DEFR_R.ACCT_CO_CD               :=  L_FRT_DEFR.CMP;
            FRT_DEFR_R.IF_DOC_TP_CD             :=  L_FRT_DEFR.DTP;
            FRT_DEFR_R.CURR_CD               	:=  L_FRT_DEFR.CUR;     
            FRT_DEFR_R.CTRT_NO                  :=  L_FRT_DEFR.CTRN; 
            FRT_DEFR_R.PST_KEY_CD               :=  L_FRT_DEFR.PSK;      
            FRT_DEFR_R.VAT_TAX_CD               :=  L_FRT_DEFR.TX;       
            FRT_DEFR_R.COST_CTR_CD              :=  L_FRT_DEFR.CTR;  
            FRT_DEFR_R.GL_ACCT_NO               :=  L_FRT_DEFR.GLA;  
            FRT_DEFR_R.CUST_NO                  :=  L_FRT_DEFR.CUSN; 
            FRT_DEFR_R.PFITCTR_CD               :=  L_FRT_DEFR.PTR; 
            FRT_DEFR_R.ALTN_ACCT_NO             :=  L_FRT_DEFR.AACT; 
            FRT_DEFR_R.ACT_PLC_CD               :=  L_FRT_DEFR.APL;  
            FRT_DEFR_R.ACT_DT                   :=  L_FRT_DEFR.ADT;   
            FRT_DEFR_R.VSL_CD                   :=  L_FRT_DEFR.VSL;      
            FRT_DEFR_R.VVL_CD                   :=  L_FRT_DEFR.VVL;
            FRT_DEFR_R.LOCL_AMT                 :=  L_FRT_DEFR.LAMT; 
            FRT_DEFR_R.DOC_AMT                  :=  L_FRT_DEFR.DAMT;
            
            INSERT_TMP_FRT_DEFR(pi_doc_dt => V_PRM_E, pi_div_seq => DIV_SEQ, pi_frt_defr_r => FRT_DEFR_R);

            TMP_SEQ := TMP_SEQ +1;
            TTL_SEQ := TTL_SEQ +1;
        END LOOP; 
        ---------------------------------------------------------------------------------------------------------------------------------------------------

        ---------------------------------------------------------------------------------------------------------------------------------------------------
        INSERT INTO SAC_FRT_DEFR_IF
        (
                DEFR_IF_SEQ             --1
            ,   IF_SEQ_NO
            ,   ACCT_CO_CD
            ,   IF_DOC_TP_CD
            ,   DOC_DT                  --5
            ,   PST_DT
            ,   REF_DOC_NO
            ,   DOC_HDR_CD
            ,   CURR_CD
            ,   PST_KEY_CD              --10
            ,   VAT_TAX_CD
            ,   LOCL_AMT
            ,   DOC_AMT
            ,   ASGN_NO
            ,   COST_CTR_CD             --15
            ,   GL_ACCT_NO
            ,   PFITCTR_CD
            ,   CTRT_NO
            ,   CTRT_TP_CD
            ,   ACT_PLC_CD              --20
            ,   ACT_DT
            ,   VSL_CD
            ,   VVL_CD
            ,   CRE_USR_ID
            ,   CRE_DT                  --25                  
            ,   UPD_USR_ID
            ,   UPD_DT
            ,   IF_FLG                  --28
        )
        SELECT	SAC_DEFR_IF_SEQ.NEXTVAL                             AS  DEFR_IF_SEQ                         --01    DEFR_IF_SEQ        
            ,	SEQ_NO                     				            AS  IF_SEQ_NO			                --      Sequence Number                                      
            ,	CO_CD                        						AS	ACCT_CO_CD			                --      Company Code                                         
            ,	DOCTP	                    						AS	IF_DOC_TP_CD						--      Document Type                                        
            ,	V_PRM_E                                             AS  DOC_DT                              --05    Document Date in Document                             
            ,	V_PRM_E        		                                AS  PST_DT                              --      Posting Date in the Document                         
            ,	SEQ_NO                        				        AS  REF_DOC_NUM			                --      Reference Document Number                            
            ,	'OPR303' || TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS')    AS  DOC_HDR_TXT            	            --      Document Header Text                                 
            ,	CURR                        				        AS  CURR_CD 							--      Currency Key                                         
            ,	PSK                         						AS					                    --10    Posting Key                                           
            ,	TXCD         										AS                                    	--      Tax on Sales/Purchases Code                          
            ,	AMOUNT_IN_LOCAL_CURRENCY            				AS  LOCL_AMT		                    --      Amount in local currency                             
            ,	AMOUNT_IN_DOCUMENT_CURRENCY         				AS  DOC_AMT							    --      Amount in document currency                          
            ,   NULL                                                AS  ASGN_NO                             --      Assignment Number
            ,	COST_CENTER                         				AS										--15    Cost Center                                          
            ,	GL_ACCOUNT_NUMBER                   				AS  GL_ACCT_NO							--      G/L Account Number                                    
            ,	PROFIT_CENTER                       				AS										--      Profit Center                                        
            ,	CONTRACT_NUMBER                     				AS  CTRT_NO								--      Contract Number                                      
            ,	CONTRACT_TYPE                                       AS  CTRT_TP						        --      Contract Type                                        
            ,	ACTIVITY_PLACE                      				AS										--20    Activity Place                                       
            ,	ACTIVITY_DATE                       				AS										--      Activity Date                                        
            ,	VESSEL                              				AS										--      Vessel                                      
            ,	VVL                                 				AS										--      VVL
            , 	'SYSTEM'                            			    AS  CRE_USR_ID							--      CRE_USR_ID                                                                                               
            , 	SYSDATE                             				AS  CRE_DT								--25    CRE_DT                                                                             
            , 	'SYSTEM'                            				AS  UPD_USR_ID							--      UPD_USR_ID                                                                                                                  
            , 	SYSDATE                             				AS  UPD_DT								--      UPD_DT                                                                                                                
            , 	'N'                                 				AS  IF_FLG								--28    IF_FLG                                                                                                                   
        FROM
        (
            SELECT  DECODE(PSK, '50','CR', 'DR') AS DR_CR_FLG   
                ,   XXXXXX.*
            FROM
            ( 
                SELECT  IF_SEQ_NO                                       AS  SEQ_NO
                    ,   ACCT_CO_CD                                      AS  CO_CD
                    ,   IF_DOC_TP_CD                                    AS  DOCTP
                    ,   CURR_CD                                         AS  CURR            
                    ,   DECODE(L, '1',LOCL_AMT      ,   ABS(T1)     )   AS  AMOUNT_IN_LOCAL_CURRENCY 
                    ,   DECODE(L, '1',DOC_AMT       ,   ABS(T2)     )   AS  AMOUNT_IN_DOCUMENT_CURRENCY 
                    ,   DECODE(L, '1',PST_KEY_CD    ,   SUP_PSK     )   AS  PSK        
                    ,   DECODE(L, '1',VAT_TAX_CD    ,   NULL        )   AS  TXCD                        
                    ,   DECODE(L, '1',COST_CTR_CD   ,   NULL        )   AS  COST_CENTER                 
                    ,   DECODE(L, '1',GL_ACCT_NO    ,   SUPGL       )   AS  GL_ACCOUNT_NUMBER           
                    ,   DECODE(L, '1',PFITCTR_CD    ,   'Z900'      )   AS  PROFIT_CENTER               
                    ,   DECODE(L, '1',CTRT_NO       ,   NULL        )   AS  CONTRACT_NUMBER
                    ,   DECODE(L, '1','Z'           ,   NULL        )   AS  CONTRACT_TYPE             
                    ,   DECODE(L, '1',ACT_PLC_CD    ,   NULL        )   AS  ACTIVITY_PLACE              
                    ,   DECODE(L, '1',ACT_DT        ,   V_PRM_E     )   AS  ACTIVITY_DATE               
                    ,   DECODE(L, '1',VSL_CD        ,   NULL        )   AS  VESSEL                      
                    ,   DECODE(L, '1',VVL_CD        ,   NULL        )   AS  VVL
                    ,   DECODE(L, '1','N'           ,   'Y'         )   AS  SUP_ACCT_FLG
                FROM
                (
                    SELECT  DECODE(ROW_SEQQ, 1,(CASE WHEN T2>0 THEN '50' WHEN T2<0 THEN '40' ELSE '' END), '') AS SUP_PSK
                        ,   XXXXX.*
                    FROM
                    (
                        SELECT  SUM(DECODE(PST_KEY_CD,'40',1,-1)*LOCL_AMT)  OVER (PARTITION BY IF_SEQ_NO ORDER BY IF_SEQ_NO)  AS T1
                            ,   SUM(DECODE(PST_KEY_CD,'40',1,-1)*DOC_AMT)   OVER (PARTITION BY IF_SEQ_NO ORDER BY IF_SEQ_NO)  AS T2
                            ,   ROW_NUMBER()                                OVER (PARTITION BY IF_SEQ_NO ORDER BY IF_SEQ_NO)  AS ROW_SEQQ
                            ,   XXXX.*
                        FROM
                        (
                            SELECT  TMPDEFR.*
                            FROM    SAC_FRT_DEFR_IF TMPDEFR
                            WHERE   ERP_IF_ERR_RSN = 'TEMP'
                              AND   IF_FLG = 'E'
                              AND   DOC_DT = V_PRM_E
                            ORDER BY DEFR_IF_SEQ
                        ) XXXX
                    ) XXXXX
                ) AA, (SELECT LEVEL AS L FROM DUAL CONNECT BY LEVEL <= 2) BB
            ) XXXXXX
            WHERE   PSK IS NOT NULL
            ORDER BY SEQ_NO, DR_CR_FLG DESC, SUP_ACCT_FLG
        )
        --WHERE   NVL(AMOUNT_IN_LOCAL_CURRENCY, AMOUNT_IN_DOCUMENT_CURRENCY) > 0
        ;
        ---------------------------------------------------------------------------------------------------------------------------------------------------

        OUT_YN := 'Y';
        OUT_RESULT := SQL%ROWCOUNT || ' Freight Deferral Data Created.';

        COMMIT;

        --TEMP DATA DELETE...
        DELETE  SAC_FRT_DEFR_IF
        WHERE   ERP_IF_ERR_RSN = 'TEMP' 
          AND   IF_FLG = 'E'
          AND   DOC_DT = V_PRM_E;
        
        COMMIT;

    EXCEPTION
        WHEN USER_CALL_EX THEN
            ROLLBACK;
            SCO_ERR_LOG_PRC('SAC_BRG_IF_PKG.'||V_PRC_NM, OUT_RESULT, EXE_YYYYMM, MOD_NAME);
            OUT_YN := 'N';
        WHEN OTHERS THEN
            ROLLBACK;
            SCO_ERR_LOG_PRC('SAC_BRG_IF_PKG.'||V_PRC_NM, SQLERRM, EXE_YYYYMM, MOD_NAME);
            OUT_YN := 'N';
            OUT_RESULT := SQLERRM;
    END SAC_FRT_DEFR_IF_PRC;

    --OPR304 : Freight Deferral Report SAKUARA Monthly I/F
    --Run through EAI from SKUARA on 3WD
    PROCEDURE SAC_FRT_DEFR_RPT_IF_PRC
    (
            EXE_YYYYMM      IN  VARCHAR2
        ,   OUT_YN          OUT VARCHAR2
        ,   OUT_RESULT      OUT VARCHAR2
    )
    IS
        J_PRCS              NUMBER          :=  SAC_BRG_IF_PKG.GET_AMT_PRECISION('JPY');
        U_PRCS              NUMBER          :=  SAC_BRG_IF_PKG.GET_AMT_PRECISION('USD');
        CUR_MON             DATE            :=  TO_DATE(EXE_YYYYMM, 'YYYYMM');
        PRM_E               DATE            :=  LAST_DAY(ADD_MONTHS(CUR_MON, -1));
        V_PRM               VARCHAR2(6)     :=  TO_CHAR(ADD_MONTHS(CUR_MON, -1), 'YYYYMM');
        V_PRM_E             VARCHAR2(8)     :=  TO_CHAR(LAST_DAY(ADD_MONTHS(CUR_MON, -1)), 'YYYYMMDD');
        V_PRC_NM            VARCHAR2(50)    :=  'SAC_FRT_DEFR_RPT_IF';
        MOD_NAME            VARCHAR2(10)    :=  'ACCRUAL';
        
        USER_CALL_EX        EXCEPTION;
    BEGIN
        --check whether AR period is open or not
        IF GET_PERIOD_CLS_FLG('AR', V_PRM) = 'N' THEN
            OUT_RESULT := V_PRM || ' AR Period still open.';
            RAISE USER_CALL_EX;
        END IF;

        -- Uploaded Data Dup Delete
        DELETE  FROM SAC_FRT_DEFR_RPT_IF WHERE DOC_DT = V_PRM_E;        
        COMMIT;

        INSERT INTO SAC_FRT_DEFR_RPT_IF
        (
                DEFR_RPT_IF_SEQ     --01
            ,   IF_SEQ_NO
            ,   TRD_CD
            ,   LINE_CD
            ,   LINE_VIP_CD         --05
            ,   VSL_CD              
            ,   VSL_VIP_CD  
            ,   VOY_NO
            ,   LEG_CD
            ,   BL_NO               --10
            ,   N1ST_LODG_PORT_CD
            ,   N1ST_POL_DEP_DT   
            ,   LST_DCHG_PORT_CD
            ,   LST_POD_ARR_DT
            ,   TTL_DYS             --15                       
            ,   ELPSD_DYS
            ,   TEU_QTY             
            ,   CURR_CD
            ,   DOC_AMT
            ,   PFITCTR_CD          --20          
            ,   CRE_USR_ID
            ,   CRE_DT              
            ,   UPD_USR_ID
            ,   UPD_DT
            ,   IF_FLG              --25
            ,   DOC_DT              --26
        )
       	SELECT  SAC_DEFR_RPT_IF_SEQ.NEXTVAL                                                     AS  DEFR_RPT_IF_SEQ  	--01    DEFR_RPT_IF_SEQ 
            ,   SEQUENCE_NUMBER																							--		IF_SEQ_NO 
            ,   TRADE                                                                                                   --  	Trade                 
            ,   LINE                                                                                                    --  	Line                  
            ,   LINE_VIP                                                                                                --05	Line(VIP)             
            ,   VESSEL                                                                                                  --  	Vessel                
            ,   VESSEL_VIP                                                                                              --  	Vessel(VIP)           
            ,   VOYAGE                                                                                                  --  	Voyage                
            ,   LEG                                                                                                     --  	Leg                   
            ,   BL                                                                                                      --10	BL No.                
            ,   N1ST_LOADING_PORT                                                                                       --  	1st Loading Port      
            ,   DEPARTURE_DATE                                                                                          --  	Departure Date        
            ,   LAST_DISCHARGING_PORT                                                                                   --  	Last Discharging Port 
            ,   ARRIVAL_DATE                                                                                            --  	Arrival Date          
            ,   TTL_DYS                                                                                                 --15	Total Days            
            ,   ELPSD_DYS                                                                                               --  	Elapsed days          
            ,   CASE WHEN RWSQ=RWCT THEN PRT_LCLTEU+(TEU-PRT_LCL_TEU_S) ELSE PRT_LCLTEU END     AS  PRORATE_LOCL_TEU    --  	TEU                   
            ,   CURRENCY                                                                                                --  	Currency              
            ,   DEFR_DOC_AMT                                                                                            --  	Amount               
            ,   PROFIT_CENTER                                                                                           --20	Profit Center        
            ,   'SYSTEM'                                                                        AS  CRE_USR_ID          --  	CRE_USR_ID       
            ,   SYSDATE                                                                         AS  CRE_DT              --  	UPD_USR_ID
            ,   'SYSTEM'                                                                        AS  UPD_USR_ID          --  	UPD_USR_ID
            ,   SYSDATE                                                                         AS  UPD_DT              --  	UPD_DT
            ,   'N'                                                                             AS  IF_FLG              --25    IF_FLG
            ,   V_PRM_E                                                                         AS  DOC_DT              --26    DOC_DT
        FROM
        (
            SELECT  CCC.*
                ,   SUM(PRT_LCLTEU) OVER (PARTITION BY BL ORDER BY BL       )   AS  PRT_LCL_TEU_S
                ,   COUNT(*)        OVER (PARTITION BY BL ORDER BY BL       )   AS  RWSQ
                ,   ROW_NUMBER()    OVER (PARTITION BY BL ORDER BY ROWNUM   )   AS  RWCT
            FROM
            (
                SELECT  BBB.*
                    ,   DECODE(SUM_DEFR_LCL_AMT, 0,0, TRUNC((DEFR_LCL_AMT/SUM_DEFR_LCL_AMT)*TEU, 2)) AS PRT_LCLTEU
                FROM
                (
                    SELECT  AAA.*
                        ,   SUM(DEFR_LCL_AMT) OVER (PARTITION BY BL ORDER BY BL) AS SUM_DEFR_LCL_AMT
                    FROM
                    (
                        SELECT  DENSE_RANK() OVER (ORDER BY BL, CURR)                                           AS  SEQUENCE_NUMBER
                            ,   TRD_CD                                                             	            AS  TRADE
                            ,   SLAN_CD                                                            	            AS  LINE
                            ,   (SELECT MODI_VSL_SLAN_CD FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD = SLAN_CD)     AS  LINE_VIP
                            ,   SUBSTR(TRNK_VVD_CD,1,4)                                            	            AS  VESSEL
                            ,   (SELECT MODI_VSL_CD FROM MDM_VSL_CNTR WHERE VSL_CD = SUBSTR(TRNK_VVD_CD,1,4))   AS  VESSEL_VIP                 
                            ,   SUBSTR(TRNK_VVD_CD,6,3)                                            	            AS  VOYAGE
                            ,   SAC_BRG_IF_PKG.GET_DTX_DIR_CD(ACCL.SLAN_CD, ACCL.TRNK_VVD_CD)                   AS  LEG
                            ,   BL                                                              	            AS  BL
                            ,   POL_PORT_CD                                                        	            AS  N1ST_LOADING_PORT
                            ,   TO_CHAR(POL_ETD_DT, 'YYYYMMDD')                                    	            AS  DEPARTURE_DATE              
                            ,   POD_PORT_CD                                                        	            AS  LAST_DISCHARGING_PORT
                            ,   TO_CHAR(POD_ETA_DT, 'YYYYMMDD')                                    	            AS  ARRIVAL_DATE
                            ,   TTL_DYS                                                         	            AS  TTL_DYS
                            ,   DECODE(SIGN(ELPSD_DYS), 1,ELPSD_DYS, 0)                         	            AS  ELPSD_DYS
                            ,   ROUND((DEFER_DYS/TTL_DYS) * BKG_QTY, 2)                                         AS  TEU                         
                            ,   CURR                                                          	                AS  CURRENCY
                            ,   SIGN_MK * ROUND((DEFER_DYS/TTL_DYS) * DOCU_AMT, D_PRCS  )                       AS  DEFR_DOC_AMT
                            ,   SIGN_MK * ROUND((DEFER_DYS/TTL_DYS) * LOCL_AMT, J_PRCS  )  	                    AS  DEFR_LCL_AMT
                            ,   PFITCTR_CD                                                        	            AS  PROFIT_CENTER     
                        FROM    
                        (
                            --Accrual Deferred
                            SELECT  BL_NO                                                                                   AS  BL
                                ,   ACCL.CURR_CD                                                               				AS  CURR
                                ,   ROUND(NVL(TJ_AMT    , 0)    , U_PRCS    )                               				AS  DOCU_AMT
                                ,   ROUND(NVL(LOCL_AMT  , 0)    , J_PRCS    )                               				AS  LOCL_AMT
                                ,   (SELECT MODI_COST_CTR_CD FROM MDM_TRADE MT WHERE MT.TRD_CD=ACCL.TRD_CD) 				AS	PFITCTR_CD 
                                ,   POL_CD                                                                  				AS  POL_PORT_CD
                                ,   POL_ETD_DT                                                              				AS  POL_ETD_DT
                                ,   POD_CD                                                                  				AS  POD_PORT_CD
                                ,   POD_ETA_DT                                                              				AS  POD_ETA_DT
                                ,   SAC_BRG_IF_PKG.GET_DAYS_CALC(POD_ETA_DT ,   POL_ETD_DT  )               				AS  TTL_DYS
                                ,   SAC_BRG_IF_PKG.GET_DAYS_CALC(PRM_E      ,   POL_ETD_DT  )               				AS  ELPSD_DYS
                                ,   SAC_BRG_IF_PKG.GET_DAYS_CALC(POD_ETA_DT ,   CUR_MON     )               				AS  DEFER_DYS
                                ,   TRD_CD                                                                  				AS  TRD_CD
                                ,   VVD_CD                                                                  				AS  TRNK_VVD_CD
                                ,   U_PRCS                                                                  				AS  D_PRCS
                                ,   SLAN_CD                                                                 				AS  SLAN_CD
                                ,   BKG_QTY                                                                 				AS  BKG_QTY
                                ,   1                                                                       				AS  SIGN_MK
                            FROM    SAC_FRT_ACCL_PRE_IF ACCL    
                            WHERE   EXE_YRMON   = V_PRM                                             --Freight Accrual for current month.
                              AND   POL_ETD_DT <= TO_DATE(V_PRM_E||'235959', 'YYYYMMDDHH24MISS')    --sailing date <= End of Month
                              AND   POD_ETA_DT >= TO_DATE(EXE_YYYYMM||'01', 'YYYYMMDD')             --Bookings, {ETA of Last POD} ≥ {End of Month*}
                            --AND   TRD_CD IN ('TPT', 'TAT', 'AET', 'OCT', 'IAT', 'LAA')
                            UNION ALL
                            --Actual Deferred
                            SELECT  BL                                                                                      AS  BL_NO
                                ,   CUR                    													                AS  CURR
                                ,   ABS(TMP_AMT)               						                	                    AS  DOCU_AMT
                                ,   ROUND(TMP_AMT*SAC_GET_GL_XCH_RT_FNC(1,TO_CHAR(POL_ETD,'YYYYMMDD'),CUR,'JPY'), J_PRCS)   AS  LOCL_AMT
                                ,   PTR                                                          		                    AS	PFITCTR_CD 
                                ,   POL_CD                                                              	                AS  POL_PORT_CD
                                ,   POL_ETD                                                          		                AS  POL_ETD_DT
                                ,   POD_CD                                                              	                AS  POD_PORT_CD
                                ,   POD_ETA                                                          		                AS  POD_ETA_DT
                                ,   SAC_BRG_IF_PKG.GET_DAYS_CALC(POD_ETA    ,   POL_ETD     )                               AS  TTL_DYS
                                ,   SAC_BRG_IF_PKG.GET_DAYS_CALC(PRM_E      ,   POL_ETD     )                               AS  ELPSD_DYS
                                ,   SAC_BRG_IF_PKG.GET_DAYS_CALC(POD_ETA    ,   CUR_MON     )                               AS  DEFER_DYS
                                ,   TRD_CD                                                              	                AS  TRD_CD
                                ,   TRNK_VVD                                                         		                AS  TRNK_VVD_CD
                                ,   SAC_BRG_IF_PKG.GET_AMT_PRECISION(CUR)                           		                AS  D_PRCS
                                ,   SLAN_CD                                                             	                AS  SLAN_CD
                                ,   BKG_QTY                                                             	                AS  BKG_QTY
                                ,   DECODE(POSTING_KEY, '50',1, -1)                                                         AS  SIGN_MK
                            FROM 
                            (
                                SELECT  XXX.*
                                    ,   CASE--2nd, 3rd, 4th case does not occur on business?.
                                            WHEN PSK1 = '50' AND PSK2 = '50' THEN CASE WHEN DIFF_1>=0 THEN DECODE(L, '1','50', '50') ELSE DECODE(L, '1','40', '50') END  
                                            WHEN PSK1 = '40' AND PSK2 = '40' THEN CASE WHEN DIFF_1>=0 THEN DECODE(L, '1','40', '40') ELSE DECODE(L, '1','50', '40') END
                                            WHEN PSK1 = '50' AND PSK2 = '40' THEN DECODE(L, '1','50', '40')                                                         
                                            WHEN PSK1 = '40' AND PSK2 = '50' THEN DECODE(L, '1','40', '50')                                                      
                                        END                                                                                             AS POSTING_KEY
                                    ,   CASE 
                                            WHEN RCV_AMT = 0 THEN DECODE(L, '1',ABS(DAMT_TTL), 0) 
                                            ELSE
                                                CASE--2nd, 3rd, 4th case does not occur on business?.     
                                                    WHEN PSK1 = '50' AND PSK2 = '50' THEN  DECODE(L, '1',ABS(DIFF_1), ABS(RCV_AMT)) 
                                                    WHEN PSK1 = '40' AND PSK2 = '40' THEN  DECODE(L, '1',ABS(DIFF_1), ABS(RCV_AMT))   
                                                    WHEN PSK1 = '50' AND PSK2 = '40' THEN  DECODE(L, '1',ABS(DIFF_2), ABS(RCV_AMT))  
                                                    WHEN PSK1 = '40' AND PSK2 = '50' THEN  DECODE(L, '1',ABS(DIFF_2), ABS(RCV_AMT))   
                                                END
                                        END                                                                                             AS TMP_AMT
                                FROM
                                (
                                    SELECT  ZZZ.*
                                        ,   CASE WHEN DAMT_TTL >=0 THEN '50' ELSE '40' END  AS PSK1
                                        ,   CASE WHEN RCV_AMT  >=0 THEN '50' ELSE '40' END  AS PSK2
                                        ,   ABS(DAMT_TTL) - ABS(RCV_AMT)                    AS DIFF_1
                                        ,   ABS(DAMT_TTL) + ABS(RCV_AMT)                    AS DIFF_2
                                    FROM
                                    (
                                        SELECT  ZZ.*
                                            ,   SUM(MK*DOC_AMT) OVER (PARTITION BY BL,CUR,CTR,PTR,GLA,APL,ADT,VSL,VVL,CRTN)                   AS DAMT_TTL
                                            ,   DENSE_RANK()    OVER (PARTITION BY BL,CUR,CTR,PTR,GLA,APL,ADT,VSL,VVL,CRTN ORDER BY UDT DESC) AS ROW_RNK
                                            ,   ROW_NUMBER()    OVER (PARTITION BY BL,CUR,CTR,PTR,GLA,APL,ADT,VSL,VVL,CRTN ORDER BY UDT DESC) AS ROW_NUM
                                        FROM
                                        (
                                            SELECT  BL_NO           AS BL       , CURR_CD                       AS CUR      
                                                ,   PST_KEY_CD      AS PSK      , DECODE(PST_KEY_CD,'50',1,-1)  AS MK         
                                                ,   COST_CTR_CD	    AS CTR      , PFITCTR_CD                    AS PTR      
                                                ,   GL_ACCT_CD      AS GLA      , CTRT_NO                       AS CRTN    
                                                ,   ACT_PLC_CD      AS APL      , ACT_DT                        AS ADT      
                                                ,   VSL_CD          AS VSL      , VVD_CD                        AS VVL   
                                                ,   POL_ETD_DT      AS POL_ETD  , POD_ETA_DT                    AS POD_ETA  
                                                ,   POD_CD          AS POD_CD   , POL_CD                        AS POL_CD
                                                ,   TJ_AMT          AS DOC_AMT  , RCV_IN_ADV_REV_AMT            AS RCV_AMT  
                                                ,   BKG_QTY         AS BKG_QTY  , SLAN_CD                       AS SLAN_CD    
                                                ,   TRD_CD          AS TRD_CD   , UPD_DT                        AS UDT      
                                                ,   TRNK_VVD_CD     AS TRNK_VVD
                                            FROM    SAC_FRT_ACT_PRE_IF
                                            WHERE   EXE_YRMON   = V_PRM                                             --Deferred data that extracted by ETL Job in monthly
                                              AND   GL_DT      <= V_PRM_E                                           --posting date <= End of Month
                                              AND   POL_ETD_DT <= TO_DATE(V_PRM_E||'235959', 'YYYYMMDDHH24MISS')    --Bookings, {Sailing Date} ≤{End of Month*}
                                              AND   POD_ETA_DT >= TO_DATE(EXE_YYYYMM||'01', 'YYYYMMDD')             --Bookings, {ETD of Last POD} ≥{End of Month*}
                                            --AND   TRD_CD IN ('TPT', 'TAT', 'AET', 'OCT', 'IAT', 'LAA')
                                        ) ZZ
                                    ) ZZZ
                                    WHERE   ROW_RNK = 1
                                      AND   ROW_NUM = 1
                                      AND   (DAMT_TTL <> 0 OR RCV_AMT <> 0)         -- minus inovoice도 추출하도록 수정 (DAMT_TTL > 0 OR RCV_AMT > 0)
                                ) XXX, (SELECT LEVEL AS L FROM DUAL CONNECT BY LEVEL <= 2) YYY 
                            ) ZZZZ
                            WHERE   TMP_AMT > 0
                        ) ACCL    
                    ) AAA
                ) BBB
            ) CCC
        ) DDD
        ;
        
        OUT_YN := 'Y';
        OUT_RESULT := SQL%ROWCOUNT || ' Freight Deferral Report Data Created.';

        COMMIT;

    EXCEPTION
        WHEN USER_CALL_EX THEN
            ROLLBACK;
            SCO_ERR_LOG_PRC('SAC_BRG_IF_PKG.'||V_PRC_NM, OUT_RESULT, EXE_YYYYMM, MOD_NAME);
            OUT_YN := 'N';
        WHEN OTHERS THEN
            ROLLBACK;
            SCO_ERR_LOG_PRC('SAC_BRG_IF_PKG.'||V_PRC_NM, SQLERRM, EXE_YYYYMM, MOD_NAME);
            OUT_YN := 'N';
            OUT_RESULT := SQLERRM;
    END SAC_FRT_DEFR_RPT_IF_PRC;

    --OPR306 : Cost Accrual SAKUARA Monthly I/F
    --Run through EAI from SKUARA on 3WD
    PROCEDURE SAC_COST_ACCL_IF_PRC
    (
            EXE_YYYYMM      IN  VARCHAR2
        ,   OUT_YN          OUT VARCHAR2
        ,   OUT_RESULT      OUT VARCHAR2
    )
    IS
        V_LINE_CNT_SET      NUMBER          :=  700;      --Restriction to have number of lines in 1 sequence no more than 700 lines
        J_PRCS              NUMBER          :=  SAC_BRG_IF_PKG.GET_AMT_PRECISION('JPY');
        CUR_MON             DATE            :=  TO_DATE(EXE_YYYYMM, 'YYYYMM');
        V_PRM               VARCHAR2(6)     :=  TO_CHAR(ADD_MONTHS(CUR_MON, -1), 'YYYYMM');
        V_PRM_E             VARCHAR2(8)     :=  TO_CHAR(LAST_DAY(ADD_MONTHS(CUR_MON, -1)), 'YYYYMMDD');
        V_PRC_NM            VARCHAR2(50)    :=  'SAC_COST_ACCL_IF_PRC';
        MOD_NAME            VARCHAR2(10)    :=  'ACCRUAL';
        SUPGL               VARCHAR2(20)    :=  '540ZZ00000';

        DIV_SEQ             NUMBER          :=  0;
        TMP_SEQ             NUMBER          :=  0;
        TTL_SEQ             NUMBER          :=  0;

        USER_CALL_EX        EXCEPTION;
        CST_ACCL_R          SAC_COST_ACCL_IF%ROWTYPE;
    BEGIN
        --check whether AP period is open or not
        IF GET_PERIOD_CLS_FLG('AP', V_PRM) = 'N' THEN
            OUT_RESULT := V_PRM || ' AP Period still open.';
            RAISE USER_CALL_EX;
        END IF;
        
        -- Uploaded Data Dup Delete
        DELETE  FROM SAC_COST_ACCL_IF WHERE DOC_DT = V_PRM_E;        
        COMMIT;

        --Divding seqNo setup data Temp insert...
        ---------------------------------------------------------------------------------------------------------------------------------
        FOR L_CST_ACCL IN 
        (
            SELECT  XXX_5.*
              --,   DENSE_RANK()      OVER (PARTITION BY CMP,DTP,CUR ORDER BY CMP,DTP,CUR,GRP_NM,GRP_DIV_SQ)   AS TMPSQ_5
                ,   LAG(GRP_DIV_SQ,1) OVER (PARTITION BY CMP,DTP,CUR ORDER BY CMP,DTP,CUR,GRP_NM,GRP_DIV_SQ)   AS BF_GRP_DIV_SQ          
            FROM
            (
                SELECT  XXX_4.*
                    ,   DENSE_RANK() OVER (PARTITION BY CMP,DTP,CUR,GRP_NM ORDER BY CEIL(GRP_SQ/V_LINE_CNT_SET)) AS GRP_DIV_SQ
                FROM
                (
                    SELECT  XXX_3.*
                        ,   ROW_NUMBER() OVER (PARTITION BY CMP,DTP,CUR,GRP_NM ORDER BY RWSQ    )   AS GRP_SQ
                        ,   COUNT(*)     OVER (PARTITION BY CMP,DTP,CUR,GRP_NM ORDER BY GRP_NM  )   AS GRP_CT
                    FROM
                    (
                        SELECT  XXX_2.*
                            ,   DECODE(SAMT,0,TMPSQ, TMPSQ+1) AS GRP_NM
                        FROM    
                        (
                            SELECT  XXX_1.*
                                ,   LAG(SAMT,1)             OVER (PARTITION BY CMP,DTP,CUR ORDER BY RWSQ) AS BAMT          
                                ,   SUM(DECODE(SAMT,0,1,0)) OVER (PARTITION BY CMP,DTP,CUR ORDER BY RWSQ) AS TMPSQ
                            FROM
                            (
                                SELECT  XXX.*
                                    ,   SUM(DECODE(TX,NULL,-1,1)*DAMT) OVER (PARTITION BY CMP,DTP,CUR ORDER BY RWSQ) AS SAMT
                                FROM
                                (
                                    SELECT  ROW_NUMBER() OVER (PARTITION BY CMP,DTP,CUR ORDER BY CMP,DTP,CUR,CTRN,PSK,TX,CTR,GLA,AVC,PTR,AACT,IKY1,IKY2,CTRN,APL,ADT,BZRF)  AS  RWSQ
                                        ,   CMP     AS CMP  ,	DTP     AS DTP  ,   CUR   	    AS CUR  ,	CTRN        AS CTRN ,	PSK         AS PSK
                                        ,	TX      AS TX   ,	CTR     AS CTR  ,	GLA         AS GLA  ,	AVC         AS AVC  ,	PTR         AS PTR
                                        ,	AACT    AS AACT ,   IKY1    AS IKY1 ,   IKY2   	    AS IKY2 ,	CTRN        AS CTRN1,   APL         AS APL
                                        ,	ADT   	AS ADT  ,   BZRF    AS BZRF ,	MAX(VSL)    AS VSL  ,	MAX(VVL)    AS VVL  ,   SUM(LAMT) 	AS LAMT, SUM(DAMT) AS DAMT             
                                        ,   MAX(SYS_SRC_ID) AS  MAX_SYS_SRC_ID
                                    FROM
                                    (
                                        SELECT 	'1000'                      AS  CMP  
                                            ,   A.DOCTP                     AS  DTP  
                                            ,   A.LCL_CUR                   AS  CUR  
                                            ,   ''                          AS  IKY1 
                                            ,   ''                          AS  IKY2 
                                            ,   'G5'||VNDR_CNT_CD||SPL_CD   AS  CTRN                    
                                            ,   A.LCL_AMT                   AS  LAMT 
                                            ,   A.DOC_AMT                   AS  DAMT
                                            ,   A.SYS_SRC_ID                AS  SYS_SRC_ID
                                            , 	DECODE(L, '1',PSK                       ,   DECODE(PSK, '40','31', '21')    )   AS  PSK                        
                                            , 	DECODE(L, '1','F0'                      ,   NULL                            )   AS  TX        
                                            , 	DECODE(L, '1',PROFIT_CENTER             ,   NULL                            )   AS  CTR                        
                                            , 	DECODE(L, '1',GL_ACCOUNT_NUMBER         ,   NULL                            )   AS  GLA                  
                                            ,   DECODE(L, '1',NULL                      ,   'G5'||VNDR_CNT_CD||SPL_CD       )   AS  AVC     
                                            ,   DECODE(L, '1',NULL                      ,   V_PRM_E                         )   AS  BCLC        
                                            , 	DECODE(L, '1',PROFIT_CENTER             ,   NULL                            )   AS  PTR                      
                                            , 	DECODE(L, '1',NULL                      ,   '6030000000'                    )   AS  AACT      
                                            , 	DECODE(L, '1',NULL                      ,   PROFIT_CENTER                   )   AS  BZRF          
                                            , 	DECODE(L, '1',A.ACTIVITY_PLACE          ,   NULL                            )   AS  APL                     
                                            , 	DECODE(L, '1',SUBSTR(ACT_DT,1,6)||'01'  ,   NULL                            )   AS  ADT                      
                                            , 	DECODE(L, '1',DX_VSL                    ,   NULL                            )   AS  VSL                             
                                            , 	DECODE(L, '1',DX_VSL||DX_VOY||DX_DIR	,   NULL                            )   AS  VVL                                
                                        FROM
                                        (
                                            SELECT  DECODE(X.SYS_SRC_ID, 'SAP','HD', 'HC')                                                                  AS  DOCTP
                                                ,   LOCL_CURR_CD                                                                                            AS  LCL_CUR
                                                ,   DECODE(SIGN(ACCL_AMT), 1,'40', '50')                                                                    AS  PSK
                                                ,   DECODE(LOCL_CURR_CD,'JPY','',ROUND(ACCL_AMT*SAC_GET_GL_XCH_RT_FNC(1,ACT_DT,LOCL_CURR_CD,'JPY'),J_PRCS)) AS  LCL_AMT
                                                ,   ROUND(ACCL_AMT, SAC_BRG_IF_PKG.GET_AMT_PRECISION(LOCL_CURR_CD))                                         AS  DOC_AMT
                                                ,   NVL
                                                    (
                                                        (SELECT DECODE(VSL_SLAN_CD, 'COM',NULL, 'CNT',NULL, MODI_COST_CTR_CD) FROM MDM_VSL_SVC_LANE WHERE VSL_SLAN_CD = X.SLAN_CD)
                                                        , 
                                                        NVL
                                                        (
                                                            DECODE
                                                            (
                                                                    SAC_BRG_IF_PKG.GET_STMT_CD_CONV('GL ACCT OF PROFIT CENTER', (SELECT MODI_ACCT_CD FROM MDM_ACCOUNT WHERE ACCT_CD = X.ACCT_CD))        
                                                                ,   'ZH',(SELECT MODI_COST_CTR_CD FROM MDM_ORGANIZATION WHERE OFC_CD = NVL(X.CTRL_OFC_CD, X.ACT_PLC_CD))
                                                                ,   SAC_BRG_IF_PKG.GET_STMT_CD_CONV('GL ACCT OF PROFIT CENTER', (SELECT MODI_ACCT_CD FROM MDM_ACCOUNT WHERE ACCT_CD = X.ACCT_CD))        
                                                            )
                                                            , 
                                                            'A106'
                                                        ) 
                                                    )                                                                                                       AS  PROFIT_CENTER
                                                ,   (SELECT MODI_ACCT_CD FROM MDM_ACCOUNT WHERE ACCT_CD = X.ACCT_CD)                                        AS  GL_ACCOUNT_NUMBER
                                                ,   LPAD
                                                    (
                                                        TO_CHAR
                                                        (
                                                            DECODE
                                                            (
                                                                    X.SYS_SRC_ID
                                                                ,   'PSO',(SELECT N1ST_VNDR_SEQ FROM MDM_YARD WHERE YD_CD=NVL(X.COST_ACT_PLC_CD, X.ACT_PLC_CD))
                                                                ,   X.CUST_SEQ
                                                            )
                                                        )
                                                        ,6,'0'
                                                    )                                                                                                       AS  SPL_CD
                                                ,   ACT_DT                                                                                                  AS  ACT_DT
                                                ,   NVL
                                                    (
                                                        (
                                                            SELECT  ML.MODI_LOC_CD
                                                            FROM    MDM_YARD        MY
                                                                ,   MDM_LOCATION    ML
                                                            WHERE   MY.LOC_CD   = ML.LOC_CD
                                                              AND   MY.YD_CD    = NVL(X.COST_ACT_PLC_CD, X.ACT_PLC_CD)
                                                              AND   ROWNUM = 1
                                                        )
                                                        ,
                                                        NVL
                                                        (
                                                            (
                                                                SELECT  ML.MODI_LOC_CD
                                                                FROM    MDM_ORGANIZATION    MO2
                                                                    ,   MDM_LOCATION        ML
                                                                WHERE   MO2.LOC_CD  = ML.LOC_CD
                                                                  AND   MO2.OFC_CD  = NVL(X.COST_ACT_PLC_CD, X.ACT_PLC_CD)
                                                                  AND   ROWNUM = 1
                                                            )
                                                            ,
                                                            (
                                                                SELECT  ML.MODI_LOC_CD
                                                                FROM    MDM_LOCATION ML
                                                                WHERE   ML.LOC_CD = NVL(X.COST_ACT_PLC_CD, X.ACT_PLC_CD)
                                                                  AND   ROWNUM = 1
                                                            )
                                                        )
                                                    )                                                                                                       AS  ACTIVITY_PLACE
                                                ,   CASE 
                                                        WHEN X.VSL_CD IN ('CFDR', '0000', 'CNTC', 'COMC') THEN ''
                                                        ELSE (SELECT MODI_VSL_CD FROM MDM_VSL_CNTR WHERE VSL_CD = X.VSL_CD)
                                                    END                                                                                                     AS  DX_VSL
                                                ,   CASE 
                                                        WHEN X.VSL_CD IN ('CFDR', '0000', 'CNTC', 'COMC') THEN ''
                                                        ELSE SUBSTR(X.SKD_VOY_NO,2,3)
                                                    END                                                                                                     AS  DX_VOY
                                                ,   CASE 
                                                        WHEN X.VSL_CD IN ('CFDR', '0000', 'CNTC', 'COMC') THEN ''
                                                        ELSE SAC_BRG_IF_PKG.GET_DTX_DIR_CD(X.SLAN_CD, X.VSL_CD||X.SKD_VOY_NO||X.SKD_DIR_CD)
                                                    END                                                                                                     AS  DX_DIR
                                                ,   (
                                                        SELECT  M1.CNT_CD 
                                                        FROM    MDM_LOCATION        M1
                                                            ,   MDM_ORGANIZATION    M2
                                                            ,   MDM_VENDOR          M3
                                                        WHERE   M1.LOC_CD = M2.LOC_CD
                                                          AND   M2.OFC_CD = M3.OFC_CD
                                                          AND   M3.VNDR_SEQ =   DECODE
                                                                                (
                                                                                        X.SYS_SRC_ID
                                                                                    ,   'PSO',(SELECT N1ST_VNDR_SEQ FROM MDM_YARD WHERE YD_CD=NVL(X.COST_ACT_PLC_CD, X.ACT_PLC_CD))
                                                                                    ,   X.CUST_SEQ
                                                                                )
                                                          AND   M1.DELT_FLG = 'N'
                                                          AND   M2.DELT_FLG = 'N'
                                                          AND   M3.DELT_FLG = 'N'
                                                          AND   ROWNUM  = 1
                                                    )                                                                                                       AS  VNDR_CNT_CD
                                                ,   X.SYS_SRC_ID                                                                                            AS  SYS_SRC_ID
                                            FROM    SAC_COST_ACCL_INFO  X
                                            WHERE   EXE_YRMON = V_PRM
                                              AND   ACT_DT <= V_PRM_E
                                              AND   NVL(ACCL_AMT, 0) > 0
                                              AND   NVL(X.ACCL_FLG, 'Y') = 'Y'
                                              /*
                                              AND   EXISTS  (
                                                                SELECT  'X' 
                                                                FROM    MDM_VENDOR MV 
                                                                WHERE   MV.VNDR_SEQ =   DECODE
                                                                                        (
                                                                                                X.SYS_SRC_ID
                                                                                            ,   'PSO',(SELECT N1ST_VNDR_SEQ FROM MDM_YARD WHERE YD_CD=NVL(X.COST_ACT_PLC_CD, X.ACT_PLC_CD))
                                                                                            ,   X.CUST_SEQ
                                                                                        ) 
                                                                  AND   MV.DELT_FLG = 'N'
                                                            )
                                              */ 
                                        ) A, (SELECT LEVEL AS L FROM DUAL CONNECT BY LEVEL <= 2) B
                                    )
                                    GROUP BY CMP,DTP,CUR,CTRN,PSK,TX,CTR,GLA,AVC,PTR,AACT,IKY1,IKY2,CTRN,APL,ADT,BZRF
                                ) XXX
                            ) XXX_1
                        ) XXX_2
                    ) XXX_3
                ) XXX_4
            ) XXX_5
            ORDER BY CMP,DTP,CUR,RWSQ
        ) 
        LOOP
            IF L_CST_ACCL.RWSQ = 1 THEN
                DIV_SEQ := DIV_SEQ + 1;
                TMP_SEQ := 1;
                TTL_SEQ := 0;
            ELSE
                IF L_CST_ACCL.SAMT = 0 THEN
                    IF TMP_SEQ > V_LINE_CNT_SET THEN    --Total Cnt of Dr&Cr set > LineSetCnt --> Next SeqNo. Dividing
                        DIV_SEQ := DIV_SEQ + 1;
                        TMP_SEQ := 1;
                        TTL_SEQ := 0;
                    ELSE
                        NULL;
                    END IF;
                ELSE
                    IF L_CST_ACCL.BAMT = 0 THEN     -- Dr&Cr set relation of previousRow is OK
                        IF TTL_SEQ+L_CST_ACCL.GRP_CT > V_LINE_CNT_SET THEN  --Count of Previous Dr&Cr Set + Count ofCurrent DR&CR Set > LineSetCnt ---> Next SeqNo. Divding
                            DIV_SEQ := DIV_SEQ + 1;
                            TMP_SEQ := 1;
                            TTL_SEQ := 0;
                        ELSE
                            IF L_CST_ACCL.GRP_DIV_SQ < L_CST_ACCL.BF_GRP_DIV_SQ THEN --Previous 차대변 set의 라인설정값에 걸려 다음 SeqNo로 분리된 row와 현재 차대변 set와는 분리한다,
                                DIV_SEQ := DIV_SEQ + 1;
                                TMP_SEQ := 1;
                                TTL_SEQ := 0;
                            END IF;
                        END IF;
                    ELSE
                        IF TMP_SEQ > V_LINE_CNT_SET THEN    --Current Dr&Cr set relation >  LineSetCnt --> Next SeqNo. Dividing
                            DIV_SEQ := DIV_SEQ + 1;
                            TMP_SEQ := 1;
                            TTL_SEQ := 0; 
                        END IF;
                    END IF;
                END IF;
            END IF;
            
            --INSERT Statment...
            CST_ACCL_R.ACCT_CO_CD               :=  L_CST_ACCL.CMP;
            CST_ACCL_R.IF_DOC_TP_CD             :=  L_CST_ACCL.DTP;
            CST_ACCL_R.CURR_CD               	:=  L_CST_ACCL.CUR;     
            CST_ACCL_R.CTRT_NO                  :=  L_CST_ACCL.CTRN; 
            CST_ACCL_R.PST_KEY_CD               :=  L_CST_ACCL.PSK;      
            CST_ACCL_R.VAT_TAX_CD               :=  L_CST_ACCL.TX;       
            CST_ACCL_R.COST_CTR_CD              :=  L_CST_ACCL.CTR;  
            CST_ACCL_R.GL_ACCT_NO               :=  L_CST_ACCL.GLA;  
            CST_ACCL_R.VNDR_CRTR_ACCT_NO        :=  L_CST_ACCL.AVC;
            CST_ACCL_R.PFITCTR_CD               :=  L_CST_ACCL.PTR; 
            CST_ACCL_R.ALTN_ACCT_NO             :=  L_CST_ACCL.AACT; 
            CST_ACCL_R.ACT_PLC_CD               :=  L_CST_ACCL.APL;  
            CST_ACCL_R.ACT_DT                   :=  L_CST_ACCL.ADT;   
            CST_ACCL_R.VSL_CD                   :=  L_CST_ACCL.VSL;      
            CST_ACCL_R.VVL_CD                   :=  L_CST_ACCL.VVL;
            CST_ACCL_R.BIZ_PRNR_REF_KEY_CD1     :=  L_CST_ACCL.BZRF;
            CST_ACCL_R.LOCL_AMT                 :=  L_CST_ACCL.LAMT; 
            CST_ACCL_R.DOC_AMT                  :=  L_CST_ACCL.DAMT;
            CST_ACCL_R.SYS_SRC_ID               :=  L_CST_ACCL.MAX_SYS_SRC_ID;
             
            INSERT_TMP_CST_ACCL(pi_doc_dt => V_PRM_E, pi_div_seq => DIV_SEQ, pi_cst_accl_r => CST_ACCL_R);
            
            TMP_SEQ := TMP_SEQ +1;
            TTL_SEQ := TTL_SEQ +1;
        END LOOP; 
        ---------------------------------------------------------------------------------------------------------------------------------------------------
        
        ---------------------------------------------------------------------------------------------------------------------------------------------------
        INSERT INTO SAC_COST_ACCL_IF
        (
                COST_IF_SEQ             --1
            ,   IF_SEQ_NO
            ,   ACCT_CO_CD
            ,   IF_DOC_TP_CD
            ,   DOC_DT                  --5
            ,   PST_DT
            ,   REF_DOC_NO
            ,   DOC_HDR_CD
            ,   CURR_CD
            ,   PST_KEY_CD              --10
            ,   VAT_TAX_CD
            ,   LOCL_AMT
            ,   DOC_AMT
            ,   COST_CTR_CD
            ,   GL_ACCT_NO              --15
            ,   VNDR_CRTR_ACCT_NO
            ,   DUE_DT_CALC_BSEL_DT
            ,   PFITCTR_CD
            ,   ALTN_ACCT_NO
            ,   BIZ_PRNR_REF_KEY_CD1    --20
            ,   CTRT_NO
            ,   CTRT_TP_CD
            ,   ACT_PLC_CD
            ,   ACT_DT
            ,   VSL_CD                  --25
            ,   VVL_CD
            ,   CRE_USR_ID
            ,   CRE_DT
            ,   UPD_USR_ID             
            ,   UPD_DT                  --30
            ,   IF_FLG                  
            ,   SYS_SRC_ID              --32
        )
        SELECT	SAC_COST_IF_SEQ.NEXTVAL                             AS  COST_IF_SEQ                                 --01    COST_IF_SEQ                                 -            
            ,	SEQ_NO                     				            AS  IF_SEQ_NO									--      Sequence Number                                      
            ,	CO_CD                        																        --      Company Code                                         
            ,	DOCTP	                    																        --      Document Type                                        
            ,	V_PRM_E                                             AS  DOC_DT         					            --05    Document Date in Document                             
            ,	V_PRM_E        							            AS  PST_DT						                --      Posting Date in the Document                         
            ,	SEQ_NO                    				    	    AS  REF_DOC_NUM								    --      Reference Document Number                            
            ,	'OPR306' || TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS')    AS  DOCU_HDR_TXT                                --      Document Header Text                                 
            ,	CURR                        				        AS  CURR_CD									    --      Currency Key                                         
            ,	PSK                         																        --10    Posting Key                                           
            ,	TXCD         										                                    			--      Tax on Sales/Purchases Code                          
            ,	AMOUNT_IN_LOCAL_CURRENCY            				AS  LOCL_AMT								    --      Amount in local currency                             
            ,	AMOUNT_IN_DOCUMENT_CURRENCY         				AS  DOC_AMT									    --      Amount in document currency                          
            ,	COST_CENTER                         																--      Cost Center                                          
            ,	GL_ACCOUNT_NUMBER                   				AS  GL_ACCT_NO									--15    G/L Account Number                                    
            ,	ACCT_NUMBER_OF_VENDOR_CREDITOR      				AS  VNDR_CRTR_ACCT_NO							--      Account Number of Vendor or Creditor                       
            ,	BASELINE_DT_FOR_DUE_DT_CALC                         AS  BASELINE_DT        				            --      Baseline date for due date calculation                         
            ,	PROFIT_CENTER                       																--      Profit Center                                        
            ,	ALTN_ACCT_NUMBER_COMPANY_CODE                       AS  ALTN_ACCT_NO       	                        --      Alternative account number in company code                        
            ,	BUSINESS_PARTNER_REF_KEY1           				AS  BIZ_PRNR_REF_KEY_CD1						--20    Business partner reference key                       
            ,	CONTRACT_NUMBER                     				AS  CTRT_NO 									--      Contract Number                                      
            ,	CONTRACT_TYPE                                       AS  CTRT_TP		                                --      Contract Type                                        
            ,	ACTIVITY_PLACE                      																--      Activity Place                                       
            ,	ACTIVITY_DATE                       																--      Activity Date                                        
            ,	VESSEL                              																--25    Vessel                                      
            ,	VVL                                 																--      VVL
            , 	'SYSTEM'                                            AS  CRE_USR_ID              		            --      CRE_USR_ID                                                                                               
            , 	SYSDATE                             				AS  CRE_DT							            --      CRE_DT                                                                             
            , 	'SYSTEM'                            				AS  UPD_USR_ID						            --      UPD_USR_ID                                                                                                                  
            , 	SYSDATE                             				AS  UPD_DT							            --30    UPD_DT                                                                                               
            , 	'N'                                 				AS  IF_FLG									    --      IF_FLG                                                                                                                   
            , 	MAX_SYS_SRC_ID                                      AS  SYS_SRC_ID								    --32    SYS_SRC_ID                                                                                                                   
        FROM
        (
            SELECT  CASE WHEN PSK IN ('40', '21') THEN 'DR' ELSE 'CR' END AS DR_CR_FLG   
                ,   XXXXXX.*
            FROM
            ( 
                SELECT  IF_SEQ_NO                                                                   AS  SEQ_NO
                    ,   ACCT_CO_CD                                                                  AS  CO_CD
                    ,   IF_DOC_TP_CD                                                                AS  DOCTP
                    ,   CURR_CD                                                                     AS  CURR                                                                               
                    ,   SYS_SRC_ID                                                                  AS  MAX_SYS_SRC_ID                                                                               
                    ,   DECODE(L, '1',LOCL_AMT      					    ,   ABS(T1)         )   AS  AMOUNT_IN_LOCAL_CURRENCY 
                    ,   DECODE(L, '1',DOC_AMT      					        ,   ABS(T2)         )   AS  AMOUNT_IN_DOCUMENT_CURRENCY 
                    ,   DECODE(L, '1',PST_KEY_CD          					,   SUP_PSK         )   AS  PSK        
                    ,   DECODE(L, '1',VAT_TAX_CD         					,   NULL            )   AS  TXCD                        
                    ,   DECODE(L, '1',COST_CTR_CD      					    ,   NULL            )   AS  COST_CENTER                 
                    ,   DECODE(L, '1',GL_ACCT_NO      					    ,   SUPGL           )   AS  GL_ACCOUNT_NUMBER           
                    ,   DECODE(L, '1',VNDR_CRTR_ACCT_NO 					,   NULL            )   AS  ACCT_NUMBER_OF_VENDOR_CREDITOR            
                    ,   DECODE(L, '1',DECODE(VAT_TAX_CD, 'F0','', V_PRM_E)  ,   NULL            )   AS  BASELINE_DT_FOR_DUE_DT_CALC           
                    ,   DECODE(L, '1',PFITCTR_CD                            ,   'Z900'          )   AS  PROFIT_CENTER               
                    ,   DECODE(L, '1',ALTN_ACCT_NO     					    ,   NULL            )   AS  ALTN_ACCT_NUMBER_COMPANY_CODE   
                    ,   DECODE(L, '1',BIZ_PRNR_REF_KEY_CD1                  ,   NULL            )   AS  BUSINESS_PARTNER_REF_KEY1   
                    ,   DECODE(L, '1',CTRT_NO     					        ,   NULL            )   AS  CONTRACT_NUMBER
                    ,   DECODE(L, '1','Z'                                   ,   NULL            )   AS  CONTRACT_TYPE                          
                    ,   DECODE(L, '1',ACT_PLC_CD      					    ,   NULL            )   AS  ACTIVITY_PLACE              
                    ,   DECODE(L, '1',ACT_DT       				            ,   V_PRM_E         )   AS  ACTIVITY_DATE               
                    ,   DECODE(L, '1',VSL_CD          					    ,   NULL            )   AS  VESSEL                      
                    ,   DECODE(L, '1',VVL_CD          					    ,   NULL            )   AS  VVL
                    ,   DECODE(L, '1','N'          					        ,   'Y'             )   AS  SUP_ACCT_FLG
                FROM
                (
                    SELECT  DECODE(ROW_SEQQ, 1,(CASE WHEN T2>0 THEN '50' WHEN T2<0 THEN '40' ELSE '' END), '') AS SUP_PSK
                        ,   XXXXX.*
                    FROM
                    (
                        SELECT  SUM(DECODE(PST_KEY_CD,'40',1,-1)*LOCL_AMT) OVER (PARTITION BY IF_SEQ_NO ORDER BY IF_SEQ_NO)  AS T1
                            ,   SUM(DECODE(PST_KEY_CD,'40',1,-1)*DOC_AMT)  OVER (PARTITION BY IF_SEQ_NO ORDER BY IF_SEQ_NO)  AS T2
                            ,   ROW_NUMBER()                               OVER (PARTITION BY IF_SEQ_NO ORDER BY IF_SEQ_NO)  AS ROW_SEQQ
                            ,   XXXX.*
                        FROM
                        (
                            SELECT  TMPCOST.*
                            FROM    SAC_COST_ACCL_IF TMPCOST
                            WHERE   ERP_IF_ERR_RSN = 'TEMP'
                              AND   IF_FLG = 'E'
                              AND   DOC_DT = V_PRM_E
                            ORDER BY COST_IF_SEQ
                            
                        ) XXXX
                    ) XXXXX
                ) AA, (SELECT LEVEL AS L FROM DUAL CONNECT BY LEVEL <= 2) BB
            ) XXXXXX
            WHERE   PSK IS NOT NULL
            ORDER BY SEQ_NO, DR_CR_FLG DESC, SUP_ACCT_FLG
        )
        --WHERE   NVL(AMOUNT_IN_LOCAL_CURRENCY, AMOUNT_IN_DOCUMENT_CURRENCY) > 0
        ;

        OUT_YN := 'Y';
        OUT_RESULT := SQL%ROWCOUNT || ' Cost Accrual Data Created.';
        
        COMMIT;

        --TEMP DATA DELETE...
        DELETE  SAC_COST_ACCL_IF
        WHERE   ERP_IF_ERR_RSN = 'TEMP' 
          AND   IF_FLG = 'E'
          AND   DOC_DT = V_PRM_E;
        
        COMMIT;

        --Cost Accrual RowData Interface Flag Update...
        UPDATE  SAC_COST_ACCL_INFO CSTACCL
        SET     CSTACCL.IF_FLG = 'Y'
        WHERE   CSTACCL.EXE_YRMON = V_PRM;

        COMMIT;

        --G/L Estimated VVD RowData Accrual Close Flag Update...
        UPDATE  SAC_ESTM_REV_VVD ESTMVVD
        SET     ESTMVVD.ACCL_CLZ_FLG = 'Y'
        WHERE   ESTMVVD.EXE_YRMON = V_PRM;

        COMMIT;

    EXCEPTION
        WHEN USER_CALL_EX THEN
            ROLLBACK;
            SCO_ERR_LOG_PRC('SAC_BRG_IF_PKG.'||V_PRC_NM, OUT_RESULT, EXE_YYYYMM, MOD_NAME);
            OUT_YN := 'N';
        WHEN OTHERS THEN
            ROLLBACK;
            SCO_ERR_LOG_PRC('SAC_BRG_IF_PKG.'||V_PRC_NM, SQLERRM, EXE_YYYYMM, MOD_NAME);
            OUT_YN := 'N';
            OUT_RESULT := SQLERRM;
    END SAC_COST_ACCL_IF_PRC;

    --OPR309 : Freight Accrual Detail SAKUARA Monthly I/F
    --Run through EAI from SKUARA on 3WD
    PROCEDURE SAC_FRT_ACCL_DTL_IF_PRC
    (
            EXE_YYYYMM      IN  VARCHAR2
        ,   OUT_YN          OUT VARCHAR2
        ,   OUT_RESULT      OUT VARCHAR2
    )
    IS
        J_PRCS              NUMBER          :=  SAC_BRG_IF_PKG.GET_AMT_PRECISION('JPY');
        U_PRCS              NUMBER          :=  SAC_BRG_IF_PKG.GET_AMT_PRECISION('USD');
        CUR_MON             DATE            :=  TO_DATE(EXE_YYYYMM, 'YYYYMM');
        V_PRM               VARCHAR2(6)     :=  TO_CHAR(ADD_MONTHS(CUR_MON, -1), 'YYYYMM');
        V_PRM_E             VARCHAR2(8)     :=  TO_CHAR(LAST_DAY(ADD_MONTHS(CUR_MON, -1)), 'YYYYMMDD');
        V_PRC_NM            VARCHAR2(50)    :=  'SAC_FRT_ACCL_DTL_IF_PRC';
        MOD_NAME            VARCHAR2(10)    :=  'ACCRUAL';
      --REVGL               VARCHAR2(20)    :=  '7001000000';
        RECGL               VARCHAR2(20)    :=  '5060000000';
        
        USER_CALL_EX        EXCEPTION;
    BEGIN
        --check whether AR period is open or not
        IF GET_PERIOD_CLS_FLG('AR', V_PRM) = 'N' THEN
            OUT_RESULT := V_PRM || ' AR Period still open.';
            RAISE USER_CALL_EX;
        END IF;
        
        -- Uploaded Data Dup Delete
        DELETE  FROM SAC_FRT_ACCL_DTL_IF WHERE DOC_DT = V_PRM_E;        
        COMMIT;

        INSERT INTO SAC_FRT_ACCL_DTL_IF
        (
                FRT_IF_SEQ              --1
            ,   IF_SEQ_NO
            ,   ACCT_CO_CD
            ,   IF_DOC_TP_CD
            ,   DOC_DT                  --5
            ,   PST_DT
            ,   REF_DOC_NO
            ,   DOC_HDR_CD
            ,   CURR_CD
            ,   PST_KEY_CD              --10
            ,   VAT_TAX_CD
            ,   LOCL_AMT
            ,   DOC_AMT
            ,   COST_CTR_CD
            ,   GL_ACCT_NO              --15
            ,   CUST_NO
            ,   PFITCTR_CD
            ,   ALTN_ACCT_NO
            ,   BIZ_PRNR_REF_KEY_CD1
            ,   CTRT_NO                 --20
            ,   CTRT_TP_CD
            ,   ACT_PLC_CD
            ,   ACT_DT
            ,   VSL_CD
            ,   VVL_CD                  --25
            ,   CRE_USR_ID
            ,   CRE_DT
            ,   UPD_USR_ID
            ,   UPD_DT         
            ,   IF_FLG                  --30
        )
        SELECT	SAC_FRT_DTL_IF_SEQ.NEXTVAL                              AS  FRT_IF_SEQ                      --01    FRT_IF_SEQ          
            ,	SEQ_NO                     					            AS  IF_SEQ_NO   					--      Sequence Number                                      
            ,	CO_CD                        							AS  ACCT_CO_CD						--      Company Code                                         
            ,	DOCTP	                    							AS  IF_DOC_TP_CD					--      Document Type                                        
            ,	V_PRM_E                                                 AS  DOC_DT                          --05    Document Date in Document                             
            ,	V_PRM_E        								            AS  PST_DT				            --      Posting Date in the Document                         
            ,	BL_NO                    						        AS  REF_DOC_NUM	                    --      Reference Document Number                            
            ,	'OPR309' || TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS')        AS  DOC_HDR_TXT                     --      Document Header Text                                 
            ,	CURR                        					        AS  CURR_CD 						--      Currency Key                                         
            ,	PSK                         							AS  PST_KEY_CD					    --10    Posting Key                                           
            ,	TXCD         											AS  VAT_TAX_CD                      --      Tax on Sales/Purchases Code                          
            ,	AMOUNT_IN_LOCAL_CURRENCY                                AS  LOCAL_AMT						--      Amount in local currency                             
            ,	AMOUNT_IN_DOCUMENT_CURRENCY         					AS  DOCU_AMT    					--      Amount in document currency                          
            ,	COST_CENTER                         					AS	COST_CTR_CD						--      Cost Center                                          
            ,	GL_ACCOUNT_NUMBER                   					AS  GL_ACCT_NO						--15    G/L Account Number                                    
            ,   CUSTOMER_NUMBER1                                        AS  CUST_NO                         --      Customer Number1
            ,	PROFIT_CENTER                       					AS	PFITCTR_CD						--      Profit Center                                        
            ,	ALTN_ACCT_NUMBER_COMPANY_CODE                           AS  ALTN_ACCT_NO      	            --      Alternative account number in company code                        
            ,	BUSINESS_PARTNER_REF_KEY1                               AS  BIZ_PRNR_REF_KEY_CD1			--      Business partner reference key                       
            ,	CONTRACT_NUMBER                     					AS  CTRT_NO							--20    Contract Number                                      
            ,	'Z'                                                     AS  CTRT_TP     	                --      Contract Type                                        
            ,	ACTIVITY_PLACE                      					AS	ACT_PLC_CD						--      Activity Place                                       
            ,	ACTIVITY_DATE                       					AS	ACT_DT							--      Activity Date                                        
            ,	VESSEL                              					AS	VSL_CD							--      Vessel                                      
            ,	VVL                                 					AS	VVL_CD							--25    VVL
            , 	CRE_USR_ID                                              AS  CRE_USR_ID              		--      CRE_USR_ID                                                                                               
            , 	SYSDATE                             					AS  CRE_DT							--      CRE_DT                                                                             
            , 	UPD_USR_ID                            					AS  UPD_USR_ID						--      UPD_USR_ID                                                                                                                  
            , 	SYSDATE                             					AS  UPD_DT							--      UPD_DT                                                                                                                
            , 	'N'                                 					AS  IF_FLG							--30    IF_FLG                                                                                                                   
        FROM
        (
            SELECT  DENSE_RANK() OVER (ORDER BY CO_CD, DOCTP, BL_NO, CURR)  AS  SEQ_NO
                ,   DECODE(PSK, '50','CR', 'DR')                            AS  DR_CR_FLG
                ,   AA.*
            FROM
            (
                SELECT 	'1000'                                                  AS  CO_CD  
                    ,   'HA'        											AS  DOCTP  
                    ,   BL_NO       											AS  BL_NO       
                    ,   CURR_CD       											AS  CURR  
                    ,   LOCL_AMT    											AS  AMOUNT_IN_LOCAL_CURRENCY 
                    ,   DOCU_AMT    											AS  AMOUNT_IN_DOCUMENT_CURRENCY
                    ,   CUST_NUM    											AS  CONTRACT_NUMBER 
                    ,   CRE_USR_ID                                              AS  CRE_USR_ID
                    ,   UPD_USR_ID                                              AS  UPD_USR_ID
                    , 	DECODE(L, '1','01'    	,   '50'                    )   AS  PSK                        
                    , 	DECODE(L, '1',NULL    	,   TAX_CD                  )   AS  TXCD        
                    , 	DECODE(L, '1',NULL    	,   PFIT_CTR                )   AS  COST_CENTER                        
                    , 	DECODE(L, '1',NULL    	,   GL_ACCT                 )   AS  GL_ACCOUNT_NUMBER
                    ,   DECODE(L, '1',CUST_NUM	,   NULL                    )   AS  CUSTOMER_NUMBER1                  
                    , 	DECODE(L, '1',NULL    	,   PFIT_CTR                )   AS  PROFIT_CENTER                      
                    , 	DECODE(L, '1',RECGL   	,   NULL                    )   AS  ALTN_ACCT_NUMBER_COMPANY_CODE      
                    , 	DECODE(L, '1',PFIT_CTR	,   NULL                    )   AS  BUSINESS_PARTNER_REF_KEY1          
                    , 	DECODE(L, '1',NULL    	,   ACT_PLC                 )   AS  ACTIVITY_PLACE                     
                    , 	DECODE(L, '1',NULL    	,   ACT_DT                  )   AS  ACTIVITY_DATE                      
                    , 	DECODE(L, '1',NULL    	,   DX_VSL                  )   AS  VESSEL                             
                    , 	DECODE(L, '1',NULL      ,   DX_VSL||DX_VOY||DX_DIR  )   AS  VVL                                
                FROM
                (
                    SELECT  X.BL_NO                                                                                 AS  BL_NO
                        ,   X.CURR_CD                                                                               AS  CURR_CD
                        ,   CASE WHEN SUBSTR(POL_CD,1,2)='JP' OR SUBSTR(POD_CD,1,2)='JP' THEN 'B0' ELSE 'D0' END    AS  TAX_CD
                        ,   ROUND(X.LOCL_AMT    , J_PRCS   )	                                                    AS  LOCL_AMT
                        ,   ROUND(X.TJ_AMT      , U_PRCS    )                                                       AS  DOCU_AMT
                        ,   (SELECT MODI_COST_CTR_CD FROM MDM_TRADE MT WHERE MT.TRD_CD = X.TRD_CD)                  AS  PFIT_CTR
                        ,   X.IF_CUST_CD                                                                            AS  CUST_NUM
                        ,   (SELECT MODI_LOC_CD FROM MDM_LOCATION WHERE LOC_CD = X.POL_CD)                          AS  ACT_PLC
                        ,   TO_CHAR(X.POL_ETD_DT, 'YYYYMMDD')                                                       AS  ACT_DT
                        ,   (SELECT MODI_VSL_CD FROM MDM_VSL_CNTR WHERE VSL_CD = SUBSTR(X.VVD_CD,1,4))              AS  DX_VSL
                        ,   SUBSTR(X.VVD_CD,6,3)                                                                    AS  DX_VOY
                        ,   SAC_BRG_IF_PKG.GET_DTX_DIR_CD(X.SLAN_CD, X.VVD_CD)                                      AS  DX_DIR                                
                        ,   X.CRE_USR_ID                                                                            AS  CRE_USR_ID
                        ,   X.UPD_USR_ID                                                                            AS  UPD_USR_ID
                        ,   X.GL_ACCT_NO                                                                            AS  GL_ACCT
                    FROM    SAC_FRT_ACCL_PRE_IF X
                    WHERE   EXE_YRMON   = V_PRM                                             --Accrual data that extracted by ETL Job in monthly    
                      AND   POL_ETD_DT <= TO_DATE(V_PRM_E||'235959', 'YYYYMMDDHH24MISS')    --sailing date <= EndofMonth
                ) A, (SELECT LEVEL AS L FROM DUAL CONNECT BY LEVEL <= 2) B
            ) AA
            ORDER BY SEQ_NO, DR_CR_FLG DESC
        )
        --WHERE   NVL(AMOUNT_IN_LOCAL_CURRENCY, AMOUNT_IN_DOCUMENT_CURRENCY) > 0
        ;
   
        OUT_YN := 'Y';
        OUT_RESULT := SQL%ROWCOUNT || ' Freight Accrual Detail Data Created.';
        
        COMMIT;
        
    EXCEPTION
        WHEN USER_CALL_EX THEN
            ROLLBACK;
            SCO_ERR_LOG_PRC('SAC_BRG_IF_PKG.'||V_PRC_NM, OUT_RESULT, EXE_YYYYMM, MOD_NAME);
            OUT_YN := 'N';
        WHEN OTHERS THEN
            ROLLBACK;
            SCO_ERR_LOG_PRC('SAC_BRG_IF_PKG.'||V_PRC_NM, SQLERRM, EXE_YYYYMM, MOD_NAME);
            OUT_YN := 'N';
            OUT_RESULT := SQLERRM;
    END SAC_FRT_ACCL_DTL_IF_PRC;
    
    --OPR310 : Freight Deferral Detail SAKUARA Monthly I/F
    --Run through EAI from SKUARA on 3WD
    PROCEDURE SAC_FRT_DEFR_DTL_IF_PRC
    (
            EXE_YYYYMM      IN  VARCHAR2
        ,   OUT_YN          OUT VARCHAR2
        ,   OUT_RESULT      OUT VARCHAR2
    )
    IS
        J_PRCS              NUMBER          :=  SAC_BRG_IF_PKG.GET_AMT_PRECISION('JPY');
        U_PRCS              NUMBER          :=  SAC_BRG_IF_PKG.GET_AMT_PRECISION('USD');
        CUR_MON             DATE            :=  TO_DATE(EXE_YYYYMM, 'YYYYMM');
        V_PRM               VARCHAR2(6)     :=  TO_CHAR(ADD_MONTHS(CUR_MON, -1), 'YYYYMM');
        V_PRM_E             VARCHAR2(8)     :=  TO_CHAR(LAST_DAY(ADD_MONTHS(CUR_MON, -1)), 'YYYYMMDD');
        V_PRC_NM            VARCHAR2(50)    :=  'SAC_FRT_DEFR_DTL_IF_PRC';
        MOD_NAME            VARCHAR2(10)    :=  'ACCRUAL';
      --REVGL               VARCHAR2(20)    :=  '7001000000';
        OTSGL               VARCHAR2(20)    :=  '5060000100';
        RCVGL               VARCHAR2(20)    :=  '6220100050';
        
        USER_CALL_EX        EXCEPTION;
    BEGIN
        --check whether AR period is open or not
        IF GET_PERIOD_CLS_FLG('AR', V_PRM) = 'N' THEN
            OUT_RESULT := V_PRM || ' AR Period still open.';
            RAISE USER_CALL_EX;
        END IF;

        -- Uploaded Data Dup Delete
        DELETE  FROM SAC_FRT_DEFR_DTL_IF WHERE DOC_DT = V_PRM_E;        
        COMMIT;
        
        INSERT INTO SAC_FRT_DEFR_DTL_IF
        (
                DEFR_IF_SEQ             --1
            ,   IF_SEQ_NO
            ,   ACCT_CO_CD
            ,   IF_DOC_TP_CD
            ,   DOC_DT                  --5
            ,   PST_DT
            ,   REF_DOC_NO
            ,   DOC_HDR_CD
            ,   CURR_CD
            ,   PST_KEY_CD              --10
            ,   VAT_TAX_CD
            ,   LOCL_AMT
            ,   DOC_AMT
            ,   ASGN_NO
            ,   COST_CTR_CD             --15
            ,   GL_ACCT_NO
            ,   PFITCTR_CD
            ,   CTRT_NO
            ,   CTRT_TP_CD
            ,   ACT_PLC_CD              --20
            ,   ACT_DT
            ,   VSL_CD
            ,   VVL_CD
            ,   CRE_USR_ID
            ,   CRE_DT                  --25                  
            ,   UPD_USR_ID
            ,   UPD_DT
            ,   IF_FLG                  --28
        )
        SELECT	SAC_DEFR_DTL_IF_SEQ.NEXTVAL                         AS  DEFR_IF_SEQ                         --01    DEFR_IF_SEQ        
            ,	SEQ_NO                     				            AS  IF_SEQ_NO			                --      Sequence Number                                      
            ,	CO_CD                        						AS	ACCT_CO_CD						    --      Company Code                                         
            ,	DOCTP	                    						AS	IF_DOC_TP_CD						--      Document Type                                        
            ,	V_PRM_E                                             AS  DOC_DT                              --05    Document Date in Document                             
            ,	V_PRM_E        		                                AS  PST_DT                              --      Posting Date in the Document                         
            ,	BL_NO                        				        AS  REF_DOC_NUM			                --      Reference Document Number                            
            ,	'OPR310' || TO_CHAR(SYSDATE, 'YYYYMMDDHH24MISS')    AS  DOC_HDR_TXT            	            --      Document Header Text                                 
            ,	CURR                        				        AS  CURR_CD 							--      Currency Key                                         
            ,	PSK                         						AS	PST_KEY_CD				            --10    Posting Key                                           
            ,	TXCD         										AS  VAT_TAX_CD                          --      Tax on Sales/Purchases Code                          
            ,	AMOUNT_IN_LOCAL_CURRENCY            				AS  LOCL_AMT		                    --      Amount in local currency                             
            ,	AMOUNT_IN_DOCUMENT_CURRENCY         				AS  DOC_AMT							    --      Amount in document currency                          
            ,   NULL                                                AS  ASGN_NO                             --      Assignment Number
            ,	COST_CENTER                         				AS	COST_CTR_CD							--15    Cost Center                                          
            ,	GL_ACCOUNT_NUMBER                   				AS  GL_ACCT_NO							--      G/L Account Number                                    
            ,	PROFIT_CENTER                       				AS	PFITCTR_CD							--      Profit Center                                        
            ,	CONTRACT_NUMBER                     				AS  CTRT_NO								--      Contract Number                                      
            ,	'Z'                                                 AS  CTRT_TP						        --      Contract Type                                        
            ,	ACTIVITY_PLACE                      				AS	ACT_PLC_CD							--20    Activity Place                                       
            ,	ACTIVITY_DATE                       				AS	ACT_DT								--      Activity Date                                        
            ,	VESSEL                              				AS	VSL_CD								--      Vessel                                      
            ,	VVL                                 				AS	VVL_CD								--      VVL
            , 	CRE_USR_ID                            			    AS  CRE_USR_ID							--      CRE_USR_ID                                                                                               
            , 	SYSDATE                             				AS  CRE_DT								--25    CRE_DT                                                                             
            , 	UPD_USR_ID                            				AS  UPD_USR_ID							--      UPD_USR_ID                                                                                                                  
            , 	SYSDATE                             				AS  UPD_DT								--      UPD_DT                                                                                                                
            , 	'N'                                 				AS  IF_FLG								--28    IF_FLG                                                                                                                   
        FROM
        (
            SELECT  DENSE_RANK() OVER (ORDER BY CO_CD, DOCTP, BL_NO, CURR)  AS  SEQ_NO
                ,   DECODE(PSK, '50','CR', 'DR')                            AS  DR_CR_FLG   
                ,   AA.*
            FROM
            ( 
                SELECT  CO_CD
                    ,   DOCTP
                    ,   BL_NO
                    ,   CURR
                    ,   COST_CENTER
                    ,   PROFIT_CENTER
                    ,   GL_ACCOUNT_NUMBER
                    ,   ACTIVITY_PLACE
                    ,   ACTIVITY_DATE
                    ,   VESSEL
                    ,   VVL
                    ,   CONTRACT_NUMBER
                    ,   MAX(PSK)                            AS  PSK
                    ,   MAX(TXCD)                           AS  TXCD 
                    ,   MAX(CRE_USR_ID)                     AS  CRE_USR_ID
                    ,   MAX(UPD_USR_ID)                     AS  UPD_USR_ID
                    ,   SUM(AMOUNT_IN_LOCAL_CURRENCY)       AS  AMOUNT_IN_LOCAL_CURRENCY
                    ,   SUM(AMOUNT_IN_DOCUMENT_CURRENCY)    AS  AMOUNT_IN_DOCUMENT_CURRENCY
                FROM
                (
                    SELECT 	'1000'                                                                                          AS  CO_CD  
                        ,   'HB'        																					AS  DOCTP  
                        ,   BL_NO       																					AS  BL_NO       
                        , 	CURR_CD     																					AS  CURR  
                        , 	PFITCTR_CD  																					AS  PROFIT_CENTER  
                        ,   CTRT_NO     																					AS  CONTRACT_NUMBER                    
                        , 	DECODE(CURR_CD, 'JPY',NULL, ROUND((DEFER_DYS/TTL_DYS)*LOCL_AMT, J_PRCS)                     )   AS  AMOUNT_IN_LOCAL_CURRENCY           
                        , 	ROUND((DEFER_DYS/TTL_DYS)*DOC_AMT, DOCU_AMT_PRCS                                            )   AS  AMOUNT_IN_DOCUMENT_CURRENCY
                        ,   CRE_USR_ID                                                                                      AS  CRE_USR_ID
                        ,   UPD_USR_ID                                                                                      AS  UPD_USR_ID
                        , 	DECODE(L, '1',DECODE(TP, 'AT',DECODE(PSK,'50','40','50'), '40') ,   DECODE(TP,'AT',PSK,'50'))   AS  PSK                        
                        , 	DECODE(L, '1',VAT_TAX_CD                                        ,   'F0'                    )	AS  TXCD        
                        , 	DECODE(L, '1',COST_CTR_CD                                       ,   NULL                    )	AS  COST_CENTER                        
                        , 	DECODE(L, '1',GL_ACCT_NO                                        ,   DEFERR_GL_ACCT_NO       )	AS  GL_ACCOUNT_NUMBER
                        , 	DECODE(L, '1',ACT_PLC_CD                                        ,   NULL                    )	AS  ACTIVITY_PLACE                     
                        , 	DECODE(L, '1',ACT_DT                                            ,   NULL                    )	AS  ACTIVITY_DATE                      
                        , 	DECODE(L, '1',VSL_CD                                            ,   NULL                    )	AS  VESSEL                             
                        , 	DECODE(L, '1',VVL_CD                                            ,   NULL                    )   AS  VVL                                
                    FROM
                    (   
                        -- 1. Accrual Data
                        SELECT  'AL'                                                                                    AS  TP
                            ,   AC.CURR_CD                                                                              AS  CURR_CD
                            ,   '50'                                                                                    AS  PSK
                            ,   BL_NO                                                                                   AS  BL_NO
                            ,   CASE WHEN SUBSTR(POL_CD,1,2)='JP' OR SUBSTR(POD_CD,1,2)='JP' THEN 'B0' ELSE 'D0' END    AS  VAT_TAX_CD
                            ,   NVL(ROUND(LOCL_AMT  , J_PRCS    ), 0)                                                   AS  LOCL_AMT
                            ,   NVL(ROUND(TJ_AMT    , U_PRCS    ), 0)                                                   AS  DOC_AMT
                            ,   (SELECT MODI_COST_CTR_CD FROM MDM_TRADE MT WHERE MT.TRD_CD = AC.TRD_CD)                 AS	COST_CTR_CD
                            ,   AC.GL_ACCT_NO                                                                           AS	GL_ACCT_NO
                            ,   OTSGL                                                                                   AS  DEFERR_GL_ACCT_NO
                            ,   (SELECT MODI_COST_CTR_CD FROM MDM_TRADE MT WHERE MT.TRD_CD = AC.TRD_CD)                 AS	PFITCTR_CD 
                            ,   IF_CUST_CD                                                                              AS	CTRT_NO    
                            ,   (SELECT MODI_LOC_CD FROM MDM_LOCATION WHERE LOC_CD = AC.POL_CD)                         AS	ACT_PLC_CD 
                            ,   TO_CHAR(POL_ETD_DT, 'YYYYMMDD')                                                         AS	ACT_DT     
                            ,   (SELECT MODI_VSL_CD FROM MDM_VSL_CNTR WHERE VSL_CD = SUBSTR(AC.VVD_CD,1,4))             AS	VSL_CD     
                            ,   (SELECT MODI_VSL_CD FROM MDM_VSL_CNTR WHERE VSL_CD = SUBSTR(AC.VVD_CD,1,4))
                                || SUBSTR(VVD_CD,6,3) || SAC_BRG_IF_PKG.GET_DTX_DIR_CD(AC.SLAN_CD, AC.VVD_CD)           AS	VVL_CD     
                            ,   SAC_BRG_IF_PKG.GET_DAYS_CALC(POD_ETA_DT ,   POL_ETD_DT  )                               AS  TTL_DYS
                            ,   SAC_BRG_IF_PKG.GET_DAYS_CALC(POD_ETA_DT ,   CUR_MON     )                               AS  DEFER_DYS
                            ,   U_PRCS                                                                                  AS  DOCU_AMT_PRCS
                            ,   CRE_USR_ID                                                                              AS  CRE_USR_ID
                            ,   UPD_USR_ID                                                                              AS  UPD_USR_ID
                        FROM    SAC_FRT_ACCL_PRE_IF     AC   
                        WHERE   EXE_YRMON   = V_PRM                                             --Freight Accrual for current month.
                          AND   POL_ETD_DT <= TO_DATE(V_PRM_E||'235959', 'YYYYMMDDHH24MISS')    --sailing date <= End of Month
                          AND   POD_ETA_DT >=  TO_DATE(EXE_YYYYMM||'01', 'YYYYMMDD')            --Bookings, {ETA of Last POD} ≥ {End of Month*}
                        --AND   TRD_CD IN ('TPT', 'TAT', 'AET', 'OCT', 'IAT', 'LAA')
                        UNION ALL
                        -- 2. Actual Data
                        SELECT  'AT'                                                                                    AS  TP
                            ,   CUR                    																    AS  CURR_CD
                            ,   POSTING_KEY                  								    					    AS  PSK
                            ,   BL                                                                                      AS  BL_NO
                            ,   TX                     																    AS  VAT_TAX_CD
                            ,   ROUND(TMP_AMT*SAC_GET_GL_XCH_RT_FNC(1,TO_CHAR(POL_ETD,'YYYYMMDD'),CUR,'JPY'), J_PRCS)   AS  LOCL_AMT
                            ,   ABS(TMP_AMT)               						                					    AS  DOC_AMT
                            ,   CTR                 																    AS  COST_CTR_CD
                            ,   GLA                  																    AS  GL_ACCT_NO
                            ,   DEFR_GL_ACCT       										        					    AS  DEFERR_GL_ACCT_NO
                            ,   PTR                 																    AS  PFITCTR_CD
                            ,   CRTN                  																    AS  CTRT_NO
                            ,   APL                 										    					    AS  ACT_PLC_CD
                            ,   ADT                   										    					    AS  ACT_DT
                            ,   VSL                     															    AS  VSL_CD
                            ,   VVL                     															    AS  VVL_CD
                            ,   SAC_BRG_IF_PKG.GET_DAYS_CALC(POD_ETA ,  POL_ETD )               					    AS  TTL_DYS
                            ,   SAC_BRG_IF_PKG.GET_DAYS_CALC(POD_ETA ,  CUR_MON )               					    AS  DEFER_DYS
                            ,   SAC_BRG_IF_PKG.GET_AMT_PRECISION(CUR)                           					    AS  DOCU_AMT_PRCS
                            ,   CRE_USR_ID                                                                              AS  CRE_USR_ID
                            ,   UPD_USR_ID                                                                              AS  UPD_USR_ID
                        FROM 
                        (
                            SELECT  AAA.*
                                ,   CASE--2nd, 3rd case does not occur on business?
                                        WHEN PSK1 = '50' AND PSK2 = '50' THEN CASE WHEN DIFF_1>=0 THEN DECODE(L, '1','50', '50') ELSE DECODE(L, '1','40', '50') END  
                                        WHEN PSK1 = '40' AND PSK2 = '40' THEN CASE WHEN DIFF_1>=0 THEN DECODE(L, '1','40', '40') ELSE DECODE(L, '1','50', '40') END
                                        WHEN PSK1 = '50' AND PSK2 = '40' THEN DECODE(L, '1','50', '40')                                                         
                                        WHEN PSK1 = '40' AND PSK2 = '50' THEN DECODE(L, '1','40', '50')                                                      
                                    END                                                                                             AS POSTING_KEY
                                ,   CASE 
                                        WHEN RCV_AMT = 0 THEN DECODE(L, '1',ABS(DAMT_TTL), 0) 
                                        ELSE
                                            CASE--2nd, 3rd case does not occur on business?  
                                                WHEN PSK1 = '50' AND PSK2 = '50' THEN  DECODE(L, '1',ABS(DIFF_1), ABS(RCV_AMT)) 
                                                WHEN PSK1 = '40' AND PSK2 = '40' THEN  DECODE(L, '1',ABS(DIFF_1), ABS(RCV_AMT))   
                                                WHEN PSK1 = '50' AND PSK2 = '40' THEN  DECODE(L, '1',ABS(DIFF_2), ABS(RCV_AMT))  
                                                WHEN PSK1 = '40' AND PSK2 = '50' THEN  DECODE(L, '1',ABS(DIFF_2), ABS(RCV_AMT))   
                                            END
                                    END                                                                                             AS TMP_AMT
                                ,   CASE WHEN RCV_AMT = 0 THEN DECODE(L, '1',OTSGL, '') ELSE DECODE(L, '1',OTSGL, RCVGL) END        AS DEFR_GL_ACCT
                            FROM
                            (
                                SELECT  ZZZ.*
                                    ,   CASE WHEN DAMT_TTL >=0 THEN '50' ELSE '40' END  AS PSK1
                                    ,   CASE WHEN RCV_AMT  >=0 THEN '50' ELSE '40' END  AS PSK2
                                    ,   ABS(DAMT_TTL) - ABS(RCV_AMT)                    AS DIFF_1
                                    ,   ABS(DAMT_TTL) + ABS(RCV_AMT)                    AS DIFF_2
                                FROM
                                (
                                    SELECT  ZZ.*
                                        ,   SUM(MK*DOC_AMT) OVER (PARTITION BY BL,CUR,CTR,PTR,GLA,APL,ADT,VSL,VVL,CRTN)                   AS DAMT_TTL
                                        ,   DENSE_RANK()    OVER (PARTITION BY BL,CUR,CTR,PTR,GLA,APL,ADT,VSL,VVL,CRTN ORDER BY UDT DESC) AS ROW_RNK
                                        ,   ROW_NUMBER()    OVER (PARTITION BY BL,CUR,CTR,PTR,GLA,APL,ADT,VSL,VVL,CRTN ORDER BY UDT DESC) AS ROW_NUM
                                    FROM
                                    (
                                        SELECT  BL_NO       AS BL       ,   CURR_CD     AS CUR      ,   PST_KEY_CD                      AS PSK      
                                            ,   VAT_TAX_CD  AS TX       ,   COST_CTR_CD AS CTR      ,   PFITCTR_CD                      AS PTR     
                                            ,   GL_ACCT_CD  AS GLA      ,   CTRT_NO     AS CRTN     ,   UPD_DT                          AS UDT    
                                            ,   ACT_PLC_CD  AS APL      ,   ACT_DT      AS ADT      ,   DECODE(PST_KEY_CD,'50',1,-1)    AS MK    
                                            ,   LOCL_AMT    AS LCL_AMT  ,   TJ_AMT      AS DOC_AMT  ,   RCV_IN_ADV_REV_AMT              AS RCV_AMT  
                                            ,   VSL_CD      AS VSL      ,   VVD_CD      AS VVL   
                                            ,   POL_ETD_DT  AS POL_ETD  ,   POD_ETA_DT  AS POD_ETA 
                                            ,   CRE_USR_ID  AS CRE_USR_ID
                                            ,   UPD_USR_ID  AS UPD_USR_ID
                                        FROM    SAC_FRT_ACT_PRE_IF
                                        WHERE   EXE_YRMON   = V_PRM                                             --Deferred data that extracted by ETL Job in monthly
                                          AND   GL_DT      <= V_PRM_E                                           --posting date is less than or equal to previous month end date 
                                          AND   POL_ETD_DT <= TO_DATE(V_PRM_E||'235959', 'YYYYMMDDHH24MISS')    --Bookings, {Sailing Date} ≤{End of Month*}
                                          AND   POD_ETA_DT >= TO_DATE(EXE_YYYYMM||'01', 'YYYYMMDD')             --Bookings, {ETD of Last POD} ≥{End of Month*}
                                        --AND   TRD_CD IN ('TPT', 'TAT', 'AET', 'OCT', 'IAT', 'LAA')
                                    ) ZZ
                                ) ZZZ
                                WHERE   ROW_RNK = 1
                                  AND   ROW_NUM = 1
                                  AND   (DAMT_TTL <> 0 OR RCV_AMT <> 0) -- minus inovoice도 추출하도록 수정 (DAMT_TTL > 0 OR RCV_AMT > 0)
                            ) AAA, (SELECT LEVEL AS L FROM DUAL CONNECT BY LEVEL <= 2) BBB 
                        ) ZZZZ
                        WHERE   TMP_AMT > 0
                    ) A, (SELECT LEVEL AS L FROM DUAL CONNECT BY LEVEL <= 2) B
                )
                GROUP BY    CO_CD
                        ,   DOCTP
                        ,   BL_NO
                        ,   CURR
                        ,   COST_CENTER
                        ,   PROFIT_CENTER
                        ,   GL_ACCOUNT_NUMBER
                        ,   ACTIVITY_PLACE
                        ,   ACTIVITY_DATE
                        ,   VESSEL
                        ,   VVL
                        ,   CONTRACT_NUMBER 
            ) AA
            ORDER BY SEQ_NO, DR_CR_FLG DESC
        )
        --WHERE   NVL(AMOUNT_IN_LOCAL_CURRENCY, AMOUNT_IN_DOCUMENT_CURRENCY) > 0
        ;

        OUT_YN := 'Y';
        OUT_RESULT := SQL%ROWCOUNT || ' Freight Deferral Data Created.';

        COMMIT;

    EXCEPTION
        WHEN USER_CALL_EX THEN
            ROLLBACK;
            SCO_ERR_LOG_PRC('SAC_BRG_IF_PKG.'||V_PRC_NM, OUT_RESULT, EXE_YYYYMM, MOD_NAME);
            OUT_YN := 'N';
        WHEN OTHERS THEN
            ROLLBACK;
            SCO_ERR_LOG_PRC('SAC_BRG_IF_PKG.'||V_PRC_NM, SQLERRM, EXE_YYYYMM, MOD_NAME);
            OUT_YN := 'N';
            OUT_RESULT := SQLERRM;
    END SAC_FRT_DEFR_DTL_IF_PRC;

    FUNCTION GET_AMT_PRECISION
    (
            pi_curr_cd     IN VARCHAR2
    )   RETURN NUMBER
    IS
        R_PRECISION NUMBER;
    BEGIN
        IF pi_curr_cd IS NULL THEN
            RETURN NULL;
        END IF;

        SELECT  DP_PRCS_KNT
        INTO    R_PRECISION
        FROM    MDM_CURRENCY MC
        WHERE   MC.CURR_CD = pi_curr_cd;

        RETURN R_PRECISION;
    EXCEPTION
        WHEN OTHERS THEN
            RETURN NULL;
    END GET_AMT_PRECISION;

    FUNCTION GET_DAYS_CALC
    (
            pi_to_dt     IN DATE
        ,   pi_fm_dt     IN DATE
    )    RETURN NUMBER
    IS
        CALCDAYS NUMBER;
    BEGIN
        IF pi_to_dt IS NULL OR pi_fm_dt IS NULL THEN
            RETURN NULL;
        END IF;

        SELECT      TO_DATE(TO_CHAR(pi_to_dt, 'YYYYMMDD'), 'YYYYMMDD')
                -   TO_DATE(TO_CHAR(pi_fm_dt, 'YYYYMMDD'), 'YYYYMMDD')
                +   1
        INTO    CALCDAYS
        FROM    DUAL;

        RETURN CALCDAYS;
    EXCEPTION
        WHEN OTHERS THEN
            RETURN NULL;
    END GET_DAYS_CALC;
    
    FUNCTION GET_DTX_DIR_CD
    (
            pi_slan_cd      IN VARCHAR2
        ,   pi_vvd_cd       IN VARCHAR2
    )   RETURN VARCHAR2
    IS
      --R_VSL_SLAN_DIR_SEQ      VARCHAR2(1);
        R_MODI_VSL_SLAN_DIR_CD  VARCHAR2(1);
    BEGIN
        IF pi_slan_cd IS NULL OR pi_vvd_cd IS NULL THEN
            RETURN NULL;
        END IF;

        SELECT  SUBSTR(D.MODI_VSL_SLAN_DIR_CD,1,1)
              --TO_CHAR(VSL_SLAN_DIR_SEQ) 
        INTO    R_MODI_VSL_SLAN_DIR_CD  
              --R_VSL_SLAN_DIR_SEQ
        FROM    MDM_VSL_SVC_LANE_DIR D
        WHERE   VSL_SLAN_CD = pi_slan_cd
          AND   VSL_SLAN_DIR_CD = SUBSTR(pi_vvd_cd,9,1)
          AND   ROWNUM = 1;

        RETURN R_MODI_VSL_SLAN_DIR_CD;   --R_VSL_SLAN_DIR_SEQ;
    EXCEPTION
        WHEN OTHERS THEN
            RETURN NULL;
    END GET_DTX_DIR_CD;
    
    FUNCTION GET_PERIOD_CLS_FLG
    (
            pi_mdl_cd       IN VARCHAR2
        ,   pi_prd_yrmon    IN VARCHAR2
    )   RETURN VARCHAR2
    IS
        R_PRD_CLS_FLAG VARCHAR2(1);
    BEGIN
        IF pi_mdl_cd IS NULL OR pi_prd_yrmon IS NULL THEN
            RETURN NULL;
        END IF;

        SELECT  DECODE(COUNT(*), 0,'N', 'Y')
        INTO    R_PRD_CLS_FLAG
        FROM    SCO_PERIOD
        WHERE   PRD_APPL_CD = pi_mdl_cd
          AND   EFF_YRMON   = pi_prd_yrmon
          AND   PRD_STS_CD  = 'C';

        RETURN R_PRD_CLS_FLAG;
    EXCEPTION
        WHEN OTHERS THEN
            RETURN NULL;
    END GET_PERIOD_CLS_FLG;
    
    FUNCTION GET_STMT_CD_CONV
    (
            pi_conv_tp      IN VARCHAR2
        ,   pi_src_cd       IN VARCHAR2
    )   RETURN VARCHAR2
    IS
        R_TGT_CD VARCHAR2(100);
    BEGIN
        IF pi_conv_tp IS NULL OR pi_src_cd IS NULL THEN
            RETURN NULL;
        END IF;

        SELECT  TGT_CD 
        INTO    R_TGT_CD
        FROM    SCO_STMT_CD_CONV 
        WHERE   CONV_TP_CD = pi_conv_tp
          AND   SRC_CD = pi_src_cd
          AND   USE_FLG = 'Y' 
          AND   DELT_FLG = 'N' 
          AND   ROWNUM = 1;

        RETURN R_TGT_CD;
    EXCEPTION
        WHEN OTHERS THEN
            RETURN NULL;
    END GET_STMT_CD_CONV;
    
    PROCEDURE INSERT_TMP_FRT_ACCL
    (
            pi_doc_dt       IN  VARCHAR2
        ,   pi_div_seq      IN  NUMBER
        ,   pi_frt_accl_r   IN  SAC_FRT_ACCL_IF%ROWTYPE
    )
    IS
    BEGIN
        INSERT INTO SAC_FRT_ACCL_IF
        (
                FRT_IF_SEQ              --01
            ,   IF_SEQ_NO
            ,   ACCT_CO_CD
            ,   IF_DOC_TP_CD            
            ,   DOC_DT                  --05
            ,   CURR_CD
            ,   PST_KEY_CD                            
            ,   VAT_TAX_CD              
            ,   LOCL_AMT
            ,   DOC_AMT                 --10
            ,   COST_CTR_CD
            ,   GL_ACCT_NO           
            ,   CUST_NO                
            ,   PFITCTR_CD
            ,   ALTN_ACCT_NO            --15
            ,   BIZ_PRNR_REF_KEY_CD1
            ,   CTRT_NO                                    
            ,   ACT_PLC_CD              
            ,   ACT_DT
            ,   VSL_CD                  --20
            ,   VVL_CD
            ,   IF_FLG                                    
            ,   ERP_IF_ERR_RSN          --23
        )
        VALUES
        (
                SAC_FRT_IF_SEQ.NEXTVAL              --01
            ,   pi_div_seq
            ,   pi_frt_accl_r.ACCT_CO_CD
            ,   pi_frt_accl_r.IF_DOC_TP_CD
            ,   pi_doc_dt                           --05
            ,   pi_frt_accl_r.CURR_CD       
            ,   pi_frt_accl_r.PST_KEY_CD   
            ,   pi_frt_accl_r.VAT_TAX_CD   
            ,   pi_frt_accl_r.LOCL_AMT 
            ,   pi_frt_accl_r.DOC_AMT               --10  
            ,   pi_frt_accl_r.COST_CTR_CD      
            ,   pi_frt_accl_r.GL_ACCT_NO 
            ,   pi_frt_accl_r.CUST_NO  
            ,   pi_frt_accl_r.PFITCTR_CD                  
            ,	pi_frt_accl_r.ALTN_ACCT_NO          --15  
            ,	pi_frt_accl_r.BIZ_PRNR_REF_KEY_CD1                 
            ,	pi_frt_accl_r.CTRT_NO                 
            ,   pi_frt_accl_r.ACT_PLC_CD
            ,   pi_frt_accl_r.ACT_DT
            ,   pi_frt_accl_r.VSL_CD                --20
            ,   pi_frt_accl_r.VVL_CD
            ,   'E'
            ,   'TEMP'                              --23
        );
        
        COMMIT;

    EXCEPTION
        WHEN OTHERS THEN
            SCO_ERR_LOG_PRC('SAC_BRG_IF_PKG.INSERT_TMP_FRT_ACCL', SQLERRM, pi_doc_dt, 'ACCRUAL', NULL);
    END INSERT_TMP_FRT_ACCL;
    
    PROCEDURE INSERT_TMP_FRT_DEFR
    (
            pi_doc_dt       IN  VARCHAR2
        ,   pi_div_seq      IN  NUMBER
        ,   pi_frt_defr_r   IN  SAC_FRT_DEFR_IF%ROWTYPE
    )
    IS
    BEGIN
        INSERT INTO SAC_FRT_DEFR_IF
        (
                DEFR_IF_SEQ             --01
            ,   IF_SEQ_NO
            ,   ACCT_CO_CD
            ,   IF_DOC_TP_CD            
            ,   DOC_DT                  --05
            ,   CURR_CD
            ,   PST_KEY_CD                           
            ,   VAT_TAX_CD              
            ,   LOCL_AMT
            ,   DOC_AMT                 --10
            ,   COST_CTR_CD
            ,   GL_ACCT_NO                            
            ,   CUST_NO                
            ,   PFITCTR_CD
            ,   ALTN_ACCT_NO            --15            
            ,   CTRT_NO                                     
            ,   ACT_PLC_CD              
            ,   ACT_DT
            ,   VSL_CD                                    
            ,   VVL_CD                  --20
            ,   IF_FLG                                    
            ,   ERP_IF_ERR_RSN          --22
        )
        VALUES
        (
                SAC_DEFR_IF_SEQ.NEXTVAL             --01
            ,   pi_div_seq
            ,   pi_frt_defr_r.ACCT_CO_CD
            ,   pi_frt_defr_r.IF_DOC_TP_CD
            ,   pi_doc_dt                           --05
            ,   pi_frt_defr_r.CURR_CD       
            ,   pi_frt_defr_r.PST_KEY_CD   
            ,   pi_frt_defr_r.VAT_TAX_CD   
            ,   pi_frt_defr_r.LOCL_AMT 
            ,   pi_frt_defr_r.DOC_AMT               --10  
            ,   pi_frt_defr_r.COST_CTR_CD      
            ,   pi_frt_defr_r.GL_ACCT_NO 
            ,   pi_frt_defr_r.CUST_NO  
            ,   pi_frt_defr_r.PFITCTR_CD                  
            ,	pi_frt_defr_r.ALTN_ACCT_NO          --15  
            ,	pi_frt_defr_r.CTRT_NO                 
            ,   pi_frt_defr_r.ACT_PLC_CD
            ,   pi_frt_defr_r.ACT_DT
            ,   pi_frt_defr_r.VSL_CD                
            ,   pi_frt_defr_r.VVL_CD                --20
            ,   'E'
            ,   'TEMP'                              --22
        );
        
        COMMIT;

    EXCEPTION
        WHEN OTHERS THEN
            SCO_ERR_LOG_PRC('SAC_BRG_IF_PKG.INSERT_TMP_FRT_DEFR', SQLERRM, pi_doc_dt, 'ACCRUAL', NULL);
    END INSERT_TMP_FRT_DEFR;
    
    PROCEDURE INSERT_TMP_CST_ACCL
    (
            pi_doc_dt       IN  VARCHAR2
        ,   pi_div_seq      IN  NUMBER
        ,   pi_cst_accl_r   IN  SAC_COST_ACCL_IF%ROWTYPE
    )
    IS
    BEGIN
        INSERT INTO SAC_COST_ACCL_IF
        (
                COST_IF_SEQ             --01
            ,   IF_SEQ_NO
            ,   ACCT_CO_CD
            ,   IF_DOC_TP_CD            
            ,   DOC_DT                  --05
            ,   CURR_CD
            ,   PST_KEY_CD                           
            ,   VAT_TAX_CD              
            ,   LOCL_AMT
            ,   DOC_AMT                 --10
            ,   COST_CTR_CD
            ,   GL_ACCT_NO                            
            ,   VNDR_CRTR_ACCT_NO                
            ,   PFITCTR_CD
            ,   ALTN_ACCT_NO            --15            
            ,   BIZ_PRNR_REF_KEY_CD1
            ,   CTRT_NO                                     
            ,   ACT_PLC_CD              
            ,   ACT_DT
            ,   VSL_CD                  --20                  
            ,   VVL_CD
            ,   IF_FLG                                    
            ,   ERP_IF_ERR_RSN          
            ,   SYS_SRC_ID              --24
        )
        VALUES
        (
                SAC_COST_IF_SEQ.NEXTVAL             --01
            ,   pi_div_seq
            ,   pi_cst_accl_r.ACCT_CO_CD
            ,   pi_cst_accl_r.IF_DOC_TP_CD
            ,   pi_doc_dt                           --05
            ,   pi_cst_accl_r.CURR_CD       
            ,   pi_cst_accl_r.PST_KEY_CD   
            ,   pi_cst_accl_r.VAT_TAX_CD   
            ,   pi_cst_accl_r.LOCL_AMT 
            ,   pi_cst_accl_r.DOC_AMT               --10  
            ,   pi_cst_accl_r.COST_CTR_CD      
            ,   pi_cst_accl_r.GL_ACCT_NO 
            ,   pi_cst_accl_r.VNDR_CRTR_ACCT_NO
            ,   pi_cst_accl_r.PFITCTR_CD                  
            ,	pi_cst_accl_r.ALTN_ACCT_NO          --15  
            ,	pi_cst_accl_r.BIZ_PRNR_REF_KEY_CD1                 
            ,	pi_cst_accl_r.CTRT_NO                 
            ,   pi_cst_accl_r.ACT_PLC_CD
            ,   pi_cst_accl_r.ACT_DT
            ,   pi_cst_accl_r.VSL_CD                --20
            ,   pi_cst_accl_r.VVL_CD
            ,   'E'
            ,   'TEMP'                              
            ,   pi_cst_accl_r.SYS_SRC_ID            --24
        );
        
        COMMIT;

    EXCEPTION
        WHEN OTHERS THEN
            SCO_ERR_LOG_PRC('SAC_BRG_IF_PKG.INSERT_TMP_CST_ACCL', SQLERRM, pi_doc_dt, 'ACCRUAL', NULL);
    END INSERT_TMP_CST_ACCL;

END SAC_BRG_IF_PKG;
/
