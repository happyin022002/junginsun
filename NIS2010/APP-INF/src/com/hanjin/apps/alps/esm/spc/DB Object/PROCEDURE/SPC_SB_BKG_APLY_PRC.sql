CREATE OR REPLACE PROCEDURE NISADM.SPC_SB_BKG_APLY_PRC
(     
    in_mode       IN VARCHAR2, -- default=B, B:BKG단건, R:BKG단건(Reprocess) W:Week기준(wk, duration, rev lane, bound) , T: Compulsory firm 화면에서 week 기준                
    in_bkg_no     IN VARCHAR2,                
    in_vvd        IN VARCHAR2,                
    in_trade      IN VARCHAR2,                
    in_sub_trd_cd IN VARCHAR2,                
    in_rlane      IN VARCHAR2,                
    in_bound      IN VARCHAR2,                
    in_wk         IN VARCHAR2,                
    in_duration   IN VARCHAR2,                
    in_ofc_cd     IN VARCHAR2,                
    in_user_id    IN VARCHAR2                
)                
Authid current_user                
IS                
/******************************************************************************                
    1. Object Name      : SPC_SB_BKG_APLY_PRC                
    2. Version          : 0.1                
    3. Create Date      : 2015.04.02                
    4. Sub System       : ALPS>ESM>SPC                
    5. Author           : Arie Im, EJ Park, SW Kim                
    6. Description      : SPC의 MasterTable, SMP, Allocation Constraint을 적용하여 해당 BKG을 Standby/F                
                         BKG_BOOKING, BKG_VVD, BKG_QUANTITY, BKG_CUSTOMER                
                         SPC_BKG_ALOC_MGMT, SPC_BKG_ALOC_MGMT_NOD_DTL, SPC_BKG_ALOC_MGMT_CUST_DTL                
                         SPC_SB_BKG           
                                 
                         ===T/S Port 인식 로직====================        
                         T/S는 Trunk VVD의 POL도 전체 Route 구조에서 T/S가 될수 있기 때문에,         
                         이점 참고하시어 로직 보완해주시면 감사하겠습니다.        
                         BKG Main의 POL/POD 제외 즉, BKG-Route Detail의 1st POL, Last POD를 제외한 Port는 모두         
                         T/S로 인식되어야 합니다.        
                         ========================================        
                                    
                         ===  REPROCESS 로직 =====================    
                         1. 화면에서 BKG 별 체크 후 REPROCESS 버튼클릭시 (MODE:R)    
                           -- BKG 별 STANDBY 로직을 태워서 FIRM 처리되면 BKG 정보까지 업데이트 된다. (STANDBY->FIRM 버튼 로직 적용)    
                         2. 시간배치 (MODE:W)    
                           -- 1)MASTERTABLE 정보(CMPB등)가 변경된 경우 현재주차 기준으로0~8주차 구간의 Standby BKG 목록을 가져온다.    
                           -- 2)STANDBY 로직을 태운후 Firm 처리되면 SPC 테이블 FIRM 처리한 후 배치 모니터링 테이블에 INSERT 한다. Standby 이면 pass    
                           -- 3) 2)번에서 들어온 BKG 목록(BAT CD:S)을 읽어들여 STANDBY->FIRM 버튼 로직을 적용한다.    
                           -- 4) 3)번완료후 배치 모니터링 테이블 해당 BKG 데이터의 BAT STS CD를 'F' 업데이트 한다. (FINISHED)    
                         ========================================    
    7. Revision History : 2015.04.01 버전 최초 생성                
                          2015.04.06 Trunk Type NYCNA에만 적용, OFFICE조직 SPC기준으로 변경                
                                     모든 BKG에 대해 HISTORY를 위해 모든 제약조건을 다 태우고, 저장하도록 수정                
                          2015.04.10 SMP BKG 연동쿼리 입력                
                          2015.04.10 SPC_SB_BKG_DTL 추가, cursor에 WK,RHQ,RGN_OFC추가                
                          2015.04.29 SMP 로직 변경(SPC_BKG_CTRL_OPT_DTL테이블에서 Rlane걸어주는 부분에 대해서 제거)                
                          MASTER 로직 수정, ALOC_STS_CD비교시 NVL처리                
                          SMP 로그 정보 추가                
                          2015.04.30 aply fm yrwk, aply to yrwk                
                          2015.05.04 Free Type에 HUL_BND_CD 추가, Allocation 수정                
                          2015.05.12 Free Type에 Dummy VVD 처리하도록 추가                
                          2015.05.14 MasterTable에서 FDR 처리하도록 추가                
                          2015.05.27 smp by Accout 적용                
--                          2015.05.28 커서에 OFFICE 조건 추가(V,W 일때) --확인해봐야 할것 같아서 EJ프로시저 만들고 주석처리함                
                          2015.05.29 CMDT 멀티 입력 처리, WGT 추가                
                                     BKG POR, BKG POL, BKG POD, BKG DEL 멀티 입력 처리                
                                     POR/POL/POD/DEL, TS POL/ TS POD 멀티 입력 처리                
                          ---------------- 아래 작업중--------------------                
                          2015.06.01 Free type 및 추가된 Country Code(TS CNT등) 확인만 하면 완료될 것임                
                          2015.06.03 Free type 튜닝을 위해 Cursor에 HUL_BND_CD 추가함                
                          2015.06.03 in_mode 에 T 추가(Compulsory Firm 화면에서 주차와 Trade로 처리되는 경우를 위해)                
                                     Office 권한 관련하여 추가(V,T 일경우만 적용, B, W의 경우는 제외하도록 함)                
                                     must, fcst, lf 관련사항 MASTER, SMP, ALOC으로 구분적용, 소스 정리                
                          2015.06.08 SMP 로직 보완(BKG에서만 추출된 경우 SMP에서 MAX이거나 MAX가 아니면 DELTE되지 않은 경우만)                
                          2015.06.09 DIR_CD, HUL_BND_CD 관련 변경, Free type oft에 걸린 smpflg 삭제, 커서에 POL_CONTI삭제                
                                     WGT 구하는 부분 수정, 일부 SPC_SCR_OFC_CONV_FNC dual문 제거                
                          2015.06.10 ALOC,WTG,CMPB 관련 로직 보완                
                                     V03 - SMP대상이면 CMPB ONLY인 경우의 조건은 제외시킨다.                
                          2015.06.11 v_must_flg, v_fcst_flg, v_lf_cnt 삭제, CMPB_ONY_FLG 컬럼 추가로 조건 보완                
                          2015.06.12 MAster SMP대상 수정                
                          2015.06.15 CMPB ONLY 룰 수정, 커서 수정                
                          2015.06.16 W 커서 수정 --> ofc conti관련 V도 나중에 모니터링 후 수정할것                
                          2015.06.23 NYCNA BKG 처리(기존 BKG의 rule을 그대로 적용, Master는 무조건 적용, Allocationd은 option에 따라->변경없음, SMP는 적용안함)                
                                     LF기준 변경->현재 들어온 BKG의 이후 3주치 L/F로 변경                
                                     (요구사항:Control Option Registration에서 L/F가 체크된 날짜의 해당 주차 기준 향후 3주 VVD의 LF 였으나,                
                                               옵션의 기준주차 변경하고 싶을때 적용할 방법이 없으므로 BKG기준 이후 3주치 L/F로 변경함)                
                          2015.06.29 NYCNA Trunk SPC_OFC_LVL --> BKG_OFC_LVL_V로 원복(BKg로직 그대로)                
                                     NYCNA의 경우 SLS_RHQ_CD = 'NYCRA' 추가                    
                          2015.06.29 COA-> MAS 변환                
                          2015.07.03 TS/WGT 로직 수정 TS/TSPOL-POD Rownum=1 추가                
                          2015.07.03 Allocation 제약조건 내 Fixed 관련 수정                
                          2015.07.13 Firm물량 산출시 MASTER-CMPB 조건 적용 누락 수정, WGT관련 수정                
						  2015.07.13 프로시저에서 뉴욕인경우 타는것 삭제처리할것                 
                          2015.07.14 Almighty 기능 추가  로직 수정                 
                          2015.07.15 CNTR Type입력 기능보완   로직 수정                 
                          2015.07.16 BCO/NVO 칼럼 추가  로직 수정                 
                          2015.07.21 NYCRA: TRUNK만 제외하고 나머지 삭제,SCG_GRP_CMDT_SEQ:CUSTOMER,COMMODITY추가,SMP 제약조건 제거                
                          2015.07.28 L.F 기준 변경(기준주차 이후 3주치)                
                          2015.07.30 MasterTable 조건 삭제(control option 저장화면에서)-->MasterTable에 Data가 있다면 무조건 적용                
                          2015.08.12 reason 정리, Master의 경우 저장된 값만 나오도록 수정                                         
                          2015.08.12 SPC_MDL_CUST_RFA 관련 SMP 추정 로직 변경                  
                          2015.08.18 CHM-201537549  Mastertable management 보완 사항(wgt, NYCRA, tpsz)                
                          2015.08.18 CHM-201537550 SB BKG management 및 Control Option Registration 보완 요청(MasterTable 조건 삭제, reason 정리, initial cmpb등 추가요건)                
                          2015.08.18 LJS, BOX ea에서 ratio 변환처리                
                          2015.08.18 김성욱, Standby Booking Report History 용                
                          2015.08.24 Arie, reason에서 SEQ및 USE YN 이동                
                          2015.08.25 김성욱, modi_seq 각 type별 추가                
                          2015.08.25 김성욱, Group by 수정.                
                          2015.08.26 Arie, BKG 호출시 'F' BKG도 SB 체크 하도록 처리              
                          2015.09.09 Arie, 결과 update시 IF문 주석처리 4758 line              
                          2015.09.11 최성민, allocation 로직(v_bkg_aloc_flg 체크하던 오류)  수정              
                          2015.09.14 이진서, LIKE '%X%' 오류 수정              
                          2015.09.15 최성민, 이전firm 처리된 bkg이 vvd변경으로 자동 firm 처리될때의 미삭제오류 수정              
                          2015.09.23 이혜민 SMP bkg 컨트롤 시 By Lane 기준으로 컨트롤 할수있도록 수정              
                          2015.09.24 최성민, Mastertable T/S 칼럼 로직 보완요청 - T/S PORT가 아님에도 T/S 인식되는 문제 수정              
                          2015.09.24 LJS, Attention 시뮬레이션 하도록 처리              
                          2015.10.16 최성민, Reason 정보 미삭제처리 - Delete flag 처리              
                          2015.11.03 이진서, NYCNA 탭에서만 활성화 되고 있는 Trunk Type이라는 기능 확대 적용 ? SHARC/SINRS/HAMRU        
                          2015.11.12 최성민, T/S TEU, BOX, WGT RATIO 로직 수정         
                          2015.11.17 최성민, Mastertable T/S 관련 칼럼 추가 요청  [2015.10.23]        
                          2015.11.18 최성민, M.SCG_GRP_CMDT_SEQ -> TO_CHAR(M.SCG_GRP_CMDT_SEQ) 변경 - WHERE 에서의 TYPE이 다름          
                          2015.12.14 최성민, mastertable Bound  칼럼 재정의             
                          2015.12.16 최성민, BKG이 Firm 이면서 Standby 계산 결과가 'S' 일경우에도 SPC 에서 저장        
                          2015.12.24 최성민, Standby Management 보완요청 - BKG Firm->standby 변환시점을 파악하기 위한 작업       
                          2015.12.28 이진서, Mastertable Group Customer 칼럼 추가 요청       
                          2016.01.07 최성민, Aloc 관련 booking Control Option에 입력하지 않은 OFC에 100로 적용되는 오류 수정       
                          2016.01.18 이진서, Mastertable RFA_CTRT_TP_CD , CMPB_PER_TON_AMT , TON_PER_TEU_WGT 항목 추가       
                          2016.01.20 이진서, OFT_CHG_AMT RATE없을 경우 CMPB값으로 대체하도록 수정       
                          2016.02.11 이혜민, FOXIA 노선 Bound 변경하여 조회되도록 수정       
                          2016.02.15 최성민, Standby BKG 통제조건에 대한 CMPB 산출 판단 기준 변경요청(Estimated CMPB → MAS CMPB)      
                          2016.02.22 최성민, Standby BKG에 대한 Reproces Logic 변경 요청    
                          2016.03.29 이진서, Mastertable/Standby BKG MGMT의 RF Type 조건시 EQ Sub 대상 화물 합계 제외요청    
                          2016.04.12 최성민, Dummy VVD에 대한 Mastertable 값 인식 및 Standby Logic 적용 요청  
                          2016.05.16 최성민, Double Callling Route 에 대한 물량집계 및 병목상 Logic 보완  
                          2016.05.25 최성민, Standy에서 Firm 된 건들에 대한 재 Reprocess Logic 추가 관련 
                          2016.08.05 최성민, 긴급조치요청*BKG control system ERR (SMP 조건변경시 master 제약조건 태우도록 처리) 
                          2016.08.26 이혜민, 1. SMP Guide 값이 없을 경우 Standby 처리 2. SMP Guide 값이 0일 경우 Standby 처리
******************************************** **********************************/                
--//////////////////////////////////////////////////////////////////////////////////////////////////                
-- 변수 정의                
--//////////////////////////////////////////////////////////////////////////////////////////////////                
    -- 공통변수 -------------------------------------------------------------------------------------                
    v_prc_nm                 VARCHAR2(50)   := 'SPC_SB_BKG_APLY_PRC';                
    v_prc_ver                VARCHAR2(50)   := 'V.2016826-01';                
    v_prc_usr_id             VARCHAR2(20)   := 'SYSTEM_SPC';                
    v_prc_sys_date           DATE           := SYSDATE;                
    v_step                   VARCHAR2(30)   := '';                
    v_appl_info              VARCHAR2(30);                
    v_init_cmpb              SPC_SB_BKG.INIT_CMPB_AMT%TYPE;                
                    
    v_user_info              VARCHAR2(30);                
    v_sb_ck_rlst             VARCHAR2(1)    := 'N';                 -- Standby 여부 N:No, S:Standby                
    a_sb_ck_rlst             VARCHAR2(1)    := 'N';                 -- Attention 여부 N:No, S:Standby                
    v_old_lst_sb_rsn_tp_cd   SPC_SB_BKG_DTL.LST_SB_RSN_TP_CD%TYPE; -- M:Master, S:SMP, A:Allocation                
    v_is_confirm             VARCHAR2(1)    := 'N'; -- BKG Confirm여부                
    v_is_standby             VARCHAR2(1)    := 'N'; -- standbyExist여부            
    v_is_attention           VARCHAR2(1)    := 'N'; -- AttentionExist여부                
    v_smp_must_flg           VARCHAR2(1)    := 'N'; -- Master Table의 무조건 BKG Cntrol 적용여부(FCST와 배타적임)                
    v_smp_fcst_flg           VARCHAR2(1)    := 'N'; -- Master Table의 Fcast 연속 3주 조건 적용여부                
    v_smp_lf_cnt             NUMBER(1)      := 0 ;  -- Master Table의 LF 조건 만족하는 갯수                
                
    v_aloc_must_flg           VARCHAR2(1)    := 'N'; -- Master Table의 무조건 BKG Cntrol 적용여부(FCST와 배타적임)                
    v_aloc_fcst_flg           VARCHAR2(1)    := 'N'; -- Master Table의 Fcast 연속 3주 조건 적용여부                
    v_aloc_lf_cnt             NUMBER(1)      := 0 ;  -- Master Table의 LF 조건 만족하는 갯수                
    v_lf_wk                   VARCHAR2(6)    := '200001';                
                
    -- MasterTable용 --------------------------------------------------------------------------------                
    v_bkg_aloc_tp_cd         SPC_BKG_ALOC_MGMT.BKG_ALOC_TP_CD%TYPE; -- BKG_ALOC_TP_CD : |Free|Trunk|T/S|Customer|EQ|Commodity |F|T|S|C|E|M                
    v_mst_t_rlst             VARCHAR2(1)    := 'N';               -- Trunk                
    v_mst_s_rlst             VARCHAR2(1)    := 'N';               -- T/S                
    v_mst_c_rlst             VARCHAR2(1)    := 'N';               -- Customer                
    v_mst_e_rlst             VARCHAR2(1)    := 'N';               -- EQ                
    v_mst_m_rlst             VARCHAR2(1)    := 'N';               -- Commodity                
    v_mst_f_rlst             VARCHAR2(1)    := 'N';               -- Free                
                            
    v_mst_t_seq              SPC_BKG_ALOC_MGMT.BKG_ALOC_SEQ %TYPE;                
    v_mst_s_seq              SPC_BKG_ALOC_MGMT.BKG_ALOC_SEQ %TYPE;                
    v_mst_c_seq              SPC_BKG_ALOC_MGMT.BKG_ALOC_SEQ %TYPE;                
    v_mst_e_seq              SPC_BKG_ALOC_MGMT.BKG_ALOC_SEQ %TYPE;                
    v_mst_m_seq              SPC_BKG_ALOC_MGMT.BKG_ALOC_SEQ %TYPE;                
    v_mst_f_seq              SPC_BKG_ALOC_MGMT.BKG_ALOC_SEQ %TYPE;                
                
    v_mst_t_rs               SPC_SB_BKG_DTL.LST_SB_RSN%TYPE;                
    v_mst_s_rs               SPC_SB_BKG_DTL.LST_SB_RSN%TYPE;                
    v_mst_c_rs               SPC_SB_BKG_DTL.LST_SB_RSN%TYPE;                
    v_mst_e_rs               SPC_SB_BKG_DTL.LST_SB_RSN%TYPE;                
    v_mst_m_rs               SPC_SB_BKG_DTL.LST_SB_RSN%TYPE;                
    v_mst_f_rs               SPC_SB_BKG_DTL.LST_SB_RSN%TYPE;                
                
    v_mst_t_svc_cd            SPC_BKG_ALOC_MGMT.ALOC_SVC_CD%TYPE;    -- Auto/Manual, NYCRA, MasterTable만 사용함                
    v_mst_s_svc_cd            SPC_BKG_ALOC_MGMT.ALOC_SVC_CD%TYPE;    -- Auto/Manual, NYCRA, MasterTable만 사용함                
    v_mst_c_svc_cd            SPC_BKG_ALOC_MGMT.ALOC_SVC_CD%TYPE;    -- Auto/Manual, NYCRA, MasterTable만 사용함                
    v_mst_e_svc_cd            SPC_BKG_ALOC_MGMT.ALOC_SVC_CD%TYPE;    -- Auto/Manual, NYCRA, MasterTable만 사용함                
    v_mst_m_svc_cd            SPC_BKG_ALOC_MGMT.ALOC_SVC_CD%TYPE;    -- Auto/Manual, NYCRA, MasterTable만 사용함                
    v_mst_f_svc_cd            SPC_BKG_ALOC_MGMT.ALOC_SVC_CD%TYPE;    -- Auto/Manual, NYCRA, MasterTable만 사용함                
    v_mst_raply_cnt          NUMBER(5)      := 0;                
    v_mst_smp_flg            VARCHAR2(1)    := 'N';                  -- Master Table에서 CMPB 조건에서 제외하기 위해 SMP대상인지 여부 확인                
    v_mst_smp_season         VARCHAR2(10);                
    v_dummy_vvd_flg          VARCHAR2(1)    := 'N';                  -- Master Table에서 Dummy VVD조건을 처리하기 위해 Dummy VVD 여부 확인  
       
                
    -- Attention 용 START --------------------------------------------------------------------------------               
    a_mst_t_rlst             VARCHAR2(1)    := 'N';               -- Trunk               
    a_mst_s_rlst             VARCHAR2(1)    := 'N';               -- T/S               
    a_mst_c_rlst             VARCHAR2(1)    := 'N';               -- Customer               
    a_mst_e_rlst             VARCHAR2(1)    := 'N';               -- EQ               
    a_mst_m_rlst             VARCHAR2(1)    := 'N';               -- Commodity               
    a_mst_f_rlst             VARCHAR2(1)    := 'N';               -- Free               
                
    a_mst_t_seq              SPC_BKG_ALOC_MGMT.BKG_ALOC_SEQ %TYPE;               
    a_mst_s_seq              SPC_BKG_ALOC_MGMT.BKG_ALOC_SEQ %TYPE;               
    a_mst_c_seq              SPC_BKG_ALOC_MGMT.BKG_ALOC_SEQ %TYPE;               
    a_mst_e_seq              SPC_BKG_ALOC_MGMT.BKG_ALOC_SEQ %TYPE;               
    a_mst_m_seq              SPC_BKG_ALOC_MGMT.BKG_ALOC_SEQ %TYPE;               
    a_mst_f_seq              SPC_BKG_ALOC_MGMT.BKG_ALOC_SEQ %TYPE;               
               
    a_mst_t_rs               SPC_SB_BKG_DTL.LST_SB_RSN%TYPE;               
    a_mst_s_rs               SPC_SB_BKG_DTL.LST_SB_RSN%TYPE;               
    a_mst_c_rs               SPC_SB_BKG_DTL.LST_SB_RSN%TYPE;               
    a_mst_e_rs               SPC_SB_BKG_DTL.LST_SB_RSN%TYPE;               
    a_mst_m_rs               SPC_SB_BKG_DTL.LST_SB_RSN%TYPE;               
    a_mst_f_rs               SPC_SB_BKG_DTL.LST_SB_RSN%TYPE;               
               
    a_mst_t_svc_cd            SPC_BKG_ALOC_MGMT.ALOC_SVC_CD%TYPE;    -- Auto/Manual, NYCRA, MasterTable만 사용함               
    a_mst_s_svc_cd            SPC_BKG_ALOC_MGMT.ALOC_SVC_CD%TYPE;    -- Auto/Manual, NYCRA, MasterTable만 사용함               
    a_mst_c_svc_cd            SPC_BKG_ALOC_MGMT.ALOC_SVC_CD%TYPE;    -- Auto/Manual, NYCRA, MasterTable만 사용함               
    a_mst_e_svc_cd            SPC_BKG_ALOC_MGMT.ALOC_SVC_CD%TYPE;    -- Auto/Manual, NYCRA, MasterTable만 사용함               
    a_mst_m_svc_cd            SPC_BKG_ALOC_MGMT.ALOC_SVC_CD%TYPE;    -- Auto/Manual, NYCRA, MasterTable만 사용함               
    a_mst_f_svc_cd            SPC_BKG_ALOC_MGMT.ALOC_SVC_CD%TYPE;    -- Auto/Manual, NYCRA, MasterTable만 사용함               
    -- Attention 용 END --------------------------------------------------------------------------------               
    -- SMP 용                
    v_smp_aloc_sts_cd       VARCHAR2(1)    := ''; -- Standby 여부 S : Standby, F : Firm,  Default : 대상아님                
    v_smp_reason            VARCHAR2(1000);                
    v_smp_raply_cnt         NUMBER(5)      := 0;                
    v_old_smp_rsn_tp_cd     VARCHAR2(1)    := '';  
    v_bkg_ctrl_lane_flg     VARCHAR2(1)    := 'N'; -- Control option Mgt-BKG Control-SMP-By Lane 체크 여부확인              
    -- ALLOCATION --KIMSW                
    v_aloc_reason varchar2(1000) := '';                
    v_aloc_aloc_sts_cd varchar2(1) := '';                
                    
    v_almighty_cnt       NUMBER(1)      := 0 ;  -- Almighty 갯수                
                
    ---- KIMSW                 
    v_modi_seq VARCHAR2(4); --** master 사유로 SB되는 경우 해당 조건 관련 SEQ 값 처리                
    v_modi_t_seq             VARCHAR2(4)    := 'N';               -- Trunk                
    a_modi_seq VARCHAR2(4); --** master 사유로 SB되는 경우 해당 조건 관련 SEQ 값 처리             
    v_modi_s_seq             VARCHAR2(4)    := 'N';               -- T/S                
    v_modi_c_seq             VARCHAR2(4)    := 'N';               -- Customer                
    v_modi_e_seq             VARCHAR2(4)    := 'N';               -- EQ                
    v_modi_m_seq             VARCHAR2(4)    := 'N';               -- Commodity                
    v_modi_f_seq             VARCHAR2(4)    := 'N';               -- Free                
    a_modi_t_seq             VARCHAR2(4)    := 'N';               -- Trunk               
    a_modi_s_seq             VARCHAR2(4)    := 'N';               -- T/S               
    a_modi_c_seq             VARCHAR2(4)    := 'N';               -- Customer               
    a_modi_e_seq             VARCHAR2(4)    := 'N';               -- EQ               
    a_modi_m_seq             VARCHAR2(4)    := 'N';               -- Commodity               
    a_modi_f_seq             VARCHAR2(4)    := 'N';               -- Free               
    v_sc_no             SPC_SB_BKG_DTL.SC_NO%TYPE; --**                
    v_rfa_no            SPC_SB_BKG_DTL.RFA_NO%TYPE; --**                
    v_acct_cd           SPC_SB_BKG_DTL.ACCT_CD%TYPE; --**                
    v_sub_trd_cd        SPC_SB_BKG_DTL.SUB_TRD_CD%TYPE; --**                
    v_vvd_cd            SPC_SB_BKG_DTL.VVD_CD%TYPE;--**                
    v_ofc_cd            SPC_SB_BKG_DTL.OFC_CD%TYPE; --**              
             
    v_rlane_cd VARCHAR2(5);              
    /************************************************************************                
     BKG 적용대상 조회                
    ************************************************************************/                
    CURSOR apply_bkg_cursor IS                
    SELECT BL.*                
          ,O.N2ND_PRNT_OFC_CD AS RHQ_CD                
          ,O.N4TH_PRNT_OFC_CD AS RGN_OFC_CD --BB,BA                
          ,CL.HUL_BND_CD                 
          ,(SELECT MIN(RFA_CTRT_TP_CD) KEEP (DENSE_RANK LAST ORDER BY AMDT_SEQ) FROM PRI_RP_HDR A,PRI_RP_MN B WHERE A.PROP_NO= B.PROP_NO AND PROP_STS_CD = 'A' AND A.RFA_NO= BL.RFA_NO) AS RFA_CTRT_TP_CD       
    FROM SPC_OFC_LVL O,                
        (                
        SELECT 'W' MD  ,B.SLAN_CD              
         , SUBSTR(V.SLS_YRMON,1,4)||V.COST_WK SLS_WK                
         , V.VSL_CD                
         , V.SKD_VOY_NO                
         , V.DIR_CD                
         , B.BKG_NO                
         , B.OB_SLS_OFC_CD                
         , V.TRD_CD, V.SUB_TRD_CD, V.RLANE_CD, V.IOC_CD                     
         , (SELECT SPC_GET_CMPB_FNC(B.BKG_NO, NULL) FROM DUAL) AS CMPB     
         , BV.POL_CD, BV.POD_CD                
         , NULL AS ORG_VVD                
         , (SELECT MAX(L.CONTI_CD)                
                FROM MDM_LOCATION     L                
                    ,MDM_ORGANIZATION O                
               WHERE L.LOC_CD = O.LOC_CD                
                 AND O.OFC_CD = NVL(in_ofc_cd, 'SHARC')) OFC_CONTI                   
         , PL.CONTI_CD         
         , CTRT_CUST_CNT_CD, CTRT_CUST_SEQ , SC_NO ,RFA_NO ,DCGO_FLG , RD_CGO_FLG       
         , (SELECT WM_CONCAT(Q.CNTR_TPSZ_CD) FROM BKG_QUANTITY Q WHERE Q.BKG_NO = B.BKG_NO ) AS CNTR_TPSZ_CD        
        FROM (  SELECT /*+ INDEX (prd1 XPKMAS_WK_PRD)*/ COST_YR||COST_WK AS SLS_WK                
                  FROM MAS_WK_PRD PRD1                
                 WHERE PRD1.COST_YR||PRD1.COST_WK >= ( SELECT PRD.COST_YR || TO_CHAR(CEIL((TO_CHAR(SYSDATE + ( 7 * in_wk ), 'DDD') + 7 - TO_CHAR(TO_DATE(PRD.SLS_TO_DT, 'YYYYMMDD'), 'DDD')) / 7), 'FM00') AS COST_WK                
                                                         FROM MAS_WK_PRD PRD                
                                                        WHERE PRD.COST_YR = TO_CHAR(SYSDATE + ( 7 * in_wk ), 'YYYY')                
                                                          AND PRD.COST_WK = '01' )                
                   AND ROWNUM <= in_duration                
                   AND 1 = DECODE(in_mode, 'W', 1, 0)        
            ) A,                
            MAS_MON_VVD V, BKG_BOOKING B, BKG_VVD BV, MDM_DTL_REV_LANE L, MDM_LOCATION PL, MDM_LOCATION PD     
          WHERE 1 = DECODE(in_mode, 'W', 1, 'T', 1, 0) -- WK 기준인 경우                
            AND SUBSTR(V.SLS_YRMON,1,4)||V.COST_WK = A.SLS_WK                
            AND V.SLAN_CD        = B.SLAN_CD                
            AND V.VSL_CD         = B.VSL_CD                
            AND V.SKD_VOY_NO     = B.SKD_VOY_NO                
            AND V.DIR_CD         = B.SKD_DIR_CD                
            AND V.TRD_CD         = CASE WHEN in_trade       IS NOT NULL THEN in_trade      ELSE (SELECT SPC_GET_REP_TRD_FNC(V.RLANE_CD) FROM DUAL)     END                
            AND V.SUB_TRD_CD     = CASE WHEN in_sub_trd_cd  IS NOT NULL THEN in_sub_trd_cd ELSE (SELECT SPC_GET_REP_SUB_TRD_FNC(V.RLANE_CD) FROM DUAL) END                
            AND V.RLANE_CD       = CASE WHEN in_rlane       IS NOT NULL THEN in_rlane      ELSE V.RLANE_CD END                
            AND V.DIR_CD         = CASE WHEN in_bound       IS NOT NULL THEN in_bound      ELSE V.DIR_CD   END                
            AND V.DELT_FLG       = 'N'                
            AND B.BKG_STS_CD     IN ('W', 'F')                
            AND B.BKG_CGO_TP_CD  IN ('F', 'R')                
            AND B.ALOC_STS_CD IN  ('S') -- reapply confirm의 경우는 Standby상태인 것들만 처리          
            AND B.BKG_NO           = BV.BKG_NO                
            AND BV.VSL_PRE_PST_CD  = 'T'                
            AND L.RLANE_CD         = V.RLANE_CD                
            AND L.VSL_SLAN_DIR_CD  = V.DIR_CD                
            AND PL.LOC_CD          = BV.POL_CD                
            AND PD.LOC_CD          = BV.POD_CD                
            AND L.FM_CONTI_CD      = SPC_CONTI_CONV_FNC(PL.CONTI_CD, L.RLANE_CD, L.VSL_SLAN_DIR_CD)                
            AND L.TO_CONTI_CD      = SPC_CONTI_CONV_FNC(PD.CONTI_CD, L.RLANE_CD, L.VSL_SLAN_DIR_CD)                
            AND L.TRD_CD           = V.TRD_CD                
            AND L.SUB_TRD_CD       = V.SUB_TRD_CD                
            AND L.DELT_FLG         = 'N'                
       GROUP BY SUBSTR(V.SLS_YRMON,1,4)||V.COST_WK                
             , V.VSL_CD                
             , V.SKD_VOY_NO                
             , V.DIR_CD                
             , B.BKG_NO                
             , B.OB_SLS_OFC_CD                
             , V.TRD_CD, V.SUB_TRD_CD, V.RLANE_CD, V.IOC_CD                
             , BV.POL_CD, BV.POD_CD    
             , PL.CONTI_CD         
             ,B.SLAN_CD,CTRT_CUST_CNT_CD, CTRT_CUST_SEQ,SC_NO,RFA_NO,DCGO_FLG,RD_CGO_FLG       
    
        UNION ALL                
        SELECT 'B' MD ,B.SLAN_CD               
             , SUBSTR(V.SLS_YRMON,1,4)||V.COST_WK SLS_WK                
             , V.VSL_CD                
             , V.SKD_VOY_NO                
             , V.DIR_CD                
             , B.BKG_NO                
             , B.OB_SLS_OFC_CD                
             , V.TRD_CD, V.SUB_TRD_CD, V.RLANE_CD, V.IOC_CD                
             , (SELECT SPC_GET_CMPB_FNC(B.BKG_NO, NULL) FROM DUAL) AS CMPB     
             , BV.POL_CD, BV.POD_CD                
             , NULL AS ORG_VVD                
             , NULL AS OFC_CONTI                
             , NULL AS CONTI_CD         
             , CTRT_CUST_CNT_CD, CTRT_CUST_SEQ , SC_NO ,RFA_NO ,DCGO_FLG , RD_CGO_FLG       
             , (SELECT WM_CONCAT(Q.CNTR_TPSZ_CD) FROM BKG_QUANTITY Q WHERE Q.BKG_NO = B.BKG_NO ) AS CNTR_TPSZ_CD        
         FROM MAS_MON_VVD V, BKG_BOOKING B, BKG_VVD BV, MDM_DTL_REV_LANE L, MDM_LOCATION PL, MDM_LOCATION PD     
         WHERE 1 = DECODE(in_mode, 'B', 1, 'R', 1, 0) -- BKG 기준인 경우 [2016.02.22]               
            AND V.SLAN_CD        = B.SLAN_CD                
            AND V.VSL_CD         = B.VSL_CD                
            AND V.SKD_VOY_NO     = B.SKD_VOY_NO                
            AND V.DIR_CD         = B.SKD_DIR_CD                
            AND V.DELT_FLG       = 'N'                
            AND B.BKG_NO         = in_bkg_no                
            AND B.BKG_STS_CD     IN ('W', 'F')                
            AND B.BKG_CGO_TP_CD  IN ('F', 'R')                
            --AND NVL(B.ALOC_STS_CD, 'X')  IN  ('X', 'A', 'S') : VVD변경시 F BKG도 BKG시스템에서 호출하므로...주석처리        
            AND B.BKG_NO           = BV.BKG_NO                
            AND BV.VSL_PRE_PST_CD  = 'T'                
            AND L.RLANE_CD         = V.RLANE_CD                
            AND L.VSL_SLAN_DIR_CD  = V.DIR_CD                
            AND PL.LOC_CD          = BV.POL_CD                
            AND PD.LOC_CD          = BV.POD_CD                
            AND L.FM_CONTI_CD      = SPC_CONTI_CONV_FNC(PL.CONTI_CD, L.RLANE_CD, L.VSL_SLAN_DIR_CD)                
            AND L.TO_CONTI_CD      = SPC_CONTI_CONV_FNC(PD.CONTI_CD, L.RLANE_CD, L.VSL_SLAN_DIR_CD)                
            AND L.TRD_CD           = V.TRD_CD                
            AND L.SUB_TRD_CD       = V.SUB_TRD_CD                
            AND L.DELT_FLG         = 'N'                
       GROUP BY SUBSTR(V.SLS_YRMON,1,4)||V.COST_WK                
             , V.VSL_CD                
             , V.SKD_VOY_NO                
             , V.DIR_CD                
             , B.BKG_NO                
             , B.OB_SLS_OFC_CD                
             , V.TRD_CD, V.SUB_TRD_CD, V.RLANE_CD, V.IOC_CD                
             , BV.POL_CD, BV.POD_CD                
             ,B.SLAN_CD,CTRT_CUST_CNT_CD, CTRT_CUST_SEQ,SC_NO,RFA_NO,DCGO_FLG,RD_CGO_FLG       
        --대상항차 정보가 없는 BKG(Feeder)                
        UNION ALL                
        SELECT MD     ,SLAN_CD           
            , SLS_WK                
            , 'FD' || SUBSTR(WK_DATE, 1, 2) VSL_CD                
            , SUBSTR(WK_DATE, -4) SKD_VOY_NO                
            , DIR_CD                
            , BKG_NO                
            , OB_SLS_OFC_CD                
            , DECODE(POL_CONTI, 'E', 'IES', 'IAS') TRD_CD                
            , DECODE(POL_CONTI, 'E', 'IE', 'IA') SUB_TRD_CD                
            , 'RBCCO' RLANE_CD                
            , 'I' IOC_CD                
            , (SELECT SPC_GET_CMPB_FNC(B2.BKG_NO, NULL) FROM DUAL) AS CMPB     
            , POL_Cd                
            , POD_Cd                
            , VVD AS ORG_VVD                
            , NULL AS OFC_CONTI                
            , NULL AS CONTI_CD                
            , CTRT_CUST_CNT_CD, CTRT_CUST_SEQ , SC_NO ,RFA_NO ,DCGO_FLG , RD_CGO_FLG       
            , CNTR_TPSZ_CD        
        FROM (SELECT 'B' MD  ,B.SLAN_CD              
                 , B.BKG_NO                
                 , TO_CHAR(NVL(NVL(VPS_ETD_DT, INIT_ETD_DT), B.CRE_DT), 'YYYYMMDD') WK_DATE                
                 , W.COST_YR||W.COST_WK SLS_WK                
                 , B.OB_SLS_OFC_CD                
                 , B.BKG_STS_CD                
                 , V.POL_CD                
                 , V.POD_CD                
                 , B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD VVD                
                 , (SELECT SPC_CONTI_CONV_FNC((SELECT CONTI_CD  FROM MDM_LOCATION M WHERE M.LOC_CD = V.POL_CD), 'RBCCO', 'E') FROM DUAL ) POL_CONTI                
                 , (SELECT SPC_CONTI_CONV_FNC((SELECT CONTI_CD  FROM MDM_LOCATION M WHERE M.LOC_CD = V.POD_CD), 'RBCCO', 'E') FROM DUAL ) POD_CONTI                
                 , 'E' DIR_CD          
                 , CTRT_CUST_CNT_CD, CTRT_CUST_SEQ , SC_NO ,RFA_NO ,DCGO_FLG , RD_CGO_FLG       
                 , (SELECT WM_CONCAT(Q.CNTR_TPSZ_CD) FROM BKG_QUANTITY Q WHERE Q.BKG_NO = B.BKG_NO ) AS CNTR_TPSZ_CD        
              FROM BKG_BOOKING B                
                 , BKG_VVD V                
                 , BKG_VVD SV                
                 , VSK_VSL_PORT_SKD S                
                 , MAS_WK_PRD W                
             WHERE 1 = DECODE(in_mode, 'B', 1, 'R', 1, 0) -- BKG 기준인 경우 [2016.02.22]               
               AND B.BKG_NO = in_bkg_no                
               AND B.BKG_NO = V.BKG_NO                
               AND B.VSL_CD = V.VSL_CD                
               AND B.SKD_VOY_NO = V.SKD_VOY_NO                
               AND B.SKD_DIR_CD = V.SKD_DIR_CD                
               AND V.VSL_PRE_PST_CD = 'T'                
               AND B.BKG_NO = SV.BKG_NO(+)                
               AND B.VSL_CD = SV.VSL_CD(+)                
               AND B.SKD_VOY_NO = SV.SKD_VOY_NO(+)                
               AND B.SKD_DIR_CD = SV.SKD_DIR_CD(+)                
               AND SV.VSL_PRE_PST_CD(+) <> 'T'                
               AND V.VSL_CD = S.VSL_CD(+)                
               AND V.SKD_VOY_NO = S.SKD_VOY_NO(+)                
               AND V.SKD_DIR_CD = S.SKD_DIR_CD(+)                
               AND V.POL_CD = S.VPS_PORT_CD(+)                
               AND V.POL_CLPT_IND_SEQ = S.CLPT_IND_SEQ(+)                
               AND V.POL_YD_CD = S.YD_CD(+)                
               AND B.BKG_STS_CD IN ('W', 'F')                
               AND TO_CHAR(NVL(NVL(VPS_ETD_DT, INIT_ETD_DT), B.CRE_DT), 'YYYYMMDD') BETWEEN W.SLS_FM_DT AND W.SLS_TO_DT                
               AND NOT EXISTS (SELECT 1 FROM MAS_MON_VVD MV WHERE MV.VSL_CD = B.VSL_CD AND MV.SKD_VOY_NO = B.SKD_VOY_NO AND MV.DIR_CD = B.SKD_DIR_CD AND MV.DELT_FLG = 'N')                
            ) B2                
   ) BL, MAS_LANE_RGST CL                
   WHERE O.OFC_CD = SPC_SCR_OFC_CONV_FNC(BL.OB_SLS_OFC_CD, '')                
    AND BL.SLS_WK BETWEEN OFC_APLY_FM_YRWK AND OFC_APLY_TO_YRWK                
    AND BL.RLANE_CD = CL.RLANE_CD                
    AND BL.DIR_CD = CL.DIR_CD                
    AND BL.TRD_CD = CL.TRD_CD                
    AND BL.IOC_CD = CL.IOC_CD                
    AND CL.DELT_FLG = 'N'                
    -- OFFICE 관련 추가 ----------------------------------------------------------------------------------                
    AND (                
          1 = DECODE(in_mode, 'B', 1, 'R', 1, 'W', 1, 0) -- BKG(B), 배치(W) 일 경우는 제외 시킨다.  [2016.02.22]    
          OR  BL.OFC_CONTI = CASE WHEN in_ofc_cd IS NULL OR in_ofc_cd IN ('NYCRA','HAMRU','SINRS','SHARC')  THEN (SELECT SPC_CONTI_CONV_FNC(BL.CONTI_CD, BL.RLANE_CD, BL.DIR_CD) FROM DUAL) END                    
          OR  CASE WHEN in_ofc_cd IS NULL OR in_ofc_cd IN ('NYCRA','HAMRU','SINRS','SHARC')                    
                   THEN O.N2ND_PRNT_OFC_CD                   
                   ELSE O.N4TH_PRNT_OFC_CD END                   
                            IN ( SELECT in_ofc_cd FROM DUAL WHERE in_ofc_cd IS NOT NULL UNION ALL                   
                                 SELECT 'SHARC' FROM DUAL WHERE in_ofc_cd IS NULL UNION ALL                   
                                 SELECT 'SINRS' FROM DUAL WHERE in_ofc_cd IS NULL)                   
          OR  BL.RLANE_CD IN ( SELECT 'WAFIE' FROM DUAL WHERE in_ofc_cd IN ('SINRS', 'SHARC') UNION ALL                   
                               SELECT 'WAFIE' FROM DUAL WHERE in_ofc_cd IS NULL               UNION ALL                   
                               SELECT 'WAXIA' FROM DUAL WHERE in_ofc_cd = 'SINRS')                   
             
        )                
   -------------------------------------------------------------------------------------------------                
   ORDER BY CMPB DESC               
  ;                
                
BEGIN                
    BEGIN                
	                
    v_user_info := NVL(in_user_id, v_prc_usr_id);                
    v_mst_raply_cnt    := 0;                
                    
    enis_log_prc('', v_prc_nm, '==== START : '||v_prc_ver||' ====' || v_user_info , v_appl_info);                
                
/************************************************************************                
 Dummy VVD 체크, Dummy의 경우는 Cursor에서 잡히지 않으므로 따로 처리한다. BKG생성시, update시에 처리                
************************************************************************/                
                
    IF(in_mode IN ('B','R')) THEN                
        v_appl_info := in_bkg_no;                
        v_step := '0. Dummy Check';                
                      
        BEGIN                
            SELECT 'Y'                
                INTO v_dummy_vvd_flg                
            FROM BKG_BOOKING                
            WHERE BKG_NO = in_bkg_no                
                AND VSL_CD IN ('SMXX', 'SMYY', 'SMZZ');                
        EXCEPTION                
            WHEN NO_DATA_FOUND THEN                
                v_dummy_vvd_flg := 'N';                
              --  enis_log_prc(SYSDATE, v_prc_nm, v_step || ' NOT DUMMY', v_appl_info);                
        END;                
                        
        IF(v_dummy_vvd_flg = 'Y') THEN             
            enis_log_prc(SYSDATE, v_prc_nm, v_step || ' START', v_appl_info);  
              
            BEGIN                
                WITH BKG_LIST AS (                
                    SELECT 'B' MD                
                         , B.BKG_NO                
                         , TO_CHAR(NVL(NVL(VPS_ETD_DT, INIT_ETD_DT), B.CRE_DT), 'YYYYMMDD') WK_DATE                
                         , DECODE(VPS_ETD_DT, NULL, DECODE(INIT_ETD_DT, NULL, 'CRE_DT', 'INIT_ETD_DT'), 'ETD_DT') WK_TP                
                         , VPS_ETD_DT                
                         , W.COST_YR||W.COST_WK SLS_WK                
                         , B.BKG_STS_CD                
                         , O.N2ND_PRNT_OFC_CD AS SLS_RHQ_CD                
                         , O.N4TH_PRNT_OFC_CD AS RGN_OFC_CD                
                         , B.VSL_CD || B.SKD_VOY_NO || B.SKD_DIR_CD VVD                
                         , L.RLANE_CD                
                         , L.IOC_CD                
                         , L.FM_CONTI_CD POL_CONTI                
                         , L.TO_CONTI_CD POD_CONTI                
                         , L.TRD_CD                
                         , L.SUB_TRD_CD    
                         , NVL((SELECT HUL_BND_CD FROM MAS_LANE_RGST WHERE RLANE_CD = L.RLANE_CD AND DIR_CD = L.VSL_SLAN_DIR_CD AND TRD_CD = L.TRD_CD AND IOC_CD = L.IOC_CD),'HH') AS HUL_BND_CD  -- [2016.04.12]             
                         , V.SLAN_CD                
                         , B.OB_SLS_OFC_CD                
                         , B.POR_CD                
                         , B.POR_NOD_CD                
                         , (SELECT SL.SCC_CD FROM MAS_LOCATION_V SL WHERE SL.LOC_CD = B.POR_CD) BKG_POR_SCC_CD                
                         , B.POL_CD                
                         , B.POL_NOD_CD                
                         , V.POL_CD TRNK_POL_CD                
                         , V.POD_CD TRNK_POD_CD                
                         , V.SLAN_CD TRNK_SLAN_CD                
                         , V.SKD_DIR_CD TRNK_DIR_CD                
                         , B.POD_CD                
                         , B.POD_NOD_CD                
                         , B.DEL_CD                
                         , B.DEL_NOD_CD                
                         , (SELECT SL.SCC_CD FROM MAS_LOCATION_V SL WHERE SL.LOC_CD = B.DEL_CD) BKG_DEL_SCC_CD                
                         , B.SC_NO                
                         , B.RFA_NO                
                         , B.CTRT_CUST_CNT_CD                
                         , B.CTRT_CUST_SEQ                
                         , B.CTRT_CUST_CNT_CD||LPAD(B.CTRT_CUST_SEQ, 6, '0') CTRT_CUST_CODE                
                         , S.CUST_CNT_CD                
                         , S.CUST_SEQ                
                         , S.CUST_CNT_CD||LPAD(S.CUST_SEQ, 6, '0') CUST_CODE                
                         , (SELECT WM_CONCAT(Q.CNTR_TPSZ_CD) FROM BKG_QUANTITY Q WHERE Q.BKG_NO = B.BKG_NO) CNTR_TPSZ_CD                
                         , (SELECT SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', 1, 2) * Q.OP_CNTR_QTY) FROM BKG_QUANTITY Q WHERE Q.BKG_NO = B.BKG_NO) AS BKG_LOD_QTY --TEU(Load)                
                         , B.CMDT_CD                
                         , B.VSL_CD                
                         , B.SKD_VOY_NO                
                         , DECODE(B.SKD_DIR_CD, '1', 'E', V.SKD_DIR_CD) DIR_CD                
                         , (SELECT C.GRP_CMDT_CD FROM MDM_COMMODITY C WHERE C.CMDT_CD = B.CMDT_CD) SCG_GRP_CMDT_SEQ                
                         , SUBSTR(B.POR_CD, 0, 2) BKG_POR_CNT_CD                
                         , SUBSTR(B.POL_CD, 0, 2) BKG_POL_CNT_CD                
                         , SUBSTR(B.POD_CD, 0, 2) BKG_POD_CNT_CD                
                         , SUBSTR(B.DEL_CD, 0, 2) BKG_DEL_CNT_CD                
                         , (SELECT SPC_GET_CMPB_FNC(B.BKG_NO, NULL) FROM DUAL) AS CMPB_AMT     
                         , B.DCGO_FLG                
                         , B.RD_CGO_FLG                
                         , B.AGMT_ACT_CNT_CD                
                         , B.AGMT_ACT_CUST_SEQ                
                         , B.AGMT_ACT_CNT_CD||LPAD(B.AGMT_ACT_CUST_SEQ, 6, '0') AGMT_ACT_CUST_CODE                
                         , NVL( (SELECT SUM(R.CHG_UT_AMT) FROM BKG_CHG_RT R WHERE R.BKG_NO = B.BKG_NO AND R.CHG_CD = 'OFT')       
                         ,(SELECT MIN(OFT_AMT) KEEP (DENSE_RANK LAST ORDER BY A.REV_COST_SEQ) FROM BKG_REV_COST A WHERE A.BKG_NO = B.BKG_NO)) AS OFT_CHG_AMT           
                         , CASE                
                             WHEN (SUBSTR(B.POR_CD, 1, 2) IN ('CA', 'US')                
                                OR SUBSTR(B.DEL_CD, 1, 2) IN ('CA', 'US')) THEN (SELECT SPC_USA_MODE_FNC(B.RCV_TERM_CD, B.DE_TERM_CD, B.POR_CD, B.POL_CD, B.POD_CD, B.DEL_CD) FROM DUAL)                
                             ELSE 'OTH'                
                           END USA_BKG_MOD_CD                
                         , SV.SLAN_CD TS_SLAN_CD                
                         , SV.VSL_CD||SV.SKD_VOY_NO||SV.SKD_DIR_CD TS_VVD                
                         , SV.POL_CD TS_POL_CD                
                         , SV.POD_CD TS_POD_CD                 
                         , SV.POL_YD_CD TS_POL_YD_CD                
                         , SV.POD_YD_CD TS_POD_YD_CD                      
                         , SUBSTR(SV.POL_CD, 1, 2) TS_POL_CNT_CD                
                         , SUBSTR(SV.POD_CD, 1, 2) TS_POD_CNT_CD                
                         , SV.SKD_DIR_CD TS_DIR                
                         , RANK() OVER ( PARTITION BY SV.BKG_NO ORDER BY SV.VSL_PRE_PST_CD, SV.VSL_SEQ) AS RK                
                         , NVL(B.ALOC_STS_CD, 'X') ALOC_STS_CD             
                         ,(SELECT CUST_GRP_ID FROM MDM_CUSTOMER C WHERE B.CTRT_CUST_CNT_CD = C.CUST_CNT_CD AND B.CTRT_CUST_SEQ = C.CUST_SEQ) AS CUST_GRP_ID       
                         ,(SELECT MIN(RFA_CTRT_TP_CD) KEEP (DENSE_RANK LAST ORDER BY AMDT_SEQ) FROM PRI_RP_HDR A,PRI_RP_MN B WHERE A.PROP_NO= B.PROP_NO AND PROP_STS_CD = 'A' AND A.RFA_NO= B.RFA_NO) AS RFA_CTRT_TP_CD       
                         ,(SELECT SUM((D.ACT_WGT * DECODE(D.WGT_UT_CD, 'LBS', 0.00045, 0.001)) + SUM(Q.OP_CNTR_QTY *        
                                    (SELECT TS.CNTR_TPSZ_TARE_WGT FROM MDM_CNTR_TP_SZ TS WHERE TS.CNTR_TPSZ_CD = Q.CNTR_TPSZ_CD )) * 0.001 ) WGT_TTL        
                               FROM BKG_QUANTITY Q        
                                  , BKG_BL_DOC D         
                              WHERE B.BKG_NO     = Q.BKG_NO        
                                AND B.BKG_NO     = D.BKG_NO        
                                AND Q.OP_CNTR_QTY > 0        
                              GROUP BY D.ACT_WGT * DECODE(D.WGT_UT_CD, 'LBS', 0.00045, 0.001) ) WGT                                     
                      FROM BKG_BOOKING B                
                         , BKG_VVD V                
                         , BKG_VVD SV                
                         , BKG_CUSTOMER S                
                         , VSK_VSL_PORT_SKD SK                
                         , MAS_WK_PRD W                
                         , SPC_OFC_LVL O                
                         , MDM_DTL_REV_LANE L                
                     WHERE 1 = 1        
                       AND B.BKG_NO = v_appl_info                
                       AND B.VSL_CD IN ('SMXX', 'SMYY', 'SMZZ')                
                       AND B.BKG_NO = V.BKG_NO                
                       AND B.VSL_CD = V.VSL_CD                
                       AND B.SKD_VOY_NO = V.SKD_VOY_NO                
                       AND B.SKD_DIR_CD = V.SKD_DIR_CD                
                       AND V.VSL_PRE_PST_CD = 'T'                
                       AND B.BKG_NO = SV.BKG_NO(+)                
                       AND B.VSL_CD = SV.VSL_CD(+)                
                       AND B.SKD_VOY_NO = SV.SKD_VOY_NO(+)                
                       AND B.SKD_DIR_CD = SV.SKD_DIR_CD(+)                
                       AND SV.VSL_PRE_PST_CD(+) <> 'T'                
                       AND V.VSL_CD = SK.VSL_CD(+)                
                       AND B.BKG_NO = S.BKG_NO                
                       AND S.BKG_CUST_TP_CD = 'S'                
                       AND V.SKD_VOY_NO = SK.SKD_VOY_NO(+)                
                       AND V.SKD_DIR_CD = SK.SKD_DIR_CD(+)                
                       AND V.POL_CD = SK.VPS_PORT_CD(+)                
                       AND V.POL_CLPT_IND_SEQ = SK.CLPT_IND_SEQ(+)                
                       AND V.POL_YD_CD = SK.YD_CD(+)                
                       AND B.BKG_STS_CD IN ('W', 'F', 'A')                
                       AND TO_CHAR(NVL(NVL(VPS_ETD_DT, INIT_ETD_DT), B.CRE_DT), 'YYYYMMDD') BETWEEN W.SLS_FM_DT AND W.SLS_TO_DT                
                       AND W.COST_YR||W.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK                
                       AND O.OFC_CD = (SELECT SPC_SCR_OFC_CONV_FNC(B.OB_SLS_OFC_CD, '') FROM DUAL)                
                       AND NOT EXISTS (SELECT 1 FROM MAS_MON_VVD MV WHERE MV.VSL_CD = B.VSL_CD AND MV.SKD_VOY_NO = B.SKD_VOY_NO AND MV.DIR_CD = B.SKD_DIR_CD AND MV.DELT_FLG = 'N')                
                       AND L.RLANE_CD LIKE V.SLAN_CD || '%'                
                       AND L.FM_CONTI_CD = ( SELECT SPC_CONTI_CONV_FNC((SELECT CONTI_CD  FROM MDM_LOCATION M WHERE M.LOC_CD = V.POL_CD), V.SLAN_CD, DECODE(V.SKD_DIR_CD, '1', 'E', V.SKD_DIR_CD)) FROM DUAL )                
                       AND L.TO_CONTI_CD = ( SELECT SPC_CONTI_CONV_FNC((SELECT CONTI_CD  FROM MDM_LOCATION M WHERE M.LOC_CD = V.POD_CD), V.SLAN_CD, DECODE(V.SKD_DIR_CD, '1', 'E', V.SKD_DIR_CD)) FROM DUAL )                
                       AND L.VSL_SLAN_DIR_CD IN ('E','W') -- Dummy의 경우 bound가 세팅되지 않음.      
                       AND ROWNUM = 1  
               )                
              , MASTER AS (                
                         SELECT MT.BKG_ALOC_SEQ        
                              , MT.BKG_ALOC_TP_CD        
                              , MT.TRNK_SLAN_CD        
                              , MT.TRNK_DIR_CD        
                              , MT.OB_SLS_OFC_CD        
                              , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POR' AND LENGTH(LD.SB_LOC_CD) = 2 ) POR_CNT_CD        
                              , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POR' AND LENGTH(LD.SB_LOC_CD) = 5 ) POR_CD        
                              , MT.POR_NOD_CD        
                              , MT.BKG_POR_SCC_CD        
                              , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POL' AND LENGTH(LD.SB_LOC_CD) = 2 ) POL_CNT_CD        
                              , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POL' AND LENGTH(LD.SB_LOC_CD) = 5 ) POL_CD        
                              , MT.POL_NOD_CD        
                                -- [2015.10.23] T/S PORT, T/S POL NODE, T/S POD NODE        
                              , CASE WHEN (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SAY' ) IS NOT NULL        
                                     THEN NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SAY' AND LENGTH(LD.SB_LOC_CD) = 5 ), 'XXXXXXXX')         
                                     ELSE NULL END AS TS_ALL_LOC_CD                              
                              , CASE WHEN (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SAY' ) IS NOT NULL        
                                     THEN NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SAY' AND LENGTH(LD.SB_LOC_CD) = 7 ), 'XXXXXXXX')         
                                     ELSE NULL END AS TS_ALL_NOD_CD            
                              , MT.N1ST_TS_SLAN_CD        
                              , MT.N1ST_TS_DIR_CD        
                              , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SPL' AND LENGTH(LD.SB_LOC_CD) = 2) N1ST_TS_POL_CNT_CD                
                              , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SPL' AND LENGTH(LD.SB_LOC_CD) = 5) N1ST_TS_POL_CD          
                              , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SLY' ) TS_POL_NOD_CD            
                              , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SPD' AND LENGTH(LD.SB_LOC_CD) = 2) N1ST_TS_POD_CNT_CD          
                              , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SPD' AND LENGTH(LD.SB_LOC_CD) = 5) N1ST_TS_POD_CD         
                              , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SDY') TS_POD_NOD_CD         
                                         
                              , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POD' AND LENGTH(LD.SB_LOC_CD) = 2) POD_CNT_CD        
                              , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POD' AND LENGTH(LD.SB_LOC_CD) = 5) POD_CD                
                              , MT.POD_NOD_CD                
                              , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(LD.SB_LOC_CD) = 2) DEL_CNT_CD         
                              , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(LD.SB_LOC_CD) = 5) DEL_CD          
                              , MT.DEL_NOD_CD        
                              , MT.BKG_DEL_SCC_CD        
                              , MT.SC_NO        
                              , MT.RFA_NO        
                              , MT.CTRT_CUST_CNT_CD        
                              , MT.CTRT_CUST_SEQ        
                              , MT.CUST_GRP_ID  
                              , MT.RFA_CTRT_TP_CD       
                              , MT.CUST_CNT_CD        
                              , MT.CUST_SEQ        
                              , (SELECT WM_CONCAT(LD.CNTR_TPSZ_CD) FROM SPC_BKG_ALOC_MGMT_TP_SZ_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ ) CNTR_TPSZ_CD        
                              , (SELECT WM_CONCAT(CMDT.CMDT_CD) FROM SPC_BKG_ALOC_MGMT_CMDT_DTL CMDT WHERE CMDT.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ ) CMDT_CD        
                              , MT.ALOC_LOD_QTY        
                              , MT.ALOC_LOD_QTY_RTO        
                              , MT.VSL_CD        
                              , MT.SKD_VOY_NO        
                              , MT.SKD_DIR_CD        
                              , MT.SLS_RHQ_CD        
                              , MT.SCG_GRP_CMDT_SEQ        
                              , MT.CMPB_AMT -- :v_mst_smp_flg = 'Y' 이면 CMPB 룰은 태우지 않음(SMP에서 처리함)        
                              , MT.BKG_CTRL_TP_CD        
                              , MT.DCGO_FLG        
                              , MT.RD_CGO_FLG        
                              , MT.CRE_USR_ID        
                              , MT.CRE_DT        
                              , MT.UPD_USR_ID        
                              , MT.UPD_DT        
                              , MT.ALOC_APLY_FM_DT        
                              , MT.ALOC_APLY_TO_DT        
                              , MT.SUB_TRD_CD        
                              , MT.OFT_CHG_AMT       
                              , MT.USA_BKG_MOD_CD        
                                -- TRUNK, T/S의 경우, Free Type은 Trunk pol-pod, TS pol-pod 동시입력 가능하므로 LOC_DIV_CD 변경함        
                              , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'TPL' AND LENGTH(LD.SB_LOC_CD) = 5) TRNK_POL_CD                
                              , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'TPD' AND LENGTH(LD.SB_LOC_CD) = 5) TRNK_POD_CD                  
                              , (SELECT WM_CONCAT(AD.CUST_CNT_CD || LPAD(AD.CUST_SEQ, 6, '0')) FROM SPC_BKG_ALOC_MGMT_CUST_DTL AD WHERE AD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND AD.BKG_CUST_TP_CD = 'B') ACT_CNT_CD          
                              , L.HUL_BND_CD         
                              , BKG_LIST.SLS_WK SLS_WK        
                              , L.DIR_CD HUL_DIR_CD        
                              , ASGN_TTL_WGT        
                              , ASGN_WGT_RTO        
                              , CMPB_ONY_FLG        
                              , RVIS_CNTR_CUST_TP_CD        
                              , OP_CNTR_QTY AS CNTR_QTY        
                              , MT.BKG_ALOC_RMK               
                              , ( SELECT NVL( MAX(MODI_SEQ) , 1) MODI_SEQ FROM SPC_BKG_ALOC_MGMT_HIS WHERE BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ ) MODI_SEQ --** master 인경우만 BKG_ALOC_SEQ와 MODI_SEQ 값 저장.                
                              , MT.CMPB_PER_TON_AMT       
                              , MT.TON_PER_TEU_WGT         
                    FROM  SPC_BKG_ALOC_MGMT MT, MAS_LANE_RGST L, BKG_LIST                
                    WHERE MT.BKG_ALOC_TP_CD = 'F'                
                    AND (MT.ALOC_USE_FLG IS NULL OR  MT.ALOC_USE_FLG = 'Y')                
                    AND TO_CHAR(SYSDATE, 'YYYYMMDD') BETWEEN NVL(MT.ALOC_APLY_FM_DT, '20150101') AND NVL(MT.ALOC_APLY_TO_DT, '20991231')                
                    AND BKG_LIST.SLS_WK BETWEEN NVL(MT.APLY_FM_YRWK, '201501') AND NVL(MT.APLY_TO_YRWK, '209953') -- Week 기준 추가                
                    AND MT.SLS_RHQ_CD = BKG_LIST.SLS_RHQ_CD --필수값                
                    AND MT.SUB_TRD_CD = BKG_LIST.SUB_TRD_CD --필수값                
                  --  AND MT.VSL_CD = 'SMXX'                
                    --HUL_BND_CD 필수값                
                    AND L.RLANE_CD = BKG_LIST.RLANE_CD                
                    AND L.TRD_CD   = BKG_LIST.TRD_CD                
                    AND L.IOC_CD   = BKG_LIST.IOC_CD              
                    AND L.DIR_CD   = BKG_LIST.DIR_CD                  
                    -------------                
                    AND NVL(MT.HUL_BND_CD, 'XX') = CASE WHEN MT.HUL_BND_CD IS NOT NULL THEN L.HUL_BND_CD ELSE 'XX' END                
                    AND NVL(MT.TRNK_DIR_CD, '#@') = CASE WHEN MT.TRNK_DIR_CD IS NOT NULL THEN L.DIR_CD ELSE '#@' END                
                    AND L.DELT_FLG = 'N'                
                )                
              , BKG AS (                
                    SELECT BKG_NO                
                         , TRNK_SLAN_CD                
                         , TRNK_DIR_CD                
                         , TRNK_POL_CD                
                         , TRNK_POD_CD                
                         , OB_SLS_OFC_CD                
                         , POR_CD                
                         , POR_NOD_CD                
                         , BKG_POR_SCC_CD                
                         , POL_CD                
                         , POL_NOD_CD                
                         -- BKG Main의 POL/POD 제외 즉, BKG-Route Detail의 1st POL, Last POD를 제외한 Port는 모두 T/S 임          
                         -- DUMMY 에서는 T/S가 의미없음        
                         , MAX(DECODE(RK, 1, TS_SLAN_CD))  AS TS_SLAN_CD1           
                         , MAX(DECODE(RK, 1, TS_DIR))      AS TS_DIR1        
                         , MAX(DECODE(RK, 1, TS_VVD))      AS TS_VVD1        
                         , MAX(DECODE(RK, 2, TS_SLAN_CD))  AS TS_SLAN_CD2        
                         , MAX(DECODE(RK, 2, TS_DIR))      AS TS_DIR2        
                         , MAX(DECODE(RK, 2, TS_VVD))      AS TS_VVD2        
                         , MAX(DECODE(RK, 3, TS_SLAN_CD))  AS TS_SLAN_CD3        
                         , MAX(DECODE(RK, 3, TS_DIR))      AS TS_DIR3        
                         , MAX(DECODE(RK, 3, TS_VVD))      AS TS_VVD3        
                                 
                         , MAX(DECODE(RK, 1, NULL))                AS TS_POL_CNT_CD1        
                         , MAX(DECODE(RK, 1, NULL))                AS TS_POL_CD1        
                         , MAX(DECODE(RK, 1, NULL))                AS TS_POL_NOD_CD1        
                         , MAX(DECODE(RK, 1, TS_POD_CNT_CD))       AS TS_POD_CNT_CD1        
                         , MAX(DECODE(RK, 1, TS_POD_CD))           AS TS_POD_CD1        
                         , MAX(DECODE(RK, 1, TS_POD_YD_CD))        AS TS_POD_NOD_CD1        
                         , MAX(DECODE(RK, 2, TS_POL_CNT_CD))       AS TS_POL_CNT_CD2        
                         , MAX(DECODE(RK, 2, TS_POL_CD))           AS TS_POL_CD2        
                         , MAX(DECODE(RK, 2, TS_POL_YD_CD))        AS TS_POL_NOD_CD2        
                         , DECODE(MAX(RK), 2, NULL, MAX(DECODE(RK, 2, TS_POD_CNT_CD)))       AS TS_POD_CNT_CD2        
                         , DECODE(MAX(RK), 2, NULL, MAX(DECODE(RK, 2, TS_POD_CD)))           AS TS_POD_CD2        
                         , DECODE(MAX(RK), 2, NULL, MAX(DECODE(RK, 2, TS_POD_YD_CD)))        AS TS_POD_NOD_CD2        
                         , MAX(DECODE(RK, 3, TS_POL_CNT_CD))       AS TS_POL_CNT_CD3        
                         , MAX(DECODE(RK, 3, TS_POL_CD))           AS TS_POL_CD3        
                         , MAX(DECODE(RK, 3, TS_POL_YD_CD))        AS TS_POL_NOD_CD3        
                         , DECODE(MAX(RK), 3, NULL, MAX(DECODE(RK, 3, TS_POD_CNT_CD)))      AS TS_POD_CNT_CD3        
                         , DECODE(MAX(RK), 3, NULL, MAX(DECODE(RK, 3, TS_POD_CD)))          AS TS_POD_CD3        
                         , DECODE(MAX(RK), 3, NULL, MAX(DECODE(RK, 3, TS_POD_YD_CD)))       AS TS_POD_NOD_CD3        
                                           
                         , SLS_RHQ_CD                
                         , RGN_OFC_CD                
                         , POD_CD                
                         , POD_NOD_CD                
                         , DEL_CD                
                         , DEL_NOD_CD                
                         , BKG_DEL_SCC_CD                
                         , SC_NO                
                         , RFA_NO                
                         , CTRT_CUST_CNT_CD                
                         , CTRT_CUST_SEQ                
                         , CTRT_CUST_CODE         
                         , CUST_GRP_ID  
                         , RFA_CTRT_TP_CD       
                         , CUST_CNT_CD                
                         , CUST_SEQ                
                         , CUST_CODE                
                         , CNTR_TPSZ_CD                
                         , CMDT_CD                
                         , BKG_LOD_QTY                
                         , VSL_CD                
                         , SKD_VOY_NO                
                         , DIR_CD                
                         , SCG_GRP_CMDT_SEQ                
                         , BKG_POR_CNT_CD                
                         , BKG_POL_CNT_CD                
                         , BKG_POD_CNT_CD                
                         , BKG_DEL_CNT_CD                
                         , SUB_TRD_CD                
                         , CMPB_AMT                
                         , DCGO_FLG                
                         , RD_CGO_FLG                
                         , AGMT_ACT_CNT_CD                
                         , AGMT_ACT_CUST_SEQ                
                         , AGMT_ACT_CUST_CODE                
                         , OFT_CHG_AMT                
                         , USA_BKG_MOD_CD                
                         , ALOC_STS_CD                 
                         , HUL_BND_CD                 
                         , ROUND(CMPB_AMT/WGT,2)  AS CMPB_PER_TON_AMT        
                         , ROUND(WGT/BKG_LOD_QTY,2)  AS TON_PER_TEU_WGT        
                      FROM BKG_LIST                
                    GROUP BY BKG_NO                
                         , TRNK_SLAN_CD                
                         , TRNK_DIR_CD                
                         , TRNK_POL_CD                
                         , TRNK_POD_CD                
                         , OB_SLS_OFC_CD                
                         , POR_CD                
                         , POR_NOD_CD                
                         , BKG_POR_SCC_CD                
                         , POL_CD                
                         , POL_NOD_CD                
                         , SLS_RHQ_CD                
                         , RGN_OFC_CD                
                         , POD_CD                
                         , POD_NOD_CD                
                         , DEL_CD                
                         , DEL_NOD_CD                
                         , BKG_DEL_SCC_CD                
                         , SC_NO                
                         , RFA_NO                
                         , CTRT_CUST_CNT_CD                
                         , CTRT_CUST_SEQ                
                         , CTRT_CUST_CODE         
                         , CUST_GRP_ID  
                         , RFA_CTRT_TP_CD       
                         , CUST_CNT_CD                
                         , CUST_SEQ                
                         , CUST_CODE                
                         , CNTR_TPSZ_CD                
                         , CMDT_CD                
                         , BKG_LOD_QTY                
                         , VSL_CD                
                         , SKD_VOY_NO                
                         , DIR_CD                
                         , SLS_RHQ_CD                
                         , SCG_GRP_CMDT_SEQ                
                         , BKG_POR_CNT_CD                
                         , BKG_POL_CNT_CD                
                         , BKG_POD_CNT_CD                
                         , BKG_DEL_CNT_CD                
                         , SUB_TRD_CD                
                         , CMPB_AMT                
                         , DCGO_FLG                
                         , RD_CGO_FLG                
                         , AGMT_ACT_CNT_CD                
                         , AGMT_ACT_CUST_SEQ                
                         , AGMT_ACT_CUST_CODE                
                         , OFT_CHG_AMT                
                         , USA_BKG_MOD_CD                
                         , ALOC_STS_CD              
                         , HUL_BND_CD       
                         , WGT             
                )               
                , G_SUM AS (                
                    SELECT M.BKG_ALOC_SEQ                
                          , M.MODI_SEQ  --** master table history              
                          , BKG_CTRL_TP_CD             
                    FROM BKG, MASTER M                
                    WHERE M.SLS_RHQ_CD = BKG.SLS_RHQ_CD --필수값                
                        AND M.SUB_TRD_CD = BKG.SUB_TRD_CD --필수값                
                   --     AND M.VSL_CD = 'SMXX'                
                        AND NVL(M.HUL_BND_CD, BKG.HUL_BND_CD) = BKG.HUL_BND_CD --필수값                
                        AND NVL(M.TRNK_SLAN_CD       ,  BKG.TRNK_SLAN_CD    ) = BKG.TRNK_SLAN_CD                
                        AND NVL(M.TRNK_POL_CD        ,  BKG.TRNK_POL_CD     ) LIKE '%'||BKG.TRNK_POL_CD||'%'                
                        AND NVL(M.TRNK_POD_CD        ,  BKG.TRNK_POD_CD     ) LIKE '%'||BKG.TRNK_POD_CD||'%'                
                        AND NVL(M.OB_SLS_OFC_CD      ,  BKG.OB_SLS_OFC_CD   ) = BKG.OB_SLS_OFC_CD                
                        AND NVL(M.POR_CD             ,  BKG.POR_CD) LIKE '%'||BKG.POR_CD||'%'                
                        AND NVL(M.POR_NOD_CD         ,  BKG.POR_NOD_CD      ) = BKG.POR_NOD_CD                
                        AND NVL(M.BKG_POR_SCC_CD     ,  BKG.BKG_POR_SCC_CD  ) = BKG.BKG_POR_SCC_CD                
                        AND NVL(M.POL_CD             ,  BKG.POL_CD) LIKE '%'||BKG.POL_CD||'%'                
                        AND NVL(M.POL_NOD_CD         ,  BKG.POL_NOD_CD      ) = BKG.POL_NOD_CD                
                        --TS조건 체크                
                        AND (NVL(M.N1ST_TS_SLAN_CD   , NVL(BKG.TS_SLAN_CD1, '#@') ) = NVL(BKG.TS_SLAN_CD1, '#@') OR                
                            NVL(M.N1ST_TS_SLAN_CD    , NVL(BKG.TS_SLAN_CD2, '#@') ) = NVL(BKG.TS_SLAN_CD2, '#@') OR                
                            NVL(M.N1ST_TS_SLAN_CD    , NVL(BKG.TS_SLAN_CD3, '#@') ) = NVL(BKG.TS_SLAN_CD3, '#@'))                
                        AND (NVL(M.N1ST_TS_POL_CD    , NVL(BKG.TS_POL_CD1, '#@')) LIKE '%'||NVL(BKG.TS_POL_CD1, '#@')||'%' OR                
                             NVL(M.N1ST_TS_POL_CD    , NVL(BKG.TS_POL_CD2, '#@')) LIKE '%'||NVL(BKG.TS_POL_CD2, '#@')||'%' OR                
                             NVL(M.N1ST_TS_POL_CD    , NVL(BKG.TS_POL_CD3, '#@')) LIKE '%'||NVL(BKG.TS_POL_CD3, '#@')||'%')                
                        AND (NVL(M.N1ST_TS_POD_CD    , NVL(BKG.TS_POD_CD1, '#@')) LIKE '%'||NVL(BKG.TS_POD_CD1, '#@')||'%' OR                
                             NVL(M.N1ST_TS_POD_CD    , NVL(BKG.TS_POD_CD2, '#@')) LIKE '%'||NVL(BKG.TS_POD_CD2, '#@')||'%' OR                
                             NVL(M.N1ST_TS_POD_CD    , NVL(BKG.TS_POD_CD3, '#@')) LIKE '%'||NVL(BKG.TS_POD_CD3, '#@')||'%')                   
                        AND (NVL(M.N1ST_TS_POL_CNT_CD    , NVL(BKG.TS_POL_CNT_CD1, '#@')) LIKE '%'||NVL(BKG.TS_POL_CNT_CD1, '#@')||'%' OR                
                             NVL(M.N1ST_TS_POL_CNT_CD    , NVL(BKG.TS_POL_CNT_CD2, '#@')) LIKE '%'||NVL(BKG.TS_POL_CNT_CD2, '#@')||'%' OR                
                             NVL(M.N1ST_TS_POL_CNT_CD    , NVL(BKG.TS_POL_CNT_CD3, '#@')) LIKE '%'||NVL(BKG.TS_POL_CNT_CD3, '#@')||'%')                
                        AND (NVL(M.N1ST_TS_POD_CNT_CD    , NVL(BKG.TS_POD_CNT_CD1, '#@')) LIKE '%'||NVL(BKG.TS_POD_CNT_CD1, '#@')||'%' OR                
                             NVL(M.N1ST_TS_POD_CNT_CD    , NVL(BKG.TS_POD_CNT_CD2, '#@')) LIKE '%'||NVL(BKG.TS_POD_CNT_CD2, '#@')||'%' OR                
                             NVL(M.N1ST_TS_POD_CNT_CD    , NVL(BKG.TS_POD_CNT_CD3, '#@')) LIKE '%'||NVL(BKG.TS_POD_CNT_CD3, '#@')||'%')            
                               
                        -- [2015.10.23]         
                        AND (NVL(M.TS_ALL_LOC_CD    , NVL(BKG.TS_POL_CD1, '#@')) LIKE '%'||NVL(BKG.TS_POL_CD1, '#@')||'%' OR                
                             NVL(M.TS_ALL_LOC_CD    , NVL(BKG.TS_POL_CD2, '#@')) LIKE '%'||NVL(BKG.TS_POL_CD2, '#@')||'%' OR                
                             NVL(M.TS_ALL_LOC_CD    , NVL(BKG.TS_POL_CD3, '#@')) LIKE '%'||NVL(BKG.TS_POL_CD3, '#@')||'%' OR        
                             NVL(M.TS_ALL_LOC_CD    , NVL(BKG.TS_POD_CD1, '#@')) LIKE '%'||NVL(BKG.TS_POD_CD1, '#@')||'%' OR                
                             NVL(M.TS_ALL_LOC_CD    , NVL(BKG.TS_POD_CD2, '#@')) LIKE '%'||NVL(BKG.TS_POD_CD2, '#@')||'%' OR                
                             NVL(M.TS_ALL_LOC_CD    , NVL(BKG.TS_POD_CD3, '#@')) LIKE '%'||NVL(BKG.TS_POD_CD3, '#@')||'%' OR         
                             NVL(M.TS_ALL_NOD_CD    , NVL(BKG.TS_POL_NOD_CD1, '#@')) LIKE '%'||NVL(BKG.TS_POL_NOD_CD1, '#@')||'%' OR                
                             NVL(M.TS_ALL_NOD_CD    , NVL(BKG.TS_POL_NOD_CD2, '#@')) LIKE '%'||NVL(BKG.TS_POL_NOD_CD2, '#@')||'%' OR                
                             NVL(M.TS_ALL_NOD_CD    , NVL(BKG.TS_POL_NOD_CD3, '#@')) LIKE '%'||NVL(BKG.TS_POL_NOD_CD3, '#@')||'%' OR              
                             NVL(M.TS_ALL_NOD_CD    , NVL(BKG.TS_POD_NOD_CD1, '#@')) LIKE '%'||NVL(BKG.TS_POD_NOD_CD1, '#@')||'%' OR                
                             NVL(M.TS_ALL_NOD_CD    , NVL(BKG.TS_POD_NOD_CD2, '#@')) LIKE '%'||NVL(BKG.TS_POD_NOD_CD2, '#@')||'%' OR                
                             NVL(M.TS_ALL_NOD_CD    , NVL(BKG.TS_POD_NOD_CD3, '#@')) LIKE '%'||NVL(BKG.TS_POD_NOD_CD3, '#@')||'%')         
                                          
                        AND (NVL(M.TS_POL_NOD_CD    , NVL(BKG.TS_POL_NOD_CD1, '#@')) LIKE '%'||NVL(BKG.TS_POL_NOD_CD1, '#@')||'%' OR                
                             NVL(M.TS_POL_NOD_CD    , NVL(BKG.TS_POL_NOD_CD2, '#@')) LIKE '%'||NVL(BKG.TS_POL_NOD_CD2, '#@')||'%' OR                
                             NVL(M.TS_POL_NOD_CD    , NVL(BKG.TS_POL_NOD_CD3, '#@')) LIKE '%'||NVL(BKG.TS_POL_NOD_CD3, '#@')||'%')             
                                           
                        AND (NVL(M.TS_POD_NOD_CD    , NVL(BKG.TS_POD_NOD_CD1, '#@')) LIKE '%'||NVL(BKG.TS_POD_NOD_CD1, '#@')||'%' OR                
                             NVL(M.TS_POD_NOD_CD    , NVL(BKG.TS_POD_NOD_CD2, '#@')) LIKE '%'||NVL(BKG.TS_POD_NOD_CD2, '#@')||'%' OR                
                             NVL(M.TS_POD_NOD_CD    , NVL(BKG.TS_POD_NOD_CD3, '#@')) LIKE '%'||NVL(BKG.TS_POD_NOD_CD3, '#@')||'%')         
                 
                                     
                        AND NVL(M.POD_CD             , BKG.POD_CD) LIKE '%'|| BKG.POD_CD ||'%'                
                        AND NVL(M.POD_NOD_CD         , BKG.POD_NOD_CD          ) = BKG.POD_NOD_CD                
                        AND NVL(M.DEL_CD             , BKG.DEL_CD) LIKE '%'|| BKG.DEL_CD ||'%'                
                        AND NVL(M.DEL_NOD_CD         , BKG.DEL_NOD_CD          ) = BKG.DEL_NOD_CD                
                        AND NVL(M.BKG_DEL_SCC_CD     , BKG.BKG_DEL_SCC_CD      ) = BKG.BKG_DEL_SCC_CD                
                        AND NVL(M.SC_NO              , NVL(BKG.SC_NO, '#@')     ) = NVL(BKG.SC_NO, '#@')                
                        AND NVL(M.RFA_NO             , NVL(BKG.RFA_NO, '#@')    ) = NVL(BKG.RFA_NO, '#@')                
                        AND NVL(M.CTRT_CUST_CNT_CD   , NVL(BKG.CTRT_CUST_CNT_CD, '#@')    ) = NVL(BKG.CTRT_CUST_CNT_CD, '#@')                
                        AND NVL(M.CTRT_CUST_SEQ      , NVL(BKG.CTRT_CUST_SEQ, 0)    ) = NVL(BKG.CTRT_CUST_SEQ, 0)          
                        AND NVL(M.CUST_GRP_ID        , NVL(BKG.CUST_GRP_ID, '#@')        ) = NVL(BKG.CUST_GRP_ID, '#@')         		       
                        AND NVL(M.RFA_CTRT_TP_CD     , NVL(BKG.RFA_CTRT_TP_CD, '#@')        ) = NVL(BKG.RFA_CTRT_TP_CD, '#@')        
                        AND NVL(M.CUST_CNT_CD        , NVL(BKG.CUST_CNT_CD, '#@')        ) = NVL(BKG.CUST_CNT_CD, '#@')                
                        AND NVL(M.CUST_SEQ           , NVL(BKG.CUST_SEQ, 0)          ) = NVL(BKG.CUST_SEQ, 0)                
                        AND NVL(M.CNTR_TPSZ_CD       , NVL(BKG.CNTR_TPSZ_CD, '#@')) LIKE '%'||NVL(BKG.CNTR_TPSZ_CD, '#@')||'%'                
                        AND NVL(M.CMDT_CD            , NVL(BKG.CMDT_CD, '#@')) LIKE '%'||NVL(BKG.CMDT_CD, '#@')||'%'                
                        AND BKG.VSL_CD IN ('SMXX', 'SMYY', 'SMZZ')                
                        AND NVL(TO_CHAR(M.SCG_GRP_CMDT_SEQ)   , NVL(BKG.SCG_GRP_CMDT_SEQ, '#@')    ) = NVL(BKG.SCG_GRP_CMDT_SEQ, '#@')                
                        AND NVL(M.POR_CNT_CD     ,  BKG.BKG_POR_CNT_CD) LIKE '%'||BKG.BKG_POR_CNT_CD||'%'                
                        AND NVL(M.POL_CNT_CD     ,  BKG.BKG_POL_CNT_CD) LIKE '%'||BKG.BKG_POL_CNT_CD||'%'                
                        AND NVL(M.POD_CNT_CD     ,  BKG.BKG_POD_CNT_CD) LIKE '%'||BKG.BKG_POD_CNT_CD||'%'                
                        AND NVL(M.DEL_CNT_CD     ,  BKG.BKG_DEL_CNT_CD) LIKE '%'||BKG.BKG_DEL_CNT_CD||'%'                
                        AND NVL(M.DCGO_FLG           , NVL(BKG.DCGO_FLG, 'N')          ) = NVL(BKG.DCGO_FLG, 'N')                
                        AND NVL(M.RD_CGO_FLG         , NVL(BKG.RD_CGO_FLG, 'N')        ) = NVL(BKG.RD_CGO_FLG, 'N')                
                        AND NVL(M.ACT_CNT_CD         , NVL((BKG.AGMT_ACT_CNT_CD||LPAD(BKG.AGMT_ACT_CUST_SEQ, 6, '0')), '#@')) LIKE '%'|| NVL((BKG.AGMT_ACT_CNT_CD||LPAD(BKG.AGMT_ACT_CUST_SEQ, 6, '0')), '#@')||'%'                
                        AND NVL(M.OFT_CHG_AMT        , NVL(BKG.OFT_CHG_AMT, 0)    )    >= NVL(BKG.OFT_CHG_AMT, 0)                
                        AND NVL(M.USA_BKG_MOD_CD     , BKG.USA_BKG_MOD_CD )     = BKG.USA_BKG_MOD_CD        
                        AND (CASE NVL(M.CMPB_AMT,0) WHEN 0 THEN 1 ELSE NVL(M.CMPB_AMT,1) END) > (CASE NVL(M.CMPB_AMT,0) WHEN 0 THEN 0 ELSE NVL(BKG.CMPB_AMT,0) END)                            
                        AND (CASE NVL(M.CMPB_PER_TON_AMT,0) WHEN 0 THEN 1 ELSE NVL(M.CMPB_PER_TON_AMT,1) END) >= (CASE NVL(M.CMPB_PER_TON_AMT,0) WHEN 0 THEN 0 ELSE NVL(BKG.CMPB_PER_TON_AMT,0) END)          
                        AND (CASE NVL(M.TON_PER_TEU_WGT,0) WHEN 0 THEN 0 ELSE NVL(M.TON_PER_TEU_WGT,1) END) <= (CASE NVL(M.TON_PER_TEU_WGT,0) WHEN 0 THEN 1 ELSE NVL(BKG.TON_PER_TEU_WGT,0) END)          
                    GROUP BY M.BKG_ALOC_SEQ, M.MODI_SEQ  , BKG_CTRL_TP_CD               
                   )                
                 SELECT              
                      MAX(DECODE(ALOC_STS_CD,'S',ALOC_STS_CD)) V11             
                    , MAX(DECODE(ALOC_STS_CD,'S',ALOC_SVC_CD)) V12             
                    , MAX(DECODE(ALOC_STS_CD,'S',BKG_ALOC_SEQ)) V13             
                    , MAX(DECODE(ALOC_STS_CD,'S',LST_SB_RS)) V14             
                    , MAX(DECODE(ALOC_STS_CD,'S',MODI_SEQ)) V15             
                    , MAX(DECODE(ALOC_STS_CD,'A',ALOC_STS_CD)) V21             
                    , MAX(DECODE(ALOC_STS_CD,'A',ALOC_SVC_CD)) V22             
                    , MAX(DECODE(ALOC_STS_CD,'A',BKG_ALOC_SEQ)) V23             
                    , MAX(DECODE(ALOC_STS_CD,'A',LST_SB_RS)) V24             
                    , MAX(DECODE(ALOC_STS_CD,'A',MODI_SEQ)) V25             
                     INTO V_MST_F_RLST, V_MST_F_SVC_CD, V_MST_F_SEQ ,V_MST_F_RS, V_MODI_SEQ ,A_MST_F_RLST, A_MST_F_SVC_CD, A_MST_F_SEQ ,A_MST_F_RS, A_MODI_SEQ             
                 FROM (                     
                    SELECT ALOC_STS_CD,ALOC_SVC_CD,BKG_ALOC_SEQ,LST_SB_RS,MODI_SEQ,F_ROW             
                    FROM (             
                                SELECT BKG_CTRL_TP_CD AS ALOC_STS_CD, 'A' ALOC_SVC_CD, BKG_ALOC_SEQ ,               
                                        'DUMMY BKG' LST_SB_RS, MODI_SEQ --**               
                                         , DENSE_RANK() OVER(PARTITION BY BKG_CTRL_TP_CD ORDER BY BKG_CTRL_TP_CD) F_ROW             
                                  FROM G_SUM               
                   ) WHERE F_ROW=1             
                  )                        
                  ;          
             
            EXCEPTION                
                    WHEN NO_DATA_FOUND THEN                
                    v_mst_f_rlst := NULL;                
                    v_mst_f_svc_cd := NULL;                
                    v_mst_f_seq := NULL;                
                    v_mst_f_rs := NULL;              
                    v_modi_seq := NULL;                
                    a_mst_f_rlst := NULL;               
                    a_mst_f_svc_cd := NULL;               
                    a_mst_f_seq := NULL;               
                    a_mst_f_rs := NULL;               
                    a_modi_seq := NULL;                  
                    enis_log_prc(SYSDATE, v_prc_nm, v_step || ' check null ', v_appl_info);                
            END;      
              
              
            -- 이전에 STANDBY REASON 정보가 있었는지 체크한다.   
            BEGIN           
                SELECT NVL(MAX(DECODE(BKG_CTRL_TP_CD,'S','Y','N')),'N')          
                     , NVL(MAX(DECODE(BKG_CTRL_TP_CD,'A','Y','N')),'N')          
                  INTO v_is_standby         
                     , v_is_attention         
                  FROM SPC_SB_BKG_DTL              
                 WHERE BKG_NO = v_appl_info;  
            EXCEPTION              
                  WHEN NO_DATA_FOUND THEN              
                       v_is_standby   := 'N';           
                       v_is_attention := 'N';                 
            END;       
                            
            IF (v_mst_f_rlst = 'S' OR a_mst_f_rlst='A' ) THEN            
                --Standby or attention 상태인 경우                
                MERGE INTO SPC_SB_BKG O  USING   
                (  
                  SELECT v_appl_info BKG_NO   
                       , (SELECT SPC_GET_CMPB_FNC(v_appl_info, 'BKG') FROM DUAL) AS CMPB     -- [2016.04.12]  
                       , NVL((SELECT 'Y' FROM BKG_BOOKING WHERE BKG_NO = v_appl_info AND ALOC_STS_CD = 'F'), 'N') AS BKG_CFM_FLG  
                       , SYSDATE LST_SB_DT                    
                    FROM DUAL) N                
                ON (O.BKG_NO = N.BKG_NO)                
                WHEN MATCHED THEN                
                UPDATE SET                
                       O.LST_SB_DT = SYSDATE             
                     , O.INIT_CMPB_AMT = N.CMPB       
                     , O.BKG_CFM_FLG   = N.BKG_CFM_FLG        
                     , O.UPD_USR_ID = v_user_info                
                     , O.UPD_DT = SYSDATE                
                WHEN NOT MATCHED THEN                
                INSERT ( BKG_NO                
                         , LST_SB_DT            
                         , INIT_CMPB_AMT         
                         , BKG_CFM_FLG        
                         , CFM_USR_ID              
                         , CRE_USR_ID                
                         , CRE_DT                
                         , UPD_USR_ID                
                         , UPD_DT )                
                VALUES ( N.BKG_NO                
                         , N.LST_SB_DT          
                         , N.CMPB            
                         , N.BKG_CFM_FLG        
                         , v_user_info        
                         , v_user_info              
                         , SYSDATE                
                         , v_user_info                
                         , SYSDATE )                
                         ;           
                                    
                                                     
                -- 이전에 STANDBY 가 존재했었고, 제약조건 완화 및 BKG 정보 변경으로 STANDBY 가 없어 졌을 경우는 FIRM 처리           
                -- [2015.10.16]           
                IF(v_mst_f_rlst IS NULL AND v_is_standby = 'Y') THEN                            
                    UPDATE SPC_SB_BKG             
                       SET CFM_USR_ID       ='SPC_SYSTEM'             
                         , CFM_DT           = SYSDATE              
                         , UPD_USR_ID       = v_user_info           
                         , UPD_DT           = SYSDATE               
                     WHERE BKG_NO           = v_appl_info;            
                                                    
                    UPDATE SPC_SB_BKG_DTL             
                       SET DELT_FLG         = 'Y'            
                         , UPD_USR_ID       = v_user_info            
                         , UPD_DT           = SYSDATE            
                     WHERE BKG_NO           = v_appl_info           
                       AND BKG_CTRL_TP_CD   = 'S';                                   
                ELSE           
                    DELETE FROM SPC_SB_BKG_DTL WHERE BKG_NO = v_appl_info;           
                END IF;            
                           
                -- INSERT 문은 ATTENTION 또는 STANDBY 존재 체크하므로 별도 조건이 필요없음.                
                INSERT INTO SPC_SB_BKG_DTL                
                (BKG_NO, LST_SB_RSN_TP_CD, LST_SB_SUB_RSN_CD, ALOC_SVC_CD, LST_SB_RSN, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT, BKG_ALOC_SEQ, MODI_SEQ, LST_SB_OTR_RSN, SC_NO, RFA_NO, ACCT_CD, SUB_TRD_CD, VVD_CD, OFC_CD, RLANE_CD,BKG_CTRL_TP_CD,DELT_FLG)               
                SELECT v_appl_info BKG_NO, 'M' LST_SB_RSN_TP_CD, 'F' LST_SB_SUB_RSN_CD, v_mst_f_svc_cd  ALOC_SVC_CD    
                , ( SELECT MAX(''	                
--                        ||	NVL2(AL.BKG_ALOC_SEQ,			'Seq:'          		||AL.BKG_ALOC_SEQ                                       ||', ','')                
                        ||	NVL2(AL.SLS_RHQ_CD,			'RHQ:'          		||AL.SLS_RHQ_CD                                         ||', ','')                
                        ||	NVL2(AL.BKG_ALOC_TP_CD,			'TYPE:'         		||AL.BKG_ALOC_TP_CD                                     ||', ','')                
                        ||	NVL2(AL.SUB_TRD_CD,			'SubTrade:'     		||AL.SUB_TRD_CD                                         ||', ','')                
                        ||	NVL2(AL.TRNK_SLAN_CD,			'T.LANE:'       		||AL.TRNK_SLAN_CD                                       ||', ','')                
                        ||	NVL2(AL.HUL_BND_CD,			'HAULBOUND:'    		||AL.HUL_BND_CD                                         ||', ','')                
                        ||	NVL2(AL.TRNK_DIR_CD,			'BD:'           		||AL.TRNK_DIR_CD                                        ||', ','')                
                        ||	NVL2(PL.BKG_ALOC_SEQ,			'TrunkPOL:'     		||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = PL.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = PL.SB_LOC_DIV_CD AND LENGTH(D.SB_LOC_CD) = 5)||', ','')                
                        ||	NVL2(PD.BKG_ALOC_SEQ,			'TrunkPOD:'     		||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = PD.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = PD.SB_LOC_DIV_CD AND LENGTH(D.SB_LOC_CD) = 5)||', ','')                
                        ||	NVL2(POR2.BKG_ALOC_SEQ,			'POR-Country:'  		||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = POR2.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = POR2.SB_LOC_DIV_CD AND LENGTH(D.SB_LOC_CD) = 2)||', ','')                
                        ||	NVL2(POR.BKG_ALOC_SEQ,			'POR-LOC:'      		||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = POR.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = POR.SB_LOC_DIV_CD AND LENGTH(D.SB_LOC_CD) = 5)||', ','')                
                        ||	NVL2(AL.POR_NOD_CD,			'POR-NODE:'     		||AL.POR_NOD_CD                                         ||', ','')                
                        ||	NVL2(AL.BKG_POR_SCC_CD,			'POR-SCC:'      		||AL.BKG_POR_SCC_CD                                     ||', ','')                
                        ||	NVL2(POL2.BKG_ALOC_SEQ,			'POL-Country:'  		||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = POL2.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = POL2.SB_LOC_DIV_CD AND LENGTH(D.SB_LOC_CD) = 2)||', ','')                
                        ||	NVL2(POL.BKG_ALOC_SEQ,			'POL-LOC:'      		||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = POL.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = POL.SB_LOC_DIV_CD AND LENGTH(D.SB_LOC_CD) = 5)||', ','')                
                        ||	NVL2(AL.POL_NOD_CD,			'POL-NODE:'     		||AL.POL_NOD_CD                                         ||', ','')                
                        ||	NVL2(AL.N1ST_TS_SLAN_CD,		'T/SLANE:'      		||AL.N1ST_TS_SLAN_CD                                    ||', ','')                
                        -- [2015.10.23]        
                        ||	NVL2(SAY1.BKG_ALOC_SEQ,			'T/S-Port:'		        ||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = SAY1.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = SAY1.SB_LOC_DIV_CD)||', ','')                
                        ||	NVL2(AL.N1ST_TS_DIR_CD,			'T/SBD:'        		||AL.N1ST_TS_DIR_CD                                     ||', ','')                
                        ||	NVL2(PL4.BKG_ALOC_SEQ,			'T/SPOL-Country:'		||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = PL4.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = PL4.SB_LOC_DIV_CD AND LENGTH(D.SB_LOC_CD) = 2)||', ','')                
                        -- [2015.10.23]        
                        ||	NVL2(SLY1.BKG_ALOC_SEQ,			'T/SPOL-NODE:'		        ||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = SLY1.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = SLY1.SB_LOC_DIV_CD)||', ','')        
                        ||	NVL2(PL2.BKG_ALOC_SEQ,			'T/SPOL:'       		||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = PL2.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = PL2.SB_LOC_DIV_CD AND LENGTH(D.SB_LOC_CD) = 5)||', ','')                
                        ||	NVL2(PD4.BKG_ALOC_SEQ,			'T/SPOD-Country:'		||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = PD4.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = PD4.SB_LOC_DIV_CD AND LENGTH(D.SB_LOC_CD) = 2)||', ','')                
                        ||	NVL2(PD2.BKG_ALOC_SEQ,			'T/SPOD:'       		||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = PD2.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = PD2.SB_LOC_DIV_CD AND LENGTH(D.SB_LOC_CD) = 5)||', ','')                
                        -- [2015.10.23]        
                        ||	NVL2(SDY1.BKG_ALOC_SEQ,			'T/SPOD-NODE:'		        ||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = SDY1.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = SDY1.SB_LOC_DIV_CD)||', ','')                
                        ||	NVL2(POD2.BKG_ALOC_SEQ,			'POD-Country:'  		||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = POD2.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = POD2.SB_LOC_DIV_CD AND LENGTH(D.SB_LOC_CD) = 2)||', ','')                
                        ||	NVL2(POD.BKG_ALOC_SEQ,			'POD-LOC:'      		||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = POD.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = POD.SB_LOC_DIV_CD AND LENGTH(D.SB_LOC_CD) = 5)||', ','')                
                        ||	NVL2(AL.POD_NOD_CD,			'POD-NODE:'     		||AL.POD_NOD_CD                                         ||', ','')                
                        ||	NVL2(DEL2.BKG_ALOC_SEQ,			'DEL-Country:'  		||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = DEL2.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = DEL2.SB_LOC_DIV_CD AND LENGTH(D.SB_LOC_CD) = 2)||', ','')                
                        ||	NVL2(DEL.BKG_ALOC_SEQ,			'DEL-LOC:'      		||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = DEL.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = DEL.SB_LOC_DIV_CD AND LENGTH(D.SB_LOC_CD) = 5)||', ','')                
                        ||	NVL2(AL.DEL_NOD_CD,			'DEL/NODE NODE:'		||AL.DEL_NOD_CD                                         ||', ','')                
                        ||	NVL2(AL.BKG_DEL_SCC_CD,			'DEL/NODE SCC:' 		||AL.BKG_DEL_SCC_CD                                     ||', ','')                
                        ||	NVL2(AL.USA_BKG_MOD_CD,			'US Mode:'      		||AL.USA_BKG_MOD_CD                                     ||', ','')                
                        ||	NVL2(AL.VSL_CD,				'VVD:'          		||AL.VSL_CD||SKD_VOY_NO||SKD_DIR_CD                     ||', ','')                
                        ||	NVL2(TP.BKG_ALOC_SEQ,			'CNTR TYPE:'    		||(SELECT REPLACE(WM_CONCAT(D.CNTR_TPSZ_CD ), ',', ' ') FROM SPC_BKG_ALOC_MGMT_TP_SZ_DTL D WHERE D.BKG_ALOC_SEQ = TP.BKG_ALOC_SEQ)||', ','')                
                        ||	NVL2(AL.DCGO_FLG,			'DG:'           		||AL.DCGO_FLG                                           ||', ','')                
                        ||	NVL2(AL.RD_CGO_FLG,			'RD:'           		||AL.RD_CGO_FLG		                                    ||', ','')                
                        ||	NVL2(AL.OB_SLS_OFC_CD,			'L.OFC:'        		||AL.OB_SLS_OFC_CD                                      ||', ','')                
                        ||	NVL2(AL.SC_NO,				'S/CNo.:'       		||AL.SC_NO		                                        ||', ','')                
                        ||	NVL2(AL.RFA_NO,				'RFANo.:'       		||AL.RFA_NO                                             ||', ','')                
                        ||	NVL2(AL.RVIS_CNTR_CUST_TP_CD,	        'BCO/NVO:'     		        ||AL.RVIS_CNTR_CUST_TP_CD                               ||', ','')                
                        ||	NVL2(AL.CTRT_CUST_CNT_CD, 		'C.CustCode:'   		||AL.CTRT_CUST_CNT_CD||LPAD(AL.CTRT_CUST_SEQ, 6, '0')	||', ','')                
                        ||	NVL2(A.BKG_ALOC_SEQ,			'ActualCustomer:'		||(SELECT REPLACE(WM_CONCAT(D.CUST_CNT_CD||LPAD(D.CUST_SEQ, 6, '0')), ',', ' ') FROM SPC_BKG_ALOC_MGMT_CUST_DTL D WHERE D.BKG_ALOC_SEQ = A.BKG_ALOC_SEQ AND D.BKG_CUST_TP_CD = A.BKG_CUST_TP_CD)||', ','')                
                        ||	NVL2(AL.CUST_CNT_CD,			'BKGShipperCode:'		||AL.CUST_CNT_CD||LPAD(AL.CUST_SEQ, 6, '0')				||', ','')                
                        ||	NVL2(AL.OFT_CHG_AMT,			'ChargeOFT:'    		||AL.OFT_CHG_AMT                            			||', ','')                
                        ||	NVL2(AL.CMPB_AMT,			'CMPBAmount:'   		||AL.CMPB_AMT                               			||', ','')                
                        ||	NVL2(AL.ALOC_LOD_QTY,			'ALLOCATION-TEU:'		||AL.ALOC_LOD_QTY                           			||', ','')                
                        ||	NVL2(AL.OP_CNTR_QTY,			'ALLOCATION-BOX:'		||AL.OP_CNTR_QTY                            			||', ','')                
                        ||	NVL2(AL.ASGN_TTL_WGT,			'ALLOCATION-WGT:'		||AL.ASGN_TTL_WGT                           			||', ','')                
                        ||	NVL2(AL.ALOC_LOD_QTY_RTO,		'%THRESHOLD-TEU/BOX:'	        ||AL.ALOC_LOD_QTY_RTO                       			||', ','')                
                        ||	NVL2(AL.ASGN_WGT_RTO,			'%THRESHOLD-WGT:'		||AL.ASGN_WGT_RTO                           			||', ','')                
                        ||	NVL2(AL.SCG_GRP_CMDT_SEQ,		'GroupCOMMODITY-CODE:'	        ||AL.SCG_GRP_CMDT_SEQ                       			||', ','')                
                        ||	NVL2(CMDT.BKG_ALOC_SEQ,			'COMMODITY-CODE:'		||(SELECT REPLACE(WM_CONCAT(D.CMDT_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_CMDT_DTL D WHERE D.BKG_ALOC_SEQ = A.BKG_ALOC_SEQ)||', ','')                
                        ||	NVL2(AL.APLY_FM_YRWK,			'ApplyWK-From:' 		||AL.APLY_FM_YRWK                                       ||', ','')                
                        ||	NVL2(AL.APLY_TO_YRWK,			'ApplyWK-To:'   		||AL.APLY_TO_YRWK                                       ||', ','')                
                        ||	NVL2(AL.BKG_CTRL_TP_CD,			'ControlType:'  		||AL.BKG_CTRL_TP_CD                                     ||', ','')                
                        ||	NVL2(AL.ALOC_SVC_CD,			'SVC:'          		||AL.ALOC_SVC_CD                                        ||', ','')                
                        ||	NVL2(AL.BKG_ALOC_RMK,			'REMARK:'       		||AL.BKG_ALOC_RMK                                       ||', ','')                
--                        ||	NVL2(AL.ALOC_USE_FLG,			'UseYN:'        		||AL.ALOC_USE_FLG                                       ||', ','')                
                        )AS RMK                
                    FROM SPC_BKG_ALOC_MGMT AL                
                         , SPC_BKG_ALOC_MGMT_NOD_DTL PL                
                         , SPC_BKG_ALOC_MGMT_NOD_DTL PD                
                         , SPC_BKG_ALOC_MGMT_NOD_DTL PL2                
                         , SPC_BKG_ALOC_MGMT_NOD_DTL PD2                
                         , SPC_BKG_ALOC_MGMT_NOD_DTL PL3                
                         , SPC_BKG_ALOC_MGMT_NOD_DTL PD3                
                         , SPC_BKG_ALOC_MGMT_NOD_DTL PL4                
                         , SPC_BKG_ALOC_MGMT_NOD_DTL PD4                
                         , SPC_BKG_ALOC_MGMT_NOD_DTL POR                
                         , SPC_BKG_ALOC_MGMT_NOD_DTL POL                
                         , SPC_BKG_ALOC_MGMT_NOD_DTL POD                
                         , SPC_BKG_ALOC_MGMT_NOD_DTL DEL                
                         , SPC_BKG_ALOC_MGMT_NOD_DTL POR2                
                         , SPC_BKG_ALOC_MGMT_NOD_DTL POL2                
                         , SPC_BKG_ALOC_MGMT_NOD_DTL POD2                
                         , SPC_BKG_ALOC_MGMT_NOD_DTL DEL2        
                         , SPC_BKG_ALOC_MGMT_NOD_DTL SAY1               
                         , SPC_BKG_ALOC_MGMT_NOD_DTL SLY1                
                         , SPC_BKG_ALOC_MGMT_NOD_DTL SDY1        
                             
                         , SPC_BKG_ALOC_MGMT_CUST_DTL A                
                         , SPC_BKG_ALOC_MGMT_TP_SZ_DTL TP                
                         , SPC_BKG_ALOC_MGMT_CMDT_DTL CMDT                
                    WHERE 1=1                 
                       AND AL.BKG_ALOC_SEQ = v_mst_f_seq                
                       AND AL.BKG_ALOC_SEQ = PL.BKG_ALOC_SEQ(+) AND PL.SB_LOC_DIV_CD(+) = 'TPL' AND LENGTH(PL.SB_LOC_CD(+)) = 5                
                       AND AL.BKG_ALOC_SEQ = PD.BKG_ALOC_SEQ(+) AND PD.SB_LOC_DIV_CD(+) = 'TPD' AND LENGTH(PD.SB_LOC_CD(+)) = 5                
                       AND AL.BKG_ALOC_SEQ = PL2.BKG_ALOC_SEQ(+) AND PL2.SB_LOC_DIV_CD(+) = 'SPL' AND LENGTH(PL2.SB_LOC_CD(+)) = 5                
                       AND AL.BKG_ALOC_SEQ = PD2.BKG_ALOC_SEQ(+) AND PD2.SB_LOC_DIV_CD(+) = 'SPD' AND LENGTH(PD2.SB_LOC_CD(+)) = 5                   
                       AND AL.BKG_ALOC_SEQ = PL3.BKG_ALOC_SEQ(+) AND PL3.SB_LOC_DIV_CD(+) = 'TPL' AND LENGTH(PL3.SB_LOC_CD(+)) = 2                
                       AND AL.BKG_ALOC_SEQ = PD3.BKG_ALOC_SEQ(+) AND PD3.SB_LOC_DIV_CD(+) = 'TPD' AND LENGTH(PD3.SB_LOC_CD(+)) = 2                
                       AND AL.BKG_ALOC_SEQ = PL4.BKG_ALOC_SEQ(+) AND PL4.SB_LOC_DIV_CD(+) = 'SPL' AND LENGTH(PL4.SB_LOC_CD(+)) = 2                
                       AND AL.BKG_ALOC_SEQ = PD4.BKG_ALOC_SEQ(+) AND PD4.SB_LOC_DIV_CD(+) = 'SPD' AND LENGTH(PD4.SB_LOC_CD(+)) = 2                               
                       AND AL.BKG_ALOC_SEQ = POR.BKG_ALOC_SEQ(+) AND POR.SB_LOC_DIV_CD(+) = 'POR' AND LENGTH(POR.SB_LOC_CD(+)) = 5                
                       AND AL.BKG_ALOC_SEQ = POL.BKG_ALOC_SEQ(+) AND POL.SB_LOC_DIV_CD(+) = 'POL' AND LENGTH(POL.SB_LOC_CD(+)) = 5                
                       AND AL.BKG_ALOC_SEQ = POD.BKG_ALOC_SEQ(+) AND POD.SB_LOC_DIV_CD(+) = 'POD' AND LENGTH(POD.SB_LOC_CD(+)) = 5                
                       AND AL.BKG_ALOC_SEQ = DEL.BKG_ALOC_SEQ(+) AND DEL.SB_LOC_DIV_CD(+) = 'DEL' AND LENGTH(DEL.SB_LOC_CD(+)) = 5                
                       AND AL.BKG_ALOC_SEQ = POR2.BKG_ALOC_SEQ(+) AND POR2.SB_LOC_DIV_CD(+) = 'POR' AND LENGTH(POR2.SB_LOC_CD(+)) = 2                
                       AND AL.BKG_ALOC_SEQ = POL2.BKG_ALOC_SEQ(+) AND POL2.SB_LOC_DIV_CD(+) = 'POL' AND LENGTH(POL2.SB_LOC_CD(+)) = 2                
                       AND AL.BKG_ALOC_SEQ = POD2.BKG_ALOC_SEQ(+) AND POD2.SB_LOC_DIV_CD(+) = 'POD' AND LENGTH(POD2.SB_LOC_CD(+)) = 2                
                       AND AL.BKG_ALOC_SEQ = DEL2.BKG_ALOC_SEQ(+) AND DEL2.SB_LOC_DIV_CD(+) = 'DEL' AND LENGTH(DEL2.SB_LOC_CD(+)) = 2         
                       -- [2015.10.23]          
                       AND AL.BKG_ALOC_SEQ = SAY1.BKG_ALOC_SEQ(+) AND SAY1.SB_LOC_DIV_CD(+) = 'SAY'        
                       AND AL.BKG_ALOC_SEQ = SLY1.BKG_ALOC_SEQ(+) AND SLY1.SB_LOC_DIV_CD(+) = 'SLY' AND LENGTH(SLY1.SB_LOC_CD(+)) = 7         
                       AND AL.BKG_ALOC_SEQ = SDY1.BKG_ALOC_SEQ(+) AND SDY1.SB_LOC_DIV_CD(+) = 'SDY' AND LENGTH(SDY1.SB_LOC_CD(+)) = 7         
                       AND AL.BKG_ALOC_SEQ = A.BKG_ALOC_SEQ(+) AND A.BKG_CUST_TP_CD(+) = 'B'                 
                       AND AL.BKG_ALOC_SEQ = TP.BKG_ALOC_SEQ(+)                
                       AND AL.BKG_ALOC_SEQ = CMDT.BKG_ALOC_SEQ(+)         
                    ) AS LST_SB_RSN, v_user_info CRE_USR_ID, SYSDATE CRE_DT, v_user_info UPD_USR_ID, SYSDATE UPD_DT, v_mst_f_seq BKG_ALOC_SEQ, v_modi_seq MODI_SEQ  
                    , v_mst_f_rs LST_SB_OTR_RSN, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NVL(v_mst_f_rlst,a_mst_f_rlst) BKG_CTRL_TP_CD,'N'           
		FROM DUAL   
                WHERE (v_mst_f_rlst = 'S' OR  a_mst_f_rlst = 'A')            
                
                ;                
         
            ELSE    
                -- REASON 정보 존재하면 업데이트          
                IF (v_is_standby = 'Y') THEN                   
                    UPDATE SPC_SB_BKG            
                       SET CFM_USR_ID   ='SPC_SYSTEM'            
                         , CFM_DT       = SYSDATE             
                         , UPD_USR_ID   = v_user_info          
                         , UPD_DT       = SYSDATE              
                     WHERE BKG_NO       = v_appl_info ;            
                                
                    UPDATE SPC_SB_BKG_DTL           
                       SET DELT_FLG         = 'Y'          
                         , UPD_USR_ID       = v_user_info          
                         , UPD_DT           = SYSDATE          
                     WHERE BKG_NO           = v_appl_info         
                       AND BKG_CTRL_TP_CD   = 'S';    
                END IF;       
                  
                -- REASON 정보 존재하면 삭제         
                IF (v_is_attention = 'Y') THEN                 
                    DELETE FROM SPC_SB_BKG_DTL WHERE BKG_NO = v_appl_info AND BKG_CTRL_TP_CD   = 'A';         
                END IF;   
              
            END IF;    
              
            COMMIT;  
            enis_log_prc(SYSDATE, v_prc_nm, v_step || ': '|| NVL(v_mst_f_rlst,'N'), v_appl_info);             
        END IF;   
          
    END IF;                
                    
                    
    FOR bkg_list IN apply_bkg_cursor LOOP                
    BEGIN                
                    
        v_appl_info := bkg_list.bkg_no;                
        v_init_cmpb := bkg_list.CMPB;                
        v_sb_ck_rlst       := 'N';                
        a_sb_ck_rlst       := 'N';                
        v_old_lst_sb_rsn_tp_cd := NULL;                
                
        v_mst_smp_flg      := 'N';                
        v_mst_smp_season   := NULL;   
        v_bkg_ctrl_lane_flg := 'N';
                
        v_smp_must_flg := NULL;                
        v_smp_fcst_flg := NULL;                
                
                
        v_aloc_must_flg := NULL;                
        v_aloc_fcst_flg := NULL;  
        v_mst_raply_cnt    := 0;  
        v_smp_raply_cnt    := 0;                
                
                
        v_smp_lf_cnt := 0;                
        v_aloc_lf_cnt := 0;                
        v_almighty_cnt := 0;                
        v_modi_seq := NULL; --**                
                
        --Almighty 기능 추가 (전체 텝 해당)                
        v_step := '0. Almighty';                
        enis_log_prc(SYSDATE, v_prc_nm, v_step || ' START', v_appl_info);                
             
       WITH MASTER AS (        
                 SELECT MT.BKG_ALOC_SEQ        
                      , MT.BKG_ALOC_TP_CD        
                      , MT.TRNK_SLAN_CD        
                      , MT.TRNK_DIR_CD        
                      , MT.OB_SLS_OFC_CD        
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POR' AND LENGTH(LD.SB_LOC_CD) = 2 ) POR_CNT_CD        
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POR' AND LENGTH(LD.SB_LOC_CD) = 5 ) POR_CD        
                      , MT.POR_NOD_CD        
                      , MT.BKG_POR_SCC_CD        
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POL' AND LENGTH(LD.SB_LOC_CD) = 2 ) POL_CNT_CD        
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POL' AND LENGTH(LD.SB_LOC_CD) = 5 ) POL_CD        
                      , MT.POL_NOD_CD        
                      , CASE WHEN (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SAY' ) IS NOT NULL        
                             THEN NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SAY' AND LENGTH(LD.SB_LOC_CD) = 5 ), 'XXXXXXXX')         
                             ELSE NULL END AS TS_ALL_LOC_CD                              
                      , CASE WHEN (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SAY' ) IS NOT NULL        
                             THEN NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SAY' AND LENGTH(LD.SB_LOC_CD) = 7 ), 'XXXXXXXX')         
                             ELSE NULL END AS TS_ALL_NOD_CD         
                      , MT.N1ST_TS_SLAN_CD        
                      , MT.N1ST_TS_DIR_CD        
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SPL' AND LENGTH(LD.SB_LOC_CD) = 2) N1ST_TS_POL_CNT_CD                
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SPL' AND LENGTH(LD.SB_LOC_CD) = 5) N1ST_TS_POL_CD          
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SLY' ) TS_POL_NOD_CD            
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SPD' AND LENGTH(LD.SB_LOC_CD) = 2) N1ST_TS_POD_CNT_CD          
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SPD' AND LENGTH(LD.SB_LOC_CD) = 5) N1ST_TS_POD_CD         
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SDY') TS_POD_NOD_CD         
                                 
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POD' AND LENGTH(LD.SB_LOC_CD) = 2) POD_CNT_CD        
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POD' AND LENGTH(LD.SB_LOC_CD) = 5) POD_CD                
                      , MT.POD_NOD_CD                
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(LD.SB_LOC_CD) = 2) DEL_CNT_CD         
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(LD.SB_LOC_CD) = 5) DEL_CD          
                      , MT.DEL_NOD_CD        
                      , MT.BKG_DEL_SCC_CD        
                      , MT.SC_NO        
                      , MT.RFA_NO        
                      , MT.CTRT_CUST_CNT_CD        
                      , MT.CTRT_CUST_SEQ        
                      , MT.CUST_CNT_CD , MT.CUST_GRP_ID, MT.RFA_CTRT_TP_CD       
                      , MT.CUST_SEQ        
                      , (SELECT WM_CONCAT(LD.CNTR_TPSZ_CD) FROM SPC_BKG_ALOC_MGMT_TP_SZ_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ ) CNTR_TPSZ_CD        
                      , (SELECT WM_CONCAT(CMDT.CMDT_CD) FROM SPC_BKG_ALOC_MGMT_CMDT_DTL CMDT WHERE CMDT.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ ) CMDT_CD        
                      , MT.ALOC_LOD_QTY        
                      , MT.ALOC_LOD_QTY_RTO        
                      , MT.VSL_CD        
                      , MT.SKD_VOY_NO        
                      , MT.SKD_DIR_CD        
                      , MT.SLS_RHQ_CD        
                      , MT.SCG_GRP_CMDT_SEQ        
                      , MT.CMPB_AMT        
                      , MT.BKG_CTRL_TP_CD        
                      , MT.DCGO_FLG        
                      , MT.RD_CGO_FLG        
                      , MT.CRE_USR_ID        
                      , MT.CRE_DT        
                      , MT.UPD_USR_ID        
                      , MT.UPD_DT        
                      , MT.ALOC_APLY_FM_DT        
                      , MT.ALOC_APLY_TO_DT        
                      , MT.SUB_TRD_CD        
                      , MT.OFT_CHG_AMT      
                      , MT.USA_BKG_MOD_CD        
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'TPL' AND LENGTH(LD.SB_LOC_CD) = 5) TRNK_POL_CD                
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'TPD' AND LENGTH(LD.SB_LOC_CD) = 5) TRNK_POD_CD                  
                      , (SELECT WM_CONCAT(AD.CUST_CNT_CD || LPAD(AD.CUST_SEQ, 6, '0')) FROM SPC_BKG_ALOC_MGMT_CUST_DTL AD WHERE AD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND AD.BKG_CUST_TP_CD = 'B') ACT_CNT_CD          
                      , L.HUL_BND_CD         
                      , bkg_list.sls_wk SLS_WK        
                      , L.DIR_CD HUL_DIR_CD        
                      , ASGN_TTL_WGT        
                      , ASGN_WGT_RTO        
                      , CMPB_ONY_FLG        
                      , RVIS_CNTR_CUST_TP_CD        
                      , OP_CNTR_QTY AS CNTR_QTY        
                      , MT.BKG_ALOC_RMK        
                      , MT.CMPB_PER_TON_AMT       
                      , MT.TON_PER_TEU_WGT       
                   FROM SPC_BKG_ALOC_MGMT MT        
                      , MAS_LANE_RGST L        
                  WHERE MT.BKG_ALOC_TP_CD = 'A'        
                    AND (MT.ALOC_USE_FLG IS NULL OR MT.ALOC_USE_FLG   = 'Y')        
                    AND bkg_list.sls_wk BETWEEN NVL(MT.APLY_FM_YRWK, '201501') AND NVL(MT.APLY_TO_YRWK, '209953') -- Week 기준 추가        
                    AND MT.SLS_RHQ_CD   = bkg_list.rhq_cd --필수값        
                    AND MT.SUB_TRD_CD   = bkg_list.sub_trd_cd --필수값        
                    AND L.RLANE_CD      = bkg_list.rlane_cd        
                    AND L.TRD_CD        = bkg_list.trd_cd        
                    AND L.IOC_CD        = bkg_list.ioc_cd        
                    AND (MT.TRNK_SLAN_CD = bkg_list.SLAN_CD OR MT.TRNK_SLAN_CD IS NULL)       
                    AND (MT.OB_SLS_OFC_CD = bkg_list.OB_SLS_OFC_CD OR MT.OB_SLS_OFC_CD IS NULL)       
                    AND (MT.CTRT_CUST_CNT_CD = bkg_list.CTRT_CUST_CNT_CD OR MT.CTRT_CUST_CNT_CD IS NULL)       
                    AND (MT.CTRT_CUST_SEQ = bkg_list.CTRT_CUST_SEQ OR MT.CTRT_CUST_SEQ IS NULL)       
                    AND (MT.SC_NO = bkg_list.SC_NO OR MT.SC_NO IS NULL)       
                    AND (MT.RFA_NO = bkg_list.RFA_NO OR MT.RFA_NO IS NULL)       
                    AND (MT.DCGO_FLG = bkg_list.DCGO_FLG OR MT.DCGO_FLG IS NULL)       
                    AND (MT.RD_CGO_FLG = bkg_list.RD_CGO_FLG OR MT.RD_CGO_FLG IS NULL)       
                    AND (MT.VSL_CD = bkg_list.VSL_CD OR MT.VSL_CD IS NULL)       
                    AND (MT.SKD_VOY_NO = bkg_list.SKD_VOY_NO OR MT.SKD_VOY_NO IS NULL)       
                    AND (MT.SKD_DIR_CD = bkg_list.DIR_CD OR MT.SKD_DIR_CD IS NULL)       
                    AND (L.HUL_BND_CD = bkg_list.HUL_BND_CD OR L.HUL_BND_CD IS NULL)       
                    AND (MT.RFA_CTRT_TP_CD = bkg_list.RFA_CTRT_TP_CD OR MT.RFA_CTRT_TP_CD IS NULL)       
                    AND NVL(MT.HUL_BND_CD, 'XX')  = CASE WHEN MT.HUL_BND_CD IS NOT NULL  THEN L.HUL_BND_CD ELSE 'XX' END        
                    AND NVL(MT.TRNK_DIR_CD, '#@') = CASE WHEN MT.TRNK_DIR_CD IS NOT NULL THEN L.DIR_CD     ELSE '#@' END        
                    AND L.DELT_FLG = 'N'         
                )        
                , BKG AS (        
            SELECT  T.*        
                , ROUND(CMPB_AMT/WGT,2)  AS CMPB_PER_TON_AMT        
                , ROUND(WGT/BKG_LOD_QTY,2)  AS TON_PER_TEU_WGT        
            FROM (          
                 SELECT MB.BKG_NO        
                      , MB.SLAN_CD        
                      , MB.OB_SLS_OFC_CD        
                      , MB.POR_CD        
                      , MB.POR_NOD_CD        
                      , (SELECT SL.SCC_CD FROM MAS_LOCATION_V SL WHERE SL.LOC_CD = MB.POR_CD ) BKG_POR_SCC_CD        
                      , MB.POL_CD        
                      , MB.POL_NOD_CD        
                      , MB.TRNK_POL_CD        
                      , MB.TRNK_POD_CD        
                      , MB.TRNK_SLAN_CD        
                      , MB.TRNK_DIR_CD        
                      , MB.SLS_WK        
                      , MB.POD_CD        
                      , MB.POD_NOD_CD        
                      , MB.DEL_CD        
                      , MB.DEL_NOD_CD        
                      , (SELECT SL.SCC_CD FROM MAS_LOCATION_V SL WHERE SL.LOC_CD = MB.DEL_CD ) BKG_DEL_SCC_CD        
                      , MB.SC_NO        
                      , MB.RFA_NO        
                      , MB.CTRT_CUST_CNT_CD        
                      , MB.CTRT_CUST_SEQ        
                      , MB.CTRT_CUST_CODE        
                      , MB.CUST_CNT_CD , MB.CUST_GRP_ID , MB.RFA_CTRT_TP_CD       
                      , MB.CUST_SEQ        
                      , MB.CUST_CODE        
                      , (SELECT WM_CONCAT(Q.CNTR_TPSZ_CD) FROM BKG_QUANTITY Q WHERE Q.BKG_NO = MB.BKG_NO ) CNTR_TPSZ_CD        
                      , (SELECT SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', 1, 2) * Q.OP_CNTR_QTY) FROM BKG_QUANTITY Q WHERE Q.BKG_NO = MB.BKG_NO ) AS BKG_LOD_QTY --TEU(Load)        
                      , MB.CMDT_CD        
                      , MB.VSL_CD        
                      , MB.SKD_VOY_NO        
                      , MB.DIR_CD        
                      , (SELECT C.GRP_CMDT_CD FROM MDM_COMMODITY C WHERE C.CMDT_CD = MB.CMDT_CD ) SCG_GRP_CMDT_SEQ        
                      , SUBSTR(MB.POR_CD, 0, 2) BKG_POR_CNT_CD        
                      , SUBSTR(MB.POL_CD, 0, 2) BKG_POL_CNT_CD        
                      , SUBSTR(MB.POD_CD, 0, 2) BKG_POD_CNT_CD        
                      , SUBSTR(MB.DEL_CD, 0, 2) BKG_DEL_CNT_CD        
                      , (SELECT SPC_GET_CMPB_FNC(MB.BKG_NO, NULL) FROM DUAL) AS CMPB_AMT     
                      , MB.DCGO_FLG        
                      , MB.RD_CGO_FLG        
                      , MB.AGMT_ACT_CNT_CD        
                      , MB.AGMT_ACT_CUST_SEQ        
                      , MB.AGMT_ACT_CUST_CODE        
					  , NVL( (SELECT SUM(R.CHG_UT_AMT) FROM BKG_CHG_RT R WHERE R.BKG_NO = MB.BKG_NO AND R.CHG_CD = 'OFT')       
					 	    ,(SELECT MIN(OFT_AMT) KEEP (DENSE_RANK LAST ORDER BY A.REV_COST_SEQ) FROM BKG_REV_COST A WHERE A.BKG_NO = MB.BKG_NO)) AS OFT_CHG_AMT           
                      , MB.USA_BKG_MOD_CD        
                      , MAX(DECODE(SLAN_RK, 1, MB.TS_SLAN_CD))  AS TS_SLAN_CD1        
                      , MAX(DECODE(SLAN_RK, 1, MB.TS_DIR))      AS TS_DIR1        
                      , MAX(DECODE(SLAN_RK, 1, MB.TS_VVD))      AS TS_VVD1        
                      , MAX(DECODE(SLAN_RK, 2, MB.TS_SLAN_CD))  AS TS_SLAN_CD2        
                      , MAX(DECODE(SLAN_RK, 2, MB.TS_DIR))      AS TS_DIR2        
                      , MAX(DECODE(SLAN_RK, 2, MB.TS_VVD))      AS TS_VVD2        
                      , MAX(DECODE(SLAN_RK, 3, MB.TS_SLAN_CD))  AS TS_SLAN_CD3        
                      , MAX(DECODE(SLAN_RK, 3, MB.TS_DIR))      AS TS_DIR3        
                      , MAX(DECODE(SLAN_RK, 3, MB.TS_VVD))      AS TS_VVD3        
                      , MAX(DECODE(RK, 1, NULL))                AS TS_POL_CNT_CD1        
                      , MAX(DECODE(RK, 1, NULL))                AS TS_POL_CD1        
                      , MAX(DECODE(RK, 1, NULL))                AS TS_POL_NOD_CD1        
                      , MAX(DECODE(RK, 1, TS_POD_CNT_CD))       AS TS_POD_CNT_CD1        
                      , MAX(DECODE(RK, 1, TS_POD_CD))           AS TS_POD_CD1        
                      , MAX(DECODE(RK, 1, TS_POD_YD_CD))        AS TS_POD_NOD_CD1        
                      , MAX(DECODE(RK, 2, TS_POL_CNT_CD))       AS TS_POL_CNT_CD2        
                      , MAX(DECODE(RK, 2, TS_POL_CD))           AS TS_POL_CD2        
                      , MAX(DECODE(RK, 2, TS_POL_YD_CD))        AS TS_POL_NOD_CD2        
                      , DECODE(MAX(RK), 2, NULL, MAX(DECODE(RK, 2, TS_POD_CNT_CD)))       AS TS_POD_CNT_CD2        
                      , DECODE(MAX(RK), 2, NULL, MAX(DECODE(RK, 2, TS_POD_CD)))           AS TS_POD_CD2        
                      , DECODE(MAX(RK), 2, NULL, MAX(DECODE(RK, 2, TS_POD_YD_CD)))        AS TS_POD_NOD_CD2        
                      , MAX(DECODE(RK, 3, TS_POL_CNT_CD))       AS TS_POL_CNT_CD3        
                      , MAX(DECODE(RK, 3, TS_POL_CD))           AS TS_POL_CD3        
                      , MAX(DECODE(RK, 3, TS_POL_YD_CD))        AS TS_POL_NOD_CD3        
                      , DECODE(MAX(RK), 3, NULL, MAX(DECODE(RK, 3, TS_POD_CNT_CD)))      AS TS_POD_CNT_CD3        
                      , DECODE(MAX(RK), 3, NULL, MAX(DECODE(RK, 3, TS_POD_CD)))          AS TS_POD_CD3        
                      , DECODE(MAX(RK), 3, NULL, MAX(DECODE(RK, 3, TS_POD_YD_CD)))       AS TS_POD_NOD_CD3        
                      , MB.SLS_RHQ_CD        
                      , MB.RGN_OFC_CD        
                      , bkg_list.sub_trd_cd SUB_TRD_CD        
                      , MB.ALOC_STS_CD        
                      , MB.HUL_BND_CD        
                      , (SELECT SUM((D.ACT_WGT * DECODE(D.WGT_UT_CD, 'LBS', 0.00045, 0.001)) + SUM(Q.OP_CNTR_QTY *        
                                (SELECT TS.CNTR_TPSZ_TARE_WGT FROM MDM_CNTR_TP_SZ TS WHERE TS.CNTR_TPSZ_CD = Q.CNTR_TPSZ_CD )) * 0.001 ) WGT_TTL        
                           FROM BKG_QUANTITY Q        
                              , BKG_BL_DOC D        
                          WHERE MB.BKG_NO     = Q.BKG_NO        
                            AND MB.BKG_NO     = D.BKG_NO        
                            AND Q.OP_CNTR_QTY > 0        
                          GROUP BY D.ACT_WGT * DECODE(D.WGT_UT_CD, 'LBS', 0.00045, 0.001) ) WGT        
                      , (SELECT RVIS_CNTR_CUST_TP_CD FROM MDM_CUSTOMER M        
                          WHERE MB.CTRT_CUST_CNT_CD = M.CUST_CNT_CD AND MB.CTRT_CUST_SEQ    = M.CUST_SEQ ) AS RVIS_CNTR_CUST_TP_CD        
                      , (SELECT SUM(Q.OP_CNTR_QTY) FROM BKG_QUANTITY Q WHERE Q.BKG_NO = MB.BKG_NO ) AS CNTR_QTY        
                   FROM (        
                         SELECT B.BKG_NO        
                              , B.SLAN_CD        
                              , B.OB_SLS_OFC_CD        
                              , B.POR_CD        
                              , B.POR_NOD_CD        
                              , B.POL_CD        
                              , B.POL_NOD_CD        
                              , TV.POL_CD TRNK_POL_CD        
                              , TV.POD_CD TRNK_POD_CD        
                              , TV.SLAN_CD TRNK_SLAN_CD        
                              , TV.SKD_DIR_CD TRNK_DIR_CD        
                              , V.SLS_WK        
                              , B.POD_CD        
                              , B.POD_NOD_CD        
                              , B.DEL_CD        
                              , B.DEL_NOD_CD        
                              , B.SC_NO        
                              , B.RFA_NO        
                              , B.CTRT_CUST_CNT_CD        
                              , B.CTRT_CUST_SEQ        
                              , B.CTRT_CUST_CNT_CD||LPAD(B.CTRT_CUST_SEQ, 6, '0') CTRT_CUST_CODE        
                              , S.CUST_CNT_CD       
                              , S.CUST_SEQ        
                              , S.CUST_CNT_CD||LPAD(S.CUST_SEQ, 6, '0') CUST_CODE        
                              , B.CMDT_CD        
                              , B.VSL_CD        
                              , B.SKD_VOY_NO        
                              , B.SKD_DIR_CD DIR_CD        
                              , SUBSTR(B.POR_CD, 0, 2) BKG_POR_CNT_CD        
                              , SUBSTR(B.POL_CD, 0, 2) BKG_POL_CNT_CD        
                              , SUBSTR(B.POD_CD, 0, 2) BKG_POD_CNT_CD        
                              , SUBSTR(B.DEL_CD, 0, 2) BKG_DEL_CNT_CD        
                              , B.DCGO_FLG        
                              , B.RD_CGO_FLG        
                              , B.AGMT_ACT_CNT_CD        
                              , B.AGMT_ACT_CUST_SEQ        
                              , B.AGMT_ACT_CNT_CD||LPAD(B.AGMT_ACT_CUST_SEQ, 6, '0') AGMT_ACT_CUST_CODE        
                              , CASE WHEN (SUBSTR(B.POR_CD, 1, 2) IN ('CA', 'US') OR SUBSTR(B.DEL_CD, 1, 2) IN ('CA', 'US'))         
                                     THEN (SELECT SPC_USA_MODE_FNC(B.RCV_TERM_CD, B.DE_TERM_CD, B.POR_CD, B.POL_CD, B.POD_CD, B.DEL_CD) FROM DUAL )         
                                     ELSE 'OTH' END AS USA_BKG_MOD_CD        
                              , SV.SLAN_CD TS_SLAN_CD        
                              , SV.VSL_CD||SV.SKD_VOY_NO||SV.SKD_DIR_CD TS_VVD        
                              , SV.SKD_DIR_CD TS_DIR        
                              , DENSE_RANK() OVER ( PARTITION BY SV.BKG_NO ORDER BY SV.VSL_PRE_PST_CD, SV.VSL_SEQ) AS SLAN_RK        
                              , TS.POL_CD TS_POL_CD        
                              , TS.POD_CD TS_POD_CD        
                              , TS.POL_YD_CD TS_POL_YD_CD        
                              , TS.POD_YD_CD TS_POD_YD_CD        
                              , SUBSTR(TS.POL_CD, 1, 2) TS_POL_CNT_CD        
                              , SUBSTR(TS.POD_CD, 1, 2) TS_POD_CNT_CD        
                              , DENSE_RANK() OVER ( PARTITION BY TS.BKG_NO ORDER BY TS.VSL_PRE_PST_CD, TS.VSL_SEQ) AS RK        
                              , O.N2ND_PRNT_OFC_CD SLS_RHQ_CD        
                              , O.N4TH_PRNT_OFC_CD RGN_OFC_CD        
                              , NVL(B.ALOC_STS_CD, 'X') ALOC_STS_CD        
                              , V.HUL_BND_CD        
							  ,(SELECT  CUST_GRP_ID FROM MDM_CUSTOMER C WHERE B.CTRT_CUST_CNT_CD = C.CUST_CNT_CD AND B.CTRT_CUST_SEQ = C.CUST_SEQ) AS CUST_GRP_ID       
                              ,(SELECT MIN(RFA_CTRT_TP_CD) KEEP (DENSE_RANK LAST ORDER BY AMDT_SEQ) FROM PRI_RP_HDR A,PRI_RP_MN B WHERE A.PROP_NO= B.PROP_NO AND PROP_STS_CD = 'A' AND A.RFA_NO= B.RFA_NO) AS RFA_CTRT_TP_CD       
                           FROM (        
                                 SELECT V1.TRD_CD        
                                      , V1.RLANE_CD        
                                      , SUBSTR(V1.RLANE_CD, 1, 3) SLAN_CD        
                                      , V1.IOC_CD        
                                      , V1.VSL_CD        
                                      , V1.SKD_VOY_NO        
                                      , V1.DIR_CD        
                                      , V1.SUB_TRD_CD        
                                      , M.HUL_BND_CD        
                                      , M.SLS_WK        
                                   FROM MAS_MON_VVD V1        
                                      , (SELECT DISTINCT SLS_WK, SUB_TRD_CD, HUL_BND_CD, HUL_DIR_CD FROM MASTER ) M        
                                  WHERE SUBSTR(V1.SLS_YRMON, 1, 4) || V1.COST_WK = M.SLS_WK        
                                    AND V1.SUB_TRD_CD   = M.SUB_TRD_CD        
                                    AND V1.DIR_CD       = M.HUL_DIR_CD        
                                    AND V1.DELT_FLG     = 'N') V        
                              , BKG_BOOKING B        
                              , BKG_VVD TV        
                              , BKG_VVD SV        
                              , BKG_VVD TS        
                              , BKG_CUSTOMER S        
                              , SPC_OFC_LVL O        
                          WHERE 1 = 1 --주차별 Sub Trade/BD별 SUM        
                            AND B.VSL_CD                 = V.VSL_CD        
                            AND B.SKD_VOY_NO             = V.SKD_VOY_NO        
                            AND B.SKD_DIR_CD             = V.DIR_CD        
                            AND B.SLAN_CD                = V.SLAN_CD        
                            AND B.BKG_STS_CD            IN ('W', 'F')        
                            AND B.BKG_CGO_TP_CD         IN ('F', 'R')        
                            AND (NVL(B.ALOC_STS_CD, 'X') = 'F'        
                             OR B.BKG_NO                 = v_appl_info)        
                            AND B.BKG_NO                 = TV.BKG_NO        
                            AND TV.VSL_PRE_PST_CD        = 'T'        
                            AND B.BKG_NO                 = SV.BKG_NO(+)        
                            AND SV.VSL_PRE_PST_CD(+)    <> 'T'        
                            AND B.BKG_NO                 = S.BKG_NO        
                            AND B.BKG_NO                 = TS.BKG_NO        
                            AND S.BKG_CUST_TP_CD         = 'S'        
                            AND bkg_list.sls_wk BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK        
                            AND O.OFC_CD = SPC_SCR_OFC_CONV_FNC(B.OB_SLS_OFC_CD, '')        
                            AND bkg_list.rhq_cd = O.N2ND_PRNT_OFC_CD        
                        ) MB        
                GROUP BY MB.BKG_NO        
                      , MB.SLAN_CD        
                      , MB.OB_SLS_OFC_CD        
                      , MB.POR_CD        
                      , MB.POR_NOD_CD        
                      , MB.POL_CD        
                      , MB.POL_NOD_CD        
                      , MB.TRNK_POL_CD        
                      , MB.TRNK_POD_CD        
                      , MB.TRNK_SLAN_CD        
                      , MB.TRNK_DIR_CD        
                      , MB.SLS_WK        
                      , MB.POD_CD        
                      , MB.POD_NOD_CD        
                      , MB.DEL_CD        
                      , MB.DEL_NOD_CD        
                      , MB.SC_NO        
                      , MB.RFA_NO        
                      , MB.CTRT_CUST_CNT_CD        
                      , MB.CTRT_CUST_SEQ        
                      , MB.CTRT_CUST_CODE        
                      , MB.CUST_CNT_CD ,MB.CUST_GRP_ID, MB.RFA_CTRT_TP_CD       
                      , MB.CUST_SEQ        
                      , MB.CUST_CODE        
                      , MB.CMDT_CD        
                      , MB.VSL_CD        
                      , MB.SKD_VOY_NO        
                      , MB.DIR_CD        
                      , MB.DCGO_FLG        
                      , MB.RD_CGO_FLG        
                      , MB.AGMT_ACT_CNT_CD        
                      , MB.AGMT_ACT_CUST_SEQ        
                      , MB.AGMT_ACT_CUST_CODE        
                      , MB.USA_BKG_MOD_CD        
                      , MB.SLS_RHQ_CD        
                      , MB.RGN_OFC_CD        
                      , MB.ALOC_STS_CD        
                      , MB.HUL_BND_CD         
                    ) T       
                )        
                , G_SUM AS(        
                        SELECT *        
                          FROM (        
                                 SELECT M.BKG_ALOC_SEQ        
                                      , M.BKG_CTRL_TP_CD        
                                      , NVL(M.ALOC_LOD_QTY, 0) ALOC_LOD_QTY        
                                      , DECODE(NVL(M.ALOC_LOD_QTY, 0), 0, 0, NVL(M.ALOC_LOD_QTY_RTO, 100)) ALOC_LOD_QTY_RTO --ratio가 없으면 물량의 100%        
                                      , DECODE(NVL(M.CNTR_QTY, 0), 0, 0, NVL(M.ALOC_LOD_QTY_RTO, 100)) ALOC_LOD_QTY_BOX_RTO --ratio가 없으면 물량의 100%        
                                      , NVL(M.CMPB_AMT, 0) CMPB_AMT        
                                      , SUM(DECODE(T.BKG_NO, v_appl_info, 0, T.BKG_LOD_QTY)) F_TTL_QTY --전체 Confirm 갯수        
                                      , SUM(DECODE(T.BKG_NO, v_appl_info, BKG.BKG_LOD_QTY, 0)) BKG_QTY --현재 BKG의 갯수 v_appl_info        
                                      , SUM(T.BKG_LOD_QTY) TTL_QTY        
                                      , SUM(T.WGT) TTL_WGT        
                                      , NVL(M.ASGN_TTL_WGT, 0) ASGN_TTL_WGT        
                                      , DECODE(NVL(M.ASGN_TTL_WGT, 0), 0, 0, NVL(M.ASGN_WGT_RTO, 100)) ASGN_WGT_RTO --ratio가 없으면 물량의 100%        
                                      , CMPB_ONY_FLG        
                                      , NVL(M.CNTR_QTY, 0) CNTR_QTY        
                                      , SUM(T.CNTR_QTY) TTL_CNTR_QTY        
                                      , (SELECT NVL( MAX(MODI_SEQ), 1) FROM SPC_BKG_ALOC_MGMT_HIS WHERE BKG_ALOC_SEQ = M.BKG_ALOC_SEQ ) MODI_SEQ --** master 인경우만 BKG_ALOC_SEQ와 MODI_SEQ 값 저장.        
                                      , MAX(DECODE(T.BKG_NO, BKG.BKG_NO, 'Y')) SB_BKG_YN        
                                   FROM (SELECT * FROM BKG WHERE BKG_NO = v_appl_info) BKG        
                                      , BKG T        
                                      , MASTER M        
                                  WHERE M.SLS_RHQ_CD = BKG.SLS_RHQ_CD --필수값                
                                    AND M.SUB_TRD_CD = BKG.SUB_TRD_CD --필수값           
                                    AND M.SLS_RHQ_CD = T.SLS_RHQ_CD --필수값                
                                    AND M.SUB_TRD_CD = T.SUB_TRD_CD --필수값                
                                    AND NVL(M.HUL_BND_CD, '#@') = NVL(T.HUL_BND_CD,'#@') --필수값            
                                    AND NVL(M.RVIS_CNTR_CUST_TP_CD  ,  NVL(T.RVIS_CNTR_CUST_TP_CD,'#@')    ) = NVL(T.RVIS_CNTR_CUST_TP_CD,'#@')               
                                    AND NVL(M.TRNK_SLAN_CD       ,  NVL(T.TRNK_SLAN_CD,'#@')    ) = NVL(T.TRNK_SLAN_CD,'#@')                
                                    AND NVL(M.TRNK_POL_CD        ,  NVL(T.TRNK_POL_CD,'#@')     ) LIKE '%'||NVL(T.TRNK_POL_CD,'#@')||'%'                
                                    AND NVL(M.TRNK_POD_CD        ,  NVL(T.TRNK_POD_CD,'#@')     ) LIKE '%'||NVL(T.TRNK_POD_CD,'#@')||'%'                
                                    AND NVL(M.OB_SLS_OFC_CD      ,  NVL(T.OB_SLS_OFC_CD,'#@')   ) = NVL(T.OB_SLS_OFC_CD,'#@')                
                                    AND NVL(M.POR_CD             ,  NVL(T.POR_CD,'#@')) LIKE '%'||NVL(T.POR_CD,'#@')||'%'                
                                    AND NVL(M.POR_NOD_CD         ,  NVL(T.POR_NOD_CD,'#@')      ) = NVL(T.POR_NOD_CD,'#@')                
                                    AND NVL(M.BKG_POR_SCC_CD     ,  NVL(T.BKG_POR_SCC_CD,'#@')  ) = NVL(T.BKG_POR_SCC_CD,'#@')                
                                    AND NVL(M.POL_CD             ,  NVL(T.POL_CD,'#@')) LIKE '%'||NVL(T.POL_CD,'#@')||'%'                
                                    AND NVL(M.POL_NOD_CD         ,  NVL(T.POL_NOD_CD,'#@')      ) = NVL(T.POL_NOD_CD,'#@')                
                                    -- TS조건 체크 - START               
                                    AND (NVL(M.N1ST_TS_SLAN_CD    , NVL(T.TS_SLAN_CD1, '#@') ) = NVL(T.TS_SLAN_CD1, '#@') OR                
                                         NVL(M.N1ST_TS_SLAN_CD    , NVL(T.TS_SLAN_CD2, '#@') ) = NVL(T.TS_SLAN_CD2, '#@') OR                
                                         NVL(M.N1ST_TS_SLAN_CD    , NVL(T.TS_SLAN_CD3, '#@') ) = NVL(T.TS_SLAN_CD3, '#@'))          
                                    AND (NVL(M.N1ST_TS_DIR_CD    , NVL(T.TS_DIR1, '#@') ) = NVL(T.TS_DIR1, '#@') OR                
                                         NVL(M.N1ST_TS_DIR_CD    , NVL(T.TS_DIR2, '#@') ) = NVL(T.TS_DIR2, '#@') OR                
                                         NVL(M.N1ST_TS_DIR_CD    , NVL(T.TS_DIR3, '#@') ) = NVL(T.TS_DIR3, '#@'))               
                                    AND (NVL(M.N1ST_TS_POL_CD    , NVL(T.TS_POL_CD1, '#@')) LIKE '%'||NVL(T.TS_POL_CD1, '#@')||'%' OR                
                                         NVL(M.N1ST_TS_POL_CD    , NVL(T.TS_POL_CD2, '#@')) LIKE '%'||NVL(T.TS_POL_CD2, '#@')||'%' OR                
                                         NVL(M.N1ST_TS_POL_CD    , NVL(T.TS_POL_CD3, '#@')) LIKE '%'||NVL(T.TS_POL_CD3, '#@')||'%')                
                                    AND (NVL(M.N1ST_TS_POD_CD    , NVL(T.TS_POD_CD1, '#@')) LIKE '%'||NVL(T.TS_POD_CD1, '#@')||'%' OR                
                                         NVL(M.N1ST_TS_POD_CD    , NVL(T.TS_POD_CD2, '#@')) LIKE '%'||NVL(T.TS_POD_CD2, '#@')||'%' OR                
                                         NVL(M.N1ST_TS_POD_CD    , NVL(T.TS_POD_CD3, '#@')) LIKE '%'||NVL(T.TS_POD_CD3, '#@')||'%')                
                                    AND (NVL(M.N1ST_TS_POL_CNT_CD    , NVL(T.TS_POL_CNT_CD1, '#@')) LIKE '%'||NVL(T.TS_POL_CNT_CD1, '#@')||'%' OR                
                                         NVL(M.N1ST_TS_POL_CNT_CD    , NVL(T.TS_POL_CNT_CD2, '#@')) LIKE '%'||NVL(T.TS_POL_CNT_CD2, '#@')||'%' OR                
                                         NVL(M.N1ST_TS_POL_CNT_CD    , NVL(T.TS_POL_CNT_CD3, '#@')) LIKE '%'||NVL(T.TS_POL_CNT_CD3, '#@')||'%')                
                                    AND (NVL(M.N1ST_TS_POD_CNT_CD    , NVL(T.TS_POD_CNT_CD1, '#@')) LIKE '%'||NVL(T.TS_POD_CNT_CD1, '#@')||'%' OR                
                                         NVL(M.N1ST_TS_POD_CNT_CD    , NVL(T.TS_POD_CNT_CD2, '#@')) LIKE '%'||NVL(T.TS_POD_CNT_CD2, '#@')||'%' OR                
                                         NVL(M.N1ST_TS_POD_CNT_CD    , NVL(T.TS_POD_CNT_CD3, '#@')) LIKE '%'||NVL(T.TS_POD_CNT_CD3, '#@')||'%')                   
                                               
                                    AND (NVL(M.TS_ALL_LOC_CD    , NVL(T.TS_POL_CD1, '#@')) LIKE '%'||NVL(T.TS_POL_CD1, '#@')||'%' OR                
                                         NVL(M.TS_ALL_LOC_CD    , NVL(T.TS_POL_CD2, '#@')) LIKE '%'||NVL(T.TS_POL_CD2, '#@')||'%' OR                
                                         NVL(M.TS_ALL_LOC_CD    , NVL(T.TS_POL_CD3, '#@')) LIKE '%'||NVL(T.TS_POL_CD3, '#@')||'%' OR        
                                         NVL(M.TS_ALL_LOC_CD    , NVL(T.TS_POD_CD1, '#@')) LIKE '%'||NVL(T.TS_POD_CD1, '#@')||'%' OR                
                                         NVL(M.TS_ALL_LOC_CD    , NVL(T.TS_POD_CD2, '#@')) LIKE '%'||NVL(T.TS_POD_CD2, '#@')||'%' OR                
                                         NVL(M.TS_ALL_LOC_CD    , NVL(T.TS_POD_CD3, '#@')) LIKE '%'||NVL(T.TS_POD_CD3, '#@')||'%' OR         
                                         NVL(M.TS_ALL_NOD_CD    , NVL(T.TS_POL_NOD_CD1, '#@')) LIKE '%'||NVL(T.TS_POL_NOD_CD1, '#@')||'%' OR                
                                         NVL(M.TS_ALL_NOD_CD    , NVL(T.TS_POL_NOD_CD2, '#@')) LIKE '%'||NVL(T.TS_POL_NOD_CD2, '#@')||'%' OR                
                                         NVL(M.TS_ALL_NOD_CD    , NVL(T.TS_POL_NOD_CD3, '#@')) LIKE '%'||NVL(T.TS_POL_NOD_CD3, '#@')||'%' OR              
                                         NVL(M.TS_ALL_NOD_CD    , NVL(T.TS_POD_NOD_CD1, '#@')) LIKE '%'||NVL(T.TS_POD_NOD_CD1, '#@')||'%' OR                
                                         NVL(M.TS_ALL_NOD_CD    , NVL(T.TS_POD_NOD_CD2, '#@')) LIKE '%'||NVL(T.TS_POD_NOD_CD2, '#@')||'%' OR                
                                         NVL(M.TS_ALL_NOD_CD    , NVL(T.TS_POD_NOD_CD3, '#@')) LIKE '%'||NVL(T.TS_POD_NOD_CD3, '#@')||'%')         
                                                      
                                    AND (NVL(M.TS_POL_NOD_CD    , NVL(T.TS_POL_NOD_CD1, '#@')) LIKE '%'||NVL(T.TS_POL_NOD_CD1, '#@')||'%' OR                
                                         NVL(M.TS_POL_NOD_CD    , NVL(T.TS_POL_NOD_CD2, '#@')) LIKE '%'||NVL(T.TS_POL_NOD_CD2, '#@')||'%' OR                
                                         NVL(M.TS_POL_NOD_CD    , NVL(T.TS_POL_NOD_CD3, '#@')) LIKE '%'||NVL(T.TS_POL_NOD_CD3, '#@')||'%')             
                                                       
                                    AND (NVL(M.TS_POD_NOD_CD    , NVL(T.TS_POD_NOD_CD1, '#@')) LIKE '%'||NVL(T.TS_POD_NOD_CD1, '#@')||'%' OR                
                                         NVL(M.TS_POD_NOD_CD    , NVL(T.TS_POD_NOD_CD2, '#@')) LIKE '%'||NVL(T.TS_POD_NOD_CD2, '#@')||'%' OR                
                                         NVL(M.TS_POD_NOD_CD    , NVL(T.TS_POD_NOD_CD3, '#@')) LIKE '%'||NVL(T.TS_POD_NOD_CD3, '#@')||'%')         
                                    -- TS조건 체크 - END             
                                    AND NVL(M.POD_CD             , NVL(T.POD_CD,'#@')              ) LIKE '%'||NVL(T.POD_CD, '#@')||'%'                
                                    AND NVL(M.POD_NOD_CD         , NVL(T.POD_NOD_CD,'#@')          ) = NVL(T.POD_NOD_CD, '#@')                
                                    AND NVL(M.DEL_CD             , NVL(T.DEL_CD,'#@')              ) LIKE '%'||NVL(T.DEL_CD, '#@')||'%'                
                                    AND NVL(M.DEL_NOD_CD         , NVL(T.DEL_NOD_CD,'#@')          ) = NVL(T.DEL_NOD_CD, '#@')                
                                    AND NVL(M.BKG_DEL_SCC_CD     , NVL(T.BKG_DEL_SCC_CD,'#@')      ) = NVL(T.BKG_DEL_SCC_CD, '#@')                
                                    AND NVL(M.SC_NO              , NVL(T.SC_NO, '#@')     ) = NVL(T.SC_NO, '#@')                
                                    AND NVL(M.RFA_NO             , NVL(T.RFA_NO, '#@')    ) = NVL(T.RFA_NO, '#@')                
                                    AND NVL(M.CTRT_CUST_CNT_CD   , NVL(T.CTRT_CUST_CNT_CD, '#@')    ) = NVL(T.CTRT_CUST_CNT_CD, '#@')                
                                    AND NVL(M.CTRT_CUST_SEQ      , NVL(T.CTRT_CUST_SEQ, 0)    ) = NVL(T.CTRT_CUST_SEQ, 0)                
                                    AND NVL(M.CUST_CNT_CD        , NVL(T.CUST_CNT_CD, '#@')        ) = NVL(T.CUST_CNT_CD, '#@')           
									AND NVL(M.CUST_GRP_ID        , NVL(T.CUST_GRP_ID, '#@')        ) = NVL(T.CUST_GRP_ID, '#@')    		       
                                    AND NVL(M.RFA_CTRT_TP_CD     , NVL(T.RFA_CTRT_TP_CD, '#@')        ) = NVL(T.RFA_CTRT_TP_CD, '#@')       
                                    AND NVL(M.CUST_SEQ           , NVL(T.CUST_SEQ, 0)          ) = NVL(T.CUST_SEQ, 0)                
                                    AND NVL(M.CNTR_TPSZ_CD       , NVL(T.CNTR_TPSZ_CD, '#@')      )  LIKE '%'||NVL(T.CNTR_TPSZ_CD, '#@')||'%'                
                                    AND NVL(M.CMDT_CD            , NVL(T.CMDT_CD, '#@')             ) LIKE '%'||NVL(T.CMDT_CD, '#@')||'%'                
                                    AND NVL(M.VSL_CD             , T.VSL_CD              ) = T.VSL_CD                
                                    AND NVL(M.SKD_VOY_NO         , T.SKD_VOY_NO          ) = T.SKD_VOY_NO                
                                    AND NVL(M.SKD_DIR_CD         , T.DIR_CD              ) = T.DIR_CD                
                                    AND NVL(TO_CHAR(M.SCG_GRP_CMDT_SEQ)   , NVL(T.SCG_GRP_CMDT_SEQ, '#@')    ) = NVL(T.SCG_GRP_CMDT_SEQ, '#@')                
                                    AND NVL(M.POR_CNT_CD     , NVL(T.BKG_POR_CNT_CD, '#@')      )  LIKE '%'||NVL(T.BKG_POR_CNT_CD, '#@')||'%'                
                                    AND NVL(M.POL_CNT_CD     , NVL(T.BKG_POL_CNT_CD, '#@')      )  LIKE '%'||NVL(T.BKG_POL_CNT_CD, '#@')||'%'       
                                    AND NVL(M.POD_CNT_CD     , NVL(T.BKG_POD_CNT_CD, '#@')      )  LIKE '%'||NVL(T.BKG_POD_CNT_CD, '#@')||'%'                
                                    AND NVL(M.DEL_CNT_CD     , NVL(T.BKG_DEL_CNT_CD, '#@')      )  LIKE '%'||NVL(T.BKG_DEL_CNT_CD, '#@')||'%'                
                                    AND NVL(M.DCGO_FLG           , NVL(T.DCGO_FLG, 'N')          ) = NVL(T.DCGO_FLG, 'N')                
                                    AND NVL(M.RD_CGO_FLG         , NVL(T.RD_CGO_FLG, 'N')        ) = NVL(T.RD_CGO_FLG, 'N')                
                                    AND NVL(M.ACT_CNT_CD         , NVL((T.AGMT_ACT_CNT_CD||LPAD(T.AGMT_ACT_CUST_SEQ, 6, '0')), '#@')) LIKE '%'|| NVL((T.AGMT_ACT_CNT_CD||LPAD(T.AGMT_ACT_CUST_SEQ, 6, '0')), '#@')||'%'                
                                    AND NVL(M.OFT_CHG_AMT        , NVL(T.OFT_CHG_AMT, 0)    )    >= NVL(T.OFT_CHG_AMT, 0)                
                                    AND NVL(M.USA_BKG_MOD_CD     , NVL(T.USA_BKG_MOD_CD, 'OTH') )     = NVL(T.USA_BKG_MOD_CD, 'OTH')                
                                    AND (CASE NVL(M.CMPB_AMT,0) WHEN 0 THEN 1 ELSE NVL(M.CMPB_AMT,1) END) > (CASE NVL(M.CMPB_AMT,0) WHEN 0 THEN 0 ELSE NVL(T.CMPB_AMT,0) END)           
                                    AND (CASE NVL(M.CMPB_PER_TON_AMT,0) WHEN 0 THEN 1 ELSE NVL(M.CMPB_PER_TON_AMT,1) END) >= (CASE NVL(M.CMPB_PER_TON_AMT,0) WHEN 0 THEN 0 ELSE NVL(T.CMPB_PER_TON_AMT,0) END)           
                                    AND (CASE NVL(M.TON_PER_TEU_WGT,0) WHEN 0 THEN 0 ELSE NVL(M.TON_PER_TEU_WGT,1) END) <= (CASE NVL(M.TON_PER_TEU_WGT,0) WHEN 0 THEN 1 ELSE NVL(T.TON_PER_TEU_WGT,0) END)           
       
                                  GROUP BY M.BKG_ALOC_SEQ        
                                      , M.BKG_CTRL_TP_CD        
                                      , M.ALOC_LOD_QTY        
                                      , M.ALOC_LOD_QTY_RTO        
                                      , M.CMPB_AMT        
                                      , ASGN_TTL_WGT        
                                      , ASGN_WGT_RTO        
                                      , CMPB_ONY_FLG        
                                      , M.CNTR_QTY        
                                )        
                          WHERE 1 =1        
                            AND SB_BKG_YN = 'Y'        
                            AND (       
                                 DECODE(ALOC_LOD_QTY, 0, 1, ALOC_LOD_QTY_RTO) >= DECODE(ALOC_LOD_QTY, 0, 0, ROUND(TTL_QTY/ALOC_LOD_QTY * 100, 1))        
                                AND DECODE(ASGN_TTL_WGT, 0, 1, ASGN_WGT_RTO) >= DECODE(ASGN_TTL_WGT, 0, 0, ROUND(TTL_WGT/ASGN_TTL_WGT * 100, 1))        
                                AND DECODE(CNTR_QTY, 0, 1, ALOC_LOD_QTY_BOX_RTO) >= DECODE(CNTR_QTY, 0, 0, ROUND(TTL_CNTR_QTY/CNTR_QTY * 100, 1))        
                            )       
                  )       
                SELECT COUNT(1)          
                  INTO v_almighty_cnt                
                  FROM G_SUM                
                 WHERE ROWNUM = 1;           
                                
         -- 존재할경우 skip한다.                
         IF v_almighty_cnt > 0 THEN                
              UPDATE SPC_SB_BKG_DTL             
              SET DELT_FLG        = 'Y'            
               , UPD_USR_ID       = v_user_info            
               , UPD_DT           = SYSDATE            
              WHERE BKG_NO        = v_appl_info           
              AND BKG_CTRL_TP_CD  = 'S';
             enis_log_prc(SYSDATE, v_prc_nm, v_step || ' Firm! END', v_appl_info);                
             GOTO continue_loop;                
         END IF;                
                        
        BEGIN                
            -- MASTER, SMP, FCAST LF 제약조건 대상인지 확인                
            SELECT BKG_CTRL_ACCT_GRP_APLY_FLG, BKG_CTRL_ACCT_GRP_FCAST_FLG                
                    , BKG_CTRL_ALOC_APLY_FLG, BKG_CTRL_ALOC_FCAST_FLG                 
                    , BKG_CTRL_FCAST_FM_YRWK                
              INTO v_smp_must_flg, v_smp_fcst_flg                
                    , v_aloc_must_flg, v_aloc_fcst_flg                
                    , v_lf_wk                
              FROM SPC_ALOC_CTRL_OPT                
             WHERE RLANE_CD = bkg_list.RLANE_CD                 
                 AND DIR_CD = bkg_list.DIR_CD                
                 AND VSL_CD = bkg_list.VSL_CD                
                 AND SKD_VOY_NO =  bkg_list.SKD_VOY_NO                
                 AND SKD_DIR_CD =  bkg_list.DIR_CD                
             ;                
                             
             IF(v_smp_must_flg='Y' OR v_smp_fcst_flg='Y') THEN v_mst_smp_flg := 'Y'; END IF;                
                             
        EXCEPTION                
                WHEN NO_DATA_FOUND THEN                
                v_mst_smp_flg := 'N';                
                v_smp_fcst_flg := 'N';                
                v_smp_must_flg := 'N';                
                v_aloc_fcst_flg := 'N';                
                v_aloc_must_flg := 'N';                
                v_lf_wk := '200001';                
                enis_log_prc(SYSDATE, v_prc_nm, v_step || ' flag check null ', v_appl_info);                
        END;                
                        
        enis_log_prc(SYSDATE, v_prc_nm,   'Master SMP flag=' || v_mst_smp_flg                
                                        || ', SMP MUST flag = ' || v_smp_must_flg                
                                        || ', SMP FCAST flag = ' || v_smp_fcst_flg                   
                                        || ', ALOC MUST flag = ' || v_aloc_must_flg                
                                        || ', ALOC FCAST flag = ' || v_aloc_fcst_flg                   
                                        || ', LF From Week = ' || v_lf_wk                 
                                        || ', RLANE=' || bkg_list.RLANE_CD                
                                        || ', DIR=' || bkg_list.DIR_CD                
                                        || ', VVD=' || bkg_list.VSL_CD || bkg_list.SKD_VOY_NO || bkg_list.DIR_CD                
                                        , v_appl_info);                
                                                        
        -- SMP, ALOC L/F조건 만족하는지 확인                
                
        IF( v_smp_fcst_flg = 'Y' OR v_aloc_fcst_flg='Y') THEN                
                            
            BEGIN                
            -- 3주연속 L/F 조건 만족하는지 확인                
            WITH VVDS AS (                
                SELECT M.TRD_CD    ,                
                       M.SUB_TRD_CD,                
                       M.RLANE_CD  ,                
                       M.DIR_CD    ,                
                       M.IOC_CD    ,                
                       W.COST_YR   ,                
                       SUBSTR(M.SLS_YRMON, 5) AS COST_MON,                
                       M.COST_WK   ,                
                       W.NUM       ,                
                       M.VSL_CD    ,                
                       M.SKD_VOY_NO,                
                       M.DIR_CD AS SKD_DIR_CD,                
                       SPC_GET_WK_VVD_BSA_FNC('VOL', M.TRD_CD, M.RLANE_CD, M.DIR_CD, SUBSTR(M.SLS_YRMON, 1, 4)||M.COST_WK, M.VSL_CD||M.SKD_VOY_NO||M.DIR_CD) AS VVD_BSA,                
                       DECODE(H.DIR_CD, NULL, 'N', 'Y') AS HH_FLG                
                  FROM MAS_MON_VVD M, SPC_HD_HUL_MST H,                
                       (SELECT /*+ INDEX(P XPKMAS_WK_PRD) */                
                                 P.COST_YR ,                
                                 P.COST_WK ,                
                                 ROWNUM AS NUM                
                            FROM MAS_WK_PRD P                
                           WHERE P.COST_YR||P.COST_WK >= v_lf_wk                
                             AND ROWNUM               <= 3) W                
                 WHERE (SUBSTR(M.SLS_YRMON, 1, 4)||M.COST_WK) = W.COST_YR||W.COST_WK                
                   AND M.DELT_FLG = 'N'                
                   AND M.TRD_CD          = H.TRD_CD    (+)                
                   AND M.RLANE_CD        = H.RLANE_CD  (+)                
                   AND M.DIR_CD          = H.DIR_CD    (+)                
                   AND M.DIR_CD     = (CASE WHEN M.RLANE_CD IN ('AUSIA', 'CKAIA', 'WAXIA', 'AAZIA', 'QISIA', 'RUSIA', 'FOXIA') THEN DECODE('E', 'E', 'W', 'W', 'E', 'E') ELSE 'E' END)             
                   AND M.RLANE_CD = bkg_list.RLANE_CD                
                   )                
            , LF AS(                
                SELECT                
                    TRD_CD, SUB_TRD_CD, RLANE_CD, DIR_CD,                
                    SUM(DECODE(Z1.NUM, 1, NVL(Z1.LOAD , 0), 0)) LOAD1,                
                    SUM(DECODE(Z1.NUM, 2, NVL(Z1.LOAD , 0), 0)) LOAD2,                
                    SUM(DECODE(Z1.NUM, 3, NVL(Z1.LOAD , 0), 0)) LOAD3,                
                    SUM(DECODE(Z1.NUM, 1, NVL(Z1.BSA , 0), 0)) BSA1,                
                    SUM(DECODE(Z1.NUM, 2, NVL(Z1.BSA , 0), 0)) BSA2,                
                    SUM(DECODE(Z1.NUM, 3, NVL(Z1.BSA , 0), 0)) BSA3                
                    , (SELECT BKG_CTRL_ACCT_GRP_RTO FROM SPC_ALOC_LANE_CTRL_OPT O WHERE O.TRD_CD = Z1.TRD_CD AND O.SUB_TRD_CD = Z1.SUB_TRD_CD AND O.RLANE_CD = Z1.RLANE_CD AND O.DIR_CD = Z1.DIR_CD) SMP_RTO                
                    , (SELECT BKG_CTRL_ALOC_FCAST_RTO FROM SPC_ALOC_LANE_CTRL_OPT O WHERE O.TRD_CD = Z1.TRD_CD AND O.SUB_TRD_CD = Z1.SUB_TRD_CD AND O.RLANE_CD = Z1.RLANE_CD AND O.DIR_CD = Z1.DIR_CD) ALOC_RTO                
                FROM                
                (                
                    SELECT A.TRD_CD, A.SUB_TRD_CD, A.RLANE_CD,                
                           A.DIR_CD,                
                           A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD VVD,                
                           A.COST_YR||A.COST_WK AS WK    ,                
                           A.NUM,                
                           SUM(NVL(B.CFM_TTL_QTY, 0) + NVL(B.CFM_40FT_HC_QTY, 0) * 2 + NVL(B.CFM_45FT_HC_QTY, 0) * 2 + NVL(B.CFM_53FT_QTY, 0) * 2) AS LOAD,                
                           MAX(A.VVD_BSA) BSA                
                      FROM VVDS               A,                
                           SPC_DLY_FCAST_CUST B                
                     WHERE B.TRD_CD     = A.TRD_CD                
                       AND B.SUB_TRD_CD = A.SUB_TRD_CD                
                       AND B.RLANE_CD   = A.RLANE_CD                
                       AND B.IOC_TS_CD  = A.IOC_CD                
                       AND B.VSL_CD     = A.VSL_CD                
                       AND B.SKD_VOY_NO = A.SKD_VOY_NO                
                       AND B.SKD_DIR_CD = A.DIR_CD                
                       AND B.DIR_CD     = A.DIR_CD                
                  GROUP BY A.TRD_CD, A.SUB_TRD_CD, A.RLANE_CD, A.DIR_CD,                
                       A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD,                
                       A.COST_YR||A.COST_WK,                
                       A.NUM                
                    HAVING SUM(NVL(B.CFM_TTL_QTY, 0) + NVL(B.CFM_40FT_HC_QTY, 0) * 2 + NVL(B.CFM_45FT_HC_QTY, 0) * 2 + NVL(B.CFM_53FT_QTY, 0) * 2) > 0                
                ) Z1                
                GROUP BY TRD_CD, SUB_TRD_CD, RLANE_CD, DIR_CD                
            )                
        SELECT SUM(QTY2)                
             , SUM(QTY4)                
          INTO v_smp_lf_cnt                
             , v_aloc_lf_cnt                
          FROM (                
                
                SELECT 0 QTY1, COUNT(*) QTY2, 0 QTY3, 0 QTY4 FROM LF WHERE LOAD1/BSA1 > SMP_RTO AND LOAD2/BSA2 > SMP_RTO AND LOAD3/BSA3 > SMP_RTO                
                UNION ALL SELECT 0 QTY1, 0 QTY2, 0 QTY3, COUNT(*) QTY4 FROM LF WHERE LOAD1/BSA1 > ALOC_RTO AND LOAD2/BSA2 > ALOC_RTO AND LOAD3/BSA3 > ALOC_RTO                
            )                   
            ;                
           EXCEPTION                
                WHEN NO_DATA_FOUND THEN                
                    v_smp_lf_cnt := 0;                
                    v_aloc_lf_cnt := 0;                
                    enis_log_prc(SYSDATE, v_prc_nm, v_step || ' Pre 3 Weeks L/F 0', v_appl_info);                
           END;                
                           
           --L.F를 사용하는 경우 SMP 대상인지 확인                
           IF(v_smp_fcst_flg='Y' AND v_smp_lf_cnt=0) THEN v_mst_smp_flg := 'Y'; END IF;                
                           
        END IF;                
                        
        --Feeder인 경우 Must 처리                
        IF (bkg_list.VSL_CD LIKE 'FD%') THEN                
                
            v_mst_smp_flg := 'N';                
        END IF;                
                
    /************************************************************************                
     MasterTable(CMPB제외)제약조건 수행                
    ************************************************************************/                
        v_step := '1. MasterTable';                
        enis_log_prc(SYSDATE, v_prc_nm, v_step || ' START', v_appl_info);                
                        
        --MASTER에서 SMP제약조건 대상인지 확인(CMPB 제외)                
                
       IF(v_mst_smp_flg = 'Y' OR v_smp_must_flg = 'Y' OR (v_smp_fcst_flg='Y' AND v_smp_lf_cnt=0)) THEN                
                
            enis_log_prc(SYSDATE, v_prc_nm, v_step || ' SMP CHECK wk=' || bkg_list.SLS_WK || ', TRADE=' || bkg_list.trd_cd , v_appl_info);                
                            
            SELECT  /*+ INDEX_DESC (M XPKSPC_MDL_VER_MST) */                
                   DECODE(NVL((SELECT 'Y' FROM SPC_HD_HUL_MST WHERE TRD_CD = bkg_list.trd_cd AND RLANE_CD=bkg_list.rlane_cd AND DIR_CD=bkg_list.dir_cd), 'N'), 'Y', COST_YRWK||'-'||VER_SEQ, '200001-1')                
                   into v_mst_smp_season                
              FROM SPC_MDL_VER_MST M                
             WHERE bkg_list.SLS_WK BETWEEN M.VER_ST_YRWK AND M.VER_END_YRWK --                
               AND M.TRD_CD  = bkg_list.trd_cd                
               AND M.CFM_FLG = 'Y'                
               AND ROWNUM = 1;                
                              
            enis_log_prc(SYSDATE, v_prc_nm, v_step || ' season=' || v_mst_smp_season, v_appl_info);                
                            
            BEGIN                
                SELECT 'Y'                
                    INTO v_mst_smp_flg                
                FROM BKG_BOOKING B, BKG_CUSTOMER C                
                WHERE B.BKG_NO = v_appl_info                
                    AND B.BKG_NO   = C.BKG_NO                
                    AND C.BKG_CUST_TP_CD  = 'S'                
                    AND EXISTS ( SELECT 1                
                                 FROM SPC_MDL_CUST_CTRL M                
                                WHERE M.TRD_CD      = bkg_list.TRD_CD -- 2012.12.07 SLAN_CD를 RLANE_CD로 변경                
                                  AND M.COST_YRWK   = SUBSTR(v_mst_smp_season, 1, 6)                
                                  AND M.VER_SEQ     = SUBSTR(v_mst_smp_season, 8)                
                                  AND M.CUST_CNT_CD = B.CTRT_CUST_CNT_CD                
                                  AND M.CUST_SEQ    = B.CTRT_CUST_SEQ                
                                  AND M.SUB_TRD_CD  = DECODE(M.SUB_TRD_CD,'*',M.SUB_TRD_CD, bkg_list.SUB_TRD_CD) -- SPC_MDL_CUST_CTRL 테이블의 SUB_TRD_CD를 필수 항목이 아님                
                                  AND (B.SC_NO IS NOT NULL OR B.RFA_NO IS NOT NULL)                
                                  AND CASE WHEN M.SC_NO IS NOT NULL THEN M.SC_NO ELSE NVL(B.SC_NO, '#@') END = NVL(B.SC_NO, '#@')                
                                  AND CASE WHEN M.RFA_NO IS NOT NULL THEN M.RFA_NO ELSE NVL(B.RFA_NO, '#@') END = NVL(B.RFA_NO, '#@')                
                                 UNION ALL                
                                 SELECT 1                
                                 FROM SPC_MDL_CUST_RFA R                
                                 WHERE R.CUST_CNT_CD   = C.CUST_CNT_CD                
                                    AND R.CUST_SEQ     = C.CUST_SEQ                
                                    AND R.POL_CD       = B.POL_CD                
                                    AND R.POD_CD       = B.POD_CD                
                                    AND R.CUST_CTRL_CD ='R'                
                                  )                
                              ;                
           EXCEPTION                
                WHEN NO_DATA_FOUND THEN                
                    v_mst_smp_flg := 'N';                
                    enis_log_prc(SYSDATE, v_prc_nm, v_step || ' SMP CN check N', v_appl_info);                
           END;                
        END IF;                
        -- BKG_ALOC_TP_CD : |Free|Trunk|T/S|Customer|EQ|Commodity |F|T|S|C|E|M                
        -- MasterTable SPC_BKG_ALOC_MGMT 에서 reapply 인지 확인         
        -- RAPLY_CFM_FLG 가 존재할때 MASTERTABLE 수정된 SEQ와 BKG 매핑정보 구분없이 기존 로직 그대로 수행하면됨. -----------------------------------------    
        SELECT COUNT(*) CNT INTO v_mst_raply_cnt                
          FROM SPC_BKG_ALOC_MGMT                
         WHERE RAPLY_CFM_FLG = '1'                
           AND ALOC_USE_FLG ='Y'                
           AND bkg_list.SLS_WK BETWEEN NVL(APLY_FM_YRWK, '201501') AND NVL(APLY_TO_YRWK, '209953')                
          ;                
                            
           BEGIN                
                --apply_bkg_cursor 에서 Standby 상태인 bkg 들만 추출한 상태에서 재계산 태워야할 대상 존재유무 확인                
                SELECT LST_SB_RSN_TP_CD                
                  INTO v_old_lst_sb_rsn_tp_cd                
                  FROM SPC_SB_BKG B, SPC_SB_BKG_DTL D                
                 WHERE B.BKG_NO = v_appl_info                
                   AND B.BKG_NO = D.BKG_NO                
                 --  AND B.CFM_USR_ID IS NULL [2016.05.25] 주석처리               
                   AND D.LST_SB_RSN_TP_CD = 'M'             
                   AND D.BKG_CTRL_TP_CD = 'S'               
                   AND ROWNUM = 1                
                   ;                
           EXCEPTION                
                WHEN NO_DATA_FOUND THEN                
                    v_old_lst_sb_rsn_tp_cd := NULL;                
--                    enis_log_prc(SYSDATE, v_prc_nm, v_step || ' v_old_lst_sb_rsn_tp_cd check 0', v_appl_info);                
           END;                         
           enis_log_prc(SYSDATE, v_prc_nm, v_step || ': in_mode=' || in_mode                
                                        ||', v_old_lst_sb_rsn_tp_cd=' || v_old_lst_sb_rsn_tp_cd                
                                        || ', v_mst_raply_cnt = ' || v_mst_raply_cnt                
                                        || ', RHQ = ' || bkg_list.RHQ_CD                
                                        , v_appl_info);                
                
            /************************************************************************                
             BKG단 계산이거나                
             Master 로 인해 Standby상태로 된 BKG인 경우 reapply 대상이 있는 경우 수행        
             B:BKG에서 호출    
             R:Reprocess    
             W:시간배치    
            ************************************************************************/                
            IF(in_mode IN ('B','R') OR (in_mode = 'W' AND v_old_lst_sb_rsn_tp_cd='M' 
                AND (v_mst_raply_cnt > 0 OR v_mst_smp_flg = 'Y' OR v_smp_must_flg = 'Y' OR (v_smp_fcst_flg='Y' AND v_smp_lf_cnt=0)))) THEN                
                                  
                /************************************************************************                
                 1.1 Trunk NYCRA                
                
                ************************************************************************/                
                v_step := '1-1. MasterTable-TRUNK('||bkg_list.RHQ_CD||')';              
                BEGIN                
                    WITH BKG AS (                
                        SELECT BB.BKG_NO   ,BKG_CTRL_TP_CD             
                               ,NVL(BAM.BKG_ALOC_SEQ,0) BKG_ALOC_SEQ                        
                               ,LVL.OFC_N3RD_LVL_CD, LVL.GSO, BB.OB_SLS_OFC_CD                
                               ,BB.SLAN_CD, BB.VSL_CD, BB.SKD_VOY_NO, BB.SKD_DIR_CD                
                               ,BV.POL_CD T_POL_CD, BV.POD_CD T_POD_CD                
                               ,BAM.ALOC_SVC_CD                
                               ,(SELECT BAMD.BKG_ALOC_SEQ FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'TPL' AND BAMD.SB_LOC_CD = BV.POL_CD AND ROWNUM = 1) T_POL_ALOC_SEQ                
                               ,(SELECT BAMD.BKG_ALOC_SEQ FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD WHERE BAMD.BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ AND BAMD.SB_LOC_DIV_CD = 'TPD' AND BAMD.SB_LOC_CD = BV.POD_CD AND ROWNUM = 1) T_POD_ALOC_SEQ                
                               , NVL(BAM.ALOC_LOD_QTY_RTO, 0) ALOC_LOD_QTY_RTO                 
                               , NVL(BAM.ASGN_TTL_WGT, 0) ASGN_TTL_WGT                 
                               , NVL(BAM.ASGN_WGT_RTO, 100) ALOC_LOD_WGT_RTO                                                  
                               , NVL(BAM.OP_CNTR_QTY, 0) CNTR_QTY                                                
		   					   , ( SELECT NVL( MAX(MODI_SEQ) , 1) MODI_SEQ FROM SPC_BKG_ALOC_MGMT_HIS WHERE BKG_ALOC_SEQ = BAM.BKG_ALOC_SEQ ) MODI_SEQ  --**                
                               , (SELECT SPC_GET_CMPB_FNC(BB.BKG_NO, NULL) FROM DUAL) AS CMPB_AMT     
                               , BAM.CMPB_PER_TON_AMT AS MG_CMPB_PER_TON_AMT       
                               , BAM.TON_PER_TEU_WGT  AS MG_TON_PER_TEU_WGT          
                        FROM SPC_BKG_ALOC_MGMT BAM                
                             ,BKG_BOOKING BB                
                             ,BKG_VVD BV                
                             ,BKG_OFC_LVL_V LVL                
                        WHERE BAM.BKG_ALOC_TP_CD(+) = 'T'                
						AND BAM.SLS_RHQ_CD(+) = bkg_list.RHQ_CD       
                        AND BAM.TRNK_SLAN_CD(+) = BB.SLAN_CD                
                        AND NVL(BAM.TRNK_DIR_CD(+),BB.SKD_DIR_CD) =  BB.SKD_DIR_CD                
                        AND NVL(BAM.VSL_CD(+),BB.VSL_CD) = BB.VSL_CD                
                        AND NVL(BAM.SKD_VOY_NO(+),BB.SKD_VOY_NO) = BB.SKD_VOY_NO                
                        AND NVL(BAM.SKD_DIR_CD(+),BB.SKD_DIR_CD) = BB.SKD_DIR_CD                
                        AND BB.BKG_NO = BV.BKG_NO                
                        AND BB.OB_SLS_OFC_CD = LVL.OFC_CD                
                        AND BV.VSL_PRE_PST_CD = 'T'                
                        AND BB.BKG_NO = v_appl_info                
                        )                
                    , ALOC AS (                
                        SELECT BKG.BKG_ALOC_SEQ                
                               ,SUM(ASGN_TTL_QTY)     AS L_RHQ_ALLOC                   
             
                               ,SUM(CASE WHEN SUBSTR(A.POL_YD_CD,1,5) IN (SELECT BAMD.SB_LOC_CD                
                                                                          FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD                
                                                                          WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POL_ALOC_SEQ                
                                                                          AND BAMD.SB_LOC_DIV_CD = 'TPL' --'POL'                
                
                                                                          )                
                                         THEN ASGN_TTL_QTY ELSE 0 END)     AS L_RHQ_ALLOC_POL                
                
                               ,SUM(CASE WHEN SUBSTR(A.POD_YD_CD,1,5) IN (SELECT BAMD.SB_LOC_CD                
                                                                          FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD                
                                                                          WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POD_ALOC_SEQ                
                                                                          AND BAMD.SB_LOC_DIV_CD = 'TPD' --'POD'                
                
                                                                          )                
                                         THEN ASGN_TTL_QTY ELSE 0 END)     AS L_RHQ_ALLOC_POD                
                
                               ,SUM(CASE WHEN SUBSTR(A.POL_YD_CD,1,5) IN (SELECT BAMD.SB_LOC_CD                
                                                                          FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD                
                                                                          WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POD_ALOC_SEQ                
                                                                          AND BAMD.SB_LOC_DIV_CD = 'TPL'--'POL'                
                
                                                                          )                
                                              AND SUBSTR(A.POD_YD_CD,1,5) IN (SELECT BAMD.SB_LOC_CD                
                                                                          FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD                
                                                                          WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POD_ALOC_SEQ                
                                                                          AND BAMD.SB_LOC_DIV_CD = 'TPD'--'POD'                
                
                                                                          )                
                                         THEN ASGN_TTL_QTY ELSE 0 END)     AS L_RHQ_ALLOC_POL_POD                
                
							 /* --------------------------------------------------- */                   
							   ,SUM(BKG.ASGN_TTL_WGT)     AS L_RHQ_ALLOC_WGT                   
                
					           ,SUM(CASE WHEN SUBSTR(A.POL_YD_CD,1,5) IN (SELECT BAMD.SB_LOC_CD                   
					                                                      FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD                   
					                                                      WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POL_ALOC_SEQ                   
					                                                      AND BAMD.SB_LOC_DIV_CD = 'TPL' --'POL'                   
					                                                      )                   
					                     THEN BKG.ASGN_TTL_WGT ELSE 0 END)     AS L_RHQ_ALLOC_POL_WGT                   
                
					           ,SUM(CASE WHEN SUBSTR(A.POD_YD_CD,1,5) IN (SELECT BAMD.SB_LOC_CD                   
					                                                      FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD                   
					                                                      WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POD_ALOC_SEQ                   
					                                                      AND BAMD.SB_LOC_DIV_CD = 'TPD' --'POD'                   
					                                                      )                   
					                     THEN BKG.ASGN_TTL_WGT ELSE 0 END)     AS L_RHQ_ALLOC_POD_WGT                   
                  
					           ,SUM(CASE WHEN SUBSTR(A.POL_YD_CD,1,5) IN (SELECT BAMD.SB_LOC_CD                   
					                                                      FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD                   
					                                                      WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POD_ALOC_SEQ                   
					                                                      AND BAMD.SB_LOC_DIV_CD = 'TPL'--'POL'                   
					                                                      )                   
					                      AND SUBSTR(A.POD_YD_CD,1,5) IN (SELECT BAMD.SB_LOC_CD                   
					                                                      FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD                   
					                                                      WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POD_ALOC_SEQ                   
					                                                      AND BAMD.SB_LOC_DIV_CD = 'TPD'--'POD'                   
					                                                      )                   
					                     THEN BKG.ASGN_TTL_WGT ELSE 0 END)     AS L_RHQ_ALLOC_POL_POD_WGT                   
               
							 /* --------------------------------------------------- */                   
                          FROM BKG,                
                               SPC_ALOC_POL_POD  A,                
                               VSK_VSL_PORT_SKD  PD,                
                               VSK_VSL_PORT_SKD  PL                
                         WHERE A.RLANE_CD    LIKE BKG.SLAN_CD||'%'                
                           AND A.IOC_CD      = 'O'   -- 변동없음                
                           AND A.DIR_CD      = BKG.SKD_DIR_CD                
                           AND A.VSL_CD      = BKG.VSL_CD                
                           AND A.SKD_VOY_NO  = BKG.SKD_VOY_NO                
                           AND A.SKD_DIR_CD  = BKG.SKD_DIR_CD                
                           AND A.SLS_RHQ_CD  = BKG.OFC_N3RD_LVL_CD --RHQ가 같은                
                           AND A.VSL_CD      = PL.VSL_CD                
                           AND A.SKD_VOY_NO  = PL.SKD_VOY_NO                
                           AND A.SKD_DIR_CD  = PL.SKD_DIR_CD                
                           AND A.POL_YD_CD   = PL.YD_CD                
                           AND A.POL_IND_SEQ = PL.CLPT_IND_SEQ                
                           AND NVL(PL.SKD_CNG_STS_CD,'N') != 'S'                
                           AND A.VSL_CD      = PD.VSL_CD                
                           AND A.SKD_VOY_NO  = PD.SKD_VOY_NO                
                           AND A.SKD_DIR_CD  = PD.SKD_DIR_CD                
                           AND A.POD_YD_CD   = PD.YD_CD                
                           AND A.POD_IND_SEQ = PD.CLPT_IND_SEQ                
                           AND NVL(PD.SKD_CNG_STS_CD,'N') != 'S'                
                         GROUP BY BKG.BKG_ALOC_SEQ                
                         )                
                    , BKG_TEU AS (                
                         SELECT BKG.BKG_ALOC_SEQ                
                                ,NVL(SUM(DECODE(SPC_GET_CNTR_SZ_FNC(BQ.CNTR_TPSZ_CD),'2',BQ.OP_CNTR_QTY,BQ.OP_CNTR_QTY*2)),0) BKG_LRHQ_VOL                
                
                                ,SUM(CASE WHEN BV.POL_CD IN (SELECT BAMD.SB_LOC_CD                
                                                              FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD                
                                                              WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POL_ALOC_SEQ                
                                                              AND BAMD.SB_LOC_DIV_CD = 'TPL')--'POL')                
                                         THEN DECODE(SPC_GET_CNTR_SZ_FNC(BQ.CNTR_TPSZ_CD),'2',BQ.OP_CNTR_QTY,BQ.OP_CNTR_QTY*2) ELSE 0 END)     AS BKG_LRHQ_VOL_POL                
                               ,SUM(CASE WHEN BV.POD_CD IN (SELECT BAMD.SB_LOC_CD                
                                                              FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD                
                                                              WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POD_ALOC_SEQ                
                                                              AND BAMD.SB_LOC_DIV_CD = 'TPD')--'POD')                
                                         THEN DECODE(SPC_GET_CNTR_SZ_FNC(BQ.CNTR_TPSZ_CD),'2',BQ.OP_CNTR_QTY,BQ.OP_CNTR_QTY*2) ELSE 0 END)     AS BKG_LRHQ_VOL_POD                
                                ,SUM(CASE WHEN BV.POL_CD IN (SELECT BAMD.SB_LOC_CD                
                                                              FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD                
                                                              WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POD_ALOC_SEQ                
                                                              AND BAMD.SB_LOC_DIV_CD = 'TPL')--'POL')                
                                         AND BV.POD_CD IN (SELECT BAMD.SB_LOC_CD                
                                                              FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD                
                                                              WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POD_ALOC_SEQ                
                                                              AND BAMD.SB_LOC_DIV_CD = 'TPD')--'POD')                
                                         THEN DECODE(SPC_GET_CNTR_SZ_FNC(BQ.CNTR_TPSZ_CD),'2',BQ.OP_CNTR_QTY,BQ.OP_CNTR_QTY*2) ELSE 0 END)     AS BKG_LRHQ_VOL_POL_POD                
								/* --------------WGT----------------------- */                   
					            ,NVL((SUM(D.ACT_WGT * DECODE(D.WGT_UT_CD, 'LBS', 0.00045, 0.001) + (BQ.OP_CNTR_QTY * TS.CNTR_TPSZ_TARE_WGT * 0.001))),0) BKG_LRHQ_VOL_WGT                   
                
					            ,SUM(CASE WHEN BV.POL_CD IN (SELECT BAMD.SB_LOC_CD                   
					                                          FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD                   
					                                          WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POL_ALOC_SEQ                   
					                                          AND BAMD.SB_LOC_DIV_CD = 'TPL')--'POL')                   
					                     THEN ((D.ACT_WGT * DECODE(D.WGT_UT_CD, 'LBS', 0.00045, 0.001) + (BQ.OP_CNTR_QTY * TS.CNTR_TPSZ_TARE_WGT * 0.001))) ELSE 0 END)  AS BKG_LRHQ_VOL_POL_WGT                   
                
					           ,SUM(CASE WHEN BV.POD_CD IN (SELECT BAMD.SB_LOC_CD                   
					                                          FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD                   
					                                          WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POD_ALOC_SEQ                   
					                                          AND BAMD.SB_LOC_DIV_CD = 'TPD')--'POD')                   
					                     THEN ((D.ACT_WGT * DECODE(D.WGT_UT_CD, 'LBS', 0.00045, 0.001) + (BQ.OP_CNTR_QTY * TS.CNTR_TPSZ_TARE_WGT * 0.001))) ELSE 0 END) AS BKG_LRHQ_VOL_POD_WGT                   
                
					            ,SUM(CASE WHEN BV.POL_CD IN (SELECT BAMD.SB_LOC_CD                   
					                                          FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD                   
					                                          WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POD_ALOC_SEQ                   
					                                          AND BAMD.SB_LOC_DIV_CD = 'TPL')--'POL')                   
					                     AND BV.POD_CD IN (SELECT BAMD.SB_LOC_CD                   
					                                          FROM SPC_BKG_ALOC_MGMT_NOD_DTL BAMD                   
					                                          WHERE BAMD.BKG_ALOC_SEQ = BKG.T_POD_ALOC_SEQ                   
					                                          AND BAMD.SB_LOC_DIV_CD = 'TPD')--'POD')                   
					                     THEN ((D.ACT_WGT * DECODE(D.WGT_UT_CD, 'LBS', 0.00045, 0.001) + (BQ.OP_CNTR_QTY * TS.CNTR_TPSZ_TARE_WGT * 0.001))) ELSE 0 END) AS BKG_LRHQ_VOL_POL_POD_WGT                   
								/* ----------------WGT--------------------- */                   
								, SUM(BQ.OP_CNTR_QTY) TTL_CNTR_QTY                   
                           FROM BKG                
                                ,BKG_BOOKING BB1                
                                ,BKG_BL_DOC D                  
                                ,BKG_VVD BV                
                                ,BKG_QUANTITY BQ                
--                                ,SPC_OFC_LVL LVL1                
                                ,BKG_OFC_LVL_V LVL1                
								,MDM_CNTR_TP_SZ TS                  
                           WHERE BB1.BKG_NO = BQ.BKG_NO                
                               AND BB1.BKG_NO = BV.BKG_NO                
                               AND BB1.BKG_NO = D.BKG_NO                  
                               AND BV.VSL_PRE_PST_CD = 'T'                
                               AND BB1.VSL_CD = BKG.VSL_CD                
                               AND BB1.SKD_VOY_NO = BKG.SKD_VOY_NO                
                               AND BB1.SKD_DIR_CD = BKG.SKD_DIR_CD                
                               AND BB1.BKG_STS_CD <> 'X'                
                               AND BB1.BKG_CGO_TP_CD = 'F'                
                               AND (NVL(BB1.ALOC_STS_CD,'X') = 'F' OR BB1.BKG_NO = BKG.BKG_NO)                
                               AND BB1.OB_SLS_OFC_CD = LVL1.OFC_CD                
                               AND LVL1.OFC_N3RD_LVL_CD = BKG.OFC_N3RD_LVL_CD                 
								AND TS.CNTR_TPSZ_CD = BQ.CNTR_TPSZ_CD                 
                           GROUP BY BKG.BKG_ALOC_SEQ                
                    )                
SELECT              
      MAX(DECODE(ALOC_STS_CD,'S',ALOC_STS_CD)) V11             
    , MAX(DECODE(ALOC_STS_CD,'S',ALOC_SVC_CD)) V12             
    , MAX(DECODE(ALOC_STS_CD,'S',BKG_ALOC_SEQ)) V13             
    , MAX(DECODE(ALOC_STS_CD,'S',LST_SB_RS)) V14             
    , MAX(DECODE(ALOC_STS_CD,'S',MODI_SEQ)) V15               
    , MAX(DECODE(ALOC_STS_CD,'A',ALOC_STS_CD)) V21             
    , MAX(DECODE(ALOC_STS_CD,'A',ALOC_SVC_CD)) V22             
    , MAX(DECODE(ALOC_STS_CD,'A',BKG_ALOC_SEQ)) V23             
    , MAX(DECODE(ALOC_STS_CD,'A',LST_SB_RS)) V24             
    , MAX(DECODE(ALOC_STS_CD,'A',MODI_SEQ)) V25            
    INTO v_mst_t_rlst, v_mst_t_svc_cd, v_mst_t_seq ,  v_mst_t_rs, v_modi_t_seq    
    ,a_mst_t_rlst, a_mst_t_svc_cd, a_mst_t_seq ,  a_mst_t_rs, a_modi_t_seq            
FROM (             
    SELECT ALOC_STS_CD,ALOC_SVC_CD,BKG_ALOC_SEQ,LST_SB_RS,MODI_SEQ    
    FROM (             
                    SELECT BKG_CTRL_TP_CD AS ALOC_STS_CD, ALOC_SVC_CD, BKG_ALOC_SEQ ,               
                            'Type:Trunk'               
                            ||', T.LANE:'       ||TRNK_SLAN_CD               
                            ||', VVD:'          ||VVD               
                            ||', RHQ:'          ||L_RHQ               
                            ||', L.OFC:'        ||OB_SLS_OFC_CD               
                            ||', TrunkType:'    ||TRUNK_TP               
                            ||', RHQ RATIO WGT:'     ||RHQ_RATIO_WGT               
                            ||', RHQ Vol.:'     ||BKG_LRHQ_VOL               
                            ||', RHQ ALLOC:'    ||L_RHQ_ALLOC               
                            ||', RHQ RATIO:'    ||RHQ_RATIO               
                            ||', %THRESHOLD:'   ||ALOC_LOD_QTY_RTO               
                            ||', SVC:'          ||ALOC_SVC_CD             AS LST_SB_RS               
                        , MODI_SEQ --**               
                        , DENSE_RANK() OVER(PARTITION BY BKG_CTRL_TP_CD ORDER BY BKG_CTRL_TP_CD) F_ROW     
                    FROM (               
                        SELECT BKG.BKG_ALOC_SEQ, BKG.SLAN_CD                                                      TRNK_SLAN_CD               
                             , BKG_CTRL_TP_CD             
                             , BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD                       VVD               
                             , BKG.OFC_N3RD_LVL_CD                                              L_RHQ               
                             , BKG.GSO                                                          OB_SLS_OFC_CD               
                             , 'ALL'                                                            TRUNK_TP               
                             , BKG.ALOC_LOD_QTY_RTO                                             -------------               
                             , BKG.ALOC_LOD_WGT_RTO                                             -------------                  
                             , BKG.ALOC_SVC_CD               
                             , ALOC.L_RHQ_ALLOC                                                 L_RHQ_ALLOC               
                             , BKG_TEU.BKG_LRHQ_VOL                                             BKG_LRHQ_VOL               
                             , CASE WHEN L_RHQ_ALLOC = 0 THEN 0               
                                    ELSE ROUND(BKG_LRHQ_VOL/L_RHQ_ALLOC*100,1)               
                                    END                                                         RHQ_RATIO               
					         , CASE WHEN L_RHQ_ALLOC_WGT = 0 THEN 0                  
					                ELSE ROUND(BKG_LRHQ_VOL_WGT/L_RHQ_ALLOC_WGT*100,1)                  
					                END                                                         RHQ_RATIO_WGT                  
							,BKG.CNTR_QTY                  
							,TTL_CNTR_QTY                
                            , MODI_SEQ --**               
                            , ROUND(CMPB_AMT/BKG_LRHQ_VOL_WGT,2)  AS CMPB_PER_TON_AMT        
                            , ROUND(BKG_LRHQ_VOL_WGT/BKG_LRHQ_VOL,2)  AS TON_PER_TEU_WGT        
                            , MG_CMPB_PER_TON_AMT       
                            , MG_TON_PER_TEU_WGT      
                        FROM BKG, ALOC, BKG_TEU               
                        WHERE BKG.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ(+)               
                        AND   BKG.BKG_ALOC_SEQ = BKG_TEU.BKG_ALOC_SEQ               
                        AND   NVL(BKG.T_POL_ALOC_SEQ,0) = 0 --TRUNK POL               
                        AND   NVL(BKG.T_POD_ALOC_SEQ,0) = 0 --TRUNK POD               
                        UNION ALL               
                        SELECT BKG.BKG_ALOC_SEQ, BKG.SLAN_CD                                                      TRNK_SLAN_CD               
                             ,BKG_CTRL_TP_CD              
                             , BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD                       VVD               
                             , BKG.OFC_N3RD_LVL_CD                                              L_RHQ               
                             , BKG.GSO                                                          OB_SLS_OFC_CD               
                             , BKG.T_POL_CD||'/          '                                      TRUNK_TP               
                             , BKG.ALOC_LOD_QTY_RTO                                             -------------               
                             , BKG.ALOC_LOD_WGT_RTO                                             -------------                  
                             , BKG.ALOC_SVC_CD               
                             , ALOC.L_RHQ_ALLOC_POL                                             L_RHQ_ALLOC               
                             , BKG_TEU.BKG_LRHQ_VOL_POL                                         BKG_LRHQ_VOL               
                             , CASE WHEN L_RHQ_ALLOC_POL = 0 THEN 0               
                                    ELSE ROUND(BKG_LRHQ_VOL_POL/L_RHQ_ALLOC_POL*100,1)               
                                    END                                                         RHQ_RATIO               
					         , CASE WHEN L_RHQ_ALLOC_POL_WGT = 0 THEN 0                  
					                ELSE ROUND(BKG_LRHQ_VOL_POL_WGT/L_RHQ_ALLOC_POL_WGT*100,1)                  
					                END                                                         RHQ_RATIO_WGT                  
							,BKG.CNTR_QTY                  
							,TTL_CNTR_QTY               
                            , MODI_SEQ --**               
                            , ROUND(CMPB_AMT/BKG_LRHQ_VOL_POL_WGT,2)  AS CMPB_PER_TON_AMT        
                            , ROUND(BKG_LRHQ_VOL_POL_WGT/BKG_LRHQ_VOL_POL,2)  AS TON_PER_TEU_WGT                                     
                            , MG_CMPB_PER_TON_AMT       
                            , MG_TON_PER_TEU_WGT                                
                        FROM BKG, ALOC, BKG_TEU               
                        WHERE BKG.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ               
                        AND   BKG.BKG_ALOC_SEQ = BKG_TEU.BKG_ALOC_SEQ               
                        AND   NVL(BKG.T_POL_ALOC_SEQ,0) <> 0 --TRUNK POL               
                        AND   NVL(BKG.T_POD_ALOC_SEQ,0) = 0  --TRUNK POD               
                        UNION ALL               
                        SELECT BKG.BKG_ALOC_SEQ, BKG.SLAN_CD                                                      TRNK_SLAN_CD               
                             ,BKG_CTRL_TP_CD             
                             , BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD                       VVD               
                             , BKG.OFC_N3RD_LVL_CD                                              L_RHQ               
                             , BKG.GSO                                                          OB_SLS_OFC_CD               
                             , '          /'||BKG.T_POD_CD                                      TRUNK_TP               
                             , BKG.ALOC_LOD_QTY_RTO                                             -------------               
                             , BKG.ALOC_LOD_WGT_RTO                
                             , BKG.ALOC_SVC_CD               
                             , ALOC.L_RHQ_ALLOC_POD                                             L_RHQ_ALLOC               
                             , BKG_TEU.BKG_LRHQ_VOL_POD                                         BKG_LRHQ_VOL               
                             , CASE WHEN L_RHQ_ALLOC_POD = 0 THEN 0               
                                    ELSE ROUND(BKG_LRHQ_VOL_POD/L_RHQ_ALLOC_POD*100,1)               
                                    END                                                         RHQ_RATIO               
					         , CASE WHEN L_RHQ_ALLOC_POD_WGT = 0 THEN 0                  
					                ELSE ROUND(BKG_LRHQ_VOL_POD_WGT/L_RHQ_ALLOC_POD_WGT*100,1)                  
					                END                                                         RHQ_RATIO_WGT	                  
							,BKG.CNTR_QTY                  
							,TTL_CNTR_QTY                
                            , MODI_SEQ --**               
                            , ROUND(CMPB_AMT/BKG_LRHQ_VOL_POD_WGT,2)  AS CMPB_PER_TON_AMT        
                            , ROUND(BKG_LRHQ_VOL_POD_WGT/BKG_LRHQ_VOL_POD,2)  AS TON_PER_TEU_WGT              
                            , MG_CMPB_PER_TON_AMT       
                            , MG_TON_PER_TEU_WGT       
                        FROM BKG, ALOC, BKG_TEU               
                        WHERE BKG.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ               
                        AND   BKG.BKG_ALOC_SEQ = BKG_TEU.BKG_ALOC_SEQ               
                        AND   NVL(BKG.T_POL_ALOC_SEQ,0) = 0  --TRUNK POL               
                        AND   NVL(BKG.T_POD_ALOC_SEQ,0) <> 0 --TRUNK POD               
                        UNION ALL               
                        SELECT BKG.BKG_ALOC_SEQ, BKG.SLAN_CD                                                      TRNK_SLAN_CD               
                             ,BKG_CTRL_TP_CD                
                             , BKG.VSL_CD||BKG.SKD_VOY_NO||BKG.SKD_DIR_CD                       VVD               
                             , BKG.OFC_N3RD_LVL_CD                                              L_RHQ               
                             , BKG.GSO                                                          OB_SLS_OFC_CD               
                             , BKG.T_POL_CD||'/'||BKG.T_POD_CD                                  TRUNK_TP               
                             , BKG.ALOC_LOD_QTY_RTO                                             -------------               
                             , BKG.ALOC_LOD_WGT_RTO                                             -------------                  
                             , BKG.ALOC_SVC_CD               
                             , ALOC.L_RHQ_ALLOC_POL_POD                                         L_RHQ_ALLOC               
                             , BKG_TEU.BKG_LRHQ_VOL_POL_POD                                     BKG_LRHQ_VOL               
                             , CASE WHEN L_RHQ_ALLOC_POL_POD = 0 THEN 0               
                                    ELSE ROUND(BKG_LRHQ_VOL_POL_POD/L_RHQ_ALLOC_POL_POD*100,1)               
                                    END                                                         RHQ_RATIO               
					         , CASE WHEN L_RHQ_ALLOC_POL_POD_WGT = 0 THEN 0                  
					                ELSE ROUND(BKG_LRHQ_VOL_POL_POD_WGT/L_RHQ_ALLOC_POL_POD_WGT*100,1)                  
					                END                                                         RHQ_RATIO_WGT                  
							,BKG.CNTR_QTY                  
							,TTL_CNTR_QTY               
                            , MODI_SEQ --**               
                            , ROUND(CMPB_AMT/BKG_LRHQ_VOL_POL_POD_WGT,2)  AS CMPB_PER_TON_AMT        
                            , ROUND(BKG_LRHQ_VOL_POL_POD_WGT/BKG_LRHQ_VOL_POL_POD,2)  AS TON_PER_TEU_WGT                                     
                            , MG_CMPB_PER_TON_AMT       
                            , MG_TON_PER_TEU_WGT                                
                        FROM BKG, ALOC, BKG_TEU               
                        WHERE BKG.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ               
                        AND   BKG.BKG_ALOC_SEQ = BKG_TEU.BKG_ALOC_SEQ               
                        AND   NVL(BKG.T_POL_ALOC_SEQ,0) <> 0 --TRUNK POL               
                        AND   NVL(BKG.T_POD_ALOC_SEQ,0) <> 0 --TRUNK POL               
                    )  G_SUM             
                    WHERE 1=1                              
						AND (       
                            DECODE(RHQ_RATIO, 0, 1, RHQ_RATIO) > DECODE(RHQ_RATIO, 0, 0, ALOC_LOD_QTY_RTO)                      
                            AND DECODE(RHQ_RATIO_WGT, 0, 1, RHQ_RATIO_WGT) > DECODE(RHQ_RATIO_WGT, 0, 0, ALOC_LOD_WGT_RTO)            
                        )       
                      AND (CASE NVL(MG_CMPB_PER_TON_AMT,0) WHEN 0 THEN 1 ELSE NVL(MG_CMPB_PER_TON_AMT,1) END) >= (CASE NVL(MG_CMPB_PER_TON_AMT,0) WHEN 0 THEN 0 ELSE NVL(G_SUM.CMPB_PER_TON_AMT,0) END)           
                      AND (CASE NVL(MG_TON_PER_TEU_WGT,0) WHEN 0 THEN 0 ELSE NVL(MG_TON_PER_TEU_WGT,1) END) <= (CASE NVL(MG_TON_PER_TEU_WGT,0) WHEN 0 THEN 1 ELSE NVL(G_SUM.TON_PER_TEU_WGT,0) END)                                
                        --AND ROWNUM = 1                
                ) WHERE F_ROW=1             
              )                                     
                    ;               
                               
                               
               EXCEPTION               
                    WHEN NO_DATA_FOUND THEN               
                    v_mst_t_rlst := NULL;               
                    v_mst_t_svc_cd := NULL;               
                    v_mst_t_seq := NULL;               
                    v_mst_t_rs := NULL;               
                    v_modi_t_seq := NULL; --**             
                    a_mst_t_rlst := NULL;               
                    a_mst_t_svc_cd := NULL;               
                    a_mst_t_seq := NULL;               
                    a_mst_t_rs := NULL;               
                    a_modi_t_seq := NULL;            
               END;               
    
              enis_log_prc(SYSDATE, v_prc_nm, v_step || ': '|| NVL(v_mst_t_rlst,'N'), v_appl_info);     
                               
--            END IF;                         
                
                
                
                /************************************************************************               
                 1.2 TS         
                 [2015.10.23] t/s 컬럼추가로 쿼리변경        
                ************************************************************************/               
                v_step := '1-2. MasterTable-TS';                     
                BEGIN                             
                 -- Master Table 정보        
                WITH MST AS (        
                    SELECT MT.BKG_ALOC_SEQ                
                         , MT.BKG_ALOC_TP_CD          
                         , MT.ALOC_SVC_CD        
                         , MT.TRNK_SLAN_CD                
                         , MT.TRNK_DIR_CD                
                         , MT.OB_SLS_OFC_CD        
                         , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POR' AND LENGTH(LD.SB_LOC_CD) = 2) POR_CNT_CD         
                         , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POR' AND LENGTH(LD.SB_LOC_CD) = 5) POR_CD                
                         , MT.POR_NOD_CD                
                         , MT.BKG_POR_SCC_CD                
                         , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POL' AND LENGTH(LD.SB_LOC_CD) = 2) POL_CNT_CD          
                         , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POL' AND LENGTH(LD.SB_LOC_CD) = 5) POL_CD                
                         , MT.POL_NOD_CD                      
                         -- [2015.10.23] T/S PORT, T/S POL NODE, T/S POD NODE        
                         -- PORT, YARD 둘중에 하나라도 존재하면 제약조건 성립       
                         , CASE WHEN (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SAY' ) IS NOT NULL        
                                THEN NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SAY' AND LENGTH(LD.SB_LOC_CD) = 5 ), 'XXXXXXXX')         
                                ELSE NULL END AS TS_ALL_LOC_CD                              
                         , CASE WHEN (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SAY' ) IS NOT NULL        
                                THEN NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SAY' AND LENGTH(LD.SB_LOC_CD) = 7 ), 'XXXXXXXX')         
                                ELSE NULL END AS TS_ALL_NOD_CD         
                         , MT.N1ST_TS_SLAN_CD        
                         , MT.N1ST_TS_DIR_CD        
                         , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SPL' AND LENGTH(LD.SB_LOC_CD) = 2) N1ST_TS_POL_CNT_CD                
                         , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SPL' AND LENGTH(LD.SB_LOC_CD) = 5) N1ST_TS_POL_CD          
                         , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SLY' ) TS_POL_NOD_CD            
                         , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SPD' AND LENGTH(LD.SB_LOC_CD) = 2) N1ST_TS_POD_CNT_CD          
                         , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SPD' AND LENGTH(LD.SB_LOC_CD) = 5) N1ST_TS_POD_CD         
                         , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SDY') TS_POD_NOD_CD         
                                         
                         , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POD' AND LENGTH(LD.SB_LOC_CD) = 2) POD_CNT_CD        
                         , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POD' AND LENGTH(LD.SB_LOC_CD) = 5) POD_CD                
                         , MT.POD_NOD_CD                
                         , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(LD.SB_LOC_CD) = 2) DEL_CNT_CD         
                         , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(LD.SB_LOC_CD) = 5) DEL_CD                
                         , MT.DEL_NOD_CD                
                         , MT.BKG_DEL_SCC_CD                
                         , MT.SC_NO                
                         , MT.RFA_NO                
                         , MT.CTRT_CUST_CNT_CD                
                         , MT.CTRT_CUST_SEQ                
                         , MT.CUST_CNT_CD                
                         , MT.CUST_SEQ             
                         , (SELECT WM_CONCAT(LD.CNTR_TPSZ_CD) FROM SPC_BKG_ALOC_MGMT_TP_SZ_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ) CNTR_TPSZ_CD                
                         , (SELECT WM_CONCAT(CMDT.CMDT_CD) FROM SPC_BKG_ALOC_MGMT_CMDT_DTL CMDT WHERE CMDT.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ) CMDT_CD                
                         , MT.ALOC_LOD_QTY                
                         , NVL(MT.ALOC_LOD_QTY_RTO,100) ALOC_LOD_QTY_RTO           
                         , MT.VSL_CD                
                         , MT.SKD_VOY_NO                
                         , MT.SKD_DIR_CD                
                         , MT.SLS_RHQ_CD                
                         , MT.SCG_GRP_CMDT_SEQ                  
                         , NVL(MT.CMPB_AMT, 0) CMPB_AMT         
                         , MT.BKG_CTRL_TP_CD                
                         , MT.DCGO_FLG                
                         , MT.RD_CGO_FLG                
                         , MT.CRE_USR_ID                
                         , MT.CRE_DT                
                         , MT.UPD_USR_ID                
                         , MT.UPD_DT                
                         , MT.ALOC_APLY_FM_DT                
                         , MT.ALOC_APLY_TO_DT                
                         , MT.SUB_TRD_CD                
                         , MT.OFT_CHG_AMT                  
                         , MT.USA_BKG_MOD_CD                       
                         , (SELECT WM_CONCAT(AD.CUST_CNT_CD || LPAD(AD.CUST_SEQ, 6, '0')) FROM SPC_BKG_ALOC_MGMT_CUST_DTL AD WHERE AD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND AD.BKG_CUST_TP_CD = 'B') ACT_CNT_CD           
                         , MT.HUL_BND_CD                
                         , bkg_list.sls_wk SLS_WK            
                         , ASGN_TTL_WGT        
                         , NVL(MT.ASGN_WGT_RTO, 100) ASGN_WGT_RTO                
                         , CMPB_ONY_FLG                                         
                         , RVIS_CNTR_CUST_TP_CD						                 
                         , NVL(MT.OP_CNTR_QTY, 0) AS CNTR_QTY         
                         , MT.BKG_ALOC_TP_CD        
                         , MT.BKG_ALOC_RMK          
                         , (SELECT NVL( MAX(MODI_SEQ) , 1) MODI_SEQ FROM SPC_BKG_ALOC_MGMT_HIS WHERE BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ ) MODI_SEQ                     
                         , MT.CMPB_PER_TON_AMT       
                         , MT.TON_PER_TEU_WGT           
                    FROM  SPC_BKG_ALOC_MGMT MT              
                    WHERE MT.BKG_ALOC_TP_CD = 'S'                
                    AND (MT.ALOC_USE_FLG IS NULL OR  MT.ALOC_USE_FLG = 'Y')                
                    AND bkg_list.sls_wk BETWEEN NVL(MT.APLY_FM_YRWK, '201501') AND NVL(MT.APLY_TO_YRWK, '209953') -- Week 기준 추가                
                    AND MT.SLS_RHQ_CD = bkg_list.rhq_cd --필수값        
                )        
                        
                , BKG AS (        
            SELECT  T.*        
                    , ROUND(T.CMPB_AMT/T.WGT,2)  AS CMPB_PER_TON_AMT        
                    , ROUND(T.WGT/T.BKG_LOD_QTY,2)  AS TON_PER_TEU_WGT        
            FROM (            
                 SELECT MB.VVD_SEQ        
                      , MB.TRNK_SLAN_CD        
                      , MB.TRNK_SKD_DIR_CD        
                      , MB.POR_CNT_CD        
                      , MB.POR_CD        
                      , MB.POR_SCC_CD        
                      , MB.POR_NOD_CD        
                      , MB.POL_CNT_CD        
                      , MB.POL_CD        
                      , MB.POL_NOD_CD        
                      , MB.POD_CNT_CD        
                      , MB.POD_CD        
                      , MB.POD_NOD_CD        
                      , MB.DEL_CNT_CD        
                      , MB.DEL_CD        
                      , MB.DEL_SCC_CD        
                      , MB.DEL_NOD_CD        
                      , MB.OB_SLS_OFC_CD        
                      , MB.SC_NO        
                      , MB.RFA_NO        
                      , MB.SKD_DIR_CD        
                      , MB.CMDT_CD        
                      , MB.CTRT_CUST_CNT_CD        
                      , MB.CTRT_CUST_SEQ        
                      , MB.VSL_PRE_PST_CD        
                      , MB.VSL_SEQ        
                      , MB.VVD_SLAN_CD        
                      , MB.VVD_VSL_CD        
                      , MB.VVD_SKD_VOY_NO        
                      , MB.VVD_SKD_DIR_CD        
                      , MB.VVD_POL_CD        
                      , MB.VVD_POL_NOD_CD        
                      , MB.VVD_POD_CD        
                      , MB.VVD_POD_NOD_CD        
                      , MB.BKG_NO        
                      , MB.AGMT_ACT_CNT_CD        
                      , MB.AGMT_ACT_CUST_SEQ        
                      , MB.SUB_TRD_CD        
                      , MB.RCV_TERM_CD        
                      , MB.DE_TERM_CD        
                              
                      , MAX(DECODE(RK, 1, NULL))                AS TS_POL_CNT_CD1        
                      , MAX(DECODE(RK, 1, NULL))                AS TS_POL_CD1        
                      , MAX(DECODE(RK, 1, NULL))                AS TS_POL_NOD_CD1        
                      , MAX(DECODE(RK, 1, TS_POD_CNT_CD))       AS TS_POD_CNT_CD1        
                      , MAX(DECODE(RK, 1, TS_POD_CD))           AS TS_POD_CD1        
                      , MAX(DECODE(RK, 1, TS_POD_YD_CD))        AS TS_POD_NOD_CD1        
                      , MAX(DECODE(RK, 2, TS_POL_CNT_CD))       AS TS_POL_CNT_CD2        
                      , MAX(DECODE(RK, 2, TS_POL_CD))           AS TS_POL_CD2        
                      , MAX(DECODE(RK, 2, TS_POL_YD_CD))        AS TS_POL_NOD_CD2        
                      , DECODE(MAX(RK), 2, NULL, MAX(DECODE(RK, 2, TS_POD_CNT_CD)))       AS TS_POD_CNT_CD2        
                      , DECODE(MAX(RK), 2, NULL, MAX(DECODE(RK, 2, TS_POD_CD)))           AS TS_POD_CD2        
                      , DECODE(MAX(RK), 2, NULL, MAX(DECODE(RK, 2, TS_POD_YD_CD)))        AS TS_POD_NOD_CD2        
                      , MAX(DECODE(RK, 3, TS_POL_CNT_CD))       AS TS_POL_CNT_CD3        
                      , MAX(DECODE(RK, 3, TS_POL_CD))           AS TS_POL_CD3        
                      , MAX(DECODE(RK, 3, TS_POL_YD_CD))        AS TS_POL_NOD_CD3        
                      , DECODE(MAX(RK), 3, NULL, MAX(DECODE(RK, 3, TS_POD_CNT_CD)))      AS TS_POD_CNT_CD3        
                      , DECODE(MAX(RK), 3, NULL, MAX(DECODE(RK, 3, TS_POD_CD)))          AS TS_POD_CD3        
                      , DECODE(MAX(RK), 3, NULL, MAX(DECODE(RK, 3, TS_POD_YD_CD)))       AS TS_POD_NOD_CD3        
                              
					 , NVL( (SELECT SUM(R.CHG_UT_AMT) FROM BKG_CHG_RT R WHERE R.BKG_NO = MB.BKG_NO AND R.CHG_CD = 'OFT')       
					 	   ,(SELECT MIN(OFT_AMT) KEEP (DENSE_RANK LAST ORDER BY A.REV_COST_SEQ) FROM BKG_REV_COST A WHERE A.BKG_NO = MB.BKG_NO)) AS OFT_CHG_AMT           
                      , CASE WHEN (SUBSTR(MB.POR_CD, 1, 2) IN ('CA', 'US') OR SUBSTR(MB.DEL_CD, 1, 2) IN ('CA', 'US'))         
                             THEN (SELECT SPC_USA_MODE_FNC(MB.RCV_TERM_CD, MB.DE_TERM_CD, MB.POR_CD, MB.POL_CD, MB.POD_CD, MB.DEL_CD) FROM DUAL )        
                             ELSE 'OTH' END USA_BKG_MOD_CD        
                      , bkg_list.sls_wk SLS_WK        
                      , (SELECT SPC_GET_CMPB_FNC(MB.BKG_NO, NULL) FROM DUAL) AS CMPB_AMT     
                      , (SELECT RVIS_CNTR_CUST_TP_CD FROM MDM_CUSTOMER M        
                          WHERE MB.CTRT_CUST_CNT_CD = M.CUST_CNT_CD        
                            AND MB.CTRT_CUST_SEQ    = M.CUST_SEQ ) AS RVIS_CNTR_CUST_TP_CD        
                      , CNTR_QTY        
                      , (SELECT SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', 1, 2) * Q.OP_CNTR_QTY) FROM BKG_QUANTITY Q        
                          WHERE Q.BKG_NO = MB.BKG_NO ) AS BKG_LOD_QTY --TEU(Load)        
                      , (SELECT SUM((D.ACT_WGT * DECODE(D.WGT_UT_CD, 'LBS', 0.00045, 0.001)) + SUM(Q.OP_CNTR_QTY *        
                                (SELECT TS.CNTR_TPSZ_TARE_WGT FROM MDM_CNTR_TP_SZ TS WHERE TS.CNTR_TPSZ_CD = Q.CNTR_TPSZ_CD )) * 0.001 )        
                           FROM BKG_QUANTITY Q        
                              , BKG_BL_DOC D        
                          WHERE MB.BKG_NO     = Q.BKG_NO        
                            AND MB.BKG_NO     = D.BKG_NO        
                            AND Q.OP_CNTR_QTY > 0        
                       GROUP BY D.ACT_WGT * DECODE(D.WGT_UT_CD, 'LBS', 0.00045, 0.001) ) WGT        
                   FROM (        
                        SELECT (SELECT INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL        
                                  WHERE INTG_CD_ID = 'CD01233'        
                                    AND INTG_CD_VAL_CTNT = BV.VSL_PRE_PST_CD        
                                    AND ROWNUM = 1 )||' '||BV.VSL_SEQ AS VVD_SEQ        
                              , BB.SLAN_CD AS TRNK_SLAN_CD        
                              , BB.SKD_DIR_CD AS TRNK_SKD_DIR_CD        
                              , SUBSTR(BB.POR_CD, 1, 2) AS POR_CNT_CD        
                              , BB.POR_CD        
                              , (SELECT SCC_CD FROM MDM_LOCATION WHERE LOC_CD = BB.POR_CD ) AS POR_SCC_CD        
                              , BB.POR_NOD_CD        
                              , SUBSTR(BB.POL_CD, 1, 2) AS POL_CNT_CD        
                              , BB.POL_CD        
                              , BB.POL_NOD_CD        
                              , SUBSTR(BB.POD_CD, 1, 2) AS POD_CNT_CD        
                              , BB.POD_CD        
                              , BB.POD_NOD_CD        
                              , SUBSTR(BB.DEL_CD, 1, 2) AS DEL_CNT_CD        
                              , BB.DEL_CD        
                              , (SELECT SCC_CD FROM MDM_LOCATION WHERE LOC_CD = BB.DEL_CD ) AS DEL_SCC_CD        
                              , BB.DEL_NOD_CD        
                              , BB.OB_SLS_OFC_CD        
                              , BB.SC_NO        
                              , BB.RFA_NO        
                              , BB.SKD_DIR_CD        
                              , BB.CMDT_CD        
                              , BB.CTRT_CUST_CNT_CD        
                              , BB.CTRT_CUST_SEQ        
                              , BV.VSL_PRE_PST_CD        
                              , BV.VSL_SEQ        
                              , BV.SLAN_CD VVD_SLAN_CD        
                              , BV.VSL_CD VVD_VSL_CD        
                              , BV.SKD_VOY_NO VVD_SKD_VOY_NO        
                              , BV.SKD_DIR_CD VVD_SKD_DIR_CD        
                              , BV.POL_CD VVD_POL_CD        
                              , BV.POL_YD_CD VVD_POL_NOD_CD        
                              , BV.POD_CD VVD_POD_CD        
                              , BV.POD_YD_CD VVD_POD_NOD_CD        
                              , BB.BKG_NO        
                              , BB.AGMT_ACT_CNT_CD        
                              , BB.AGMT_ACT_CUST_SEQ        
                              , bkg_list.sub_trd_cd SUB_TRD_CD        
                              , DENSE_RANK() OVER ( PARTITION BY TV.BKG_NO ORDER BY TV.VSL_PRE_PST_CD, TV.VSL_SEQ) AS RK        
                              , TV.POL_CD TS_POL_CD        
                              , TV.POL_YD_CD TS_POL_YD_CD        
                              , TV.POD_CD TS_POD_CD        
                              , TV.POD_YD_CD TS_POD_YD_CD        
                              , SUBSTR(TV.POL_CD, 1, 2) AS TS_POL_CNT_CD        
                              , SUBSTR(TV.POD_CD, 1, 2) AS TS_POD_CNT_CD        
                              , BB.RCV_TERM_CD        
                              , BB.DE_TERM_CD       
							  ,CASE WHEN QTY.CNTR_TPSZ_CD LIKE 'R%' THEN QTY.OP_CNTR_QTY - EQ_SUBST_CGO_QTY ELSE OP_CNTR_QTY END AS CNTR_QTY    
                           FROM BKG_VVD MV -- in_bkg_no        
                              , BKG_VVD BV -- in_bkg_no의 SLAN||VVD 에 해당하는 BKG        
                              , BKG_VVD TV -- T/S 를 구하기 위한 BKG        
                              , BKG_BOOKING BB     ,  BKG_QUANTITY QTY    
                              , SPC_OFC_LVL LVL        
                          WHERE MV.BKG_NO                 = v_appl_info    
							AND BB.BKG_NO                 = QTY.BKG_NO        
                            AND MV.VSL_PRE_PST_CD        <> 'T'        
                            AND BV.BKG_NO                 = BB.BKG_NO        
                            AND BB.BKG_NO                 = TV.BKG_NO        
                            AND BB.BKG_STS_CD            <> 'X'        
                            AND BB.BKG_CGO_TP_CD          = 'F'        
                            AND (NVL(BB.ALOC_STS_CD, 'X') = 'F' OR BB.BKG_NO = MV.BKG_NO)        
                            AND BV.VSL_PRE_PST_CD        <> 'T'        
                            AND BV.SLAN_CD                = MV.SLAN_CD        
                            AND BV.VSL_CD                 = MV.VSL_CD        
                            AND BV.SKD_VOY_NO             = MV.SKD_VOY_NO        
                            AND BV.SKD_DIR_CD             = MV.SKD_DIR_CD        
                            AND bkg_list.sls_wk BETWEEN LVL.OFC_APLY_FM_YRWK AND LVL.OFC_APLY_TO_YRWK        
                            AND (SELECT SPC_SCR_OFC_CONV_FNC(BB.OB_SLS_OFC_CD, '') FROM DUAL) = LVL.OFC_CD        
                            AND bkg_list.rhq_cd = LVL.N2ND_PRNT_OFC_CD        
                        ) MB        
                GROUP BY MB.VVD_SEQ        
                      , MB.TRNK_SLAN_CD        
                      , MB.TRNK_SKD_DIR_CD        
                      , MB.POR_CNT_CD        
                      , MB.POR_CD        
                      , MB.POR_SCC_CD        
                      , MB.POR_NOD_CD        
                      , MB.POL_CNT_CD        
                      , MB.POL_CD        
                      , MB.POL_NOD_CD        
                      , MB.POD_CNT_CD        
                      , MB.POD_CD        
                      , MB.POD_NOD_CD        
                      , MB.DEL_CNT_CD        
                      , MB.DEL_CD        
                      , MB.DEL_SCC_CD        
                      , MB.DEL_NOD_CD        
                      , MB.OB_SLS_OFC_CD        
                      , MB.SC_NO        
                      , MB.RFA_NO        
                      , MB.SKD_DIR_CD        
                      , MB.CMDT_CD        
                      , MB.CTRT_CUST_CNT_CD        
                      , MB.CTRT_CUST_SEQ        
                      , MB.VSL_PRE_PST_CD        
                      , MB.VSL_SEQ        
                      , MB.VVD_SLAN_CD        
                      , MB.VVD_VSL_CD        
                      , MB.VVD_SKD_VOY_NO        
                      , MB.VVD_SKD_DIR_CD        
                      , MB.VVD_POL_CD        
                      , MB.VVD_POL_NOD_CD        
                      , MB.VVD_POD_CD        
                      , MB.VVD_POD_NOD_CD        
                      , MB.BKG_NO        
                      , MB.AGMT_ACT_CNT_CD        
                      , MB.AGMT_ACT_CUST_SEQ        
                      , MB.SUB_TRD_CD        
                      , MB.RCV_TERM_CD        
                      , MB.DE_TERM_CD      
					  , MB.CNTR_QTY    
      )  T       
    )                                         
                , G_SUM AS (        
                    SELECT VVD_SEQ        
                         , BKG_ALOC_SEQ        
                         , ALOC_SVC_CD        
                         , BKG_CTRL_TP_CD               
                         , ALOC_LOD_QTY          
                         , SLAN_CD        
                         , ALOC_LOD_QTY_RTO  --ratio가 없으면 물량의 100%                
                         , ALOC_LOD_QTY_BOX_RTO  --ratio가 없으면 물량의 100%                
                         , CMPB_AMT                
                         , F_TTL_QTY --전체 Confirm 갯수                
                         , BKG_QTY --현재 BKG의 갯수 v_appl_info                
                         , TEU_TTL                
                         , TTL_WGT                 
                         , ASGN_TTL_WGT                
                         , ASGN_WGT_RTO  --ratio가 없으면 물량의 100%                
                         , CMPB_ONY_FLG                
                         , BKG_ALOC_RMK        
                         , CNTR_QTY                   
                         , TTL_CNTR_QTY                 
                         , MODI_SEQ --** master 인경우만 BKG_ALOC_SEQ와 MODI_SEQ 값 저장.         
                         , TS_RATIO        
                         , WGT_RATIO /*WG비율*/        
                         , TS_BOX_RATIO         
                         , SB_BKG_YN      
                      FROM (        
                            SELECT BKG.VVD_SEQ        
                                 , MST.BKG_ALOC_SEQ        
                                 , MST.ALOC_SVC_CD        
                                 , MST.BKG_CTRL_TP_CD               
                                 , NVL(MST.ALOC_LOD_QTY, 0) ALOC_LOD_QTY          
                                 , MAX(BKG.VVD_SLAN_CD) SLAN_CD        
                                 , DECODE(NVL(MST.ALOC_LOD_QTY, 0), 0, 0, NVL(MST.ALOC_LOD_QTY_RTO, 100)) ALOC_LOD_QTY_RTO  --ratio가 없으면 물량의 100%                
                                 , DECODE(NVL(MST.CNTR_QTY, 0), 0, 0, NVL(MST.ALOC_LOD_QTY_RTO, 100)) ALOC_LOD_QTY_BOX_RTO  --ratio가 없으면 물량의 100%                
                                 , NVL(MST.CMPB_AMT, 0) CMPB_AMT                
                                 , SUM(DECODE(BKG.BKG_NO, v_appl_info, 0, BKG.BKG_LOD_QTY)) F_TTL_QTY --전체 Confirm 갯수                
                                 , SUM(DECODE(BKG.BKG_NO, v_appl_info, BKG.BKG_LOD_QTY,0)) BKG_QTY --현재 BKG의 갯수 v_appl_info                
                                 , SUM(BKG.BKG_LOD_QTY) TEU_TTL                
                                 , SUM(BKG.WGT) TTL_WGT                 
                                 , NVL(MST.ASGN_TTL_WGT, 0) ASGN_TTL_WGT                
                                 , NVL(MST.ASGN_WGT_RTO, 100) ASGN_WGT_RTO  --ratio가 없으면 물량의 100%                
                                 , CMPB_ONY_FLG                
                                 , MST.BKG_ALOC_RMK        
                                 , NVL(MST.CNTR_QTY, 0) CNTR_QTY                   
                                 , SUM(BKG.CNTR_QTY) TTL_CNTR_QTY                 
                                 , ( SELECT NVL( MAX(MODI_SEQ) , 1) MODI_SEQ FROM SPC_BKG_ALOC_MGMT_HIS WHERE BKG_ALOC_SEQ = MST.BKG_ALOC_SEQ ) MODI_SEQ --** master 인경우만 BKG_ALOC_SEQ와 MODI_SEQ 값 저장.           
                                         
                              , CASE WHEN NVL(MST.ALOC_LOD_QTY, 0) = 0 THEN 0        
                                     ELSE ROUND(SUM(BKG.BKG_LOD_QTY) / MST.ALOC_LOD_QTY * 100, 1)        
                                      END AS TS_RATIO        
                                              
                              , CASE WHEN NVL(MST.ASGN_TTL_WGT, 0) = 0 THEN 0        
                                     ELSE ROUND(SUM(BKG.WGT) / MST.ASGN_TTL_WGT * 100, 1)        
                                      END AS WGT_RATIO /*WG비율*/        
                                              
                              , CASE WHEN NVL(MST.CNTR_QTY, 0) = 0 THEN 0        
                                     ELSE ROUND(SUM(BKG.CNTR_QTY) / MST.CNTR_QTY * 100, 1)        
                                      END AS TS_BOX_RATIO         
                                              
                              , MAX(DECODE(BKG.BKG_NO, v_appl_info, 'Y')) SB_BKG_YN       
                                      
                           FROM MST          
                              , BKG        
                          WHERE NVL(MST.SUB_TRD_CD(+), BKG.SUB_TRD_CD)     = BKG.SUB_TRD_CD         
                            AND NVL(MST.TRNK_SLAN_CD(+), BKG.TRNK_SLAN_CD) = BKG.TRNK_SLAN_CD        
                            AND NVL(MST.VSL_CD(+),BKG.VVD_VSL_CD)          = BKG.VVD_VSL_CD               
                            AND NVL(MST.SKD_VOY_NO(+),BKG.VVD_SKD_VOY_NO)  = BKG.VVD_SKD_VOY_NO               
                            AND NVL(MST.SKD_DIR_CD(+),BKG.VVD_SKD_DIR_CD)  = BKG.VVD_SKD_DIR_CD          
                            -- POR/NODE        
                            AND NVL(MST.POR_CNT_CD,    NVL(BKG.POR_CNT_CD, '#@'))      LIKE '%'||NVL(BKG.POR_CNT_CD, '#@')||'%'        
                            AND NVL(MST.POR_CD,        NVL(BKG.POR_CD, '#@'))          LIKE '%'||NVL(BKG.POR_CD, '#@')||'%'        
                            AND NVL(MST.POR_NOD_CD,    NVL(BKG.POR_NOD_CD, '#@'))      LIKE '%'||NVL(BKG.POR_NOD_CD, '#@')||'%'        
                            AND NVL(MST.BKG_POR_SCC_CD,NVL(BKG.POR_SCC_CD, '#@'))      LIKE '%'||NVL(BKG.POR_SCC_CD, '#@')||'%'        
                            -- POL/NODE        
                            AND NVL(MST.POL_CNT_CD,    NVL(BKG.POL_CNT_CD, '#@'))      LIKE '%'||NVL(BKG.POL_CNT_CD, '#@')||'%'        
                            AND NVL(MST.POL_CD,        NVL(BKG.POL_CD, '#@'))          LIKE '%'||NVL(BKG.POL_CD, '#@')||'%'        
                            AND NVL(MST.POL_NOD_CD,    NVL(BKG.POL_NOD_CD, '#@'))      LIKE '%'||NVL(BKG.POL_NOD_CD, '#@')||'%'       
                            -- T/S -> T/S PORT        
                            AND (NVL(MST.TS_ALL_LOC_CD, NVL(BKG.TS_POL_CD1, '#@'))      LIKE '%'||NVL(BKG.TS_POL_CD1, '#@')||'%'        
                             OR NVL(MST.TS_ALL_LOC_CD,  NVL(BKG.TS_POL_CD2, '#@'))      LIKE '%'||NVL(BKG.TS_POL_CD2, '#@')||'%'        
                             OR NVL(MST.TS_ALL_LOC_CD,  NVL(BKG.TS_POL_CD3, '#@'))      LIKE '%'||NVL(BKG.TS_POL_CD3, '#@')||'%'        
                             OR NVL(MST.TS_ALL_LOC_CD,  NVL(BKG.TS_POD_CD1, '#@'))      LIKE '%'||NVL(BKG.TS_POD_CD1, '#@')||'%'        
                             OR NVL(MST.TS_ALL_LOC_CD,  NVL(BKG.TS_POD_CD2, '#@'))      LIKE '%'||NVL(BKG.TS_POD_CD2, '#@')||'%'        
                             OR NVL(MST.TS_ALL_LOC_CD,  NVL(BKG.TS_POD_CD3, '#@'))      LIKE '%'||NVL(BKG.TS_POD_CD3, '#@')||'%'        
                             OR NVL(MST.TS_ALL_NOD_CD,  NVL(BKG.TS_POL_NOD_CD1, '#@'))  LIKE '%'||NVL(BKG.TS_POL_NOD_CD1, '#@')||'%'        
                             OR NVL(MST.TS_ALL_NOD_CD,  NVL(BKG.TS_POL_NOD_CD2, '#@'))  LIKE '%'||NVL(BKG.TS_POL_NOD_CD2, '#@')||'%'        
                             OR NVL(MST.TS_ALL_NOD_CD,  NVL(BKG.TS_POL_NOD_CD3, '#@'))  LIKE '%'||NVL(BKG.TS_POL_NOD_CD3, '#@')||'%'        
                             OR NVL(MST.TS_ALL_NOD_CD,  NVL(BKG.TS_POD_NOD_CD1, '#@'))  LIKE '%'||NVL(BKG.TS_POD_NOD_CD1, '#@')||'%'        
                             OR NVL(MST.TS_ALL_NOD_CD,  NVL(BKG.TS_POD_NOD_CD2, '#@'))  LIKE '%'||NVL(BKG.TS_POD_NOD_CD2, '#@')||'%'        
                             OR NVL(MST.TS_ALL_NOD_CD,  NVL(BKG.TS_POD_NOD_CD3, '#@'))  LIKE '%'||NVL(BKG.TS_POD_NOD_CD3, '#@')||'%')        
                            -- T/S -> LANE        
                            AND NVL(MST.N1ST_TS_SLAN_CD(+), BKG.VVD_SLAN_CD) = BKG.VVD_SLAN_CD        
                            -- T/S -> BD        
                            AND NVL(MST.N1ST_TS_DIR_CD(+), BKG.VVD_SKD_DIR_CD) = BKG.VVD_SKD_DIR_CD        
                            -- T/S -> POL COUNTRY        
                            AND (NVL(MST.N1ST_TS_POL_CNT_CD, NVL(BKG.TS_POL_CNT_CD1, '#@')) LIKE '%'||NVL(BKG.TS_POL_CNT_CD1, '#@')||'%'        
                             OR NVL(MST.N1ST_TS_POL_CNT_CD,  NVL(BKG.TS_POL_CNT_CD2, '#@')) LIKE '%'||NVL(BKG.TS_POL_CNT_CD2, '#@')||'%'        
                             OR NVL(MST.N1ST_TS_POL_CNT_CD,  NVL(BKG.TS_POL_CNT_CD3, '#@')) LIKE '%'||NVL(BKG.TS_POL_CNT_CD3, '#@')||'%')        
                            -- T/S -> POL        
                            AND (NVL(MST.N1ST_TS_POL_CD, NVL(BKG.TS_POL_CD1, '#@'))     LIKE '%'||NVL(BKG.TS_POL_CD1, '#@')||'%'        
                             OR NVL(MST.N1ST_TS_POL_CD,  NVL(BKG.TS_POL_CD2, '#@'))     LIKE '%'||NVL(BKG.TS_POL_CD2, '#@')||'%'        
                             OR NVL(MST.N1ST_TS_POL_CD,  NVL(BKG.TS_POL_CD3, '#@'))     LIKE '%'||NVL(BKG.TS_POL_CD3, '#@')||'%')        
                            -- T/S -> POL NODE(LOC+00)        
                            AND (NVL(MST.TS_POL_NOD_CD, NVL(BKG.TS_POL_NOD_CD1, '#@'))  LIKE '%'||NVL(BKG.TS_POL_NOD_CD1, '#@')||'%'        
                             OR NVL(MST.TS_POL_NOD_CD,  NVL(BKG.TS_POL_NOD_CD2, '#@'))  LIKE '%'||NVL(BKG.TS_POL_NOD_CD2, '#@')||'%'        
                             OR NVL(MST.TS_POL_NOD_CD,  NVL(BKG.TS_POL_NOD_CD3, '#@'))  LIKE '%'||NVL(BKG.TS_POL_NOD_CD3, '#@')||'%')        
                            -- T/S -> POD COUNTRY        
                            AND (NVL(MST.N1ST_TS_POD_CNT_CD, NVL(BKG.TS_POD_CNT_CD1, '#@')) LIKE '%'||NVL(BKG.TS_POD_CNT_CD1, '#@')||'%'        
                             OR NVL(MST.N1ST_TS_POD_CNT_CD,  NVL(BKG.TS_POD_CNT_CD2, '#@')) LIKE '%'||NVL(BKG.TS_POD_CNT_CD2, '#@')||'%'        
                             OR NVL(MST.N1ST_TS_POD_CNT_CD,  NVL(BKG.TS_POD_CNT_CD3, '#@')) LIKE '%'||NVL(BKG.TS_POD_CNT_CD3, '#@')||'%')        
                            -- T/S -> POD        
                            AND (NVL(MST.N1ST_TS_POD_CD, NVL(BKG.TS_POD_CD1, '#@'))     LIKE '%'||NVL(BKG.TS_POD_CD1, '#@')||'%'        
                             OR NVL(MST.N1ST_TS_POD_CD,  NVL(BKG.TS_POD_CD2, '#@'))     LIKE '%'||NVL(BKG.TS_POD_CD2, '#@')||'%'        
                             OR NVL(MST.N1ST_TS_POD_CD,  NVL(BKG.TS_POD_CD3, '#@'))     LIKE '%'||NVL(BKG.TS_POD_CD3, '#@')||'%')        
                            -- T/S -> POD NODE(LOC+00)        
                            AND (NVL(MST.TS_POD_NOD_CD, NVL(BKG.TS_POD_NOD_CD1, '#@'))  LIKE '%'||NVL(BKG.TS_POD_NOD_CD1, '#@')||'%'        
                             OR NVL(MST.TS_POD_NOD_CD,  NVL(BKG.TS_POD_NOD_CD2, '#@'))  LIKE '%'||NVL(BKG.TS_POD_NOD_CD2, '#@')||'%'        
                             OR NVL(MST.TS_POD_NOD_CD,  NVL(BKG.TS_POD_NOD_CD3, '#@'))  LIKE '%'||NVL(BKG.TS_POD_NOD_CD3, '#@')||'%')        
                            -- POD/NODE        
                            AND NVL(MST.POD_CNT_CD,    NVL(BKG.POD_CNT_CD, '#@'))      LIKE '%'||NVL(BKG.POD_CNT_CD, '#@')||'%'        
                            AND NVL(MST.POD_CD,        NVL(BKG.POD_CD, '#@'))          LIKE '%'||NVL(BKG.POD_CD, '#@')||'%'        
                            AND NVL(MST.POD_NOD_CD,    NVL(BKG.POD_NOD_CD, '#@'))      LIKE '%'||NVL(BKG.POD_NOD_CD, '#@')||'%'        
                            -- DEL/NODE        
                            AND NVL(MST.DEL_CNT_CD,    NVL(BKG.DEL_CNT_CD, '#@'))      LIKE '%'||NVL(BKG.DEL_CNT_CD, '#@')||'%'        
                            AND NVL(MST.DEL_CD,        NVL(BKG.DEL_CD, '#@'))          LIKE '%'||NVL(BKG.DEL_CD, '#@')||'%'        
                            AND NVL(MST.DEL_NOD_CD,    NVL(BKG.DEL_NOD_CD, '#@'))      LIKE '%'||NVL(BKG.DEL_NOD_CD, '#@')||'%'       
                                    
                            AND NVL(MST.OB_SLS_OFC_CD(+), BKG.OB_SLS_OFC_CD)               = BKG.OB_SLS_OFC_CD        
                            AND NVL(MST.RVIS_CNTR_CUST_TP_CD(+), BKG.RVIS_CNTR_CUST_TP_CD) = BKG.RVIS_CNTR_CUST_TP_CD        
                            AND NVL(BKG.AGMT_ACT_CNT_CD, 'XX999999') IN (         
                                NVL( (SELECT CD.CUST_CNT_CD || LPAD(CD.CUST_SEQ, 6, '0')        
                                        FROM SPC_BKG_ALOC_MGMT_CUST_DTL CD        
                                       WHERE CD.BKG_ALOC_SEQ = MST.BKG_ALOC_SEQ ), NVL(BKG.AGMT_ACT_CNT_CD, 'XX999999')) )        
                            AND NVL(MST.OFT_CHG_AMT(+), NVL(BKG.OFT_CHG_AMT, 0)) >= NVL(BKG.OFT_CHG_AMT, 0)        
                            AND NVL(MST.USA_BKG_MOD_CD(+), NVL(BKG.USA_BKG_MOD_CD, 'OTH')) = NVL(BKG.USA_BKG_MOD_CD, 'OTH')        
                            AND CASE v_mst_smp_flg WHEN 'N' THEN ( CASE NVL(MST.CMPB_AMT, 0) WHEN 0 THEN 1 ELSE MST.CMPB_AMT END)         
                                                    ELSE (CASE MST.CMPB_ONY_FLG WHEN 'Y' THEN 0 ELSE MST.CMPB_AMT END)         
                                                    END         
                                                    >         
                                CASE v_mst_smp_flg WHEN 'N' THEN ( CASE NVL(MST.CMPB_AMT, 0) WHEN 0 THEN 0 ELSE BKG.CMPB_AMT END)         
                                                    ELSE (CASE MST.CMPB_ONY_FLG WHEN 'Y' THEN 0 ELSE BKG.CMPB_AMT END) END        
                            AND (CASE NVL(MST.CMPB_PER_TON_AMT,0) WHEN 0 THEN 1 ELSE NVL(MST.CMPB_PER_TON_AMT,1) END) >= (CASE NVL(MST.CMPB_PER_TON_AMT,0) WHEN 0 THEN 0 ELSE NVL(BKG.CMPB_PER_TON_AMT,0) END)           
                            AND (CASE NVL(MST.TON_PER_TEU_WGT,0) WHEN 0 THEN 0 ELSE NVL(MST.TON_PER_TEU_WGT,1) END) <= (CASE NVL(MST.TON_PER_TEU_WGT,0) WHEN 0 THEN 1 ELSE NVL(BKG.TON_PER_TEU_WGT,0) END)           
                        GROUP BY BKG.VVD_SEQ        
                            , MST.BKG_ALOC_SEQ        
                            , MST.ALOC_SVC_CD        
                            , MST.BKG_CTRL_TP_CD         
                            , MST.ALOC_LOD_QTY        
                            , MST.ALOC_LOD_QTY_RTO        
                            , MST.CMPB_AMT        
                            , MST.ASGN_TTL_WGT        
                            , MST.ASGN_WGT_RTO        
                            , MST.CMPB_ONY_FLG         
                            , MST.CNTR_QTY          
                            , MST.BKG_ALOC_RMK       
                      )         
                  WHERE SB_BKG_YN = 'Y'        
                  )        
                             
                ---------------------------------------------------------------------------------------        
                        
                 SELECT MAX(DECODE(ALOC_STS_CD, 'S', ALOC_STS_CD)) V_MST_S_RLST        
                      , MAX(DECODE(ALOC_STS_CD, 'S', ALOC_SVC_CD)) V_MST_S_SVC_CD        
                      , MAX(DECODE(ALOC_STS_CD, 'S', BKG_ALOC_SEQ)) V_MST_S_SEQ        
                      , MAX(DECODE(ALOC_STS_CD, 'S', LST_SB_RS)) V_MST_S_RS        
                      , MAX(DECODE(ALOC_STS_CD, 'S', MODI_SEQ)) V_MODI_S_SEQ        
                      , MAX(DECODE(ALOC_STS_CD, 'A', ALOC_STS_CD)) A_MST_S_RLST        
                      , MAX(DECODE(ALOC_STS_CD, 'A', ALOC_SVC_CD)) A_MST_S_SVC_CD        
                      , MAX(DECODE(ALOC_STS_CD, 'A', BKG_ALOC_SEQ)) A_MST_S_SEQ        
                      , MAX(DECODE(ALOC_STS_CD, 'A', LST_SB_RS)) A_MST_S_RS        
                      , MAX(DECODE(ALOC_STS_CD, 'A', MODI_SEQ)) A_MODI_S_SEQ      
                   INTO v_mst_s_rlst, v_mst_s_svc_cd, v_mst_s_seq ,  v_mst_s_rs, v_modi_s_seq    
                      , a_mst_s_rlst, a_mst_s_svc_cd, a_mst_s_seq ,  a_mst_s_rs, a_modi_s_seq         
                  FROM (         
                       SELECT ALOC_STS_CD,ALOC_SVC_CD,BKG_ALOC_SEQ,LST_SB_RS,MODI_SEQ    
                         FROM (                              
                               SELECT BKG_CTRL_TP_CD AS ALOC_STS_CD        
                                    , ALOC_SVC_CD        
                                    , BKG_ALOC_SEQ              
                                    , 'Type:TS ('           ||VVD_SEQ               
                                            ||') , T.LANE:'       ||SLAN_CD               
                                            ||', RHQ:'          ||bkg_list.rhq_cd              
                                            ||', ALLOCATION:'   ||ALOC_LOD_QTY               
                                            ||', TTL:'          ||TEU_TTL               
                                            ||', TS RATIO:'     ||TS_RATIO               
                                            ||', TS%THRESHOLD:'   ||ALOC_LOD_QTY_RTO               
                                            ||', WGT RATIO:'     ||WGT_RATIO               
                                            ||', WGT%THRESHOLD:'   ||ASGN_WGT_RTO               
                                            ||', SVC:'          ||ALOC_SVC_CD               
                                            ||', REMARK:'       ||BKG_ALOC_RMK               
                                            ||', ' ||'SMP FLG:' ||v_mst_smp_flg                
                                      AS LST_SB_RS               
                                    , MODI_SEQ         
                                    , DENSE_RANK() OVER(PARTITION BY BKG_CTRL_TP_CD ORDER BY BKG_CTRL_TP_CD) F_ROW      
                                FROM G_SUM               
                               WHERE 1=1         
				 -- [2015.11.12]        
                                 AND DECODE(ALOC_LOD_QTY, 0, 1, ROUND(TEU_TTL/ALOC_LOD_QTY * 100,1))        > DECODE(ALOC_LOD_QTY, 0, 0, ALOC_LOD_QTY_RTO)                  
                                 AND DECODE(ASGN_TTL_WGT, 0, 1, ROUND(TTL_WGT/ASGN_TTL_WGT * 100,1))        > DECODE(ASGN_TTL_WGT, 0, 0, ASGN_WGT_RTO)                 
                                 AND DECODE(CNTR_QTY, 0, 1, ROUND(TTL_CNTR_QTY/CNTR_QTY * 100,1))           > DECODE(CNTR_QTY, 0, 0, TS_BOX_RATIO)           
				           
                                    -- SMP대상은 CMPB_ONY_FLG='Y'인 조건은 해당 룰을 적용하지 않고, 나머지는 적용한다.               
                                 AND CASE v_mst_smp_flg WHEN 'N' THEN ( CASE NVL(CMPB_AMT,0) WHEN 0 THEN 1 ELSE CMPB_AMT END)                
                                                         ELSE (CASE CMPB_ONY_FLG WHEN 'Y' THEN 0 ELSE CMPB_AMT END) END               
                                        >                
                                     CASE v_mst_smp_flg WHEN 'N' THEN ( CASE NVL(CMPB_AMT,0) WHEN 0 THEN 0 ELSE TO_NUMBER(bkg_list.cmpb) END)                
                                                         ELSE (CASE CMPB_ONY_FLG WHEN 'Y' THEN 0 ELSE TO_NUMBER(bkg_list.cmpb) END) END           
                   ) WHERE F_ROW=1             
                 ) ;                  
             
              
                         
                EXCEPTION               
                        WHEN NO_DATA_FOUND THEN               
                        v_mst_s_rlst := NULL;               
                        v_mst_s_svc_cd := NULL;               
                        v_mst_s_seq := NULL;               
                        v_mst_s_rs := NULL;               
                        v_modi_s_seq := NULL;               
                        a_mst_s_rlst := NULL;               
                        a_mst_s_svc_cd := NULL;               
                        a_mst_s_seq := NULL;               
                        a_mst_s_rs := NULL;               
                        a_modi_s_seq := NULL;                
                END;               
                    
                enis_log_prc(SYSDATE, v_prc_nm, v_step || ': '|| NVL(v_mst_s_rlst,'N'), v_appl_info);       
                                
                /************************************************************************               
                 1.3 Customer               
                ************************************************************************/               
                v_step := '1-3. MasterTable-Customer';                  
                BEGIN               
                WITH BKG AS ( --BKG이 속한 VVD의 모든 BKG정보               
                SELECT  T.*        
                            , ROUND(T.CMPB_AMT/T.WGT,2)  AS CMPB_PER_TON_AMT        
                            , ROUND(T.WGT/T.OP_CNTR_QTY,2)  AS TON_PER_TEU_WGT        
                FROM (          
                    SELECT BK.BKG_NO, BK.SLAN_CD TRNK_SLAN_CD               
                         , BK.SKD_DIR_CD TRNK_DIR_CD               
                         , BK.POR_CD                POR_LOC_CD               
                         , BK.POR_NOD_CD            POR_NOD_CD               
                         , (SELECT SCC_CD FROM MDM_LOCATION LOC WHERE LOC.LOC_CD = BK.POR_CD) POR_SCC_CD               
                         , BK.POL_CD                POL_LOC_CD               
                         , BK.POL_NOD_CD            POL_NOD_CD               
                         , BK.POD_CD                POD_LOC_CD               
                         , BK.POD_NOD_CD            POD_NOD_CD               
                         , BK.DEL_CD                DEL_LOC_CD               
                         , BK.DEL_NOD_CD            DEL_NOD_CD               
                         , (SELECT SCC_CD FROM MDM_LOCATION LOC WHERE LOC.LOC_CD = BK.DEL_CD) DEL_SCC_CD               
                         , BK.OB_SLS_OFC_CD               
                         , QTY.CNTR_TPSZ_CD               
                         , DECODE(SPC_GET_CNTR_SZ_FNC(QTY.CNTR_TPSZ_CD), '2', 1, 2) * QTY.OP_CNTR_QTY OP_CNTR_QTY               
                         ,  (SELECT SPC_GET_CMPB_FNC(BK.BKG_NO, NULL) FROM DUAL) AS CMPB_AMT     
                         , BK.SC_NO               
                         , BK.RFA_NO               
                         , BK.CTRT_CUST_CNT_CD               
                         , BK.CTRT_CUST_SEQ               
                         , SHPR.CUST_CNT_CD               
                         , SHPR.CUST_SEQ               
                         , NVL(BK.ALOC_STS_CD, 'X') ALOC_STS_CD               
                          ,BK.AGMT_ACT_CNT_CD               
                          ,BK.AGMT_ACT_CUST_SEQ               
                          ,bkg_list.SUB_TRD_CD SUB_TRD_CD               
						 , NVL( (SELECT SUM(R.CHG_UT_AMT) FROM BKG_CHG_RT R WHERE R.BKG_NO = BK.BKG_NO AND R.CHG_CD = 'OFT')       
						 	   ,(SELECT MIN(OFT_AMT) KEEP (DENSE_RANK LAST ORDER BY A.REV_COST_SEQ) FROM BKG_REV_COST A WHERE A.BKG_NO = BK.BKG_NO)) AS OFT_CHG_AMT           
                          ,CASE WHEN (SUBSTR(BK.POR_CD, 1, 2) IN ('CA', 'US') OR SUBSTR(BK.DEL_CD, 1, 2) IN ('CA', 'US'))               
                                    THEN (SELECT SPC_USA_MODE_FNC(BK.RCV_TERM_CD, BK.DE_TERM_CD, BK.POR_CD, BK.POL_CD, BK.POD_CD, BK.DEL_CD) FROM DUAL)               
                                    ELSE 'OTH' END USA_BKG_MOD_CD               
                          ,bkg_list.SLS_WK SLS_WK               
                          ,(SELECT                
                             SUM((D.ACT_WGT * DECODE(D.WGT_UT_CD, 'LBS', 0.00045, 0.001))               
                                  + SUM(Q.OP_CNTR_QTY * ( SELECT TS.CNTR_TPSZ_TARE_WGT               
                                                         FROM MDM_CNTR_TP_SZ TS               
                                                         WHERE TS.CNTR_TPSZ_CD = Q.CNTR_TPSZ_CD)) * 0.001               
                                ) WGT_TTL               
                              FROM BKG_QUANTITY Q               
                              WHERE BK.BKG_NO      = Q.BKG_NO               
                              AND Q.OP_CNTR_QTY > 0               
                              GROUP BY D.ACT_WGT * DECODE(D.WGT_UT_CD, 'LBS', 0.00045, 0.001)               
                          ) WGT                              
						,(SELECT RVIS_CNTR_CUST_TP_CD FROM MDM_CUSTOMER M WHERE BK.CTRT_CUST_CNT_CD = M.CUST_CNT_CD AND BK.CTRT_CUST_SEQ = M.CUST_SEQ) AS RVIS_CNTR_CUST_TP_CD               
						,CASE WHEN QTY.CNTR_TPSZ_CD LIKE 'R%' THEN QTY.OP_CNTR_QTY - EQ_SUBST_CGO_QTY ELSE OP_CNTR_QTY END AS CNTR_QTY  
						,NVL((SELECT PSC.SCG_GRP_CMDT_SEQ               
                                 FROM PRI_SCG_GRP_CMDT_DTL PSC               
                                WHERE PSC.SVC_SCP_CD = 'TPW'               
                                  AND PSC.CHG_CD = 'GRI'               
                                  AND PSC.CMDT_CD = BK.CMDT_CD               
                                  AND ROWNUM = 1),9999) GRP_CMDT_CD            
						,(SELECT CUST_GRP_ID FROM MDM_CUSTOMER C WHERE BK.CTRT_CUST_CNT_CD = C.CUST_CNT_CD AND BK.CTRT_CUST_SEQ = C.CUST_SEQ) AS CUST_GRP_ID								         
                        ,(SELECT MIN(RFA_CTRT_TP_CD) KEEP (DENSE_RANK LAST ORDER BY AMDT_SEQ) FROM PRI_RP_HDR A,PRI_RP_MN B WHERE A.PROP_NO= B.PROP_NO AND PROP_STS_CD = 'A' AND A.RFA_NO= BK.RFA_NO) AS RFA_CTRT_TP_CD       
                      FROM BKG_BOOKING BK, BKG_BL_DOC D,BKG_QUANTITY QTY, BKG_CUSTOMER SHPR, SPC_OFC_LVL LVL               
                     WHERE BK.VSL_CD      = DECODE(bkg_list.ORG_VVD, NULL, bkg_list.VSL_CD, SUBSTR(bkg_list.ORG_VVD, 1, 4)) -- FDR 처리               
                       AND BK.SKD_VOY_NO  = DECODE(bkg_list.ORG_VVD, NULL, bkg_list.SKD_VOY_NO, SUBSTR(bkg_list.ORG_VVD, 5, 4)) -- FDR 처리               
                       AND BK.SKD_DIR_CD  = DECODE(bkg_list.ORG_VVD, NULL, bkg_list.DIR_CD, SUBSTR(bkg_list.ORG_VVD, -1)) -- FDR 처리               
                       AND (NVL(BK.ALOC_STS_CD, 'X') = 'F' OR BK.BKG_NO = v_appl_info)               
					   AND BK.BKG_STS_CD            <> 'X'  
                       --------------------------------               
                       AND BK.BKG_NO      = QTY.BKG_NO               
                       AND BK.BKG_NO      = SHPR.BKG_NO               
                       AND SHPR.BKG_CUST_TP_CD = 'S'                 
                       AND BK.BKG_NO      = D.BKG_NO					                  
                       AND bkg_list.SLS_WK BETWEEN LVL.OFC_APLY_FM_YRWK AND LVL.OFC_APLY_TO_YRWK               
                       AND LVL.N2ND_PRNT_OFC_CD = bkg_list.RHQ_CD               
                       AND LVL.OFC_CD = SPC_SCR_OFC_CONV_FNC(BK.OB_SLS_OFC_CD, '')               
    ) T       
                )               
                , G_SUM AS (               
                    SELECT * FROM (               
                        SELECT ALOC.BKG_ALOC_SEQ  ,BKG_CTRL_TP_CD             
                             , ALOC.ALOC_SVC_CD               
                             , NVL(ALOC.CMPB_AMT, 0) CMPB_AMT               
                             , NVL(ALOC.ALOC_LOD_QTY, 0) ALOC_LOD_QTY               
                             , DECODE(NVL(ALOC.ALOC_LOD_QTY, 0), 0, 0, NVL(ALOC.ALOC_LOD_QTY_RTO, 100)) ALOC_LOD_QTY_RTO  --ratio가 없으면 물량의 100%               
                             , DECODE(NVL(ALOC.OP_CNTR_QTY, 0), 0, 0, NVL(ALOC.ALOC_LOD_QTY_RTO, 100)) ALOC_LOD_QTY_BOX_RTO               
                             , BKG.SC_NO               
                             , BKG.RFA_NO               
                             , SUM(DECODE(T.BKG_NO, v_appl_info, 0, T.OP_CNTR_QTY)) F_TTL_QTY --전체 Confirm 갯수               
                             , SUM(DECODE(T.BKG_NO, v_appl_info, BKG.OP_CNTR_QTY,0)) BKG_QTY --현재 BKG의 갯수 v_appl_info               
                             , SUM(T.OP_CNTR_QTY) TTL_QTY               
                             , SUM(T.WGT) TTL_WGT  /*WGT합계*/               
                             , NVL(ASGN_TTL_WGT, 0) ASGN_TTL_WGT  /*할당된WG합계*/               
                             , DECODE(NVL(ALOC.ASGN_TTL_WGT, 0), 0, 0, NVL(ALOC.ASGN_WGT_RTO, 100)) ASGN_WGT_RTO  /*할당된WG비율*/               
                             , ALOC.CMPB_ONY_FLG                
							 , NVL(ALOC.OP_CNTR_QTY, 0) CNTR_QTY                  
							 , SUM(T.CNTR_QTY) TTL_CNTR_QTY                  
                             , ( SELECT NVL( MAX(MODI_SEQ) , 1) MODI_SEQ FROM SPC_BKG_ALOC_MGMT_HIS WHERE BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ ) MODI_SEQ --**      
                          FROM (SELECT * FROM BKG WHERE BKG_NO = v_appl_info) BKG, BKG T, SPC_BKG_ALOC_MGMT ALOC               
                         WHERE ALOC.BKG_ALOC_TP_CD = 'C'               
                           AND ALOC.ALOC_USE_FLG   = 'Y'               
                           AND ALOC.SLS_RHQ_CD = bkg_list.RHQ_CD               
                           -------------------------------------------------------------------------               
                           AND BKG.TRNK_SLAN_CD  = NVL(ALOC.TRNK_SLAN_CD,      BKG.TRNK_SLAN_CD)               
						   AND BKG.RVIS_CNTR_CUST_TP_CD  = NVL(ALOC.RVIS_CNTR_CUST_TP_CD,      BKG.RVIS_CNTR_CUST_TP_CD)	               
                           AND BKG.TRNK_DIR_CD   = NVL(ALOC.TRNK_DIR_CD,       BKG.TRNK_DIR_CD)               
                           AND BKG.OB_SLS_OFC_CD = NVL(ALOC.OB_SLS_OFC_CD,     BKG.OB_SLS_OFC_CD)               
						   AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POR' AND LENGTH(LD.SB_LOC_CD) = 5),BKG.POR_LOC_CD) LIKE '%'||BKG.POR_LOC_CD||'%'                                     
                           AND BKG.POR_NOD_CD    = NVL(ALOC.POR_NOD_CD,        BKG.POR_NOD_CD)               
                           AND BKG.POR_SCC_CD    = NVL(ALOC.BKG_POR_SCC_CD,    BKG.POR_SCC_CD)                                          
						   AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POL' AND LENGTH(LD.SB_LOC_CD) = 5),BKG.POL_LOC_CD) LIKE '%'||BKG.POL_LOC_CD||'%'                                     
                           AND BKG.POL_NOD_CD    = NVL(ALOC.POL_NOD_CD,        BKG.POL_NOD_CD)               
						   AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POD' AND LENGTH(LD.SB_LOC_CD) = 5),BKG.POD_LOC_CD) LIKE '%'||BKG.POD_LOC_CD||'%'                                     
                           AND BKG.POD_NOD_CD    = NVL(ALOC.POD_NOD_CD,        BKG.POD_NOD_CD)                                         
						   AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(LD.SB_LOC_CD) = 5),BKG.DEL_LOC_CD) LIKE '%'||BKG.DEL_LOC_CD||'%'                                     
                           AND BKG.DEL_NOD_CD    = NVL(ALOC.DEL_NOD_CD,        BKG.DEL_NOD_CD)               
                           AND BKG.DEL_SCC_CD    = NVL(ALOC.BKG_DEL_SCC_CD,    BKG.DEL_SCC_CD)               
                           AND NVL(BKG.SC_NO,'A')         = NVL(ALOC.SC_NO,             NVL(BKG.SC_NO,'A'))               
                           AND NVL(BKG.RFA_NO,'A')        = NVL(ALOC.RFA_NO,            NVL(BKG.RFA_NO,'A'))               
                           AND BKG.CTRT_CUST_CNT_CD = NVL(ALOC.CTRT_CUST_CNT_CD,BKG.CTRT_CUST_CNT_CD)               
                           AND BKG.CTRT_CUST_SEQ    = NVL(ALOC.CTRT_CUST_SEQ,   BKG.CTRT_CUST_SEQ)               
                           AND BKG.CUST_CNT_CD      = NVL(ALOC.CUST_CNT_CD,     BKG.CUST_CNT_CD)         
						   AND BKG.CUST_GRP_ID      = NVL(ALOC.CUST_GRP_ID,     BKG.CUST_GRP_ID) 						          
                           AND BKG.RFA_CTRT_TP_CD   = NVL(ALOC.RFA_CTRT_TP_CD,      BKG.RFA_CTRT_TP_CD)       
                           AND BKG.CUST_SEQ         = NVL(ALOC.CUST_SEQ,        BKG.CUST_SEQ)               
						   AND BKG.GRP_CMDT_CD      = NVL(ALOC.SCG_GRP_CMDT_SEQ,BKG.GRP_CMDT_CD)               
                           --AND BKG.CNTR_TPSZ_CD     = NVL(ALOC.CNTR_TPSZ_CD,    BKG.CNTR_TPSZ_CD)               
						   AND   NVL((SELECT WM_CONCAT(LD.CNTR_TPSZ_CD) FROM SPC_BKG_ALOC_MGMT_TP_SZ_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ ),BKG.CNTR_TPSZ_CD) LIKE '%'||BKG.CNTR_TPSZ_CD||'%'                 
						   AND   NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POR' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(BKG.POR_LOC_CD,1,2)) LIKE '%'||SUBSTR(BKG.POR_LOC_CD,1,2)||'%'               
						   AND   NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POL' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(BKG.POL_LOC_CD,1,2)) LIKE '%'||SUBSTR(BKG.POL_LOC_CD,1,2)||'%'               
						   AND   NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POD' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(BKG.POD_LOC_CD,1,2)) LIKE '%'||SUBSTR(BKG.POD_LOC_CD,1,2)||'%'               
						   AND   NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(BKG.DEL_LOC_CD,1,2)) LIKE '%'||SUBSTR(BKG.DEL_LOC_CD,1,2)||'%'			                 
                           --NYCRA제외 추가항목               
                           AND BKG.SLS_WK BETWEEN NVL(ALOC.APLY_FM_YRWK, '201501') AND NVL(ALOC.APLY_TO_YRWK, '209953') -- Week 기준 추가               
                           AND BKG.SUB_TRD_CD = NVL(ALOC.SUB_TRD_CD, BKG.SUB_TRD_CD)               
                           AND NVL(BKG.AGMT_ACT_CNT_CD, 'XX999999') IN (                  
                                NVL((SELECT CD.CUST_CNT_CD || LPAD(CD.CUST_SEQ, 6, '0') FROM SPC_BKG_ALOC_MGMT_CUST_DTL CD WHERE CD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ), NVL(BKG.AGMT_ACT_CNT_CD, 'XX999999'))                  
                           )                  
                           AND NVL(ALOC.OFT_CHG_AMT, NVL(BKG.OFT_CHG_AMT, 0)) >= NVL(BKG.OFT_CHG_AMT, 0)                  
                           AND NVL(ALOC.USA_BKG_MOD_CD, NVL(BKG.USA_BKG_MOD_CD, 'OTH')) = NVL(BKG.USA_BKG_MOD_CD, 'OTH')                  
                           AND CASE v_mst_smp_flg WHEN 'N' THEN ( CASE NVL(ALOC.CMPB_AMT,0) WHEN 0 THEN 1 ELSE ALOC.CMPB_AMT END)                
                                                ELSE (CASE ALOC.CMPB_ONY_FLG WHEN 'Y' THEN 0 ELSE ALOC.CMPB_AMT END)               
                                END               
                                >                
                                CASE v_mst_smp_flg WHEN 'N' THEN ( CASE NVL(ALOC.CMPB_AMT,0) WHEN 0 THEN 0 ELSE BKG.CMPB_AMT END)                
                                                    ELSE (CASE ALOC.CMPB_ONY_FLG WHEN 'Y' THEN 0 ELSE BKG.CMPB_AMT END)               
                                END                          
                           AND T.TRNK_SLAN_CD  = NVL(ALOC.TRNK_SLAN_CD,      T.TRNK_SLAN_CD)               
                           AND T.TRNK_DIR_CD   = NVL(ALOC.TRNK_DIR_CD,       T.TRNK_DIR_CD)               
                           AND T.OB_SLS_OFC_CD = NVL(ALOC.OB_SLS_OFC_CD,     T.OB_SLS_OFC_CD)               
                           AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POR' AND LENGTH(LD.SB_LOC_CD) = 5),T.POR_LOC_CD) LIKE '%'||T.POR_LOC_CD||'%'               
                           AND T.POR_NOD_CD    = NVL(ALOC.POR_NOD_CD,        T.POR_NOD_CD)               
                           AND T.POR_SCC_CD    = NVL(ALOC.BKG_POR_SCC_CD,    T.POR_SCC_CD)               
                           AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POL' AND LENGTH(LD.SB_LOC_CD) = 5),T.POL_LOC_CD) LIKE '%'||T.POL_LOC_CD||'%'               
                           AND T.POL_NOD_CD    = NVL(ALOC.POL_NOD_CD,        T.POL_NOD_CD)               
                           AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POD' AND LENGTH(LD.SB_LOC_CD) = 5),T.POD_LOC_CD) LIKE '%'||T.POD_LOC_CD||'%'               
                           AND T.POD_NOD_CD    = NVL(ALOC.POD_NOD_CD,        T.POD_NOD_CD)                                          
                           AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(LD.SB_LOC_CD) = 5),T.DEL_LOC_CD) LIKE '%'||T.DEL_LOC_CD||'%'               
                           AND T.DEL_NOD_CD    = NVL(ALOC.DEL_NOD_CD,        T.DEL_NOD_CD)               
                           AND T.DEL_SCC_CD    = NVL(ALOC.BKG_DEL_SCC_CD,    T.DEL_SCC_CD)               
                           AND NVL(T.SC_NO,'A')         = NVL(ALOC.SC_NO,             NVL(T.SC_NO,'A'))               
                           AND NVL(T.RFA_NO,'A')        = NVL(ALOC.RFA_NO,            NVL(T.RFA_NO,'A'))               
                           AND T.CTRT_CUST_CNT_CD = NVL(ALOC.CTRT_CUST_CNT_CD,T.CTRT_CUST_CNT_CD)               
                           AND T.CTRT_CUST_SEQ    = NVL(ALOC.CTRT_CUST_SEQ,   T.CTRT_CUST_SEQ)               
                           AND T.CUST_CNT_CD      = NVL(ALOC.CUST_CNT_CD,     T.CUST_CNT_CD)       
						   AND T.CUST_GRP_ID      = NVL(ALOC.CUST_GRP_ID,     T.CUST_GRP_ID)						          
                           AND T.RFA_CTRT_TP_CD  = NVL(ALOC.RFA_CTRT_TP_CD,   T.RFA_CTRT_TP_CD)        
                           AND T.CUST_SEQ         = NVL(ALOC.CUST_SEQ,        T.CUST_SEQ)               
                           --AND T.CNTR_TPSZ_CD     = NVL(ALOC.CNTR_TPSZ_CD,    T.CNTR_TPSZ_CD)               
                           AND NVL((SELECT WM_CONCAT(LD.CNTR_TPSZ_CD) FROM SPC_BKG_ALOC_MGMT_TP_SZ_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ ),T.CNTR_TPSZ_CD) LIKE '%'||T.CNTR_TPSZ_CD||'%'                 
                           AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POR' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(T.POR_LOC_CD,1,2)) LIKE '%'||SUBSTR(T.POR_LOC_CD,1,2)||'%'               
                           AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POL' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(T.POL_LOC_CD,1,2)) LIKE '%'||SUBSTR(T.POL_LOC_CD,1,2)||'%'               
                           AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POD' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(T.POD_LOC_CD,1,2)) LIKE '%'||SUBSTR(T.POD_LOC_CD,1,2)||'%'               
                           AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(T.DEL_LOC_CD,1,2)) LIKE '%'||SUBSTR(T.DEL_LOC_CD,1,2)||'%'               
                           AND T.SLS_WK BETWEEN NVL(ALOC.APLY_FM_YRWK, '201501') AND NVL(ALOC.APLY_TO_YRWK, '209953') -- Week 기준 추가               
                           AND T.SUB_TRD_CD = NVL(ALOC.SUB_TRD_CD, T.SUB_TRD_CD)               
                           AND NVL(T.AGMT_ACT_CNT_CD, 'XX999999') IN (                  
                                NVL((SELECT CD.CUST_CNT_CD || LPAD(CD.CUST_SEQ, 6, '0') FROM SPC_BKG_ALOC_MGMT_CUST_DTL CD WHERE CD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ), NVL(T.AGMT_ACT_CNT_CD, 'XX999999'))                  
                           )                  
                           AND NVL(ALOC.OFT_CHG_AMT, NVL(T.OFT_CHG_AMT, 0)) >= NVL(T.OFT_CHG_AMT, 0)                  
                           AND NVL(ALOC.USA_BKG_MOD_CD, NVL(T.USA_BKG_MOD_CD, 'OTH')) = NVL(T.USA_BKG_MOD_CD, 'OTH')                
                           AND CASE v_mst_smp_flg WHEN 'N' THEN ( CASE NVL(ALOC.CMPB_AMT,0) WHEN 0 THEN 1 ELSE ALOC.CMPB_AMT END)                
                                                ELSE (CASE ALOC.CMPB_ONY_FLG WHEN 'Y' THEN 0 ELSE ALOC.CMPB_AMT END)               
                                END               
                                >                
                                CASE v_mst_smp_flg WHEN 'N' THEN ( CASE NVL(ALOC.CMPB_AMT,0) WHEN 0 THEN 0 ELSE T.CMPB_AMT END)                
                                                    ELSE (CASE ALOC.CMPB_ONY_FLG WHEN 'Y' THEN 0 ELSE T.CMPB_AMT END)               
                                END                                          
                            AND (CASE NVL(ALOC.CMPB_PER_TON_AMT,0) WHEN 0 THEN 1 ELSE NVL(ALOC.CMPB_PER_TON_AMT,1) END) >= (CASE NVL(ALOC.CMPB_PER_TON_AMT,0) WHEN 0 THEN 0 ELSE NVL(T.CMPB_PER_TON_AMT,0) END)           
                            AND (CASE NVL(ALOC.TON_PER_TEU_WGT,0) WHEN 0 THEN 0 ELSE NVL(ALOC.TON_PER_TEU_WGT,1) END) <= (CASE NVL(ALOC.TON_PER_TEU_WGT,0) WHEN 0 THEN 1 ELSE NVL(T.TON_PER_TEU_WGT,0) END)                                                             
                           GROUP BY               
                               ALOC.BKG_ALOC_SEQ  ,BKG_CTRL_TP_CD             
                             , ALOC.ALOC_SVC_CD               
                             , ALOC.CMPB_AMT               
                             , ALOC_LOD_QTY               
                             , ALOC_LOD_QTY_RTO               
                             , BKG.SC_NO               
                             , BKG.RFA_NO               
                             , ALOC.BKG_ALOC_RMK               
                             , ASGN_TTL_WGT                
                             , ASGN_WGT_RTO               
                             , CMPB_ONY_FLG               
                             , ALOC.OP_CNTR_QTY                
                         )               
                     WHERE 1=1               
                        AND (               
                                DECODE(ALOC_LOD_QTY, 0, 1, ROUND(TTL_QTY/ALOC_LOD_QTY * 100,1)) > DECODE(ALOC_LOD_QTY, 0, 0, ALOC_LOD_QTY_RTO)               
                                AND                
                                DECODE(ASGN_TTL_WGT, 0, 1, ROUND(TTL_WGT/ASGN_TTL_WGT * 100,1)) > DECODE(ASGN_TTL_WGT, 0, 0, ASGN_WGT_RTO)                  
                                AND                              
                                DECODE(CNTR_QTY, 0, 1, ROUND(TTL_CNTR_QTY/CNTR_QTY * 100,1)) > DECODE(CNTR_QTY, 0, 0, ALOC_LOD_QTY_BOX_RTO)               
                             )               
                        -- SMP대상은 CMPB_ONY_FLG='Y'인 조건은 해당 룰을 적용하지 않고, 나머지는 적용한다.               
                        AND CASE v_mst_smp_flg WHEN 'N' THEN ( CASE NVL(CMPB_AMT,0) WHEN 0 THEN 1 ELSE CMPB_AMT END)                
                                                ELSE (CASE CMPB_ONY_FLG WHEN 'Y' THEN 0 ELSE CMPB_AMT END)               
                            END               
                            >                
                            CASE v_mst_smp_flg WHEN 'N' THEN ( CASE NVL(CMPB_AMT,0) WHEN 0 THEN 0 ELSE bkg_list.CMPB END)                
                                                ELSE (CASE CMPB_ONY_FLG WHEN 'Y' THEN 0 ELSE bkg_list.CMPB END)               
                            END                                       
               
                )               
SELECT              
      MAX(DECODE(ALOC_STS_CD,'S',ALOC_STS_CD)) V11             
    , MAX(DECODE(ALOC_STS_CD,'S',ALOC_SVC_CD)) V12             
    , MAX(DECODE(ALOC_STS_CD,'S',BKG_ALOC_SEQ)) V13             
    , MAX(DECODE(ALOC_STS_CD,'S',LST_SB_RS)) V14             
    , MAX(DECODE(ALOC_STS_CD,'S',MODI_SEQ)) V15                
    , MAX(DECODE(ALOC_STS_CD,'A',ALOC_STS_CD)) V21             
    , MAX(DECODE(ALOC_STS_CD,'A',ALOC_SVC_CD)) V22             
    , MAX(DECODE(ALOC_STS_CD,'A',BKG_ALOC_SEQ)) V23             
    , MAX(DECODE(ALOC_STS_CD,'A',LST_SB_RS)) V24             
    , MAX(DECODE(ALOC_STS_CD,'A',MODI_SEQ)) V25         
INTO v_mst_c_rlst, v_mst_c_svc_cd, v_mst_c_seq, v_mst_c_rs, v_modi_c_seq         
    ,a_mst_c_rlst, a_mst_c_svc_cd, a_mst_c_seq ,  a_mst_c_rs, a_modi_c_seq                                   
FROM (             
    SELECT ALOC_STS_CD,ALOC_SVC_CD,BKG_ALOC_SEQ,LST_SB_RS,MODI_SEQ    
    FROM (                              
                SELECT BKG_CTRL_TP_CD AS ALOC_STS_CD, ALOC_SVC_CD, BKG_ALOC_SEQ,               
                        'SMP FLG:' || v_mst_smp_flg || ', ' ||', Firm TTL Qty:' || F_TTL_QTY || ', BKG Qty:' || BKG_QTY || ', BKG CMPB:' || bkg_list.CMPB               
                        AS LST_SB_RS             
                        , MODI_SEQ --**               
                        , DENSE_RANK() OVER(PARTITION BY BKG_CTRL_TP_CD ORDER BY BKG_CTRL_TP_CD) F_ROW       
                  FROM G_SUM            
    ) WHERE F_ROW=1             
  )               
                ;               
                EXCEPTION               
                        WHEN NO_DATA_FOUND THEN               
                        v_mst_c_rlst := NULL;               
                        v_mst_c_svc_cd := NULL;               
                        v_mst_c_seq := NULL;               
                        v_mst_c_rs := NULL;               
                        a_mst_c_rlst := NULL;               
                        a_mst_c_svc_cd := NULL;               
                        a_mst_c_seq := NULL;               
                        a_mst_c_rs := NULL;               
                        a_modi_c_seq := NULL;                  
                END;                        
                            
                enis_log_prc(SYSDATE, v_prc_nm, v_step || ': '|| NVL(v_mst_c_rlst,'N'), v_appl_info);      
                                
                /************************************************************************               
                 1.4 Commodity               
                ************************************************************************/               
                v_step := '1-4. MasterTable-Commodity';            
                BEGIN               
                WITH BKG AS (--BKG이 속한 VVD의 모든 BKG정보               
                SELECT  T.*        
                        , ROUND(T.CMPB_AMT/T.WGT,2)  AS CMPB_PER_TON_AMT        
                        , ROUND(T.WGT/T.OP_CNTR_QTY,2)  AS TON_PER_TEU_WGT        
                FROM (         
                    SELECT BK.BKG_NO, BK.SLAN_CD TRNK_SLAN_CD               
                         , BK.SKD_DIR_CD TRNK_DIR_CD               
                         , BK.POR_CD                POR_LOC_CD               
                         , BK.POR_NOD_CD            POR_NOD_CD               
                         , (SELECT SCC_CD FROM MDM_LOCATION LOC WHERE LOC.LOC_CD = BK.POR_CD) POR_SCC_CD               
                         , BK.POL_CD                POL_LOC_CD               
                         , BK.POL_NOD_CD            POL_NOD_CD               
                         , BK.POD_CD                POD_LOC_CD               
                         , BK.POD_NOD_CD            POD_NOD_CD               
                         , BK.DEL_CD                DEL_LOC_CD               
                         , BK.DEL_NOD_CD            DEL_NOD_CD               
                         , (SELECT SCC_CD FROM MDM_LOCATION LOC WHERE LOC.LOC_CD = BK.DEL_CD) DEL_SCC_CD               
                         , BK.OB_SLS_OFC_CD               
                         , BK.CMDT_CD               
                         , QTY.CNTR_TPSZ_CD               
                         , DECODE(SPC_GET_CNTR_SZ_FNC(QTY.CNTR_TPSZ_CD), '2', 1, 2) * QTY.OP_CNTR_QTY OP_CNTR_QTY               
                         , (SELECT SPC_GET_CMPB_FNC(BK.BKG_NO, NULL) FROM DUAL) AS CMPB_AMT         
                          ,BK.AGMT_ACT_CNT_CD               
                          ,BK.AGMT_ACT_CUST_SEQ               
                          ,bkg_list.SUB_TRD_CD SUB_TRD_CD               
						 , NVL( (SELECT SUM(R.CHG_UT_AMT) FROM BKG_CHG_RT R WHERE R.BKG_NO = BK.BKG_NO AND R.CHG_CD = 'OFT')       
						 	   ,(SELECT MIN(OFT_AMT) KEEP (DENSE_RANK LAST ORDER BY A.REV_COST_SEQ) FROM BKG_REV_COST A WHERE A.BKG_NO = BK.BKG_NO)) AS OFT_CHG_AMT           
                          ,CASE WHEN (SUBSTR(BK.POR_CD, 1, 2) IN ('CA', 'US') OR SUBSTR(BK.DEL_CD, 1, 2) IN ('CA', 'US'))               
                                    THEN (SELECT SPC_USA_MODE_FNC(BK.RCV_TERM_CD, BK.DE_TERM_CD, BK.POR_CD, BK.POL_CD, BK.POD_CD, BK.DEL_CD) FROM DUAL)               
                                    ELSE 'OTH' END USA_BKG_MOD_CD               
                         ,NVL((SELECT PSC.SCG_GRP_CMDT_SEQ               
                             FROM PRI_SCG_GRP_CMDT_DTL PSC               
                            WHERE PSC.SVC_SCP_CD = 'TPW'               
                              AND PSC.CHG_CD = 'GRI'               
                              AND PSC.CMDT_CD = BK.CMDT_CD               
                              AND ROWNUM = 1),9999) GRP_CMDT_CD               
                         , BK.SC_NO               
                         , BK.RFA_NO               
                         , NVL(BK.ALOC_STS_CD, 'X') ALOC_STS_CD               
                          ,bkg_list.SLS_WK SLS_WK               
                         ,(SELECT                
                             SUM((D.ACT_WGT * DECODE(D.WGT_UT_CD, 'LBS', 0.00045, 0.001))               
                                  + SUM(Q.OP_CNTR_QTY * ( SELECT TS.CNTR_TPSZ_TARE_WGT               
                                                         FROM MDM_CNTR_TP_SZ TS               
                                                         WHERE TS.CNTR_TPSZ_CD = Q.CNTR_TPSZ_CD)) * 0.001               
                                ) WGT_TTL               
                              FROM BKG_QUANTITY Q               
                              WHERE BK.BKG_NO      = Q.BKG_NO               
                              AND Q.OP_CNTR_QTY > 0               
                              GROUP BY D.ACT_WGT * DECODE(D.WGT_UT_CD, 'LBS', 0.00045, 0.001)               
                          ) WGT               
						 ,(SELECT RVIS_CNTR_CUST_TP_CD FROM MDM_CUSTOMER M WHERE BK.CTRT_CUST_CNT_CD = M.CUST_CNT_CD AND BK.CTRT_CUST_SEQ = M.CUST_SEQ) AS RVIS_CNTR_CUST_TP_CD						                 
						 ,CASE WHEN QTY.CNTR_TPSZ_CD LIKE 'R%' THEN QTY.OP_CNTR_QTY - EQ_SUBST_CGO_QTY ELSE OP_CNTR_QTY END AS CNTR_QTY  
                      FROM BKG_BOOKING BK, BKG_BL_DOC D,BKG_QUANTITY QTY, SPC_OFC_LVL LVL               
                     WHERE BK.VSL_CD      = DECODE(bkg_list.ORG_VVD, NULL, bkg_list.VSL_CD, SUBSTR(bkg_list.ORG_VVD, 1, 4)) -- FDR 처리               
                       AND BK.SKD_VOY_NO  = DECODE(bkg_list.ORG_VVD, NULL, bkg_list.SKD_VOY_NO, SUBSTR(bkg_list.ORG_VVD, 5, 4)) -- FDR 처리               
                       AND BK.SKD_DIR_CD  = DECODE(bkg_list.ORG_VVD, NULL, bkg_list.DIR_CD, SUBSTR(bkg_list.ORG_VVD, -1)) -- FDR 처리               
                       AND (NVL(BK.ALOC_STS_CD, 'X') = 'F' OR BK.BKG_NO = v_appl_info)               
					   AND BK.BKG_STS_CD != 'X'  
                       AND BK.BKG_NO = QTY.BKG_NO               
					   AND BK.BKG_NO      = D.BKG_NO               
                       AND bkg_list.SLS_WK BETWEEN LVL.OFC_APLY_FM_YRWK AND LVL.OFC_APLY_TO_YRWK               
                       AND LVL.OFC_CD = SPC_SCR_OFC_CONV_FNC(BK.OB_SLS_OFC_CD, '')               
                       AND LVL.N2ND_PRNT_OFC_CD = bkg_list.RHQ_CD               
        ) T       
  )                
                , G_SUM AS ( SELECT * FROM (               
                    SELECT ALOC.BKG_ALOC_SEQ  ,BKG_CTRL_TP_CD             
                         , ALOC.BKG_ALOC_TP_CD               
                         , ALOC.ALOC_SVC_CD               
                         , NVL(ALOC.CMPB_AMT, 0) CMPB_AMT               
                         , NVL(ALOC.ALOC_LOD_QTY, 0) ALOC_LOD_QTY               
                         , DECODE(NVL(ALOC.ALOC_LOD_QTY, 0), 0, NVL(ALOC.ALOC_LOD_QTY_RTO, 100)) ALOC_LOD_QTY_RTO               
                         , DECODE(NVL(ALOC.OP_CNTR_QTY, 0), 0, NVL(ALOC.ALOC_LOD_QTY_RTO, 100)) ALOC_LOD_QTY_BOX_RTO               
                         , ALOC.CMDT_CD               
                         , ALOC.SCG_GRP_CMDT_SEQ               
                         , ALOC.BKG_ALOC_RMK               
                         , SUM(DECODE(T.BKG_NO, v_appl_info, 0, T.OP_CNTR_QTY)) F_TTL_QTY --전체 Confirm 갯수               
                         , SUM(DECODE(T.BKG_NO, v_appl_info, BKG.OP_CNTR_QTY,0)) BKG_QTY --현재 BKG의 갯수 v_appl_info               
                         , SUM(T.OP_CNTR_QTY) TTL_QTY               
                         , SUM(T.WGT) TTL_WGT  /*WGT합계*/               
                         , NVL(ASGN_TTL_WGT, 0) ASGN_TTL_WGT  /*할당된WGT합계*/               
                         , DECODE(NVL(ALOC.ASGN_TTL_WGT, 0), 0, 0, NVL(ALOC.ASGN_WGT_RTO, 100)) ASGN_WGT_RTO  /*할당된WGT비율*/               
                         , ALOC.CMPB_ONY_FLG               
						 , NVL(ALOC.OP_CNTR_QTY, 0) CNTR_QTY                  
						 , SUM(T.CNTR_QTY) TTL_CNTR_QTY                  
                         , ( SELECT NVL( MAX(MODI_SEQ) , 1) MODI_SEQ FROM SPC_BKG_ALOC_MGMT_HIS WHERE BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ ) MODI_SEQ --**         
                       FROM (SELECT * FROM BKG WHERE BKG_NO = v_appl_info) BKG, BKG T, SPC_BKG_ALOC_MGMT ALOC               
                     WHERE ALOC.ALOC_USE_FLG   = 'Y'               
                       AND ALOC.BKG_ALOC_TP_CD = 'M'               
                       AND ALOC.SLS_RHQ_CD = bkg_list.RHQ_CD               
                       AND BKG.TRNK_SLAN_CD  = NVL(ALOC.TRNK_SLAN_CD,      BKG.TRNK_SLAN_CD)               
                       AND BKG.TRNK_DIR_CD   = NVL(ALOC.TRNK_DIR_CD,       BKG.TRNK_DIR_CD)               
                       AND BKG.OB_SLS_OFC_CD = NVL(ALOC.OB_SLS_OFC_CD,     BKG.OB_SLS_OFC_CD)               
					   AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POR' AND LENGTH(LD.SB_LOC_CD) = 5),BKG.POR_LOC_CD) LIKE '%'||BKG.POR_LOC_CD||'%'                
                       AND BKG.POR_NOD_CD    = NVL(ALOC.POR_NOD_CD,        BKG.POR_NOD_CD)               
                       AND BKG.POR_SCC_CD    = NVL(ALOC.BKG_POR_SCC_CD,    BKG.POR_SCC_CD)               
					   AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POL' AND LENGTH(LD.SB_LOC_CD) = 5),BKG.POL_LOC_CD) LIKE '%'||BKG.POL_LOC_CD||'%'                
                       AND BKG.POL_NOD_CD    = NVL(ALOC.POL_NOD_CD,        BKG.POL_NOD_CD)               
					   AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POD' AND LENGTH(LD.SB_LOC_CD) = 5),BKG.POD_LOC_CD) LIKE '%'||BKG.POD_LOC_CD||'%'                
                       AND BKG.POD_NOD_CD    = NVL(ALOC.POD_NOD_CD,        BKG.POD_NOD_CD)               
					   AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(LD.SB_LOC_CD) = 5),BKG.DEL_LOC_CD) LIKE '%'||BKG.DEL_LOC_CD||'%'                
                       AND BKG.DEL_NOD_CD    = NVL(ALOC.DEL_NOD_CD,        BKG.DEL_NOD_CD)               
                       AND BKG.DEL_SCC_CD    = NVL(ALOC.BKG_DEL_SCC_CD,    BKG.DEL_SCC_CD)               
					   AND BKG.RVIS_CNTR_CUST_TP_CD  = NVL(ALOC.RVIS_CNTR_CUST_TP_CD,      BKG.RVIS_CNTR_CUST_TP_CD)               
                       AND NVL(BKG.SC_NO,'A')         = NVL(ALOC.SC_NO,             NVL(BKG.SC_NO,'A'))               
                       AND NVL(BKG.RFA_NO,'A')        = NVL(ALOC.RFA_NO,            NVL(BKG.RFA_NO,'A'))               
                       --AND BKG.CNTR_TPSZ_CD  = NVL(ALOC.CNTR_TPSZ_CD,      BKG.CNTR_TPSZ_CD)               
					   AND NVL((SELECT WM_CONCAT(LD.CNTR_TPSZ_CD) FROM SPC_BKG_ALOC_MGMT_TP_SZ_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ ),BKG.CNTR_TPSZ_CD) LIKE '%'||BKG.CNTR_TPSZ_CD||'%'                         
					   AND NVL((SELECT WM_CONCAT(CMDT.CMDT_CD) FROM SPC_BKG_ALOC_MGMT_CMDT_DTL CMDT WHERE CMDT.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ),BKG.CMDT_CD) LIKE '%'||BKG.CMDT_CD||'%'               
                       AND BKG.GRP_CMDT_CD   = NVL(ALOC.SCG_GRP_CMDT_SEQ,  BKG.GRP_CMDT_CD)               
					   AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POR' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(BKG.POR_LOC_CD,1,2)) LIKE '%'||SUBSTR(BKG.POR_LOC_CD,1,2)||'%'               
					   AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POL' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(BKG.POL_LOC_CD,1,2)) LIKE '%'||SUBSTR(BKG.POL_LOC_CD,1,2)||'%'               
					   AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POD' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(BKG.POD_LOC_CD,1,2)) LIKE '%'||SUBSTR(BKG.POD_LOC_CD,1,2)||'%'               
					   AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(BKG.DEL_LOC_CD,1,2)) LIKE '%'||SUBSTR(BKG.DEL_LOC_CD,1,2)||'%'			                 
                       AND BKG.SLS_WK BETWEEN NVL(ALOC.APLY_FM_YRWK, '201501') AND NVL(ALOC.APLY_TO_YRWK, '209953') -- Week 기준 추가               
                       AND BKG.SUB_TRD_CD = NVL(ALOC.SUB_TRD_CD, BKG.SUB_TRD_CD)               
                       AND NVL(BKG.AGMT_ACT_CNT_CD, 'XX999999') IN (                  
                            NVL((SELECT CD.CUST_CNT_CD || LPAD(CD.CUST_SEQ, 6, '0') FROM SPC_BKG_ALOC_MGMT_CUST_DTL CD WHERE CD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ), NVL(BKG.AGMT_ACT_CNT_CD, 'XX999999'))                  
                       )                  
                       AND NVL(ALOC.OFT_CHG_AMT, NVL(BKG.OFT_CHG_AMT, 0)) >= NVL(BKG.OFT_CHG_AMT, 0)                  
                       AND NVL(ALOC.USA_BKG_MOD_CD, NVL(BKG.USA_BKG_MOD_CD, 'OTH')) = NVL(BKG.USA_BKG_MOD_CD, 'OTH')                  
                        AND CASE v_mst_smp_flg WHEN 'N' THEN ( CASE NVL(ALOC.CMPB_AMT,0) WHEN 0 THEN 1 ELSE ALOC.CMPB_AMT END)                
                                                ELSE (CASE ALOC.CMPB_ONY_FLG WHEN 'Y' THEN 0 ELSE ALOC.CMPB_AMT END)               
                            END               
                            >                
                            CASE v_mst_smp_flg WHEN 'N' THEN ( CASE NVL(ALOC.CMPB_AMT,0) WHEN 0 THEN 0 ELSE BKG.CMPB_AMT END)                
                                                ELSE (CASE ALOC.CMPB_ONY_FLG WHEN 'Y' THEN 0 ELSE BKG.CMPB_AMT END)               
                            END                 
                       ---------------------------------------------------------------------------------------------               
                       AND T.TRNK_SLAN_CD  = NVL(ALOC.TRNK_SLAN_CD,      T.TRNK_SLAN_CD)               
                       AND T.TRNK_DIR_CD   = NVL(ALOC.TRNK_DIR_CD,       T.TRNK_DIR_CD)               
                       AND T.OB_SLS_OFC_CD = NVL(ALOC.OB_SLS_OFC_CD,     T.OB_SLS_OFC_CD)               
                       AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POR' AND LENGTH(LD.SB_LOC_CD) = 5),T.POR_LOC_CD) LIKE '%'||T.POR_LOC_CD||'%'                
                       AND T.POR_NOD_CD    = NVL(ALOC.POR_NOD_CD,        T.POR_NOD_CD)               
                       AND T.POR_SCC_CD    = NVL(ALOC.BKG_POR_SCC_CD,    T.POR_SCC_CD)               
                       AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POL' AND LENGTH(LD.SB_LOC_CD) = 5),T.POL_LOC_CD) LIKE '%'||T.POL_LOC_CD||'%'                                       
                       AND T.POL_NOD_CD    = NVL(ALOC.POL_NOD_CD,        T.POL_NOD_CD)               
                       AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POD' AND LENGTH(LD.SB_LOC_CD) = 5),T.POD_LOC_CD) LIKE '%'||T.POD_LOC_CD||'%'                
                       AND T.POD_NOD_CD    = NVL(ALOC.POD_NOD_CD,        T.POD_NOD_CD)               
                       AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(LD.SB_LOC_CD) = 5),T.DEL_LOC_CD) LIKE '%'||T.DEL_LOC_CD||'%'                                       
                       AND T.DEL_NOD_CD    = NVL(ALOC.DEL_NOD_CD,        T.DEL_NOD_CD)               
                       AND T.DEL_SCC_CD    = NVL(ALOC.BKG_DEL_SCC_CD,    T.DEL_SCC_CD)               
                       AND NVL(T.SC_NO,'A')         = NVL(ALOC.SC_NO,             NVL(T.SC_NO,'A'))               
                       AND NVL(T.RFA_NO,'A')        = NVL(ALOC.RFA_NO,            NVL(T.RFA_NO,'A'))               
                       --AND T.CNTR_TPSZ_CD  = NVL(ALOC.CNTR_TPSZ_CD,      T.CNTR_TPSZ_CD)               
					   AND NVL((SELECT WM_CONCAT(LD.CNTR_TPSZ_CD) FROM SPC_BKG_ALOC_MGMT_TP_SZ_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ ),T.CNTR_TPSZ_CD) LIKE '%'||T.CNTR_TPSZ_CD||'%'                         
					   AND NVL((SELECT WM_CONCAT(CMDT.CMDT_CD) FROM SPC_BKG_ALOC_MGMT_CMDT_DTL CMDT WHERE CMDT.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ),T.CMDT_CD) LIKE '%'||T.CMDT_CD||'%'               
                       AND T.GRP_CMDT_CD   = NVL(ALOC.SCG_GRP_CMDT_SEQ,  T.GRP_CMDT_CD)               
                       AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POR' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(T.POR_LOC_CD,1,2)) LIKE '%'||SUBSTR(T.POR_LOC_CD,1,2)||'%'               
					   AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POL' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(T.POL_LOC_CD,1,2)) LIKE '%'||SUBSTR(T.POL_LOC_CD,1,2)||'%'               
					   AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POD' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(T.POD_LOC_CD,1,2)) LIKE '%'||SUBSTR(T.POD_LOC_CD,1,2)||'%'               
					   AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(T.DEL_LOC_CD,1,2)) LIKE '%'||SUBSTR(T.DEL_LOC_CD,1,2)||'%'			                 
					   AND T.SLS_WK BETWEEN NVL(ALOC.APLY_FM_YRWK, '201501') AND NVL(ALOC.APLY_TO_YRWK, '209953') -- Week 기준 추가               
                       AND T.SUB_TRD_CD = NVL(ALOC.SUB_TRD_CD, T.SUB_TRD_CD)               
                       AND NVL(T.AGMT_ACT_CNT_CD, 'XX999999') IN (                  
                            NVL((SELECT CD.CUST_CNT_CD || LPAD(CD.CUST_SEQ, 6, '0') FROM SPC_BKG_ALOC_MGMT_CUST_DTL CD WHERE CD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ), NVL(T.AGMT_ACT_CNT_CD, 'XX999999'))                  
                       )                  
                       AND NVL(ALOC.OFT_CHG_AMT, NVL(T.OFT_CHG_AMT, 0)) >= NVL(T.OFT_CHG_AMT, 0)                  
                       AND NVL(ALOC.USA_BKG_MOD_CD, NVL(T.USA_BKG_MOD_CD, 'OTH')) = NVL(T.USA_BKG_MOD_CD, 'OTH')        
                        AND CASE v_mst_smp_flg WHEN 'N' THEN ( CASE NVL(ALOC.CMPB_AMT,0) WHEN 0 THEN 1 ELSE ALOC.CMPB_AMT END)               
                                                ELSE (CASE ALOC.CMPB_ONY_FLG WHEN 'Y' THEN 0 ELSE ALOC.CMPB_AMT END)              
                            END              
                            >               
                            CASE v_mst_smp_flg WHEN 'N' THEN ( CASE NVL(ALOC.CMPB_AMT,0) WHEN 0 THEN 0 ELSE T.CMPB_AMT END)               
                                                ELSE (CASE ALOC.CMPB_ONY_FLG WHEN 'Y' THEN 0 ELSE T.CMPB_AMT END)              
                            END                
                      AND (CASE NVL(ALOC.CMPB_PER_TON_AMT,0) WHEN 0 THEN 1 ELSE NVL(ALOC.CMPB_PER_TON_AMT,1) END) >= (CASE NVL(ALOC.CMPB_PER_TON_AMT,0) WHEN 0 THEN 0 ELSE NVL(T.CMPB_PER_TON_AMT,0) END)           
                      AND (CASE NVL(ALOC.TON_PER_TEU_WGT,0) WHEN 0 THEN 0 ELSE NVL(ALOC.TON_PER_TEU_WGT,1) END) <= (CASE NVL(ALOC.TON_PER_TEU_WGT,0) WHEN 0 THEN 1 ELSE NVL(T.TON_PER_TEU_WGT,0) END)                                     
                    GROUP BY ALOC.BKG_ALOC_SEQ  ,BKG_CTRL_TP_CD             
                         , ALOC.BKG_ALOC_TP_CD               
                         , ALOC.ALOC_SVC_CD               
                         , ALOC.CMPB_AMT               
                         , ALOC_LOD_QTY               
                         , ALOC_LOD_QTY_RTO               
                         , ALOC.CMDT_CD               
                         , ALOC.SCG_GRP_CMDT_SEQ               
                         , ALOC.BKG_ALOC_RMK               
                         , ASGN_TTL_WGT                
                         , ASGN_WGT_RTO               
                         , CMPB_ONY_FLG               
                         , ALOC.OP_CNTR_QTY             
                         )               
                     WHERE 1=1               
                        AND (               
                                DECODE(ALOC_LOD_QTY, 0, 1, ROUND(TTL_QTY/ALOC_LOD_QTY * 100,1)) > DECODE(ALOC_LOD_QTY, 0, 0, ALOC_LOD_QTY_RTO)               
                                AND                
                                DECODE(ASGN_TTL_WGT, 0, 1, ROUND(TTL_WGT/ASGN_TTL_WGT * 100,1)) > DECODE(ASGN_TTL_WGT, 0, 0, ASGN_WGT_RTO)               
								AND                  
--								DECODE(CNTR_QTY, 0, 1, CNTR_QTY) > DECODE(CNTR_QTY, 0, 0, TTL_CNTR_QTY)                  
                                DECODE(CNTR_QTY, 0, 1, ROUND(TTL_CNTR_QTY/CNTR_QTY * 100,1)) > DECODE(CNTR_QTY, 0, 0, ALOC_LOD_QTY_BOX_RTO)               
               
                             )               
                        -- SMP대상은 CMPB_ONY_FLG='Y'인 조건은 해당 룰을 적용하지 않고, 나머지는 적용한다.               
                        AND CASE v_mst_smp_flg WHEN 'N' THEN ( CASE NVL(CMPB_AMT,0) WHEN 0 THEN 1 ELSE CMPB_AMT END)                
                                                ELSE (CASE CMPB_ONY_FLG WHEN 'Y' THEN 0 ELSE CMPB_AMT END)               
                            END               
                            >                
                            CASE v_mst_smp_flg WHEN 'N' THEN ( CASE NVL(CMPB_AMT,0) WHEN 0 THEN 0 ELSE bkg_list.CMPB END)                
                                                ELSE (CASE CMPB_ONY_FLG WHEN 'Y' THEN 0 ELSE bkg_list.CMPB END)               
                            END                 
                                            
                )               
SELECT              
      MAX(DECODE(ALOC_STS_CD,'S',ALOC_STS_CD)) V11             
    , MAX(DECODE(ALOC_STS_CD,'S',ALOC_SVC_CD)) V12             
    , MAX(DECODE(ALOC_STS_CD,'S',BKG_ALOC_SEQ)) V13             
    , MAX(DECODE(ALOC_STS_CD,'S',LST_SB_RS)) V14             
    , MAX(DECODE(ALOC_STS_CD,'S',MODI_SEQ)) V15              
    , MAX(DECODE(ALOC_STS_CD,'A',ALOC_STS_CD)) V21             
    , MAX(DECODE(ALOC_STS_CD,'A',ALOC_SVC_CD)) V22             
    , MAX(DECODE(ALOC_STS_CD,'A',BKG_ALOC_SEQ)) V23             
    , MAX(DECODE(ALOC_STS_CD,'A',LST_SB_RS)) V24             
    , MAX(DECODE(ALOC_STS_CD,'A',MODI_SEQ)) V25       
    INTO v_mst_m_rlst, v_mst_m_svc_cd, v_mst_m_seq ,  v_mst_m_rs, v_modi_m_seq              
        ,a_mst_m_rlst, a_mst_m_svc_cd, a_mst_m_seq ,  a_mst_m_rs, a_modi_m_seq                     
FROM (             
    SELECT ALOC_STS_CD,ALOC_SVC_CD,BKG_ALOC_SEQ,LST_SB_RS,MODI_SEQ    
    FROM (                             
                SELECT BKG_CTRL_TP_CD AS ALOC_STS_CD, ALOC_SVC_CD, BKG_ALOC_SEQ,               
                        'SMP FLG:' || v_mst_smp_flg || ', Firm TTL Qty:' || F_TTL_QTY || ', BKG Qty:' || BKG_QTY || ', BKG CMPB:' || bkg_list.CMPB               
                        AS LST_SB_RS               
                       , MODI_SEQ --**               
                       , DENSE_RANK() OVER(PARTITION BY BKG_CTRL_TP_CD ORDER BY BKG_CTRL_TP_CD) F_ROW         
                  FROM G_SUM               
    ) WHERE F_ROW=1             
  )                                 
                ;               
                EXCEPTION               
                        WHEN NO_DATA_FOUND THEN               
                        v_mst_m_rlst := NULL;               
                        v_mst_m_svc_cd := NULL;               
                        v_mst_m_seq := NULL;               
                        v_mst_m_rs := NULL;               
                        a_mst_m_rlst := NULL;               
                        a_mst_m_svc_cd := NULL;               
                        a_mst_m_seq := NULL;               
                        a_mst_m_rs := NULL;               
                        a_modi_m_seq := NULL;                 
                END;               
                    
                enis_log_prc(SYSDATE, v_prc_nm, v_step || ': '|| NVL(v_mst_m_rlst,'N'), v_appl_info);       
                                
                /************************************************************************               
                1.5 EQ               
                ************************************************************************/               
                v_step := '1-5. MasterTable-EQ';              
                BEGIN               
                WITH BKG AS (               
                SELECT  T.*        
                        , ROUND(T.CMPB_AMT/T.WGT,2)  AS CMPB_PER_TON_AMT        
                        , ROUND(T.WGT/T.OP_CNTR_QTY,2)  AS TON_PER_TEU_WGT        
                FROM (        
                    SELECT BK.BKG_NO, BK.SLAN_CD TRNK_SLAN_CD               
                         , BK.SKD_DIR_CD TRNK_DIR_CD               
                         , BK.POR_CD                POR_LOC_CD               
                         , BK.POR_NOD_CD            POR_NOD_CD               
                         , (SELECT SCC_CD FROM MDM_LOCATION LOC WHERE LOC.LOC_CD = BK.POR_CD) POR_SCC_CD               
                         , BK.POL_CD                POL_LOC_CD               
                         , BK.POL_NOD_CD            POL_NOD_CD               
                         , BK.POD_CD                POD_LOC_CD               
                         , BK.POD_NOD_CD            POD_NOD_CD               
                         , BK.DEL_CD                DEL_LOC_CD               
                         , BK.DEL_NOD_CD            DEL_NOD_CD               
                         , (SELECT SCC_CD FROM MDM_LOCATION LOC WHERE LOC.LOC_CD = BK.DEL_CD) DEL_SCC_CD               
                         , BK.OB_SLS_OFC_CD               
                         , QTY.CNTR_TPSZ_CD               
                         , DECODE(SPC_GET_CNTR_SZ_FNC(QTY.CNTR_TPSZ_CD), '2', 1, 2) * QTY.OP_CNTR_QTY OP_CNTR_QTY               
                         , (SELECT SPC_GET_CMPB_FNC(BK.BKG_NO, NULL) FROM DUAL) AS CMPB_AMT           
                         , BK.DCGO_FLG               
                         , BK.RD_CGO_FLG               
                          ,BK.AGMT_ACT_CNT_CD               
                          ,BK.AGMT_ACT_CUST_SEQ               
                          ,bkg_list.SUB_TRD_CD SUB_TRD_CD               
						 , NVL( (SELECT SUM(R.CHG_UT_AMT) FROM BKG_CHG_RT R WHERE R.BKG_NO = BK.BKG_NO AND R.CHG_CD = 'OFT')       
						 	   ,(SELECT MIN(OFT_AMT) KEEP (DENSE_RANK LAST ORDER BY A.REV_COST_SEQ) FROM BKG_REV_COST A WHERE A.BKG_NO = BK.BKG_NO)) AS OFT_CHG_AMT           
                          ,CASE WHEN (SUBSTR(BK.POR_CD, 1, 2) IN ('CA', 'US') OR SUBSTR(BK.DEL_CD, 1, 2) IN ('CA', 'US'))               
                                    THEN (SELECT SPC_USA_MODE_FNC(BK.RCV_TERM_CD, BK.DE_TERM_CD, BK.POR_CD, BK.POL_CD, BK.POD_CD, BK.DEL_CD) FROM DUAL)               
                                    ELSE 'OTH' END USA_BKG_MOD_CD               
                          , NVL(BK.ALOC_STS_CD, 'X') ALOC_STS_CD               
                          ,bkg_list.SLS_WK SLS_WK               
                          ,(SELECT                
                             SUM((D.ACT_WGT * DECODE(D.WGT_UT_CD, 'LBS', 0.00045, 0.001))               
                                  + SUM(Q.OP_CNTR_QTY * ( SELECT TS.CNTR_TPSZ_TARE_WGT               
                                                         FROM MDM_CNTR_TP_SZ TS               
                                                         WHERE TS.CNTR_TPSZ_CD = Q.CNTR_TPSZ_CD)) * 0.001               
                                ) WGT_TTL               
                              FROM BKG_QUANTITY Q               
                              WHERE BK.BKG_NO      = Q.BKG_NO               
                              AND Q.OP_CNTR_QTY > 0               
                              GROUP BY D.ACT_WGT * DECODE(D.WGT_UT_CD, 'LBS', 0.00045, 0.001)               
                          ) WGT                
						 ,(SELECT RVIS_CNTR_CUST_TP_CD FROM MDM_CUSTOMER M WHERE BK.CTRT_CUST_CNT_CD = M.CUST_CNT_CD AND BK.CTRT_CUST_SEQ = M.CUST_SEQ) AS RVIS_CNTR_CUST_TP_CD               
						 ,CASE WHEN QTY.CNTR_TPSZ_CD LIKE 'R%' THEN QTY.OP_CNTR_QTY - EQ_SUBST_CGO_QTY ELSE OP_CNTR_QTY END AS CNTR_QTY  
                      FROM BKG_BOOKING BK,BKG_BL_DOC D,  BKG_QUANTITY QTY, SPC_OFC_LVL LVL               
                     WHERE BK.BKG_NO = QTY.BKG_NO               
                       AND BK.VSL_CD      = DECODE(bkg_list.ORG_VVD, NULL, bkg_list.VSL_CD, SUBSTR(bkg_list.ORG_VVD, 1, 4)) -- FDR 처리               
                       AND BK.SKD_VOY_NO  = DECODE(bkg_list.ORG_VVD, NULL, bkg_list.SKD_VOY_NO, SUBSTR(bkg_list.ORG_VVD, 5, 4)) -- FDR 처리               
                       AND BK.SKD_DIR_CD  = DECODE(bkg_list.ORG_VVD, NULL, bkg_list.DIR_CD, SUBSTR(bkg_list.ORG_VVD, -1)) -- FDR 처리               
                       AND (NVL(BK.ALOC_STS_CD, 'X') = 'F' OR BK.BKG_NO = v_appl_info)               
					   AND BK.BKG_STS_CD            <> 'X'   
                       AND BK.BKG_NO = QTY.BKG_NO               
					   AND BK.BKG_NO      = D.BKG_NO               
                       AND bkg_list.SLS_WK BETWEEN LVL.OFC_APLY_FM_YRWK AND LVL.OFC_APLY_TO_YRWK               
                       AND LVL.OFC_CD = SPC_SCR_OFC_CONV_FNC(BK.OB_SLS_OFC_CD, '')               
                       AND LVL.N2ND_PRNT_OFC_CD = bkg_list.RHQ_CD               
    ) T       
)               
                , G_SUM AS (SELECT * FROM (               
                    SELECT ALOC.BKG_CTRL_TP_CD             
                         , (SELECT WM_CONCAT(LD.CNTR_TPSZ_CD) FROM SPC_BKG_ALOC_MGMT_TP_SZ_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ) CNTR_TPSZ_CD               
                         , ALOC.DCGO_FLG               
                         , ALOC.RD_CGO_FLG               
                         , ALOC.BKG_ALOC_SEQ               
                         , ALOC.BKG_ALOC_TP_CD               
                         , ALOC.ALOC_SVC_CD               
                         , NVL(ALOC.CMPB_AMT, 0) CMPB_AMT               
                         , NVL(ALOC.ALOC_LOD_QTY, 0) ALOC_LOD_QTY               
                         , DECODE(NVL(ALOC.ALOC_LOD_QTY, 0), 0, 0, NVL(ALOC.ALOC_LOD_QTY_RTO, 100)) ALOC_LOD_QTY_RTO  --ratio가 없으면 물량의 100%               
                         , DECODE(NVL(ALOC.OP_CNTR_QTY, 0), 0, 0, NVL(ALOC.ALOC_LOD_QTY_RTO, 100)) ALOC_LOD_QTY_BOX_RTO  --ratio가 없으면 물량의 100%               
                         , ALOC.BKG_ALOC_RMK               
                         , SUM(DECODE(T.BKG_NO, v_appl_info, 0, T.OP_CNTR_QTY)) F_TTL_QTY --전체 Confirm 갯수               
                         , SUM(DECODE(T.BKG_NO, v_appl_info, BKG.OP_CNTR_QTY,0)) BKG_QTY --현재 BKG의 갯수 v_appl_info               
                         , SUM(T.OP_CNTR_QTY) TTL_QTY               
                         , SUM(T.WGT) TTL_WGT /*WGT전체*/               
                         , NVL(ASGN_TTL_WGT, 0) ASGN_TTL_WGT /*할당된WGT전체*/               
                         , DECODE(NVL(ALOC.ASGN_TTL_WGT, 0), 0, 0, NVL(ALOC.ASGN_WGT_RTO, 100)) ASGN_WGT_RTO  /*할당된WGT비율*/               
                         , CMPB_ONY_FLG                
                         , NVL(ALOC.OP_CNTR_QTY, 0) CNTR_QTY                  
                         , SUM(T.CNTR_QTY) TTL_CNTR_QTY               
                         , ( SELECT NVL( MAX(MODI_SEQ) , 1) MODI_SEQ FROM SPC_BKG_ALOC_MGMT_HIS WHERE BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ ) MODI_SEQ --**      
                      FROM (SELECT * FROM BKG WHERE BKG_NO = v_appl_info) BKG, BKG T, SPC_BKG_ALOC_MGMT ALOC               
                     WHERE ALOC.BKG_ALOC_TP_CD = 'E'               
                       AND ALOC.ALOC_USE_FLG   = 'Y'               
                       AND ALOC.SLS_RHQ_CD = bkg_list.RHQ_CD               
                       AND BKG.TRNK_SLAN_CD  = NVL(ALOC.TRNK_SLAN_CD,      BKG.TRNK_SLAN_CD)               
                       AND BKG.TRNK_DIR_CD   = NVL(ALOC.TRNK_DIR_CD,       BKG.TRNK_DIR_CD)               
                       AND BKG.OB_SLS_OFC_CD = NVL(ALOC.OB_SLS_OFC_CD,     BKG.OB_SLS_OFC_CD)               
                       AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POR' AND LENGTH(LD.SB_LOC_CD) = 5),BKG.POR_LOC_CD) LIKE '%'||BKG.POR_LOC_CD||'%'                                         
                       AND BKG.POR_NOD_CD    = NVL(ALOC.POR_NOD_CD,        BKG.POR_NOD_CD)               
                       AND BKG.POR_SCC_CD    = NVL(ALOC.BKG_POR_SCC_CD,    BKG.POR_SCC_CD)               
                       AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POL' AND LENGTH(LD.SB_LOC_CD) = 5),BKG.POL_LOC_CD) LIKE '%'||BKG.POL_LOC_CD||'%'                  
                       AND BKG.POL_NOD_CD    = NVL(ALOC.POL_NOD_CD,        BKG.POL_NOD_CD)               
                       AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POD' AND LENGTH(LD.SB_LOC_CD) = 5),BKG.POD_LOC_CD) LIKE '%'||BKG.POD_LOC_CD||'%'                                        
                       AND BKG.POD_NOD_CD    = NVL(ALOC.POD_NOD_CD,        BKG.POD_NOD_CD)               
                       AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(LD.SB_LOC_CD) = 5),BKG.DEL_LOC_CD) LIKE '%'||BKG.DEL_LOC_CD||'%'                  
                       AND BKG.DEL_NOD_CD    = NVL(ALOC.DEL_NOD_CD,        BKG.DEL_NOD_CD)               
                       AND BKG.DEL_SCC_CD    = NVL(ALOC.BKG_DEL_SCC_CD,    BKG.DEL_SCC_CD)					                  
                       AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POR' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(BKG.POR_LOC_CD,1,2)) LIKE '%'||SUBSTR(BKG.POR_LOC_CD,1,2)||'%'               
                       AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POL' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(BKG.POL_LOC_CD,1,2)) LIKE '%'||SUBSTR(BKG.POL_LOC_CD,1,2)||'%'               
                       AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POD' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(BKG.POD_LOC_CD,1,2)) LIKE '%'||SUBSTR(BKG.POD_LOC_CD,1,2)||'%'               
                       AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(BKG.DEL_LOC_CD,1,2)) LIKE '%'||SUBSTR(BKG.DEL_LOC_CD,1,2)||'%'			                 
                       AND NVL((SELECT WM_CONCAT(LD.CNTR_TPSZ_CD) FROM SPC_BKG_ALOC_MGMT_TP_SZ_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ ),BKG.CNTR_TPSZ_CD) LIKE '%'||BKG.CNTR_TPSZ_CD||'%'                     
                       --AND DECODE(ALOC.CNTR_TPSZ_CD,'ALL','ALL',BKG.CNTR_TPSZ_CD)    = ALOC.CNTR_TPSZ_CD               
                       AND BKG.RVIS_CNTR_CUST_TP_CD  = NVL(ALOC.RVIS_CNTR_CUST_TP_CD,      BKG.RVIS_CNTR_CUST_TP_CD)               
                       AND BKG.DCGO_FLG        = NVL(ALOC.DCGO_FLG,     BKG.DCGO_FLG)               
                       AND BKG.RD_CGO_FLG      = NVL(ALOC.RD_CGO_FLG,     BKG.RD_CGO_FLG)               
                       AND BKG.SLS_WK BETWEEN NVL(ALOC.APLY_FM_YRWK, '201501') AND NVL(ALOC.APLY_TO_YRWK, '209953') -- Week 기준 추가               
                       AND BKG.SUB_TRD_CD = NVL(ALOC.SUB_TRD_CD, BKG.SUB_TRD_CD)               
                       AND NVL(BKG.AGMT_ACT_CNT_CD, 'XX999999') IN (                  
                            NVL((SELECT CD.CUST_CNT_CD || LPAD(CD.CUST_SEQ, 6, '0') FROM SPC_BKG_ALOC_MGMT_CUST_DTL CD WHERE CD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ), NVL(BKG.AGMT_ACT_CNT_CD, 'XX999999'))                  
                       )                  
                       AND NVL(ALOC.OFT_CHG_AMT, NVL(BKG.OFT_CHG_AMT, 0)) >= NVL(BKG.OFT_CHG_AMT, 0)                  
                       AND NVL(ALOC.USA_BKG_MOD_CD, NVL(BKG.USA_BKG_MOD_CD, 'OTH')) = NVL(BKG.USA_BKG_MOD_CD, 'OTH')                  
                        AND CASE v_mst_smp_flg WHEN 'N' THEN ( CASE NVL(ALOC.CMPB_AMT,0) WHEN 0 THEN 1 ELSE ALOC.CMPB_AMT END)                
                                                ELSE (CASE ALOC.CMPB_ONY_FLG WHEN 'Y' THEN 0 ELSE ALOC.CMPB_AMT END)               
                            END               
                            >                
                            CASE v_mst_smp_flg WHEN 'N' THEN ( CASE NVL(ALOC.CMPB_AMT,0) WHEN 0 THEN 0 ELSE BKG.CMPB_AMT END)                
                                                ELSE (CASE ALOC.CMPB_ONY_FLG WHEN 'Y' THEN 0 ELSE BKG.CMPB_AMT END)               
                            END                 
                       -----------------------------------------------------------------------------------------------               
                       AND T.TRNK_SLAN_CD  = NVL(ALOC.TRNK_SLAN_CD,      T.TRNK_SLAN_CD)               
                       AND T.TRNK_DIR_CD   = NVL(ALOC.TRNK_DIR_CD,       T.TRNK_DIR_CD)               
                       AND T.OB_SLS_OFC_CD = NVL(ALOC.OB_SLS_OFC_CD,     T.OB_SLS_OFC_CD)               
                       AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POR' AND LENGTH(LD.SB_LOC_CD) = 5),T.POR_LOC_CD) LIKE '%'||T.POR_LOC_CD||'%'                                         
                       AND T.POR_NOD_CD    = NVL(ALOC.POR_NOD_CD,        T.POR_NOD_CD)               
                       AND T.POR_SCC_CD    = NVL(ALOC.BKG_POR_SCC_CD,    T.POR_SCC_CD)               
                       AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POL' AND LENGTH(LD.SB_LOC_CD) = 5),T.POL_LOC_CD) LIKE '%'||T.POL_LOC_CD||'%'                                         
                       AND T.POL_NOD_CD    = NVL(ALOC.POL_NOD_CD,        T.POL_NOD_CD)               
                       AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POD' AND LENGTH(LD.SB_LOC_CD) = 5),T.POD_LOC_CD) LIKE '%'||T.POD_LOC_CD||'%'                                                               
                       AND T.POD_NOD_CD    = NVL(ALOC.POD_NOD_CD,        T.POD_NOD_CD)               
                       AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(LD.SB_LOC_CD) = 5),T.DEL_LOC_CD) LIKE '%'||T.DEL_LOC_CD||'%'                                         
                       AND T.DEL_NOD_CD    = NVL(ALOC.DEL_NOD_CD,        T.DEL_NOD_CD)               
                       AND T.DEL_SCC_CD    = NVL(ALOC.BKG_DEL_SCC_CD,    T.DEL_SCC_CD)               
					                  
                       AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POR' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(T.POR_LOC_CD,1,2)) LIKE '%'||SUBSTR(T.POR_LOC_CD,1,2)||'%'               
                       AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POL' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(T.POL_LOC_CD,1,2)) LIKE '%'||SUBSTR(T.POL_LOC_CD,1,2)||'%'               
                       AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POD' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(T.POD_LOC_CD,1,2)) LIKE '%'||SUBSTR(T.POD_LOC_CD,1,2)||'%'               
                       AND NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(LD.SB_LOC_CD) = 2),SUBSTR(T.DEL_LOC_CD,1,2)) LIKE '%'||SUBSTR(T.DEL_LOC_CD,1,2)||'%'			                 
                       AND NVL((SELECT WM_CONCAT(LD.CNTR_TPSZ_CD) FROM SPC_BKG_ALOC_MGMT_TP_SZ_DTL LD WHERE LD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ ),T.CNTR_TPSZ_CD) LIKE '%'||T.CNTR_TPSZ_CD||'%'               
                       --AND DECODE(ALOC.CNTR_TPSZ_CD,'ALL','ALL',T.CNTR_TPSZ_CD)    = ALOC.CNTR_TPSZ_CD               
                       AND T.DCGO_FLG        = NVL(ALOC.DCGO_FLG,     T.DCGO_FLG)               
                       AND T.RD_CGO_FLG      = NVL(ALOC.RD_CGO_FLG,     T.RD_CGO_FLG)               
                       AND T.SLS_WK BETWEEN NVL(ALOC.APLY_FM_YRWK, '201501') AND NVL(ALOC.APLY_TO_YRWK, '209953') -- Week 기준 추가               
                       AND T.SUB_TRD_CD = NVL(ALOC.SUB_TRD_CD, T.SUB_TRD_CD)               
                       AND NVL(T.AGMT_ACT_CNT_CD, 'XX999999') IN (                  
                            NVL((SELECT CD.CUST_CNT_CD || LPAD(CD.CUST_SEQ, 6, '0') FROM SPC_BKG_ALOC_MGMT_CUST_DTL CD WHERE CD.BKG_ALOC_SEQ = ALOC.BKG_ALOC_SEQ), NVL(T.AGMT_ACT_CNT_CD, 'XX999999'))                  
                       )                  
                       AND NVL(ALOC.OFT_CHG_AMT, NVL(T.OFT_CHG_AMT, 0)) >= NVL(T.OFT_CHG_AMT, 0)                  
                       AND NVL(ALOC.USA_BKG_MOD_CD, NVL(T.USA_BKG_MOD_CD, 'OTH')) = NVL(T.USA_BKG_MOD_CD, 'OTH')                
                        AND CASE v_mst_smp_flg WHEN 'N' THEN ( CASE NVL(ALOC.CMPB_AMT,0) WHEN 0 THEN 1 ELSE ALOC.CMPB_AMT END)                
                                                ELSE (CASE ALOC.CMPB_ONY_FLG WHEN 'Y' THEN 0 ELSE ALOC.CMPB_AMT END)               
                            END               
                            >                
                            CASE v_mst_smp_flg WHEN 'N' THEN ( CASE NVL(ALOC.CMPB_AMT,0) WHEN 0 THEN 0 ELSE T.CMPB_AMT END)                
                                                ELSE (CASE ALOC.CMPB_ONY_FLG WHEN 'Y' THEN 0 ELSE T.CMPB_AMT END)               
                            END                 
                       AND (CASE NVL(ALOC.CMPB_PER_TON_AMT,0) WHEN 0 THEN 1 ELSE NVL(ALOC.CMPB_PER_TON_AMT,1) END) >= (CASE NVL(ALOC.CMPB_PER_TON_AMT,0) WHEN 0 THEN 0 ELSE NVL(T.CMPB_PER_TON_AMT,0) END)           
                       AND (CASE NVL(ALOC.TON_PER_TEU_WGT,0) WHEN 0 THEN 0 ELSE NVL(ALOC.TON_PER_TEU_WGT,1) END) <= (CASE NVL(ALOC.TON_PER_TEU_WGT,0) WHEN 0 THEN 1 ELSE NVL(T.TON_PER_TEU_WGT,0) END)           
                    GROUP BY ALOC.BKG_CTRL_TP_CD               
                         , ALOC.DCGO_FLG                 
                         , ALOC.RD_CGO_FLG               
                         , ALOC.BKG_ALOC_SEQ               
                         , ALOC.BKG_ALOC_TP_CD               
                         , ALOC.ALOC_SVC_CD               
                         , ALOC.CMPB_AMT               
                         , ALOC_LOD_QTY               
                         , ALOC_LOD_QTY_RTO               
                         , ALOC.BKG_ALOC_RMK               
                         , ASGN_TTL_WGT                
                         , ASGN_WGT_RTO               
                         , CMPB_ONY_FLG               
                         , ALOC.OP_CNTR_QTY                
               
                       )               
                     WHERE 1=1               
                        AND (               
                                DECODE(ALOC_LOD_QTY, 0, 1, ROUND(TTL_QTY/ALOC_LOD_QTY * 100,1)) > DECODE(ALOC_LOD_QTY, 0, 0, ALOC_LOD_QTY_RTO)               
                                AND                
                                DECODE(ASGN_TTL_WGT, 0, 1, ROUND(TTL_WGT/ASGN_TTL_WGT * 100,1)) > DECODE(ASGN_TTL_WGT, 0, 0, ASGN_WGT_RTO)               
                                AND	           
                                DECODE(CNTR_QTY, 0, 1, ROUND(TTL_CNTR_QTY/CNTR_QTY * 100,1)) > DECODE(CNTR_QTY, 0, 0, ALOC_LOD_QTY_BOX_RTO)               
               
                             )               
                            -- SMP대상은 CMPB_ONY_FLG='Y'인 조건은 해당 룰을 적용하지 않고, 나머지는 적용한다.       
               
                )               
SELECT              
      MAX(DECODE(ALOC_STS_CD,'S',ALOC_STS_CD)) V11             
    , MAX(DECODE(ALOC_STS_CD,'S',ALOC_SVC_CD)) V12             
    , MAX(DECODE(ALOC_STS_CD,'S',BKG_ALOC_SEQ)) V13             
    , MAX(DECODE(ALOC_STS_CD,'S',LST_SB_RS)) V14             
    , MAX(DECODE(ALOC_STS_CD,'S',MODI_SEQ)) V15               
    , MAX(DECODE(ALOC_STS_CD,'A',ALOC_STS_CD)) V21             
    , MAX(DECODE(ALOC_STS_CD,'A',ALOC_SVC_CD)) V22             
    , MAX(DECODE(ALOC_STS_CD,'A',BKG_ALOC_SEQ)) V23             
    , MAX(DECODE(ALOC_STS_CD,'A',LST_SB_RS)) V24             
    , MAX(DECODE(ALOC_STS_CD,'A',MODI_SEQ)) V25            
INTO v_mst_e_rlst, v_mst_e_svc_cd, v_mst_e_seq, v_mst_e_rs, v_modi_e_seq    
    ,a_mst_e_rlst, a_mst_e_svc_cd, a_mst_e_seq ,a_mst_e_rs, a_modi_e_seq               
FROM (             
    SELECT ALOC_STS_CD,ALOC_SVC_CD,BKG_ALOC_SEQ,LST_SB_RS,MODI_SEQ    
    FROM (                               
                SELECT BKG_CTRL_TP_CD AS ALOC_STS_CD, ALOC_SVC_CD, BKG_ALOC_SEQ,               
                        'SMP FLG:' || v_mst_smp_flg || ', Firm TTL Qty:' || F_TTL_QTY || ', BKG Qty:' || BKG_QTY || ', BKG CMPB:' || bkg_list.CMPB               
                        AS LST_SB_RS               
                       , MODI_SEQ --**               
                       , DENSE_RANK() OVER(PARTITION BY BKG_CTRL_TP_CD ORDER BY BKG_CTRL_TP_CD) F_ROW       
                  FROM G_SUM               
    ) WHERE F_ROW=1             
  )                             
  ;               
                EXCEPTION               
                        WHEN NO_DATA_FOUND THEN               
                        v_mst_e_rlst := NULL;               
                        v_mst_e_svc_cd := NULL;               
                        v_mst_e_seq := NULL;               
                        v_mst_e_rs := NULL;              
                        a_mst_e_rlst := NULL;               
                        a_mst_e_svc_cd := NULL;               
                        a_mst_e_seq := NULL;               
                        a_mst_e_rs := NULL;               
                        a_modi_e_seq := NULL;               
                END;       
                    
                enis_log_prc(SYSDATE, v_prc_nm, v_step || ': '|| NVL(v_mst_e_rlst,'N'), v_appl_info);      
                                
                /************************************************************************                
                1.6 Free                
                
                ************************************************************************/                
               v_step := '1-6. MasterTable-Free';                
               BEGIN                
                
                WITH MASTER AS (        
                 SELECT MT.BKG_ALOC_SEQ        
                      , MT.BKG_ALOC_TP_CD        
                      , MT.TRNK_SLAN_CD        
                      , MT.TRNK_DIR_CD        
                      , MT.OB_SLS_OFC_CD        
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POR' AND LENGTH(LD.SB_LOC_CD) = 2 ) POR_CNT_CD        
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POR' AND LENGTH(LD.SB_LOC_CD) = 5 ) POR_CD        
                      , MT.POR_NOD_CD        
                      , MT.BKG_POR_SCC_CD        
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POL' AND LENGTH(LD.SB_LOC_CD) = 2 ) POL_CNT_CD        
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POL' AND LENGTH(LD.SB_LOC_CD) = 5 ) POL_CD        
                      , MT.POL_NOD_CD        
                       -- [2015.10.23] T/S PORT, T/S POL NODE, T/S POD NODE        
                      , CASE WHEN (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SAY' ) IS NOT NULL        
                             THEN NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SAY' AND LENGTH(LD.SB_LOC_CD) = 5 ), 'XXXXXXXX')         
                             ELSE NULL END AS TS_ALL_LOC_CD                              
                      , CASE WHEN (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SAY' ) IS NOT NULL        
                             THEN NVL((SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SAY' AND LENGTH(LD.SB_LOC_CD) = 7 ), 'XXXXXXXX')         
                             ELSE NULL END AS TS_ALL_NOD_CD         
                      , MT.N1ST_TS_SLAN_CD        
                      , MT.N1ST_TS_DIR_CD        
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SPL' AND LENGTH(LD.SB_LOC_CD) = 2) N1ST_TS_POL_CNT_CD                
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SPL' AND LENGTH(LD.SB_LOC_CD) = 5) N1ST_TS_POL_CD          
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SLY' ) TS_POL_NOD_CD            
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SPD' AND LENGTH(LD.SB_LOC_CD) = 2) N1ST_TS_POD_CNT_CD          
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SPD' AND LENGTH(LD.SB_LOC_CD) = 5) N1ST_TS_POD_CD         
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'SDY') TS_POD_NOD_CD         
                                 
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POD' AND LENGTH(LD.SB_LOC_CD) = 2) POD_CNT_CD        
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'POD' AND LENGTH(LD.SB_LOC_CD) = 5) POD_CD                
                      , MT.POD_NOD_CD                
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(LD.SB_LOC_CD) = 2) DEL_CNT_CD         
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'DEL' AND LENGTH(LD.SB_LOC_CD) = 5) DEL_CD          
                      , MT.DEL_NOD_CD        
                      , MT.BKG_DEL_SCC_CD        
                      , MT.SC_NO        
                      , MT.RFA_NO        
                      , MT.CTRT_CUST_CNT_CD        
                      , MT.CTRT_CUST_SEQ        
                      , MT.CUST_CNT_CD , MT.CUST_GRP_ID , MT.RFA_CTRT_TP_CD       
                      , MT.CUST_SEQ        
                      , (SELECT WM_CONCAT(LD.CNTR_TPSZ_CD) FROM SPC_BKG_ALOC_MGMT_TP_SZ_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ ) CNTR_TPSZ_CD        
                      , (SELECT WM_CONCAT(CMDT.CMDT_CD) FROM SPC_BKG_ALOC_MGMT_CMDT_DTL CMDT WHERE CMDT.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ ) CMDT_CD        
                      , MT.ALOC_LOD_QTY        
                      , MT.ALOC_LOD_QTY_RTO        
                      , MT.VSL_CD        
                      , MT.SKD_VOY_NO        
                      , MT.SKD_DIR_CD        
                      , MT.SLS_RHQ_CD        
                      , MT.SCG_GRP_CMDT_SEQ        
                      , MT.CMPB_AMT -- v_mst_smp_flg = 'Y' 이면 CMPB 룰은 태우지 않음(SMP에서 처리함)        
                      , MT.BKG_CTRL_TP_CD        
                      , MT.DCGO_FLG        
                      , MT.RD_CGO_FLG        
                      , MT.CRE_USR_ID        
                      , MT.CRE_DT        
                      , MT.UPD_USR_ID        
                      , MT.UPD_DT        
                      , MT.ALOC_APLY_FM_DT        
                      , MT.ALOC_APLY_TO_DT        
                      , MT.SUB_TRD_CD        
                      , MT.OFT_CHG_AMT       
                      , MT.USA_BKG_MOD_CD        
                        -- TRUNK, T/S의 경우, Free Type은 Trunk pol-pod, TS pol-pod 동시입력 가능하므로 LOC_DIV_CD 변경함        
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'TPL' AND LENGTH(LD.SB_LOC_CD) = 5) TRNK_POL_CD                
                      , (SELECT WM_CONCAT(LD.SB_LOC_CD) FROM SPC_BKG_ALOC_MGMT_NOD_DTL LD WHERE LD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND LD.SB_LOC_DIV_CD = 'TPD' AND LENGTH(LD.SB_LOC_CD) = 5) TRNK_POD_CD                  
                      , (SELECT WM_CONCAT(AD.CUST_CNT_CD || LPAD(AD.CUST_SEQ, 6, '0')) FROM SPC_BKG_ALOC_MGMT_CUST_DTL AD WHERE AD.BKG_ALOC_SEQ = MT.BKG_ALOC_SEQ AND AD.BKG_CUST_TP_CD = 'B') ACT_CNT_CD          
                      -- FREE 에서 HAUL BOUND 와 BOUND 중에 하나는 필수이므로 MAS_LANE_RGST 참조하여 데이터 가져와야함. [2015.12.14]        
                      , L.HUL_BND_CD         
                      , bkg_list.sls_wk SLS_WK        
                      , L.DIR_CD HUL_DIR_CD        
                      , ASGN_TTL_WGT        
                      , ASGN_WGT_RTO        
                      , CMPB_ONY_FLG        
                      , RVIS_CNTR_CUST_TP_CD        
                      , OP_CNTR_QTY AS CNTR_QTY        
                      , MT.BKG_ALOC_RMK        
                      , MT.CMPB_PER_TON_AMT       
                      , MT.TON_PER_TEU_WGT       
                   FROM SPC_BKG_ALOC_MGMT MT        
                      , MAS_LANE_RGST L        
                  WHERE MT.BKG_ALOC_TP_CD = 'F'        
                    AND (MT.ALOC_USE_FLG IS NULL OR MT.ALOC_USE_FLG   = 'Y')        
                    AND bkg_list.sls_wk BETWEEN NVL(MT.APLY_FM_YRWK, '201501') AND NVL(MT.APLY_TO_YRWK, '209953') -- Week 기준 추가        
                    AND MT.SLS_RHQ_CD   = bkg_list.rhq_cd --필수값        
                    AND MT.SUB_TRD_CD   = bkg_list.sub_trd_cd --필수값        
                    AND L.RLANE_CD      = bkg_list.rlane_cd        
                    AND L.TRD_CD        = bkg_list.trd_cd        
                    AND L.IOC_CD        = bkg_list.ioc_cd        
                           
                    AND (MT.TRNK_SLAN_CD = bkg_list.SLAN_CD OR MT.TRNK_SLAN_CD IS NULL)       
                    AND (MT.OB_SLS_OFC_CD = bkg_list.OB_SLS_OFC_CD OR MT.OB_SLS_OFC_CD IS NULL)       
                    AND (MT.CTRT_CUST_CNT_CD = bkg_list.CTRT_CUST_CNT_CD OR MT.CTRT_CUST_CNT_CD IS NULL)       
                    AND (MT.CTRT_CUST_SEQ = bkg_list.CTRT_CUST_SEQ OR MT.CTRT_CUST_SEQ IS NULL)       
                    AND (MT.SC_NO = bkg_list.SC_NO OR MT.SC_NO IS NULL)       
                    AND (MT.RFA_NO = bkg_list.RFA_NO OR MT.RFA_NO IS NULL)       
                    AND (MT.DCGO_FLG = bkg_list.DCGO_FLG OR MT.DCGO_FLG IS NULL)       
                    AND (MT.RD_CGO_FLG = bkg_list.RD_CGO_FLG OR MT.RD_CGO_FLG IS NULL)       
                    AND (MT.VSL_CD = bkg_list.VSL_CD OR MT.VSL_CD IS NULL)       
                    AND (MT.SKD_VOY_NO = bkg_list.SKD_VOY_NO OR MT.SKD_VOY_NO IS NULL)       
                    AND (MT.SKD_DIR_CD = bkg_list.DIR_CD OR MT.SKD_DIR_CD IS NULL)       
                    AND (L.HUL_BND_CD = bkg_list.HUL_BND_CD OR L.HUL_BND_CD IS NULL)       
                           
                    AND (MT.RFA_CTRT_TP_CD = bkg_list.RFA_CTRT_TP_CD OR MT.RFA_CTRT_TP_CD IS NULL)       
                           
                    AND NVL(MT.HUL_BND_CD, 'XX')  = CASE WHEN MT.HUL_BND_CD IS NOT NULL  THEN L.HUL_BND_CD ELSE 'XX' END        
                    AND NVL(MT.TRNK_DIR_CD, '#@') = CASE WHEN MT.TRNK_DIR_CD IS NOT NULL THEN L.DIR_CD     ELSE '#@' END        
                    AND L.DELT_FLG = 'N'         
                )        
                , BKG AS (        
            SELECT  T.*        
                    , ROUND(T.CMPB_AMT/T.WGT,2)  AS CMPB_PER_TON_AMT        
                    , ROUND(T.WGT/T.BKG_LOD_QTY,2)  AS TON_PER_TEU_WGT        
            FROM (           
                 SELECT MB.BKG_NO        
                      , MB.SLAN_CD        
                      , MB.OB_SLS_OFC_CD        
                      , MB.POR_CD        
                      , MB.POR_NOD_CD        
                      , (SELECT SL.SCC_CD FROM MAS_LOCATION_V SL WHERE SL.LOC_CD = MB.POR_CD ) BKG_POR_SCC_CD        
                      , MB.POL_CD        
                      , MB.POL_NOD_CD        
                      , MB.TRNK_POL_CD        
                      , MB.TRNK_POD_CD        
                      , MB.TRNK_SLAN_CD        
                      , MB.TRNK_DIR_CD        
                      , MB.SLS_WK        
                      , MB.POD_CD        
                      , MB.POD_NOD_CD        
                      , MB.DEL_CD        
                      , MB.DEL_NOD_CD        
                      , (SELECT SL.SCC_CD FROM MAS_LOCATION_V SL WHERE SL.LOC_CD = MB.DEL_CD ) BKG_DEL_SCC_CD        
                      , MB.SC_NO        
                      , MB.RFA_NO        
                      , MB.CTRT_CUST_CNT_CD        
                      , MB.CTRT_CUST_SEQ        
                      , MB.CTRT_CUST_CODE        
                      , MB.CUST_CNT_CD , MB.CUST_GRP_ID, MB.RFA_CTRT_TP_CD       
                      , MB.CUST_SEQ        
                      , MB.CUST_CODE        
                      , (SELECT WM_CONCAT(Q.CNTR_TPSZ_CD) FROM BKG_QUANTITY Q WHERE Q.BKG_NO = MB.BKG_NO ) CNTR_TPSZ_CD        
                      , (SELECT SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', 1, 2) * Q.OP_CNTR_QTY) FROM BKG_QUANTITY Q WHERE Q.BKG_NO = MB.BKG_NO ) AS BKG_LOD_QTY --TEU(Load)        
                      , MB.CMDT_CD        
                      , MB.VSL_CD        
                      , MB.SKD_VOY_NO        
                      , MB.DIR_CD        
                      , (SELECT C.GRP_CMDT_CD FROM MDM_COMMODITY C WHERE C.CMDT_CD = MB.CMDT_CD ) SCG_GRP_CMDT_SEQ        
                      , SUBSTR(MB.POR_CD, 0, 2) BKG_POR_CNT_CD        
                      , SUBSTR(MB.POL_CD, 0, 2) BKG_POL_CNT_CD        
                      , SUBSTR(MB.POD_CD, 0, 2) BKG_POD_CNT_CD        
                      , SUBSTR(MB.DEL_CD, 0, 2) BKG_DEL_CNT_CD        
                      , (SELECT SPC_GET_CMPB_FNC(MB.BKG_NO, NULL) FROM DUAL) AS CMPB_AMT     
                      , MB.DCGO_FLG        
                      , MB.RD_CGO_FLG        
                      , MB.AGMT_ACT_CNT_CD        
                      , MB.AGMT_ACT_CUST_SEQ        
                      , MB.AGMT_ACT_CUST_CODE        
					  , NVL( (SELECT SUM(R.CHG_UT_AMT) FROM BKG_CHG_RT R WHERE R.BKG_NO = MB.BKG_NO AND R.CHG_CD = 'OFT')       
					 	    ,(SELECT MIN(OFT_AMT) KEEP (DENSE_RANK LAST ORDER BY A.REV_COST_SEQ) FROM BKG_REV_COST A WHERE A.BKG_NO = MB.BKG_NO)) AS OFT_CHG_AMT           
                      , MB.USA_BKG_MOD_CD        
                      , MAX(DECODE(SLAN_RK, 1, MB.TS_SLAN_CD))  AS TS_SLAN_CD1        
                      , MAX(DECODE(SLAN_RK, 1, MB.TS_DIR))      AS TS_DIR1        
                      , MAX(DECODE(SLAN_RK, 1, MB.TS_VVD))      AS TS_VVD1        
                      , MAX(DECODE(SLAN_RK, 2, MB.TS_SLAN_CD))  AS TS_SLAN_CD2        
                      , MAX(DECODE(SLAN_RK, 2, MB.TS_DIR))      AS TS_DIR2        
                      , MAX(DECODE(SLAN_RK, 2, MB.TS_VVD))      AS TS_VVD2        
                      , MAX(DECODE(SLAN_RK, 3, MB.TS_SLAN_CD))  AS TS_SLAN_CD3        
                      , MAX(DECODE(SLAN_RK, 3, MB.TS_DIR))      AS TS_DIR3        
                      , MAX(DECODE(SLAN_RK, 3, MB.TS_VVD))      AS TS_VVD3        
                              
                      , MAX(DECODE(RK, 1, NULL))                AS TS_POL_CNT_CD1        
                      , MAX(DECODE(RK, 1, NULL))                AS TS_POL_CD1        
                      , MAX(DECODE(RK, 1, NULL))                AS TS_POL_NOD_CD1        
                      , MAX(DECODE(RK, 1, TS_POD_CNT_CD))       AS TS_POD_CNT_CD1        
                      , MAX(DECODE(RK, 1, TS_POD_CD))           AS TS_POD_CD1        
                      , MAX(DECODE(RK, 1, TS_POD_YD_CD))        AS TS_POD_NOD_CD1        
                      , MAX(DECODE(RK, 2, TS_POL_CNT_CD))       AS TS_POL_CNT_CD2        
                      , MAX(DECODE(RK, 2, TS_POL_CD))           AS TS_POL_CD2        
                      , MAX(DECODE(RK, 2, TS_POL_YD_CD))        AS TS_POL_NOD_CD2        
                      , DECODE(MAX(RK), 2, NULL, MAX(DECODE(RK, 2, TS_POD_CNT_CD)))       AS TS_POD_CNT_CD2        
                      , DECODE(MAX(RK), 2, NULL, MAX(DECODE(RK, 2, TS_POD_CD)))           AS TS_POD_CD2        
                      , DECODE(MAX(RK), 2, NULL, MAX(DECODE(RK, 2, TS_POD_YD_CD)))        AS TS_POD_NOD_CD2        
                      , MAX(DECODE(RK, 3, TS_POL_CNT_CD))       AS TS_POL_CNT_CD3        
                      , MAX(DECODE(RK, 3, TS_POL_CD))           AS TS_POL_CD3        
                      , MAX(DECODE(RK, 3, TS_POL_YD_CD))        AS TS_POL_NOD_CD3        
                      , DECODE(MAX(RK), 3, NULL, MAX(DECODE(RK, 3, TS_POD_CNT_CD)))      AS TS_POD_CNT_CD3        
                      , DECODE(MAX(RK), 3, NULL, MAX(DECODE(RK, 3, TS_POD_CD)))          AS TS_POD_CD3        
                      , DECODE(MAX(RK), 3, NULL, MAX(DECODE(RK, 3, TS_POD_YD_CD)))       AS TS_POD_NOD_CD3        
                              
                      , MB.SLS_RHQ_CD        
                      , MB.RGN_OFC_CD        
                      , bkg_list.sub_trd_cd SUB_TRD_CD        
                      , MB.ALOC_STS_CD        
                      , MB.HUL_BND_CD        
                      , (SELECT SUM((D.ACT_WGT * DECODE(D.WGT_UT_CD, 'LBS', 0.00045, 0.001)) + SUM(Q.OP_CNTR_QTY *        
                                (SELECT TS.CNTR_TPSZ_TARE_WGT FROM MDM_CNTR_TP_SZ TS WHERE TS.CNTR_TPSZ_CD = Q.CNTR_TPSZ_CD )) * 0.001 ) WGT_TTL        
                           FROM BKG_QUANTITY Q        
                              , BKG_BL_DOC D        
                          WHERE MB.BKG_NO     = Q.BKG_NO        
                            AND MB.BKG_NO     = D.BKG_NO        
                            AND Q.OP_CNTR_QTY > 0        
                          GROUP BY D.ACT_WGT * DECODE(D.WGT_UT_CD, 'LBS', 0.00045, 0.001) ) WGT        
                      , (SELECT RVIS_CNTR_CUST_TP_CD FROM MDM_CUSTOMER M        
                          WHERE MB.CTRT_CUST_CNT_CD = M.CUST_CNT_CD AND MB.CTRT_CUST_SEQ    = M.CUST_SEQ ) AS RVIS_CNTR_CUST_TP_CD        
                      , CNTR_QTY        
                   FROM (        
                         SELECT B.BKG_NO        
                              , B.SLAN_CD        
                              , B.OB_SLS_OFC_CD        
                              , B.POR_CD        
                              , B.POR_NOD_CD        
                              , B.POL_CD        
                              , B.POL_NOD_CD        
                              , TV.POL_CD TRNK_POL_CD        
                              , TV.POD_CD TRNK_POD_CD        
                              , TV.SLAN_CD TRNK_SLAN_CD        
                              , TV.SKD_DIR_CD TRNK_DIR_CD        
                              , V.SLS_WK        
                              , B.POD_CD        
                              , B.POD_NOD_CD        
                              , B.DEL_CD        
                              , B.DEL_NOD_CD        
                              , B.SC_NO        
                              , B.RFA_NO        
                              , B.CTRT_CUST_CNT_CD        
                              , B.CTRT_CUST_SEQ        
                              , B.CTRT_CUST_CNT_CD||LPAD(B.CTRT_CUST_SEQ, 6, '0') CTRT_CUST_CODE        
                              , S.CUST_CNT_CD       
                              , S.CUST_SEQ        
                              , S.CUST_CNT_CD||LPAD(S.CUST_SEQ, 6, '0') CUST_CODE        
                              , B.CMDT_CD        
                              , B.VSL_CD        
                              , B.SKD_VOY_NO        
                              , B.SKD_DIR_CD DIR_CD        
                              , SUBSTR(B.POR_CD, 0, 2) BKG_POR_CNT_CD        
                              , SUBSTR(B.POL_CD, 0, 2) BKG_POL_CNT_CD        
                              , SUBSTR(B.POD_CD, 0, 2) BKG_POD_CNT_CD        
                              , SUBSTR(B.DEL_CD, 0, 2) BKG_DEL_CNT_CD        
                              , B.DCGO_FLG        
                              , B.RD_CGO_FLG        
                              , B.AGMT_ACT_CNT_CD        
                              , B.AGMT_ACT_CUST_SEQ        
                              , B.AGMT_ACT_CNT_CD||LPAD(B.AGMT_ACT_CUST_SEQ, 6, '0') AGMT_ACT_CUST_CODE        
                              , CASE WHEN (SUBSTR(B.POR_CD, 1, 2) IN ('CA', 'US') OR SUBSTR(B.DEL_CD, 1, 2) IN ('CA', 'US'))         
                                     THEN (SELECT SPC_USA_MODE_FNC(B.RCV_TERM_CD, B.DE_TERM_CD, B.POR_CD, B.POL_CD, B.POD_CD, B.DEL_CD) FROM DUAL )         
                                     ELSE 'OTH' END AS USA_BKG_MOD_CD        
                              , SV.SLAN_CD TS_SLAN_CD        
                              , SV.VSL_CD||SV.SKD_VOY_NO||SV.SKD_DIR_CD TS_VVD        
                              , SV.SKD_DIR_CD TS_DIR        
                              , DENSE_RANK() OVER ( PARTITION BY SV.BKG_NO ORDER BY SV.VSL_PRE_PST_CD, SV.VSL_SEQ) AS SLAN_RK        
                              , TS.POL_CD TS_POL_CD        
                              , TS.POD_CD TS_POD_CD        
                              , TS.POL_YD_CD TS_POL_YD_CD        
                              , TS.POD_YD_CD TS_POD_YD_CD        
                              , SUBSTR(TS.POL_CD, 1, 2) TS_POL_CNT_CD        
                              , SUBSTR(TS.POD_CD, 1, 2) TS_POD_CNT_CD        
                              , DENSE_RANK() OVER ( PARTITION BY TS.BKG_NO ORDER BY TS.VSL_PRE_PST_CD, TS.VSL_SEQ) AS RK        
                              , O.N2ND_PRNT_OFC_CD SLS_RHQ_CD        
                              , O.N4TH_PRNT_OFC_CD RGN_OFC_CD        
                              , NVL(B.ALOC_STS_CD, 'X') ALOC_STS_CD        
                              , V.HUL_BND_CD        
							  ,(SELECT  CUST_GRP_ID FROM MDM_CUSTOMER C WHERE B.CTRT_CUST_CNT_CD = C.CUST_CNT_CD AND B.CTRT_CUST_SEQ = C.CUST_SEQ) AS CUST_GRP_ID       
                              ,(SELECT MIN(RFA_CTRT_TP_CD) KEEP (DENSE_RANK LAST ORDER BY AMDT_SEQ) FROM PRI_RP_HDR A,PRI_RP_MN B WHERE A.PROP_NO= B.PROP_NO AND PROP_STS_CD = 'A' AND A.RFA_NO= B.RFA_NO) AS RFA_CTRT_TP_CD       
							  ,CASE WHEN QTY.CNTR_TPSZ_CD LIKE 'R%' THEN QTY.OP_CNTR_QTY - EQ_SUBST_CGO_QTY ELSE OP_CNTR_QTY END AS CNTR_QTY  
                           FROM (        
                                 SELECT V1.TRD_CD        
                                      , V1.RLANE_CD        
                                      , SUBSTR(V1.RLANE_CD, 1, 3) SLAN_CD        
                                      , V1.IOC_CD        
                                      , V1.VSL_CD        
                                      , V1.SKD_VOY_NO        
                                      , V1.DIR_CD        
                                      , V1.SUB_TRD_CD        
                                      , M.HUL_BND_CD        
                                      , M.SLS_WK        
                                   FROM MAS_MON_VVD V1        
                                      , (SELECT DISTINCT SLS_WK, SUB_TRD_CD, HUL_BND_CD, HUL_DIR_CD FROM MASTER ) M        
                                  WHERE SUBSTR(V1.SLS_YRMON, 1, 4) || V1.COST_WK = M.SLS_WK        
                                    AND V1.SUB_TRD_CD   = M.SUB_TRD_CD        
                                    AND V1.DIR_CD       = M.HUL_DIR_CD        
                                    AND V1.DELT_FLG     = 'N') V        
                              , BKG_BOOKING B   ,  BKG_QUANTITY QTY     
                              , BKG_VVD TV        
                              , BKG_VVD SV        
                              , BKG_VVD TS        
                              , BKG_CUSTOMER S        
                              , SPC_OFC_LVL O        
                          WHERE 1 = 1 --주차별 Sub Trade/BD별 SUM        
							AND B.BKG_NO = QTY.BKG_NO  
                            AND B.VSL_CD                 = V.VSL_CD        
                            AND B.SKD_VOY_NO             = V.SKD_VOY_NO        
                            AND B.SKD_DIR_CD             = V.DIR_CD        
                            AND B.SLAN_CD                = V.SLAN_CD        
                            AND B.BKG_STS_CD            <> 'X'   
                            AND B.BKG_CGO_TP_CD         IN ('F', 'R')        
                            AND (NVL(B.ALOC_STS_CD, 'X') = 'F'        
                             OR B.BKG_NO                 = v_appl_info)        
                            AND B.BKG_NO                 = TV.BKG_NO        
                            AND TV.VSL_PRE_PST_CD        = 'T'        
                            AND B.BKG_NO                 = SV.BKG_NO(+)        
                            AND SV.VSL_PRE_PST_CD(+)    <> 'T'        
                            AND B.BKG_NO                 = S.BKG_NO        
                            AND B.BKG_NO                 = TS.BKG_NO        
                            AND S.BKG_CUST_TP_CD         = 'S'        
                            AND bkg_list.sls_wk BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK        
                            AND O.OFC_CD = SPC_SCR_OFC_CONV_FNC(B.OB_SLS_OFC_CD, '')        
                            AND bkg_list.rhq_cd = O.N2ND_PRNT_OFC_CD        
                        ) MB        
                GROUP BY MB.BKG_NO        
                      , MB.SLAN_CD        
                      , MB.OB_SLS_OFC_CD        
                      , MB.POR_CD        
                      , MB.POR_NOD_CD        
                      , MB.POL_CD        
                      , MB.POL_NOD_CD        
                      , MB.TRNK_POL_CD        
                      , MB.TRNK_POD_CD        
                      , MB.TRNK_SLAN_CD        
                      , MB.TRNK_DIR_CD        
                      , MB.SLS_WK        
                      , MB.POD_CD        
                      , MB.POD_NOD_CD        
                      , MB.DEL_CD        
                      , MB.DEL_NOD_CD        
                      , MB.SC_NO        
                      , MB.RFA_NO        
                      , MB.CTRT_CUST_CNT_CD        
                      , MB.CTRT_CUST_SEQ        
                      , MB.CTRT_CUST_CODE        
                      , MB.CUST_CNT_CD ,MB.CUST_GRP_ID,RFA_CTRT_TP_CD       
                      , MB.CUST_SEQ        
                      , MB.CUST_CODE        
                      , MB.CMDT_CD        
                      , MB.VSL_CD        
                      , MB.SKD_VOY_NO        
                      , MB.DIR_CD        
                      , MB.DCGO_FLG        
                      , MB.RD_CGO_FLG        
                      , MB.AGMT_ACT_CNT_CD        
                      , MB.AGMT_ACT_CUST_SEQ        
                      , MB.AGMT_ACT_CUST_CODE        
                      , MB.USA_BKG_MOD_CD        
                      , MB.SLS_RHQ_CD        
                      , MB.RGN_OFC_CD        
                      , MB.ALOC_STS_CD        
                      , MB.HUL_BND_CD   
					  , MB.CNTR_QTY        
    ) T                       
 )                        
                , G_SUM AS(        
                        SELECT *        
                          FROM (        
                                 SELECT M.BKG_ALOC_SEQ        
                                      , M.BKG_CTRL_TP_CD      
                                      , NVL(M.ALOC_LOD_QTY, 0) ALOC_LOD_QTY        
                                      , DECODE(NVL(M.ALOC_LOD_QTY, 0), 0, 0, NVL(M.ALOC_LOD_QTY_RTO, 100)) ALOC_LOD_QTY_RTO --ratio가 없으면 물량의 100%        
                                      , DECODE(NVL(M.CNTR_QTY, 0), 0, 0, NVL(M.ALOC_LOD_QTY_RTO, 100)) ALOC_LOD_QTY_BOX_RTO --ratio가 없으면 물량의 100%        
                                      , NVL(M.CMPB_AMT, 0) CMPB_AMT        
                                      , SUM(DECODE(T.BKG_NO, v_appl_info, 0, T.BKG_LOD_QTY)) F_TTL_QTY --전체 Confirm 갯수        
                                      , SUM(DECODE(T.BKG_NO, v_appl_info, BKG.BKG_LOD_QTY, 0)) BKG_QTY --현재 BKG의 갯수 v_appl_info        
                                      , SUM(T.BKG_LOD_QTY) TTL_QTY        
                                      , SUM(T.WGT) TTL_WGT        
                                      , NVL(M.ASGN_TTL_WGT, 0) ASGN_TTL_WGT        
                                      , DECODE(NVL(M.ASGN_TTL_WGT, 0), 0, 0, NVL(M.ASGN_WGT_RTO, 100)) ASGN_WGT_RTO --ratio가 없으면 물량의 100%        
                                      , CMPB_ONY_FLG        
                                      , NVL(M.CNTR_QTY, 0) CNTR_QTY        
                                      , SUM(T.CNTR_QTY) TTL_CNTR_QTY        
                                      , (SELECT NVL( MAX(MODI_SEQ), 1) FROM SPC_BKG_ALOC_MGMT_HIS WHERE BKG_ALOC_SEQ = M.BKG_ALOC_SEQ ) MODI_SEQ --** master 인경우만 BKG_ALOC_SEQ와 MODI_SEQ 값 저장.        
                                      , MAX(DECODE(T.BKG_NO, BKG.BKG_NO, 'Y')) SB_BKG_YN        
                                   FROM (SELECT * FROM BKG WHERE BKG_NO = v_appl_info) BKG        
                                      , BKG T        
                                      , MASTER M        
                                  WHERE M.SLS_RHQ_CD = BKG.SLS_RHQ_CD --필수값                
                                    AND M.SUB_TRD_CD = BKG.SUB_TRD_CD --필수값           
                                    AND M.SLS_RHQ_CD = T.SLS_RHQ_CD --필수값                
                                    AND M.SUB_TRD_CD = T.SUB_TRD_CD --필수값                
                                    AND NVL(M.HUL_BND_CD, '#@') = NVL(T.HUL_BND_CD,'#@') --필수값            
                                    AND NVL(M.RVIS_CNTR_CUST_TP_CD  ,  NVL(T.RVIS_CNTR_CUST_TP_CD,'#@')    ) = NVL(T.RVIS_CNTR_CUST_TP_CD,'#@')               
                                    AND NVL(M.TRNK_SLAN_CD       ,  NVL(T.TRNK_SLAN_CD,'#@')    ) = NVL(T.TRNK_SLAN_CD,'#@')                
                                    AND NVL(M.TRNK_POL_CD        ,  NVL(T.TRNK_POL_CD,'#@')     ) LIKE '%'||NVL(T.TRNK_POL_CD,'#@')||'%'                
                                    AND NVL(M.TRNK_POD_CD        ,  NVL(T.TRNK_POD_CD,'#@')     ) LIKE '%'||NVL(T.TRNK_POD_CD,'#@')||'%'                
                                    AND NVL(M.OB_SLS_OFC_CD      ,  NVL(T.OB_SLS_OFC_CD,'#@')   ) = NVL(T.OB_SLS_OFC_CD,'#@')                
                                    AND NVL(M.POR_CD             ,  NVL(T.POR_CD,'#@')) LIKE '%'||NVL(T.POR_CD,'#@')||'%'                
                                    AND NVL(M.POR_NOD_CD         ,  NVL(T.POR_NOD_CD,'#@')      ) = NVL(T.POR_NOD_CD,'#@')                
                                    AND NVL(M.BKG_POR_SCC_CD     ,  NVL(T.BKG_POR_SCC_CD,'#@')  ) = NVL(T.BKG_POR_SCC_CD,'#@')                
                                    AND NVL(M.POL_CD             ,  NVL(T.POL_CD,'#@')) LIKE '%'||NVL(T.POL_CD,'#@')||'%'                
                                    AND NVL(M.POL_NOD_CD         ,  NVL(T.POL_NOD_CD,'#@')      ) = NVL(T.POL_NOD_CD,'#@')                
                                    -- TS조건 체크 - START               
                                    AND (NVL(M.N1ST_TS_SLAN_CD    , NVL(T.TS_SLAN_CD1, '#@') ) = NVL(T.TS_SLAN_CD1, '#@') OR                
                                         NVL(M.N1ST_TS_SLAN_CD    , NVL(T.TS_SLAN_CD2, '#@') ) = NVL(T.TS_SLAN_CD2, '#@') OR                
                                         NVL(M.N1ST_TS_SLAN_CD    , NVL(T.TS_SLAN_CD3, '#@') ) = NVL(T.TS_SLAN_CD3, '#@'))          
                                    AND (NVL(M.N1ST_TS_DIR_CD    , NVL(T.TS_DIR1, '#@') ) = NVL(T.TS_DIR1, '#@') OR                
                                         NVL(M.N1ST_TS_DIR_CD    , NVL(T.TS_DIR2, '#@') ) = NVL(T.TS_DIR2, '#@') OR                
                                         NVL(M.N1ST_TS_DIR_CD    , NVL(T.TS_DIR3, '#@') ) = NVL(T.TS_DIR3, '#@'))               
                                    AND (NVL(M.N1ST_TS_POL_CD    , NVL(T.TS_POL_CD1, '#@')) LIKE '%'||NVL(T.TS_POL_CD1, '#@')||'%' OR                
                                         NVL(M.N1ST_TS_POL_CD    , NVL(T.TS_POL_CD2, '#@')) LIKE '%'||NVL(T.TS_POL_CD2, '#@')||'%' OR                
                                         NVL(M.N1ST_TS_POL_CD    , NVL(T.TS_POL_CD3, '#@')) LIKE '%'||NVL(T.TS_POL_CD3, '#@')||'%')                
                                    AND (NVL(M.N1ST_TS_POD_CD    , NVL(T.TS_POD_CD1, '#@')) LIKE '%'||NVL(T.TS_POD_CD1, '#@')||'%' OR                
                                         NVL(M.N1ST_TS_POD_CD    , NVL(T.TS_POD_CD2, '#@')) LIKE '%'||NVL(T.TS_POD_CD2, '#@')||'%' OR                
                                         NVL(M.N1ST_TS_POD_CD    , NVL(T.TS_POD_CD3, '#@')) LIKE '%'||NVL(T.TS_POD_CD3, '#@')||'%')                
                                    AND (NVL(M.N1ST_TS_POL_CNT_CD    , NVL(T.TS_POL_CNT_CD1, '#@')) LIKE '%'||NVL(T.TS_POL_CNT_CD1, '#@')||'%' OR                
                                         NVL(M.N1ST_TS_POL_CNT_CD    , NVL(T.TS_POL_CNT_CD2, '#@')) LIKE '%'||NVL(T.TS_POL_CNT_CD2, '#@')||'%' OR                
                                         NVL(M.N1ST_TS_POL_CNT_CD    , NVL(T.TS_POL_CNT_CD3, '#@')) LIKE '%'||NVL(T.TS_POL_CNT_CD3, '#@')||'%')                
                                    AND (NVL(M.N1ST_TS_POD_CNT_CD    , NVL(T.TS_POD_CNT_CD1, '#@')) LIKE '%'||NVL(T.TS_POD_CNT_CD1, '#@')||'%' OR                
                                         NVL(M.N1ST_TS_POD_CNT_CD    , NVL(T.TS_POD_CNT_CD2, '#@')) LIKE '%'||NVL(T.TS_POD_CNT_CD2, '#@')||'%' OR                
                                         NVL(M.N1ST_TS_POD_CNT_CD    , NVL(T.TS_POD_CNT_CD3, '#@')) LIKE '%'||NVL(T.TS_POD_CNT_CD3, '#@')||'%')                   
                                               
                                    AND (NVL(M.TS_ALL_LOC_CD    , NVL(T.TS_POL_CD1, '#@')) LIKE '%'||NVL(T.TS_POL_CD1, '#@')||'%' OR                
                                         NVL(M.TS_ALL_LOC_CD    , NVL(T.TS_POL_CD2, '#@')) LIKE '%'||NVL(T.TS_POL_CD2, '#@')||'%' OR                
                                         NVL(M.TS_ALL_LOC_CD    , NVL(T.TS_POL_CD3, '#@')) LIKE '%'||NVL(T.TS_POL_CD3, '#@')||'%' OR        
                                         NVL(M.TS_ALL_LOC_CD    , NVL(T.TS_POD_CD1, '#@')) LIKE '%'||NVL(T.TS_POD_CD1, '#@')||'%' OR                
                                         NVL(M.TS_ALL_LOC_CD    , NVL(T.TS_POD_CD2, '#@')) LIKE '%'||NVL(T.TS_POD_CD2, '#@')||'%' OR                
                                         NVL(M.TS_ALL_LOC_CD    , NVL(T.TS_POD_CD3, '#@')) LIKE '%'||NVL(T.TS_POD_CD3, '#@')||'%' OR         
                                         NVL(M.TS_ALL_NOD_CD    , NVL(T.TS_POL_NOD_CD1, '#@')) LIKE '%'||NVL(T.TS_POL_NOD_CD1, '#@')||'%' OR                
                                         NVL(M.TS_ALL_NOD_CD    , NVL(T.TS_POL_NOD_CD2, '#@')) LIKE '%'||NVL(T.TS_POL_NOD_CD2, '#@')||'%' OR                
                                         NVL(M.TS_ALL_NOD_CD    , NVL(T.TS_POL_NOD_CD3, '#@')) LIKE '%'||NVL(T.TS_POL_NOD_CD3, '#@')||'%' OR              
                                         NVL(M.TS_ALL_NOD_CD    , NVL(T.TS_POD_NOD_CD1, '#@')) LIKE '%'||NVL(T.TS_POD_NOD_CD1, '#@')||'%' OR                
                                         NVL(M.TS_ALL_NOD_CD    , NVL(T.TS_POD_NOD_CD2, '#@')) LIKE '%'||NVL(T.TS_POD_NOD_CD2, '#@')||'%' OR                
                                         NVL(M.TS_ALL_NOD_CD    , NVL(T.TS_POD_NOD_CD3, '#@')) LIKE '%'||NVL(T.TS_POD_NOD_CD3, '#@')||'%')         
                                                      
                                    AND (NVL(M.TS_POL_NOD_CD    , NVL(T.TS_POL_NOD_CD1, '#@')) LIKE '%'||NVL(T.TS_POL_NOD_CD1, '#@')||'%' OR                
                                         NVL(M.TS_POL_NOD_CD    , NVL(T.TS_POL_NOD_CD2, '#@')) LIKE '%'||NVL(T.TS_POL_NOD_CD2, '#@')||'%' OR                
                                         NVL(M.TS_POL_NOD_CD    , NVL(T.TS_POL_NOD_CD3, '#@')) LIKE '%'||NVL(T.TS_POL_NOD_CD3, '#@')||'%')             
                                                       
                                    AND (NVL(M.TS_POD_NOD_CD    , NVL(T.TS_POD_NOD_CD1, '#@')) LIKE '%'||NVL(T.TS_POD_NOD_CD1, '#@')||'%' OR                
                                         NVL(M.TS_POD_NOD_CD    , NVL(T.TS_POD_NOD_CD2, '#@')) LIKE '%'||NVL(T.TS_POD_NOD_CD2, '#@')||'%' OR                
                                         NVL(M.TS_POD_NOD_CD    , NVL(T.TS_POD_NOD_CD3, '#@')) LIKE '%'||NVL(T.TS_POD_NOD_CD3, '#@')||'%')         
                                    -- TS조건 체크 - END             
                                    AND NVL(M.POD_CD             , NVL(T.POD_CD,'#@')              ) LIKE '%'||NVL(T.POD_CD, '#@')||'%'                
                                    AND NVL(M.POD_NOD_CD         , NVL(T.POD_NOD_CD,'#@')          ) = NVL(T.POD_NOD_CD, '#@')                
                                    AND NVL(M.DEL_CD             , NVL(T.DEL_CD,'#@')              ) LIKE '%'||NVL(T.DEL_CD, '#@')||'%'                
                                    AND NVL(M.DEL_NOD_CD         , NVL(T.DEL_NOD_CD,'#@')          ) = NVL(T.DEL_NOD_CD, '#@')                
                                    AND NVL(M.BKG_DEL_SCC_CD     , NVL(T.BKG_DEL_SCC_CD,'#@')      ) = NVL(T.BKG_DEL_SCC_CD, '#@')                
                                    AND NVL(M.SC_NO              , NVL(T.SC_NO, '#@')     ) = NVL(T.SC_NO, '#@')                
                                    AND NVL(M.RFA_NO             , NVL(T.RFA_NO, '#@')    ) = NVL(T.RFA_NO, '#@')                
                                    AND NVL(M.CTRT_CUST_CNT_CD   , NVL(T.CTRT_CUST_CNT_CD, '#@')    ) = NVL(T.CTRT_CUST_CNT_CD, '#@')                
                                    AND NVL(M.CTRT_CUST_SEQ      , NVL(T.CTRT_CUST_SEQ, 0)    ) = NVL(T.CTRT_CUST_SEQ, 0)                
                                    AND NVL(M.CUST_CNT_CD        , NVL(T.CUST_CNT_CD, '#@')        ) = NVL(T.CUST_CNT_CD, '#@')           
									AND NVL(M.CUST_GRP_ID        , NVL(T.CUST_GRP_ID, '#@')        ) = NVL(T.CUST_GRP_ID, '#@')    		       
                                    AND NVL(M.RFA_CTRT_TP_CD     , NVL(T.RFA_CTRT_TP_CD, '#@')        ) = NVL(T.RFA_CTRT_TP_CD, '#@')    		       
                                    AND NVL(M.CUST_SEQ           , NVL(T.CUST_SEQ, 0)          ) = NVL(T.CUST_SEQ, 0)                
                                    AND NVL(M.CNTR_TPSZ_CD       , NVL(T.CNTR_TPSZ_CD, '#@')      )  LIKE '%'||NVL(T.CNTR_TPSZ_CD, '#@')||'%'                
                                    AND NVL(M.CMDT_CD            , NVL(T.CMDT_CD, '#@')             ) LIKE '%'||NVL(T.CMDT_CD, '#@')||'%'                
                                    AND NVL(M.VSL_CD             , T.VSL_CD              ) = T.VSL_CD                
                                    AND NVL(M.SKD_VOY_NO         , T.SKD_VOY_NO          ) = T.SKD_VOY_NO                
                                    AND NVL(M.SKD_DIR_CD         , T.DIR_CD              ) = T.DIR_CD                
                                                 
                                    AND NVL(TO_CHAR(M.SCG_GRP_CMDT_SEQ)   , NVL(T.SCG_GRP_CMDT_SEQ, '#@')    ) = NVL(T.SCG_GRP_CMDT_SEQ, '#@')                
                                    AND NVL(M.POR_CNT_CD     , NVL(T.BKG_POR_CNT_CD, '#@')      )  LIKE '%'||NVL(T.BKG_POR_CNT_CD, '#@')||'%'                
                                    AND NVL(M.POL_CNT_CD     , NVL(T.BKG_POL_CNT_CD, '#@')      )  LIKE '%'||NVL(T.BKG_POL_CNT_CD, '#@')||'%'       
                                    AND NVL(M.POD_CNT_CD     , NVL(T.BKG_POD_CNT_CD, '#@')      )  LIKE '%'||NVL(T.BKG_POD_CNT_CD, '#@')||'%'                
                                    AND NVL(M.DEL_CNT_CD     , NVL(T.BKG_DEL_CNT_CD, '#@')      )  LIKE '%'||NVL(T.BKG_DEL_CNT_CD, '#@')||'%'                
                                    AND NVL(M.DCGO_FLG           , NVL(T.DCGO_FLG, 'N')          ) = NVL(T.DCGO_FLG, 'N')                
                                    AND NVL(M.RD_CGO_FLG         , NVL(T.RD_CGO_FLG, 'N')        ) = NVL(T.RD_CGO_FLG, 'N')                
                                    AND NVL(M.ACT_CNT_CD         , NVL((T.AGMT_ACT_CNT_CD||LPAD(T.AGMT_ACT_CUST_SEQ, 6, '0')), '#@')) LIKE '%'|| NVL((T.AGMT_ACT_CNT_CD||LPAD(T.AGMT_ACT_CUST_SEQ, 6, '0')), '#@')||'%'                
                                    AND NVL(M.OFT_CHG_AMT        , NVL(T.OFT_CHG_AMT, 0)    )    >= NVL(T.OFT_CHG_AMT, 0)                
                                    AND NVL(M.USA_BKG_MOD_CD     , NVL(T.USA_BKG_MOD_CD, 'OTH') )     = NVL(T.USA_BKG_MOD_CD, 'OTH')                
                                    AND CASE v_mst_smp_flg WHEN 'N' THEN ( CASE NVL(M.CMPB_AMT,0) WHEN 0 THEN 1 ELSE NVL(M.CMPB_AMT,1) END)                 
                                                            ELSE (CASE M.CMPB_ONY_FLG WHEN 'Y' THEN 0 ELSE NVL(M.CMPB_AMT,1) END) END                
                                        >                 
                                        CASE v_mst_smp_flg WHEN 'N' THEN ( CASE NVL(M.CMPB_AMT,0) WHEN 0 THEN 0 ELSE NVL(T.CMPB_AMT,0) END)                 
                                                            ELSE (CASE M.CMPB_ONY_FLG WHEN 'Y' THEN 0 ELSE NVL(T.CMPB_AMT,0) END) END           
                                    AND (CASE NVL(M.CMPB_PER_TON_AMT,0) WHEN 0 THEN 1 ELSE NVL(M.CMPB_PER_TON_AMT,1) END) >= (CASE NVL(M.CMPB_PER_TON_AMT,0) WHEN 0 THEN 0 ELSE NVL(T.CMPB_PER_TON_AMT,0) END)           
                                    AND (CASE NVL(M.TON_PER_TEU_WGT,0) WHEN 0 THEN 0 ELSE NVL(M.TON_PER_TEU_WGT,1) END) <= (CASE NVL(M.TON_PER_TEU_WGT,0) WHEN 0 THEN 1 ELSE NVL(T.TON_PER_TEU_WGT,0) END)                                                                      
                                  GROUP BY M.BKG_ALOC_SEQ        
                                      , M.BKG_CTRL_TP_CD      
                                      , M.ALOC_LOD_QTY        
                                      , M.ALOC_LOD_QTY_RTO        
                                      , M.CMPB_AMT        
                                      , ASGN_TTL_WGT        
                                      , ASGN_WGT_RTO        
                                      , CMPB_ONY_FLG        
                                      , M.CNTR_QTY        
                                )        
                          WHERE 1 =1        
                            AND SB_BKG_YN = 'Y'        
                            AND (DECODE(ALOC_LOD_QTY, 0, 1, ROUND(TTL_QTY/ALOC_LOD_QTY * 100, 1)) > DECODE(ALOC_LOD_QTY, 0, 0, ALOC_LOD_QTY_RTO)        
                            AND DECODE(ASGN_TTL_WGT, 0, 1, ROUND(TTL_WGT/ASGN_TTL_WGT * 100, 1))  > DECODE(ASGN_TTL_WGT, 0, 0, ASGN_WGT_RTO)        
                            AND DECODE(CNTR_QTY, 0, 1, ROUND(TTL_CNTR_QTY/CNTR_QTY * 100, 1))     > DECODE(CNTR_QTY, 0, 0, ALOC_LOD_QTY_BOX_RTO) )        
                            -- SMP대상은 CMPB_ONY_FLG='Y'인 조건은 해당 룰을 적용하지 않고, 나머지는 적용한다.        
                            AND CASE v_mst_smp_flg WHEN 'N' THEN ( CASE NVL(CMPB_AMT, 0) WHEN 0 THEN 1 ELSE NVL(CMPB_AMT, 1) END)         
                                                    ELSE (CASE CMPB_ONY_FLG WHEN 'Y' THEN 0 ELSE NVL(CMPB_AMT, 1) END) END         
                                >         
                                CASE v_mst_smp_flg WHEN 'N' THEN ( CASE NVL(CMPB_AMT, 0) WHEN 0 THEN 0 ELSE TO_NUMBER(NVL(bkg_list.cmpb, 0)) END)         
                                                    ELSE (CASE CMPB_ONY_FLG WHEN 'Y' THEN 0 ELSE TO_NUMBER(NVL(bkg_list.cmpb, 0)) END) END        
                  )        
             SELECT MAX(DECODE(ALOC_STS_CD, 'S', ALOC_STS_CD)) V11        
                  , MAX(DECODE(ALOC_STS_CD, 'S', ALOC_SVC_CD)) V12        
                  , MAX(DECODE(ALOC_STS_CD, 'S', BKG_ALOC_SEQ)) V13        
                  , MAX(DECODE(ALOC_STS_CD, 'S', LST_SB_RS)) V14        
                  , MAX(DECODE(ALOC_STS_CD, 'S', MODI_SEQ)) V15        
                  , MAX(DECODE(ALOC_STS_CD, 'A', ALOC_STS_CD)) V21        
                  , MAX(DECODE(ALOC_STS_CD, 'A', ALOC_SVC_CD)) V22        
                  , MAX(DECODE(ALOC_STS_CD, 'A', BKG_ALOC_SEQ)) V23        
                  , MAX(DECODE(ALOC_STS_CD, 'A', LST_SB_RS)) V24        
                  , MAX(DECODE(ALOC_STS_CD, 'A', MODI_SEQ)) V25       
              INTO v_mst_f_rlst, v_mst_f_svc_cd, v_mst_f_seq ,  v_mst_f_rs, v_modi_f_seq    
                 , a_mst_f_rlst, a_mst_f_svc_cd, a_mst_f_seq ,  a_mst_f_rs, a_modi_f_seq       
              FROM (SELECT ALOC_STS_CD        
                         , ALOC_SVC_CD        
                         , BKG_ALOC_SEQ        
                         , LST_SB_RS        
                         , MODI_SEQ        
                      FROM (SELECT BKG_CTRL_TP_CD AS ALOC_STS_CD        
                                 , 'A' ALOC_SVC_CD        
                                 , BKG_ALOC_SEQ        
                                 , 'SMP FLG:' || v_mst_smp_flg || ', Firm TTL Qty:' || F_TTL_QTY || ', BKG Qty:' || BKG_QTY || ', BKG CMPB:' || bkg_list.cmpb AS LST_SB_RS        
                                 , MODI_SEQ        
                                 , DENSE_RANK() OVER(PARTITION BY BKG_CTRL_TP_CD ORDER BY BKG_CTRL_TP_CD) F_ROW     
                              FROM G_SUM        
                           )        
                     WHERE F_ROW=1        
                  ) ;        
                               
                EXCEPTION               
                        WHEN NO_DATA_FOUND THEN               
                        v_mst_f_rlst := NULL;               
                        v_mst_f_svc_cd := NULL;               
                        v_mst_f_seq := NULL;               
                        v_mst_f_rs := NULL;               
                        v_modi_f_seq := NULL;               
                        a_mst_f_rlst := NULL;               
                        a_mst_f_svc_cd := NULL;               
                        a_mst_f_seq := NULL;               
                        a_mst_f_rs := NULL;               
                        a_modi_f_seq := NULL;               
                END;                          
                         
                enis_log_prc(SYSDATE, v_prc_nm, v_step || ': '|| NVL(v_mst_f_rlst,'N'), v_appl_info);       
                                      
            --Master중 하나라도 걸리면 Y               
            IF (a_mst_t_rlst ='A' OR a_mst_s_rlst='A' OR a_mst_c_rlst='A' OR a_mst_e_rlst='A' OR a_mst_m_rlst='A' OR a_mst_f_rlst='A') THEN               
                a_sb_ck_rlst := 'A';                              
            END IF;            
            IF (v_mst_t_rlst ='S' OR v_mst_s_rlst='S' OR v_mst_c_rlst='S' OR v_mst_e_rlst='S' OR v_mst_m_rlst='S' OR v_mst_f_rlst='S') THEN               
                v_sb_ck_rlst := 'S';               
            END IF;               
       
            --  BKG단 계산이거나               
            --, Master 로 인해 Standby상태로 된 BKG인 경우 reapply 대상이 있는 경우 수행 종료               
            END IF;               
                           
               
        enis_log_prc(SYSDATE, v_prc_nm, '1. MasterTable END v_sb_ck_rlst=' || v_sb_ck_rlst ||' Attention'|| a_sb_ck_rlst, v_appl_info);               
                
        /************************************************************************                
         Control Option 중 BKG Control Option의 SMP 제약조건이                
         Must 이거나, v_smp_lf_cnt = 0 이면 BKG Control 수행                
        ************************************************************************/    
IF (v_smp_must_flg='Y' OR (v_smp_fcst_flg='Y' AND v_smp_lf_cnt =0))  THEN    
 
        v_step := '2. SMP';                
        enis_log_prc(SYSDATE, v_prc_nm, v_step || ' START', v_appl_info);                
                            
        /************************************************************************                
        SMP 제약조건 수행                
        미주 BKG은 SMP 제약조건 수행 안함 (bkg_list.RHQ_CD = 'NYCRA') 20150721 제외요청 by shin                
        ************************************************************************/  
        -- By Lane 별 체크인지 확인
        BEGIN     
                SELECT DISTINCT NVL(BKG_CTRL_LANE_FLG,'N')       
                  INTO v_bkg_ctrl_lane_flg   
                  FROM SPC_BKG_CTRL_OPT_DTL    
                 WHERE TRD_CD     = bkg_list.TRD_CD            
                   AND SUB_TRD_CD = bkg_list.SUB_TRD_CD               
                   AND RLANE_CD   = bkg_list.RLANE_CD                        
                   AND DIR_CD     = bkg_list.DIR_CD          
                   AND BKG_CTRL_TP_CD = 'S'   
                   AND ROWNUM = 1;                         
        EXCEPTION                
                  WHEN NO_DATA_FOUND THEN                
                         v_bkg_ctrl_lane_flg := 'N';                
        END;                      
        
        -- By Lane 일 경우                       
        IF (v_bkg_ctrl_lane_flg='Y') THEN 
            BEGIN                
                select count(*)                
                  into v_smp_raply_cnt                
                  from SPC_MDL_CUST_REV_LANE                
                 where cost_yrwk     = SUBSTR(v_mst_smp_season, 1, 6)                
                   and ver_seq       = SUBSTR(v_mst_smp_season, 8)                
                   and trd_cd        = bkg_list.TRD_CD                
                   and sub_trd_cd    = bkg_list.SUB_TRD_CD              
                   and rlane_cd      = bkg_list.RLANE_CD                
                   and RAPLY_CFM_FLG = '1';                
            EXCEPTION                
                  WHEN NO_DATA_FOUND THEN                
                         v_smp_raply_cnt := 0;                
            END; 
        -- By Sub Trade 일 경우    
        ELSE
            BEGIN                
                select count(*)                
                  into v_smp_raply_cnt                
                  from SPC_MDL_CUST_REV_LANE                
                 where cost_yrwk     = SUBSTR(v_mst_smp_season, 1, 6)                
                   and ver_seq       = SUBSTR(v_mst_smp_season, 8)                
                   and trd_cd        = bkg_list.TRD_CD                
                   and sub_trd_cd    = bkg_list.SUB_TRD_CD                 
                   and RAPLY_CFM_FLG = '1';                
            EXCEPTION                
                  WHEN NO_DATA_FOUND THEN                
                         v_smp_raply_cnt := 0;                
            END;                
        END IF;   
                
        BEGIN                
         SELECT LST_SB_RSN_TP_CD                
          INTO v_old_smp_rsn_tp_cd                
          FROM SPC_SB_BKG B, SPC_SB_BKG_DTL D                
         WHERE B.BKG_NO           = v_appl_info                
           AND B.BKG_NO           = D.BKG_NO             
           AND D.LST_SB_RSN_TP_CD = 'S'            
           AND D.BKG_CTRL_TP_CD = 'S'               
           AND ROWNUM = 1                
           ;                
        EXCEPTION                
            WHEN NO_DATA_FOUND THEN                
                 v_old_smp_rsn_tp_cd := '';                
        END;                
        --SMP대상일 경우 아래 로직을 처리한다.                
        --IF ((v_smp_must_flg='Y' OR v_smp_fcst_flg='Y') and (in_mode IN ('B','R') or ( in_mode  = 'W' and v_smp_raply_cnt>0 and v_old_smp_rsn_tp_cd IN ('S','A') ))) THEN                
        IF ((v_smp_must_flg='Y' OR v_smp_fcst_flg='Y') and (in_mode IN ('B','R','W') )) THEN 
        BEGIN
            v_step := '2-1. SMP 대상';                
            enis_log_prc(SYSDATE, v_prc_nm, v_step , v_appl_info);                
            enis_log_prc(SYSDATE, v_prc_nm, 'INFO_' || ' SLS_YRWK :' || bkg_list.SLS_WK                
                                                    || ' SEASON   :' || v_mst_smp_season                
                                                    || ' BKG_NO   :' || bkg_list.BKG_NO                
                                                    || ' RLANE_CD :' || bkg_list.RLANE_CD                
                                                    || ' DIR_CD   :' || bkg_list.DIR_CD                
                                                    || ' VVD      :' || bkg_list.VSL_CD|| bkg_list.SKD_VOY_NO || bkg_list.DIR_CD                
                                          , v_appl_info);                
            WITH BASIC_INFO AS (                
                                -- VVD 별 컨트롤 옵션을 조회함(Lane과 VVD별 control option 이 다를수 있음)                
                                SELECT bkg_list.SLS_WK                AS SLS_YRWK                
                                      ,SUBSTR(v_mst_smp_season, 1, 6) AS COST_YRWK                
                                      ,SUBSTR(v_mst_smp_season, 8)    AS VER_SEQ                
                                      ,A1.REP_TRD_CD                  AS TRD_CD                
                                      ,A1.REP_SUB_TRD_CD              AS SUB_TRD_CD                
                                      ,A1.RLANE_CD                
                                      ,A1.VSL_CD                
                                      ,A1.SKD_VOY_NO                
                                      ,A1.SKD_DIR_CD                  AS DIR_CD                
                                      ,DECODE(A1.BKG_CTRL_ACCT_GRP_APLY_FLG,'Y','S','*') AS BKG_CTRL_TP_CD                
                                      ,bkg_list.BKG_NO AS BKG_NO  ,BKG_CTRL_ACCT_GRP_TP_CD             
                                  FROM SPC_ALOC_CTRL_OPT A1                
                                 WHERE A1.RLANE_CD   = BKG_LIST.RLANE_CD   --'ADNAE'                
                                   AND A1.DIR_CD     = BKG_LIST.DIR_CD     --'W'                
                                   AND A1.VSL_CD     = BKG_LIST.VSL_CD     --'EEVY'                
                                   AND A1.SKD_VOY_NO = BKG_LIST.SKD_VOY_NO --'0111'                
                                   AND A1.SKD_DIR_CD = BKG_LIST.DIR_CD     --'W'                
                                )                
                 -- BKG Contral Option 중 SMP 대상의 Yield Group의 Ratio를 조회한다.                
                 ,BKG_OPTION AS (                
                               SELECT A2.TRD_CD                
                                     ,A1.COST_YRWK                
                                     ,A1.VER_SEQ                
                                     ,A2.SUB_TRD_CD              
                                     ,A2.RLANE_CD              
                                     ,A2.DIR_CD                
                                     ,A2.BKG_CTRL_DTL_CD AS CUST_CTRL_CD                
                                     ,A2.BKG_CTRL_RTO                
                                     ,A2.BKG_CTRL_ACCT_FLG              
                                     ,A2.BKG_CTRL_LANE_FLG              
                                     ,BKG_CTRL_ACCT_GRP_TP_CD             
                                 FROM BASIC_INFO A1                
                                     ,SPC_BKG_CTRL_OPT_DTL A2                
                                WHERE A1.TRD_CD         = A2.TRD_CD                
                                  AND A1.SUB_TRD_CD     = A2.SUB_TRD_CD                
                                  -- 대표 Rlane/Bound 정보가 들어가 있어서 Rlane/Bound 정보를 걸어주면 안됨                
                                  --AND A1.RLANE_CD       = A2.RLANE_CD                
                                  --AND A1.DIR_CD         = A2.DIR_CD              
                                  AND A2.RLANE_CD       = NVL((SELECT DISTINCT A3.RLANE_CD               
                                                                 FROM SPC_BKG_CTRL_OPT_DTL A3              
                                                                WHERE A3.TRD_CD     = A1.TRD_CD              
                                                                  AND A3.SUB_TRD_CD = A1.SUB_TRD_CD              
                                                                  AND A3.RLANE_CD   = A1.RLANE_CD               
                                                                  AND A3.DIR_CD     = A1.DIR_CD              
                                                                  AND A3.BKG_CTRL_LANE_FLG = 'Y'), 'XXXXX')                 
                                  AND A2.DIR_CD         = NVL((SELECT DISTINCT A3.DIR_CD               
                                                                  FROM SPC_BKG_CTRL_OPT_DTL A3              
                                                                 WHERE A3.TRD_CD     = A1.TRD_CD              
                                                                   AND A3.SUB_TRD_CD = A1.SUB_TRD_CD              
                                                                   AND A3.RLANE_CD   = A1.RLANE_CD               
                                                                   AND A3.DIR_CD     = A1.DIR_CD              
                                                                   AND A3.BKG_CTRL_LANE_FLG = 'Y'), 'X')                
                                  AND A1.BKG_CTRL_TP_CD =  A2.BKG_CTRL_TP_CD                
                         )                
            SELECT 'Trade:'           || C1.TRD_CD     ||                
                   ', SubTrade:'      || C1.SUB_TRD_CD ||              
                   ', RLane:'         || C1.RLANE_CD   ||               
                   ', SC_NO:'         || C1.SC_NO      ||                
                   ', RFA_NO:'        || C1.RFA_NO     ||                
                   ', Account:'       || C1.CUST_CD    ||                
                   ', Office:'        || C1.SLS_OFC_CD ||                
                   ', Yield Group:'   || C1.CUST_CTRL_CD ||                
                   ', Ratio:'         || C1.BKG_CTRL_RTO ||                
                   ', by Account:'    || C1.BKG_CTRL_ACCT_FLG ||                
                   ', by Lane:'       || C1.BKG_CTRL_LANE_FLG ||                
                   ', SMP Total QTY:' || C1.SMP_QTY      ||                
                   ', SMP Ratio QTY:' || C1.TOT_SMP_QTY  ||                
                   ', BKG Total QTY:' || C1.BKG_QTY      ||                
                   ', Target BKG QTY:'|| C1.TARGET_BKG_QTY ||                
                   --디버깅에 필요한 정보                
                   ', SLS_YRWK:'      || bkg_list.SLS_WK ||                
                   ', SEASON:'   || v_mst_smp_season   ||                
                   ', BKG_NO:'   || bkg_list.BKG_NO    ||                
                   ', RLANE_CD:' || bkg_list.RLANE_CD  ||                
                   ', DIR_CD:'   || bkg_list.DIR_CD    ||                
                   ', VVD:'      || bkg_list.VSL_CD|| bkg_list.SKD_VOY_NO || bkg_list.DIR_CD                
                   AS SMP_REASON                
                  , C1.ALOC_STS_CD, C1.SC_NO, C1.RFA_NO, C1.CUST_CD, C1.SUB_TRD_CD, bkg_list.VSL_CD|| bkg_list.SKD_VOY_NO || bkg_list.DIR_CD, c1.SLS_OFC_CD, C1.RLANE_CD                
               INTO v_smp_reason, v_smp_aloc_sts_cd, v_sc_no, v_rfa_no, v_acct_cd, v_sub_trd_cd, v_vvd_cd, v_ofc_cd, v_rlane_cd                
               FROM (                
                    SELECT *                
                      FROM (                
                            SELECT B1.TRD_CD                
                                  ,B1.SUB_TRD_CD              
                                  ,B1.RLANE_CD              
                                  ,B1.CUST_CD                
                                  ,B1.SC_NO                
                                  ,B1.RFA_NO                
                                  ,B1.SLS_OFC_CD                
                                  ,B1.CUST_CTRL_CD                
                                  ,B1.BKG_CTRL_ACCT_FLG              
                                  ,B1.BKG_CTRL_LANE_FLG              
                                  ,MAX(B1.BKG_CTRL_RTO) AS BKG_CTRL_RTO                
                                  ,SUM(B1.SMP_QTY) AS SMP_QTY                
                                  ,SUM(B1.SMP_QTY) * (MAX(B1.BKG_CTRL_RTO)/100) TOT_SMP_QTY                
                                  ,SUM(B1.BKG_QTY) AS BKG_QTY                
                                  ,SUM(B1.TARGET_BKG_QTY) AS TARGET_BKG_QTY                
                                  ,(SUM(B1.SMP_QTY) * (MAX(B1.BKG_CTRL_RTO)/100) ) - (SUM(B1.BKG_QTY) + SUM(B1.TARGET_BKG_QTY)) AA                
                                  ,CASE WHEN ((SUM(B1.SMP_QTY) * (MAX(B1.BKG_CTRL_RTO)/100)) - (SUM(B1.BKG_QTY) + SUM(B1.TARGET_BKG_QTY))) < 0 THEN MAX(B1.BKG_CTRL_ACCT_GRP_TP_CD) ELSE 'F' END ALOC_STS_CD                
                                  --0608 추가                
                                  , MAX(B1.DELT_FLG) DELT_FLG                
                                  , MAX(B1.IS_MAX) IS_MAX                
                              FROM (                
                                    -- BKG이 포함된 주차의 BKG 물량 정보를 조회한다.                
                                    SELECT D1.TRD_CD                
                                          ,D1.SUB_TRD_CD              
                                          ,D1.RLANE_CD              
                                          ,D1.CUST_CD                
                                          ,D1.SC_NO                
                                          ,D1.RFA_NO                
                                          ,D1.SLS_OFC_CD                
                                          ,D1.CUST_CTRL_CD                
                                          ,D2.BKG_CTRL_RTO                
                                          ,D2.BKG_CTRL_ACCT_FLG              
                                          ,D2.BKG_CTRL_LANE_FLG              
                                          ,0 AS SMP_QTY                
                                          ,BKG_QTY                
                                          ,TARGET_BKG_QTY                
                                          , NULL AS IS_MAX   ,BKG_CTRL_ACCT_GRP_TP_CD             
                                          , NULL AS DELT_FLG                
                                      FROM (                
                                            SELECT C1.TRD_CD                
                                                  ,C1.SUB_TRD_CD              
                                                  ,DECODE(C1.BKG_CTRL_LANE_FLG, 'Y', C1.RLANE_CD, '') RLANE_CD              
                                                  ,C1.SLS_OFC_CD                
                                                  ,C1.CUST_CD                
                                                  ,C1.SHP_CUST_CD                
                                                  ,C1.SC_NO                
                                                  ,C1.RFA_NO                
                                                  --SPC_MDL_CUST_CTRL의 CUST_CTRL_CD를 선적용 후 SPC_MDL_CUST_RFA의 CUST_CTRL_CD을 적용.                   
                                                  ,NVL(C2.CUST_CTRL_CD, C1.CUST_CTRL_CD) AS CUST_CTRL_CD                   
                                                  ,SUM(DECODE(C1.TARGET_BKG, C1.BKG_NO, 0, C1.BKG_QTY)) BKG_QTY                
                                                  ,SUM(DECODE(C1.TARGET_BKG, C1.BKG_NO, C1.BKG_QTY, 0)) TARGET_BKG_QTY                
                                              FROM (                
                                                    SELECT B1.BKG_NO                
                                                          ,B1.TRD_CD                
                                                          ,B1.SUB_TRD_CD              
                                                          ,B1.RLANE_CD              
                                                          ,B1.BKG_CTRL_LANE_FLG                
                                                          ,B1.SLS_OFC_CD                
                                                          ,B1.CTRT_CUST_CNT_CD                
                                                          ,B1.CTRT_CUST_SEQ                
                                                          ,B1.CUST_CD                
                                                          ,B1.SHP_CUST_CNT_CD || LPAD(B1.SHP_CUST_SEQ,6,'0') SHP_CUST_CD                
                                                          ,B1.SC_NO                
                                                          ,B1.RFA_NO                
                                                           -- AES/IAS 노선 (즉 RFA 계약을 사용하는 노선) 중 국가가 CN 일 경우 Yield group 코드를 B2 테이블 정보를 본다.                
                                                          ,CASE WHEN (B1.TRD_CD = 'AES' or B1.TRD_CD = 'IAS' )                    
                                                                      --AND B1.RFA_NO IS NOT NULL                    
                                                                      AND B1.SHP_CUST_CNT_CD = 'CN'                    
                                                                THEN B2.CUST_CTRL_CD                   
                                                                ELSE NULL                   
                                                           END CUST_CTRL_CD                   
                                                          ,B1.COST_YRWK                
                                                          ,B1.VER_SEQ                
                                                          ,B1.TARGET_BKG                
                                                          ,B1.BKG_QTY                
                                                      FROM (                
                                                            -- BKG 의 물량정보를 조회 한다.                
                                                            SELECT A2.BKG_NO,                
                                                                   A1.TRD_CD                
                                                                  ,A1.SUB_TRD_CD              
                                                                  ,A1.RLANE_CD              
                                                                  ,A1.BKG_CTRL_LANE_FLG              
                                                                  ,A5.N4TH_PRNT_OFC_CD AS SLS_OFC_CD                
                                                                  ,A2.CTRT_CUST_CNT_CD                
                                                                  ,A2.CTRT_CUST_SEQ                
                                                                  ,A2.CTRT_CUST_CNT_CD||LPAD(A2.CTRT_CUST_SEQ,6,'0') AS CUST_CD                
                                                                  ,A4.CUST_CNT_CD AS SHP_CUST_CNT_CD                
                                                                  ,A4.CUST_SEQ    AS SHP_CUST_SEQ                
                                                                  ,A2.POL_CD      AS BKG_POL_CD                
                                                                  ,A2.POD_CD      AS BKG_POD_CD                
                                                                  ,A2.CMDT_CD                   
                                                                  ,A2.SC_NO                
                                                                  ,A2.RFA_NO                
                                                                  ,A1.COST_YRWK                
                                                                  ,A1.VER_SEQ                
                                                                  ,A1.TARGET_BKG                
                                                                  ,0 AS BKG_CTRL_RTO                
                                                                  ,0 AS SMP_QTY                
                                                                  ,DECODE(SPC_GET_CNTR_SZ_FNC(A3.CNTR_TPSZ_CD), '2', 1, 2) * A3.OP_CNTR_QTY BKG_QTY                
                                                              FROM (                
                                                                    -- BKG이 포함된 Trade-sub Trade-주차 에 해당하는 VVD 대상을 선정한다(단 Head Haul만)                
                                                                    SELECT DISTINCT              
                                                                           S2.TRD_CD                
                                                                          ,S2.SUB_TRD_CD                
                                                                          ,S2.RLANE_CD                
                                                                          ,S2.DIR_CD              
                                                                          ,S3.BKG_CTRL_LANE_FLG              
                                                                          ,S1.SLS_YRWK                
                                                                          ,S1.COST_YRWK                
                                                                          ,S1.VER_SEQ                
                                                                          ,S2.VSL_CD                
                                                                          ,S2.SKD_VOY_NO                
                                                                          ,S1.BKG_NO AS TARGET_BKG                
                                                                      FROM BASIC_INFO S1                
                                                                          ,MAS_MON_VVD S2    -- 해당 TRADE-SUB TRADE 별 VVD 대상을 조회 하기 위해                
                                                                          ,SPC_HD_HUL_MST S4 -- HEAD HAUL 정보만 조회 하기 위해서               
                                                                          ,BKG_OPTION S3               
                                                                     WHERE S1.SLS_YRWK      = SUBSTR(S2.SLS_YRMON,1,4)||S2.COST_WK                
                                                                       AND S1.TRD_CD        = S2.TRD_CD                
                                                                       AND S1.SUB_TRD_CD    = S2.SUB_TRD_CD              
                                                                       AND S2.RLANE_CD      = DECODE(S3.RLANE_CD, 'XXXXX', S2.RLANE_CD, S1.RLANE_CD)              
                                                                       AND S2.DIR_CD        = DECODE(S3.DIR_CD, 'X', S2.DIR_CD, S1.DIR_CD)              
                                                                       AND S1.COST_YRWK     = S3.COST_YRWK               
                                                                       AND S1.VER_SEQ       = S3.VER_SEQ                 
                                                                       AND S1.TRD_CD        = S3.TRD_CD                
                                                                       AND S1.SUB_TRD_CD    = S3.SUB_TRD_CD              
                                                                       AND S2.DELT_FLG      = 'N'                
                                                                       AND S2.TRD_CD        = S4.TRD_CD                
                                                                       AND S2.RLANE_CD      = S4.RLANE_CD                
                                                                       AND S2.DIR_CD        = S4.DIR_CD                
                                                                   ) A1                
                                                                  ,BKG_BOOKING A2  --XAK5BKG_BOOKING                
                                                                  ,BKG_QUANTITY A3                
                                                                  ,BKG_CUSTOMER A4                
                                                                  ,SPC_OFC_LVL A5                
                                                             WHERE 1=1                
                                                               AND A1.VSL_CD          = A2.VSL_CD                
                                                               AND A1.SKD_VOY_NO      = A2.SKD_VOY_NO                
                                                               AND A1.DIR_CD          = A2.SKD_DIR_CD                
                                                               AND A2.BKG_NO          = A3.BKG_NO                
                                                               AND A2.BKG_NO          = A4.BKG_NO                
                                                               AND A4.BKG_CUST_TP_CD  = 'S'                
                                                               AND A1.SLS_YRWK        BETWEEN A5.OFC_APLY_FM_YRWK AND A5.OFC_APLY_TO_YRWK                
                                                               AND (SELECT SPC_SCR_OFC_CONV_FNC(A2.OB_SLS_OFC_CD) FROM DUAL) = A5.OFC_CD                
                                                               AND (NVL(A2.ALOC_STS_CD, 'X') = 'F' OR A2.BKG_NO = A1.TARGET_BKG)                
                                                           ) B1                
                                                          ,SPC_MDL_CUST_RFA B2 -- AES/IAS 노선(즉 RFA 계약을 사용하는 노선) 중 국가가 CN 일 경우 RFA 정보 조회                
                                                     WHERE B1.SHP_CUST_CNT_CD = B2.CUST_CNT_CD(+)                
                                                       AND B1.SHP_CUST_SEQ    = B2.CUST_SEQ(+)                
                                                       AND B1.BKG_POL_CD      = B2.POL_CD(+)                
                                                       AND B1.BKG_POD_CD      = B2.POD_CD(+)                
                                                       AND B1.CMDT_CD         = B2.CMDT_CD(+)                   
                                                    ) C1                
                                                   ,SPC_MDL_CUST_CTRL C2 -- SMP에서 관리하는 CUST의 유효한 계약 정보인지 조회                
                                              WHERE 1=1                
                                                AND C1.TRD_CD                = C2.TRD_CD(+)                
                                                AND C1.COST_YRWK             = C2.COST_YRWK(+)                
                                                AND C1.VER_SEQ               = C2.VER_SEQ(+)                
                                                AND C1.CTRT_CUST_CNT_CD      = C2.CUST_CNT_CD(+)                
                                                AND C1.CTRT_CUST_SEQ         = C2.CUST_SEQ(+)                
                                                AND NVL(C1.SC_NO, C1.RFA_NO) = NVL(C2.SC_NO(+), C2.RFA_NO(+))                
                                                AND NVL(C1.CUST_CTRL_CD,C2.CUST_CTRL_CD) IS NOT NULL                
                                             GROUP BY  C1.TRD_CD                
                                                  ,C1.SUB_TRD_CD              
                                                  ,DECODE(C1.BKG_CTRL_LANE_FLG, 'Y', C1.RLANE_CD, '')              
                                                  ,C1.SLS_OFC_CD                
                                                  ,C1.CUST_CD                
                                                  ,C1.SHP_CUST_CD                
                                                  ,C1.SC_NO                
                                                  ,C1.RFA_NO                
                                                  ,NVL(C2.CUST_CTRL_CD,C1.CUST_CTRL_CD)                
                                           ) D1                
                                          ,BKG_OPTION D2                
                                       WHERE D1.TRD_CD       = D2.TRD_CD                
                                         AND D1.SUB_TRD_CD   = D2.SUB_TRD_CD                
                                         AND D1.CUST_CTRL_CD = D2.CUST_CTRL_CD                
                                    UNION ALL                
                                    --SMP 정보는 Trade-Sub Trade-Cust-SC/RFA-Office별 Guide 물량을 집계한다.                
                                    SELECT TRD_CD                
                                          ,SUB_TRD_CD               
                                          ,RLANE_CD              
                                          ,CUST_CD                
                                          ,SC_NO                
                                          ,RFA_NO                
                                          ,SLS_RGN_OFC_CD                
                                          ,CUST_CTRL_CD                
                                          ,BKG_CTRL_RTO                
                                          ,BKG_CTRL_ACCT_FLG                
                                          ,BKG_CTRL_LANE_FLG              
                                          ,SMP_QTY                
                                          ,0 AS BKG_QTY                
                                          ,0 AS TARGET_BKG_QTY              
                                          , IS_MAX ,BKG_CTRL_ACCT_GRP_TP_CD             
                                          , DELT_FLG                   
                                     FROM (                
                                            SELECT                
                                                   A3.TRD_CD                
                                                  ,A3.SUB_TRD_CD              
                                                  ,DECODE(A1.BKG_CTRL_LANE_FLG, 'Y', A3.RLANE_CD, '') RLANE_CD              
                                                  ,A3.SLS_RGN_OFC_CD                
                                                  ,A3.CUST_CNT_CD||LPAD(A3.CUST_SEQ,6,'0') AS CUST_CD                
                                                  ,A3.SC_NO                
                                                  ,A3.RFA_NO                
                                                  ,A3.CUST_CTRL_CD                
                                                  ,A1.BKG_CTRL_RTO                
                                                  ,A1.BKG_CTRL_ACCT_FLG               
                                                  ,A1.BKG_CTRL_LANE_FLG              
                                                  -- OFFICE 별 가이드 물량은 특정 RLANE에 들어가 있기 때문에 간혹 삭제된 노선에 들어가 있을 수도 있고                
                                                  -- 또는 여러개의 노선에 들어가 있을 수도 있어서 MAX로 구하고 있음(SMP 조회 쿼리 참조)              
                                                  , CASE WHEN A1.BKG_CTRL_LANE_FLG = 'Y'              
                                                         THEN A3.RLANE_ADJ_QTY              
                                                         ELSE ( CASE WHEN A3.SUB_TRD_ADJ_QTY = MAX(A3.SUB_TRD_ADJ_QTY) OVER (PARTITION BY A3.TRD_CD, A3.SUB_TRD_CD, A3.SLS_RGN_OFC_CD, A3.CUST_CNT_CD, A3.CUST_SEQ,A3.SC_NO, A3.RFA_NO)                
                                                                     THEN A3.SUB_TRD_ADJ_QTY                
                                                                     ELSE 0               
                                                                END               
                                                               )              
                                                    END SMP_QTY              
                                                    -- MAX 값과 동일한 값이 서로다른 노선에 중복해서 들어가 있을수 있음                
                                                    -- 해당 경우 하나만 조회 되어야 함 따라서 상위에서 RNK=1인 것만 사용하기 위해서                
                                                  , CASE WHEN A1.BKG_CTRL_LANE_FLG = 'Y'              
                                                         THEN 1              
                                                         ELSE ROW_NUMBER() OVER (PARTITION BY A3.TRD_CD, A3.SUB_TRD_CD, A3.SLS_RGN_OFC_CD, A3.CUST_CNT_CD, A3.CUST_SEQ,NVL(A3.SC_NO,' ' ), NVL(A3.RFA_NO, ' ') ORDER BY A3.SUB_TRD_ADJ_QTY DESC, A3.DELT_FLG DESC)               
                                                    END RNK              
                                                  , A3.DELT_FLG                       
                                                  , CASE WHEN A1.BKG_CTRL_LANE_FLG = 'Y'               
                                                         THEN 'Y'              
                                                         ELSE ( CASE WHEN A3.SUB_TRD_ADJ_QTY = MAX(A3.SUB_TRD_ADJ_QTY) OVER (PARTITION BY A3.TRD_CD, A3.SUB_TRD_CD, A3.SLS_RGN_OFC_CD, A3.CUST_CNT_CD, A3.CUST_SEQ,A3.SC_NO, A3.RFA_NO)              
                                                                     THEN 'Y'               
                                                                     ELSE 'N'               
                                                                END              
                                                               )              
                                                     END IS_MAX ,BKG_CTRL_ACCT_GRP_TP_CD             
                                              FROM BKG_OPTION A1                
                                                  ,SPC_MDL_CUST_REV_LANE A3                
                                             WHERE A1.TRD_CD          = A3.TRD_CD                
                                               AND A1.COST_YRWK       = A3.COST_YRWK                
                                               AND A1.VER_SEQ         = A3.VER_SEQ                
                                               AND A1.SUB_TRD_CD      = A3.SUB_TRD_CD              
                                               AND A3.RLANE_CD        = DECODE(A1.RLANE_CD, 'XXXXX', A3.RLANE_CD, A1.RLANE_CD)              
                                               AND A1.CUST_CTRL_CD    = A3.CUST_CTRL_CD                
                                               --AND A3.SUB_TRD_ADJ_QTY > 0                
                                          )                
                                    WHERE 1=1 --SMP_QTY > 0                
                                      AND RNK = 1                
                                   ) B1                
                                    GROUP BY GROUPING SETS ((B1.TRD_CD, B1.SUB_TRD_CD, B1.RLANE_CD, B1.CUST_CTRL_CD, B1.SLS_OFC_CD, B1.BKG_CTRL_ACCT_FLG, B1.BKG_CTRL_LANE_FLG) -- BKG_CTRL_ACCT_FLG = N 일때                
                                                           ,(B1.TRD_CD, B1.SUB_TRD_CD, B1.RLANE_CD, B1.CUST_CTRL_CD, B1.CUST_CD, B1.SC_NO, B1.RFA_NO, B1.SLS_OFC_CD, B1.BKG_CTRL_ACCT_FLG, B1.BKG_CTRL_LANE_FLG) -- BKG_CTRL_ACCT_FLG = Y 일때                
                                                           )                   
                                    HAVING SUM(B1.TARGET_BKG_QTY) > 0                
                                           --AND ((MAX(B1.IS_MAX) = 'Y') OR (MAX(B1.IS_MAX) = 'N' AND MAX(B1.DELT_FLG) = 'N')) --SMP에는 없고, BKG에만 있는 경우 로직 보완                
                                           AND ((MAX(B1.IS_MAX) = 'Y') OR (MAX(B1.IS_MAX) = 'N' AND MAX(B1.DELT_FLG) = 'N') OR (MAX(B1.IS_MAX) IS NULL AND MAX(B1.DELT_FLG) IS NULL)) --SMP에 없는데 BKG이 SMP대상이면 Standby              
                
                            )                
                     WHERE 1=1                
                       AND NVL(CUST_CD, ' ') = DECODE(BKG_CTRL_ACCT_FLG, 'N', ' ', 'Y', CUST_CD)                
                    ) C1;                
            EXCEPTION                
                WHEN NO_DATA_FOUND THEN                
                     v_smp_aloc_sts_cd := '';                
            END;                
            enis_log_prc(SYSDATE, v_prc_nm, v_step || 'end, SMP_STAUS : '|| v_smp_aloc_sts_cd||', SMP_REASON : '|| v_smp_reason, v_appl_info);                
        ELSE                
            v_step := '2-2. SMP 대상 아님';                
            enis_log_prc(SYSDATE, v_prc_nm, v_step , v_appl_info);                
            v_smp_aloc_sts_cd := '';                
        END IF;      
                            
        enis_log_prc(SYSDATE, v_prc_nm, v_step || ' END', v_appl_info);     
                     
END IF; -- 제약조건 수행     
 
        IF (v_smp_aloc_sts_cd = '') THEN                
            v_smp_reason := 'SMP 대상 아님';                
        ELSIF (v_smp_aloc_sts_cd = 'F') THEN                
            v_smp_reason := '';                
        END IF;                
        -- 전체 result 저장                
        IF(v_sb_ck_rlst='N' AND v_smp_aloc_sts_cd = 'A') THEN               
            a_sb_ck_rlst := 'A';               
        END IF;             
        IF(v_sb_ck_rlst='N' AND v_smp_aloc_sts_cd = 'S') THEN                
            v_sb_ck_rlst := 'S';                
        END IF;                
  		   
/************************************************************************                
 Must 이거나, v_lf_cnt = 0 이면 BKG Control 수행                
************************************************************************/                
IF (v_aloc_must_flg='Y' OR (v_aloc_fcst_flg='Y' AND v_aloc_lf_cnt=0) ) THEN                
     
        v_step := '3. Allocation';                
        enis_log_prc(SYSDATE, v_prc_nm, v_step || ' START', v_appl_info);                
                                    
        /************************************************************************                
        Allocation 제약조건 수행                
        [2016.01.07] bkg total 물량관련 및 Control Option 에 해당하는 ofc 만 적용       
        ************************************************************************/      
        BEGIN                
               
        WITH REP_VVDS AS (       
         SELECT V.TRD_CD     AS REP_TRD_CD       
              , V.SUB_TRD_CD AS REP_SUB_TRD_CD       
              , V.RLANE_CD       
              , V.DIR_CD       
              , SUBSTR(V.SLS_YRMON, 1, 4) AS COST_YR       
              , SUBSTR(V.SLS_YRMON, 5)    AS COST_MON       
              , V.SLS_YRMON       
              , V.COST_WK       
              , V.VSL_CD       
              , V.SKD_VOY_NO       
              , V.DIR_CD SKD_DIR_CD       
              , bkg_list.rhq_cd    AS OFC_CD       
              , bkg_list.ofc_conti AS OFC_CONTI       
              , (SELECT DECODE(NVL(MAX(CO.CTRL_LVL_CD), 'L'), 'O', DECODE(NVL(MAX(CO.CTRL_ACCT_FLG), 'N'), 'Y', 'A', DECODE(NVL(MAX(       
                        CO.CTRL_USA_SVC_MOD_FLG), 'N'), 'Y', 'U', 'O')), NVL(MAX(CO.CTRL_LVL_CD), 'L'))       
                   FROM SPC_ALOC_CTRL_OPT CO       
                  WHERE CO.RLANE_CD   = bkg_list.rlane_cd       
                    AND CO.DIR_CD     = bkg_list.dir_cd       
                    AND CO.VSL_CD     = bkg_list.vsl_cd       
                    AND CO.SKD_VOY_NO = bkg_list.skd_voy_no       
                    AND CO.SKD_DIR_CD = bkg_list.dir_cd ) AS CTRL_LVL       
              , NVL(DECODE(A.CTRL_ECC_FLG, 'Y', 'E', DECODE(A.CTRL_ECC_GRP_FLG, 'Y', 'G', 'N')), 'N') AS CTRL_DEST       
              , NVL(A.CTRL_DEST_LVL_CD, 'N') AS CTRL_DEST_LVL -- C = COUNTRY, L = LOCATION       
              , NVL(A.CTRL_USA_SVC_MOD_FLG, 'N') AS CTRL_USA -- D = BKG_POD, T = BKG_DEL       
              , NVL(A.CTRL_ACCT_FLG, 'N')  AS CTRL_ACCOUNT -- Y = LOCAL/IPI       
              , NVL(A.CTRL_WGT_FLG, 'N')   AS CTRL_WGT_FLG       
              , NVL(A.CTRL_FX_RT_FLG, 'N') AS CTRL_FX_RT_FLG       
              , V.N1ST_LODG_PORT_ETD_DT    AS FL_ETD_DT       
              , BKG_CTRL_ALOC_TP_CD       
          FROM MAS_MON_VVD V       
              , SPC_ALOC_CTRL_OPT A       
          WHERE V.TRD_CD     = SPC_GET_REP_TRD_FNC(V.RLANE_CD)       
            AND V.SUB_TRD_CD = SPC_GET_REP_SUB_TRD_FNC(V.RLANE_CD)       
            AND V.RLANE_CD   = bkg_list.rlane_cd       
            AND V.VSL_CD     = bkg_list.vsl_cd       
            AND V.SKD_VOY_NO = bkg_list.skd_voy_no       
            AND V.DIR_CD     = bkg_list.dir_cd       
            AND (V.DELT_FLG IS NULL OR V.DELT_FLG   = 'N'       
             OR EXISTS (SELECT 1       
                          FROM MAS_MON_VVD N       
                         WHERE N.RLANE_CD   = V.RLANE_CD       
                           AND N.VSL_CD     = V.VSL_CD       
                           AND N.SKD_VOY_NO = V.SKD_VOY_NO       
                           AND N.DIR_CD     = V.DIR_CD       
                           AND N.DELT_FLG   = 'N'))       
            AND A.RLANE_CD (+)  = bkg_list.rlane_cd       
            AND A.DIR_CD (+)    = bkg_list.dir_cd       
            AND A.VSL_CD (+)    = bkg_list.vsl_cd       
            AND A.SKD_VOY_NO(+) = bkg_list.skd_voy_no       
            AND A.SKD_DIR_CD(+) = bkg_list.dir_cd       
        )       
        , CTRT_OPT_DTL AS (       
         -- SPC_ALOC_LANE_CTRL_OPT_DTL 테이블의 계약 정보를 가지고 온다.       
         SELECT DISTINCT A2.TRD_CD       
              , A2.SUB_TRD_CD       
              , A2.RLANE_CD       
              , A2.DIR_CD       
              , A2.ALOC_CTRL_TP_CD       
              , A2.CTRL_LOC_ACCT_CD       
              , A1.FL_ETD_DT       
           FROM REP_VVDS A1       
              , SPC_ALOC_LANE_CTRL_OPT_DTL A2       
          WHERE A1.REP_TRD_CD      = A2.TRD_CD       
            AND A1.REP_SUB_TRD_CD  = A2.SUB_TRD_CD       
            AND A1.RLANE_CD        = A2.RLANE_CD       
            AND A1.DIR_CD          = A2.DIR_CD       
            AND A1.CTRL_ACCOUNT    = 'Y'       
            AND A1.CTRL_FX_RT_FLG  = 'Y'       
            AND A2.CTRL_FX_RT_FLG  = 'Y'       
            AND A2.ALOC_CTRL_TP_CD = 'F'       
        )       
        , CTRT_DTL_INFO AS (       
         SELECT A5.TRD_CD       
              , A5.SUB_TRD_CD       
              , A5.RLANE_CD       
              , A5.DIR_CD       
              , A5.ALOC_CTRL_TP_CD       
              , A5.CTRL_LOC_ACCT_CD       
              , A1.PROP_NO       
              , A2.AMDT_SEQ       
              , A3.SVC_SCP_CD       
              , A4.GEN_SPCL_RT_TP_CD       
              , A4.CMDT_HDR_SEQ       
              , A2.REAL_CUST_CNT_CD || LPAD(A2.REAL_CUST_SEQ, '6', '0') CUST_CD       
              , A4.FX_RT_FLG       
              , A2.EFF_DT       
              , A2.EXP_DT       
              , A2.PROP_STS_CD       
           FROM CTRT_OPT_DTL A5       
              , PRI_SP_HDR A1       
              , PRI_SP_MN A2       
              , PRI_SP_SCP_MN A3       
              , PRI_SP_SCP_RT_CMDT_HDR A4       
          WHERE A1.SC_NO       = A5.CTRL_LOC_ACCT_CD       
            AND A1.PROP_NO     = A2.PROP_NO       
            AND A2.PROP_STS_CD = 'F' -- A, F, Q       
            AND TRUNC(A5.FL_ETD_DT) BETWEEN A2.EFF_DT AND A2.EXP_DT       
            AND A2.PROP_NO            = A3.PROP_NO       
            AND A2.AMDT_SEQ           = A3.AMDT_SEQ       
            AND A3.PROP_NO            = A4.PROP_NO       
            AND A3.AMDT_SEQ           = A4.AMDT_SEQ       
            AND A3.SVC_SCP_CD         = A4.SVC_SCP_CD       
            AND NVL(A4.FX_RT_FLG, 'N')= 'Y'       
        )       
        , ALOC_LANE_CTRL_OPT_DTL AS (       
         SELECT DISTINCT B1.TRD_CD       
              , B1.SUB_TRD_CD       
              , B1.RLANE_CD       
              , B1.DIR_CD       
              , NVL(B3.ALOC_CTRL_TP_CD, B1.ALOC_CTRL_TP_CD) AS ALOC_CTRL_TP_CD       
              , B1.CTRL_LOC_ACCT_CD       
              , B1.SC_NO       
              , B1.RFA_NO       
              , NVL(B3.ALOC_CTRL_DTL_CD, B1.ALOC_CTRL_DTL_CD) AS ALOC_CTRL_DTL_CD       
              , BKG_CTRL_ALOC_TP_CD       
           FROM SPC_ALOC_LANE_CTRL_OPT_DTL B1       
              , REP_VVDS B2       
              , (       
                -- Actual Account 정보 추출       
                SELECT DISTINCT A1.TRD_CD       
                      , A1.SUB_TRD_CD       
                      , A1.RLANE_CD       
                      , A1.DIR_CD       
                      , 'B' AS ALOC_CTRL_TP_CD       
                      , A1.ALOC_CTRL_TP_CD AS ORG_ALOC_CTRL_TP_CD -- B : A/Acct, C : Commodity, F : Fixed       
                      , A1.CTRL_LOC_ACCT_CD       
                      , A1.PROP_NO       
                      , A1.AMDT_SEQ       
                      , A1.SVC_SCP_CD       
                      , A2.CUST_CNT_CD || LPAD(A2.CUST_SEQ, '6', '0') AS ALOC_CTRL_DTL_CD       
                   FROM CTRT_DTL_INFO A1       
                      , PRI_SP_SCP_RT_ACT_CUST A2       
                  WHERE A1.PROP_NO           = A2.PROP_NO       
                    AND A1.AMDT_SEQ          = A2.AMDT_SEQ       
                    AND A1.SVC_SCP_CD        = A2.SVC_SCP_CD       
                    AND A1.GEN_SPCL_RT_TP_CD = A2.GEN_SPCL_RT_TP_CD       
                    AND A1.CMDT_HDR_SEQ      = A2.CMDT_HDR_SEQ       
                UNION ALL       
                -- CMDT 정보 추출       
                SELECT DISTINCT A1.TRD_CD       
                      , A1.SUB_TRD_CD       
                      , A1.RLANE_CD       
                      , A1.DIR_CD       
                      , 'C' AS ALOC_CTRL_TP_CD       
                      , A1.ALOC_CTRL_TP_CD AS ORG_ALOC_CTRL_TP_CD -- B : A/Acct, C : Commodity, F : Fixed       
                      , A1.CTRL_LOC_ACCT_CD       
                      , A1.PROP_NO       
                      , A1.AMDT_SEQ       
                      , A1.SVC_SCP_CD       
                      , DECODE(A2.PRC_CMDT_TP_CD, 'C', A2.PRC_CMDT_DEF_CD, 'G', A4.PRC_CMDT_DEF_CD) AS ALOC_CTRL_DTL_CD       
                   FROM CTRT_DTL_INFO A1       
                      , PRI_SP_SCP_RT_CMDT A2       
                      , PRI_SP_SCP_GRP_CMDT A3       
                      , PRI_SP_SCP_GRP_CMDT_DTL A4       
                  WHERE A1.PROP_NO           = A2.PROP_NO       
                    AND A1.AMDT_SEQ          = A2.AMDT_SEQ       
                    AND A1.SVC_SCP_CD        = A2.SVC_SCP_CD       
                    AND A1.GEN_SPCL_RT_TP_CD = A2.GEN_SPCL_RT_TP_CD       
                    AND A1.CMDT_HDR_SEQ      = A2.CMDT_HDR_SEQ       
                    AND A2.SRC_INFO_CD      <> 'AD'       
                    AND A2.PROP_NO           = A3.PROP_NO(+)       
                    AND A2.AMDT_SEQ          = A3.AMDT_SEQ(+)       
                    AND A2.SVC_SCP_CD        = A3.SVC_SCP_CD(+)       
                    AND A2.PRC_CMDT_DEF_CD   = A3.PRC_GRP_CMDT_CD(+)       
                    AND A3.PROP_NO           = A4.PROP_NO(+)       
                    AND A3.AMDT_SEQ          = A4.AMDT_SEQ(+)       
                    AND A3.SVC_SCP_CD        = A4.SVC_SCP_CD(+)       
                    AND A3.GRP_CMDT_SEQ      = A4.GRP_CMDT_SEQ(+)       
                    AND A4.SRC_INFO_CD(+)   <> 'AD'       
                  GROUP BY A1.TRD_CD       
                      , A1.SUB_TRD_CD       
                      , A1.RLANE_CD       
                      , A1.DIR_CD       
                      , A1.ALOC_CTRL_TP_CD       
                      , A1.CTRL_LOC_ACCT_CD       
                      , A1.PROP_NO       
                      , A1.AMDT_SEQ       
                      , A1.SVC_SCP_CD       
                      , DECODE(A2.PRC_CMDT_TP_CD, 'C', A2.PRC_CMDT_DEF_CD, 'G', A4.PRC_CMDT_DEF_CD)       
                ) B3       
          WHERE B2.REP_TRD_CD       = B1.TRD_CD       
            AND B2.REP_SUB_TRD_CD   = B1.SUB_TRD_CD       
            AND B2.RLANE_CD         = B1.RLANE_CD       
            AND B2.DIR_CD           = B1.DIR_CD       
            AND B1.TRD_CD           = B3.TRD_CD(+)       
            AND B1.SUB_TRD_CD       = B3.SUB_TRD_CD(+)       
            AND B1.RLANE_CD         = B3.RLANE_CD(+)       
            AND B1.DIR_CD           = B3.DIR_CD(+)       
            AND B1.ALOC_CTRL_TP_CD  = B3.ORG_ALOC_CTRL_TP_CD(+)       
            AND B1.CTRL_LOC_ACCT_CD = B3.CTRL_LOC_ACCT_CD(+)       
        )       
        , VSL_PORT_SKD AS (       
         SELECT V.REP_TRD_CD       
              , V.REP_SUB_TRD_CD       
              , V.RLANE_CD       
              , V.DIR_CD       
              , V.COST_YR       
              , V.COST_MON       
              , V.COST_WK       
              , V.VSL_CD       
              , V.SKD_VOY_NO       
              , V.SKD_DIR_CD       
              , NVL(VPS.YD_CD, VPS.VPS_PORT_CD) AS PORT_CD       
              , VPS.CLPT_SEQ                    AS PORT_SEQ       
              , VPS.TURN_PORT_IND_CD            AS PORT_IND       
              , SPC_CONTI_CONV_FNC(L.CONTI_CD, V.RLANE_CD, V.DIR_CD) AS CONTI_CD       
              , DECODE(SIGN(VPS.VPS_ETD_DT - GLOBALDATE_PKG.TIME_CONV_FNC('GMT', SYS_EXTRACT_UTC(SYSTIMESTAMP), VPS.VPS_PORT_CD)), -1, 'Y', 'N') AS PORT_PAST       
              , VPS.VPS_ETA_DT AS ETA_DT       
              , VPS.VPS_ETD_DT AS ETD_DT       
              , V.OFC_CD       
              , V.OFC_CONTI       
              , DECODE(VPS.SKD_CNG_STS_CD, 'S', 1, 0) AS SKIPPED       
              , MAX(VPS.CLPT_SEQ) OVER (PARTITION BY NVL(VPS.YD_CD, VPS.VPS_PORT_CD)) AS MAX_SEQ       
              , MIN(VPS.CLPT_SEQ) OVER (PARTITION BY NVL(VPS.YD_CD, VPS.VPS_PORT_CD)) AS MIN_SEQ       
              , VPS.CLPT_IND_SEQ AS CLPT_IND_SEQ       
              , COUNT(*) OVER (PARTITION BY NVL(VPS.YD_CD, VPS.VPS_PORT_CD)) AS PORT_CNT   
              , VPS.CALL_YD_IND_SEQ 
              , VPS.VPS_PORT_CD  
           FROM MDM_LOCATION L       
              , VSK_VSL_PORT_SKD VPS       
              , REP_VVDS V       
          WHERE L.LOC_CD       = VPS.VPS_PORT_CD       
            AND VPS.VSL_CD     = V.VSL_CD       
            AND VPS.SKD_VOY_NO = V.SKD_VOY_NO       
            AND VPS.SKD_DIR_CD = V.SKD_DIR_CD       
        )       
        , VVD_POL_POD AS (       
         SELECT A.REP_TRD_CD       
              , A.REP_SUB_TRD_CD       
              , A.RLANE_CD       
              , A.DIR_CD       
              , TRD_CD       
              , SUB_TRD_CD       
              , COST_YR       
              , COST_MON       
              , COST_WK       
              , VSL_CD       
              , SKD_VOY_NO       
              , SKD_DIR_CD       
              , POL_CD       
              , POL_CONTI       
              , POD_CD       
              , POD_CONTI       
              , IOC_CD       
              , OFC_CD       
              , OFC_CONTI       
              , PL_PD_PORT_CNT   
              -- [2015.05.16] 
              , MAX(POL_YD_SEQ) OVER (PARTITION BY VSL_CD,SKD_VOY_NO,SKD_DIR_CD, POL_CD) AS MAX_POL_PORT_SEQ 
              , MAX(POD_YD_SEQ) OVER (PARTITION BY VSL_CD,SKD_VOY_NO,SKD_DIR_CD, POD_CD) AS MAX_POD_PORT_SEQ 
              , POL_YD_SEQ 
              , POD_YD_SEQ 
              , PL_VPS_PORT_CD 
              , PD_VPS_PORT_CD 
              , PL_CLPT_IND_SEQ 
              , PD_CLPT_IND_SEQ 
           FROM (       
                 SELECT REP_TRD_CD       
                      , REP_SUB_TRD_CD       
                      , RLANE_CD       
                      , DIR_CD       
                      , TRD_CD       
                      , SUB_TRD_CD       
                      , COST_YR       
                      , COST_MON       
                      , COST_WK       
                      , VSL_CD       
                      , SKD_VOY_NO       
                      , SKD_DIR_CD       
                      , POL_CD       
                      , POL_CONTI       
                      , POD_CD       
                      , POD_CONTI       
                      , IOC_CD       
                      , OFC_CD       
                      , OFC_CONTI       
                      , PL_PD_PORT_CNT       
                      , MAX(PL_PD_PORT_CNT) OVER (PARTITION BY POL_CD, POD_CD ORDER BY POL_CD, POD_CD) AS PL_PD_PORT_MAX   
                      , POL_YD_SEQ 
                      , POD_YD_SEQ 
                      , PL_VPS_PORT_CD 
                      , PD_VPS_PORT_CD 
                      , PL_CLPT_IND_SEQ 
                      , PD_CLPT_IND_SEQ 
                   FROM (       
                         SELECT PL.REP_TRD_CD       
                              , PL.REP_SUB_TRD_CD       
                              , PL.RLANE_CD       
                              , PL.DIR_CD       
                              , DRL.TRD_CD       
                              , DRL.SUB_TRD_CD       
                              , PL.COST_YR       
                              , PL.COST_MON       
                              , PL.COST_WK       
                              , PL.VSL_CD       
                              , PL.SKD_VOY_NO       
                              , PL.SKD_DIR_CD       
                              , PL.PORT_CD                                 AS POL_CD       
                              , PL.CONTI_CD                                AS POL_CONTI       
                              , PD.PORT_CD                                 AS POD_CD       
                              , PD.CONTI_CD                                AS POD_CONTI       
                              , DECODE(PL.CONTI_CD, PD.CONTI_CD, 'I', 'O') AS IOC_CD       
                              , PL.OFC_CD       
                              , PL.OFC_CONTI       
                              , ROW_NUMBER()OVER (PARTITION BY PL.PORT_CD, PD.PORT_CD ORDER BY PL.PORT_CD, PD.PORT_CD) AS PL_PD_PORT_CNT     
                              , PL.CALL_YD_IND_SEQ AS POL_YD_SEQ 
                              , PD.CALL_YD_IND_SEQ AS POD_YD_SEQ 
                              , PL.VPS_PORT_CD     AS PL_VPS_PORT_CD 
                              , PD.VPS_PORT_CD     AS PD_VPS_PORT_CD 
                              , PL.CLPT_IND_SEQ    AS PL_CLPT_IND_SEQ 
                              , PD.CLPT_IND_SEQ    AS PD_CLPT_IND_SEQ 
                           FROM MDM_DTL_REV_LANE DRL       
                              , VSL_PORT_SKD PD       
                              , VSL_PORT_SKD PL       
                          WHERE DRL.RLANE_CD        = PL.RLANE_CD       
                            AND DRL.VSL_SLAN_DIR_CD = PL.DIR_CD       
                            AND DRL.FM_CONTI_CD     = PL.CONTI_CD       
                            AND DRL.TO_CONTI_CD     = PD.CONTI_CD       
                            AND PD.REP_TRD_CD       = PL.REP_TRD_CD       
                            AND PD.REP_SUB_TRD_CD   = PL.REP_SUB_TRD_CD       
                            AND PD.RLANE_CD         = PL.RLANE_CD       
                            AND PD.VSL_CD           = PL.VSL_CD       
                            AND PD.SKD_VOY_NO       = PL.SKD_VOY_NO       
                            AND PD.SKD_DIR_CD       = PL.SKD_DIR_CD       
                            AND PD.PORT_CD         <> PL.PORT_CD       
                            AND PD.PORT_SEQ         > PL.PORT_SEQ       
                            AND ( PL.PORT_SEQ       = DECODE(PD.CONTI_CD, PL.CONTI_CD, PL.MIN_SEQ, PL.MAX_SEQ)      
                             OR PD.PORT_SEQ         < PL.MAX_SEQ )       
                        GROUP BY PL.REP_TRD_CD       
                              , PL.REP_SUB_TRD_CD       
                              , PL.RLANE_CD       
                              , PL.DIR_CD       
                              , DRL.TRD_CD       
                              , DRL.SUB_TRD_CD       
                              , PL.COST_YR       
                              , PL.COST_MON       
                              , PL.COST_WK       
                              , PL.VSL_CD       
                              , PL.SKD_VOY_NO       
                              , PL.SKD_DIR_CD       
                              , PL.PORT_CD       
                              , PL.CONTI_CD       
                              , PD.PORT_CD       
                              , PD.CONTI_CD       
                              , DECODE(PL.CONTI_CD, PD.CONTI_CD, 'I', 'O')       
                              , PL.OFC_CD       
                              , PL.OFC_CONTI       
                              , PL.CLPT_IND_SEQ    
                              , PL.CALL_YD_IND_SEQ 
                              , PD.CALL_YD_IND_SEQ 
                              , PL.VPS_PORT_CD 
                              , PD.VPS_PORT_CD 
                              , PL.CLPT_IND_SEQ 
                              , PD.CLPT_IND_SEQ 
                        )       
                ) A       
        WHERE   A.PL_PD_PORT_CNT = PL_PD_PORT_MAX       
        )       
               
        , BKG_DATA AS (       
        --BOOKING       
         SELECT REP_TRD_CD       
              , REP_SUB_TRD_CD       
              , TRD_CD       
              , SUB_TRD_CD       
              , RLANE_CD       
              , BASE_RHQ_CD       
              , SLS_OFC_CD       
              , CUST_CTRL_CD       
              , BKG_NO       
              , IOC_CD       
              , US_MOD       
              , ACCOUNT_CD       
              , DECODE( NVL(CTRL_LVL, POL_CD), 'O', 'O', POL_CD) AS POL_CD       
              , DECODE( NVL(CTRL_LVL, 'X'), 'D', POD_CD, 'T', POD_CD, 'X') POD_CD       
              , DECODE( NVL(CTRL_LVL, 'X'), 'T', DEL_CD, 'X') DEL_CD       
              , VVD       
              , SUM(BKG_TTL_QTY) AS BKG_TTL_QTY       
              , SUM(BKG_WGT) AS BKG_WGT         
              , CTRL_WGT_FLG        
              , DECODE(IOC_CD, 'T', 'Y', 'TT', 'Y', 'N') AS TS_FLG       
              , DIR_CD        
           FROM (       
                 SELECT REP_TRD_CD       
                      , REP_SUB_TRD_CD       
                      , TRD_CD       
                      , SUB_TRD_CD       
                      , RLANE_CD       
                      , BASE_RHQ_CD       
                      , SLS_OFC_CD       
                      , CUST_CTRL_CD       
                      , BKG_NO       
                      , COST_YR       
                      , COST_WK       
                      , IOC_CD       
                      , US_MOD       
                      , ACCOUNT_CD       
                      , DEL_CD       
                      , POL_CD       
                      , POD_CD       
                      , VVD       
                      , BKG_STS_CD       
                      , VAL AS BKG_TTL_QTY       
                      , DIR_CD       
                      , CTRL_LVL       
                      , BKG_WGT        
                      , CTRL_WGT_FLG       
                   FROM (       
                         SELECT VPP.REP_TRD_CD       
                              , VPP.REP_SUB_TRD_CD       
                              , VPP.TRD_CD       
                              , VPP.SUB_TRD_CD       
                              , VPP.RLANE_CD       
                              , VPP.OFC_CD AS BASE_RHQ_CD       
                              , DECODE(DECODE(BV.VSL_PRE_PST_CD, 'T', VPP.IOC_CD, 'T'), 'T', DECODE(O.N2ND_PRNT_OFC_CD, 'SINRS', O.N4TH_PRNT_OFC_CD,       
                                bkg_list.rhq_cd, O.N4TH_PRNT_OFC_CD, DECODE(bkg_list.rlane_cd, 'WAFIE', O.N4TH_PRNT_OFC_CD, O.N2ND_PRNT_OFC_CD)),O.N4TH_PRNT_OFC_CD) AS SLS_OFC_CD       
                              , NVL(S.CUST_CTRL_CD, 'C') AS CUST_CTRL_CD       
                              , B.BKG_NO       
                              , VPP.COST_YR       
                              , VPP.COST_WK       
                              , DECODE(BV.VSL_PRE_PST_CD, 'T', VPP.IOC_CD, 'T') AS IOC_CD       
                              , CASE WHEN M.CTRL_USA = 'Y' AND (SUBSTR(B.POL_CD, 1, 2) IN ('US', 'CA') OR SUBSTR(B.POD_CD, 1, 2) IN ('US', 'CA'))       
                                     THEN NVL(SPC_USA_MODE_FNC(B.RCV_TERM_CD, B.DE_TERM_CD, B.POL_CD, B.POL_CD, B.POD_CD, B.DEL_CD), 'OTHERS')       
                                     ELSE 'OTHERS' END AS US_MOD       
                              , CASE WHEN M.CTRL_ACCOUNT = 'Y' THEN NVL( (       
                                                -- A : Individul B: Actual C: Commodity       
                                                SELECT DISTINCT(D.CTRL_LOC_ACCT_CD)       
                                                  FROM ALOC_LANE_CTRL_OPT_DTL D       
                                                 WHERE D.RLANE_CD       = M.RLANE_CD        
                                                   AND D.TRD_CD         = SPC_GET_REP_TRD_FNC(M.RLANE_CD)        
                                                   AND D.SUB_TRD_CD     = SPC_GET_REP_SUB_TRD_FNC(M.RLANE_CD)        
                                                   AND D.DIR_CD         = M.SKD_DIR_CD        
                                                   AND D.ALOC_CTRL_TP_CD IN ('A', 'B', 'C')        
                                                   AND (( SPC_SCR_OFC_CONV_FNC(B.OB_SLS_OFC_CD) IN (       
                                                        SELECT OFC.OFC_CD       
                                                          FROM SPC_ALOC_LANE_CTRL_OFC OFC       
                                                         WHERE D.RLANE_CD       = OFC.RLANE_CD       
                                                           AND D.TRD_CD         = OFC.TRD_CD        
                                                           AND D.SUB_TRD_CD     = OFC.SUB_TRD_CD       
                                                           AND D.DIR_CD         = OFC.DIR_CD        
                                                           AND D.ALOC_CTRL_TP_CD = OFC.ALOC_CTRL_TP_CD        
                                                           AND D.CTRL_LOC_ACCT_CD = OFC.CTRL_LOC_ACCT_CD ))        
                                                        OR ( NOT EXISTS (       
                                                                SELECT 1       
                                                                  FROM SPC_ALOC_LANE_CTRL_OFC OFC_ALL       
                                                                 WHERE D.RLANE_CD = OFC_ALL.RLANE_CD        
                                                                   AND D.TRD_CD = OFC_ALL.TRD_CD        
                                                                   AND D.SUB_TRD_CD = OFC_ALL.SUB_TRD_CD        
                                                                   AND D.DIR_CD = OFC_ALL.DIR_CD        
                                                                   AND D.ALOC_CTRL_TP_CD = OFC_ALL.ALOC_CTRL_TP_CD        
                                                                   AND D.CTRL_LOC_ACCT_CD = OFC_ALL.CTRL_LOC_ACCT_CD ) ))        
                                                   AND (D.CTRL_LOC_ACCT_CD = B.SC_NO OR D.CTRL_LOC_ACCT_CD = B.RFA_NO)        
                                                   AND D.ALOC_CTRL_DTL_CD = DECODE(D.ALOC_CTRL_TP_CD, 'A', B.CTRT_CUST_CNT_CD ||LPAD(B.CTRT_CUST_SEQ, 6, '0'), 'B',        
                                                        B.AGMT_ACT_CNT_CD ||LPAD(B.AGMT_ACT_CUST_SEQ, 6, '0'), 'C', B.CMDT_CD)       
                                                ), 'OTHERS')        
                                     ELSE 'OTHERS' END AS ACCOUNT_CD       
                              , CASE WHEN M.CTRL_DEST <> 'N' THEN NVL( (        
                                                SELECT DISTINCT(D.CTRL_LOC_ACCT_CD)       
                                                  FROM SPC_ALOC_LANE_CTRL_OPT_DTL D       
                                                 WHERE D.RLANE_CD = M.RLANE_CD        
                                                   AND D.TRD_CD = SPC_GET_REP_TRD_FNC(M.RLANE_CD)        
                                                   AND D.SUB_TRD_CD = SPC_GET_REP_SUB_TRD_FNC(M.RLANE_CD)        
                                                   AND D.DIR_CD = M.SKD_DIR_CD        
                                                   AND D.ALOC_CTRL_TP_CD = M.CTRL_DEST        
                                                   AND (( SPC_SCR_OFC_CONV_FNC(B.OB_SLS_OFC_CD) IN (       
                                                        SELECT OFC.OFC_CD       
                                                          FROM SPC_ALOC_LANE_CTRL_OFC OFC       
                                                         WHERE D.RLANE_CD = OFC.RLANE_CD        
                                                           AND D.TRD_CD = OFC.TRD_CD        
                                                           AND D.SUB_TRD_CD = OFC.SUB_TRD_CD       
                                                           AND D.DIR_CD = OFC.DIR_CD        
                                                           AND D.ALOC_CTRL_TP_CD = OFC.ALOC_CTRL_TP_CD        
                                                           AND D.CTRL_LOC_ACCT_CD = OFC.CTRL_LOC_ACCT_CD ))        
                                                        OR ( NOT EXISTS (       
                                                                SELECT 1       
                                                                  FROM SPC_ALOC_LANE_CTRL_OFC OFC_ALL       
                                                                 WHERE D.RLANE_CD = OFC_ALL.RLANE_CD        
                                                                   AND D.TRD_CD = OFC_ALL.TRD_CD        
                                                                   AND D.SUB_TRD_CD = OFC_ALL.SUB_TRD_CD        
                                                                   AND D.DIR_CD = OFC_ALL.DIR_CD        
                                                                   AND D.ALOC_CTRL_TP_CD = OFC_ALL.ALOC_CTRL_TP_CD        
                                                                   AND D.CTRL_LOC_ACCT_CD = OFC_ALL.CTRL_LOC_ACCT_CD ) ))        
                                                   AND DECODE(M.CTRL_DEST, 'E', D.CTRL_LOC_ACCT_CD, 'G', D.ALOC_CTRL_DTL_CD) = (       
                                                        SELECT DECODE(M.CTRL_DEST, 'E', A.ECC_CD, C.LOC_CD)       
                                                          FROM MDM_EQ_ORZ_CHT A       
                                                             , MDM_LOCATION C       
                                                         WHERE C.LOC_CD = DECODE(M.CTRL_DEST_LVL, 'T', B.DEL_CD, B.POD_CD)        
                                                           AND A.SCC_CD = C.SCC_CD)       
                                                ), 'OTHERS')        
                                     ELSE 'OTHERS' END AS DEL_CD       
                              , VPP.POL_CD       
                              , VPP.POD_CD       
                              , VPP.VSL_CD||VPP.SKD_VOY_NO||VPP.SKD_DIR_CD AS VVD       
                              , B.BKG_STS_CD       
                              , B.ALOC_STS_CD       
                              , (SELECT SUM(DECODE(SPC_GET_CNTR_SZ_FNC(Q.CNTR_TPSZ_CD), '2', 1, 2) * Q.OP_CNTR_QTY)       
                                   FROM BKG_QUANTITY Q       
                                  WHERE B.BKG_NO = Q.BKG_NO AND Q.OP_CNTR_QTY > 0 ) AS VAL       
                              , VPP.DIR_CD       
                              , M.CTRL_LVL       
                              , M.CTRL_WGT_FLG       
                              , CASE WHEN M.CTRL_WGT_FLG = 'Y' THEN (        
                                        SELECT ( SUM (( SELECT (D.ACT_WGT * DECODE(D.WGT_UT_CD, 'LBS', 0.00045, 0.001))         
                                                                + SUM(Q.OP_CNTR_QTY * ( SELECT TS.CNTR_TPSZ_TARE_WGT         
                                                                                          FROM MDM_CNTR_TP_SZ TS         
                                                                                         WHERE TS.CNTR_TPSZ_CD = Q.CNTR_TPSZ_CD)) * 0.001         
                                          FROM BKG_QUANTITY Q         
                                         WHERE B.BKG_NO      = Q.BKG_NO         
                                           AND Q.OP_CNTR_QTY > 0 ))) FROM DUAL)          
                                     ELSE NULL         
                                      END AS BKG_WGT                                       
                          FROM SPC_OFC_LVL O       
                              , BKG_BOOKING B       
                              , BKG_VVD BV       
                              , VVD_POL_POD VPP       
                              , BKG_BL_DOC D       
                              , REP_VVDS M       
                              , SPC_MDL_CUST_CTRL S       
                         WHERE O.OFC_TP_CD       IN ('BB', 'BA', 'BS')       
                            AND O.OFC_CD           = SPC_SCR_OFC_CONV_FNC(B.OB_SLS_OFC_CD)       
                            AND ( VPP.POL_CONTI    = VPP.OFC_CONTI       
                             OR O.N2ND_PRNT_OFC_CD = VPP.OFC_CD       
                             OR O.N2ND_PRNT_OFC_CD = 'SINRS'       
                             OR bkg_list.rlane_cd       = 'WAFIE' )       
                            AND VPP.COST_YR || VPP.COST_WK BETWEEN O.OFC_APLY_FM_YRWK AND O.OFC_APLY_TO_YRWK       
                            AND B.BKG_CGO_TP_CD                 IN ('F', 'B', 'R')       
                            AND B.BKG_STS_CD                    IN ('W', 'F')       
                            AND (NVL(B.ALOC_STS_CD, 'X')         = 'F'       
                             OR B.BKG_NO                         = v_appl_info) --FIRM COUNT + THIS BKG COUNT       
                            AND B.BKG_NO                         = BV.BKG_NO       
                            AND BV.VSL_CD                        = VPP.VSL_CD       
                            AND BV.SKD_VOY_NO                    = VPP.SKD_VOY_NO       
                            AND BV.SKD_DIR_CD                    = VPP.DIR_CD       
                            AND ((BV.POL_CD = VPP.PL_VPS_PORT_CD AND BV.POL_CLPT_IND_SEQ = VPP.PL_CLPT_IND_SEQ) OR (BV.POL_YD_CD = VPP.POL_CD AND BV.POL_CLPT_IND_SEQ > 1 AND VPP.MAX_POL_PORT_SEQ = 1)) 
                            AND ((BV.POD_CD = VPP.PD_VPS_PORT_CD AND BV.POD_CLPT_IND_SEQ = VPP.PD_CLPT_IND_SEQ) OR (BV.POD_YD_CD = VPP.POD_CD AND BV.POD_CLPT_IND_SEQ > 1 AND VPP.MAX_POD_PORT_SEQ = 1))  
                                
                            AND B.BKG_NO                         = D.BKG_NO       
                            AND B.CTRT_CUST_CNT_CD               = S.CUST_CNT_CD(+)       
                            AND B.CTRT_CUST_SEQ                  = S.CUST_SEQ (+)       
                            AND NVL(B.SC_NO, NVL(B.RFA_NO, 'X')) = NVL(S.SC_NO(+), NVL(S.RFA_NO(+), 'X'))       
                            AND S.COST_YRWK (+)                  = SUBSTR(v_mst_smp_season, 1, 6)       
                            AND S.VER_SEQ (+)                    = SUBSTR(v_mst_smp_season, 8)       
                        )       
                )       
          GROUP BY REP_TRD_CD       
              , REP_SUB_TRD_CD       
              , TRD_CD       
              , SUB_TRD_CD       
              , RLANE_CD       
              , BASE_RHQ_CD       
              , SLS_OFC_CD       
              , CUST_CTRL_CD       
              , BKG_NO       
              , IOC_CD       
              , US_MOD       
              , ACCOUNT_CD       
              , DECODE( NVL(CTRL_LVL, POL_CD), 'O', 'O', POL_CD)       
              , DECODE( NVL(CTRL_LVL, 'X'), 'D', POD_CD, 'T', POD_CD, 'X')       
              , DECODE( NVL(CTRL_LVL, 'X'), 'T', DEL_CD, 'X')       
              , VVD         
              , CTRL_WGT_FLG       
              , DECODE(IOC_CD, 'T', 'Y', 'TT', 'Y', 'N')       
              , DIR_CD       
        )       
        , ALOC_TOT AS (       
        --Allocation       
         SELECT REP_TRD_CD       
              , REP_SUB_TRD_CD       
              , TRD_CD       
              , SUB_TRD_CD       
              , RLANE_CD       
              , IOC_CD       
              , CUST_CTRL_CD       
              , BASE_RHQ_CD       
              , RHQ_CD       
              , OFC_CD       
              , US_MOD       
              , ACCOUNT_CD       
              , POL_CD       
              , POD_CD       
              , DEL_CD       
              , VVD       
              , SUM(AP_TEU) AP_TEU       
              , SUM(AP_WGT) AP_WGT         
              , TS_FLG       
              , DIR_CD       
              , BKG_CTRL_ALOC_TP_CD       
           FROM (       
                 SELECT VPP.REP_TRD_CD       
                      , VPP.REP_SUB_TRD_CD       
                      , VPP.TRD_CD       
                      , VPP.SUB_TRD_CD       
                      , VPP.RLANE_CD       
                      , DECODE(A.TS_FLG, 'Y', 'T', A.IOC_CD)||DECODE(A.MNL_FLG, 'Y', 'T', '') AS IOC_CD       
                      , 'C' CUST_CTRL_CD       
                      , VPP.OFC_CD   AS BASE_RHQ_CD       
                      , A.SLS_RHQ_CD AS RHQ_CD       
                      , DECODE(VPP.OFC_CD, A.SLS_RHQ_CD, A.SLS_RGN_OFC_CD, DECODE(A.SLS_RHQ_CD, 'SINRS', A.SLS_RGN_OFC_CD,       
                                DECODE(A.RLANE_CD, 'WAFIE', A.SLS_RGN_OFC_CD, DECODE(A.TS_FLG, 'Y', A.SLS_RHQ_CD, A.SLS_RGN_OFC_CD)))) AS OFC_CD       
                      , DECODE(A.USA_BKG_MOD_CD, 'OTH', 'OTHERS', A.USA_BKG_MOD_CD) AS US_MOD       
                      , DECODE(A.CTRT_NO||A.CUST_CNT_CD||LPAD(A.CUST_SEQ, 6, '0'), 'XXX999999', 'OTHERS',       
                                DECODE(A.CUST_CNT_CD||LPAD(A.CUST_SEQ, 6, '0'), 'XX999999', A.CTRT_NO, A.CUST_CNT_CD||LPAD(A.CUST_SEQ, 6, '0'))) AS ACCOUNT_CD       
                      , DECODE( NVL(M.CTRL_LVL, VPP.POL_CD ), 'O', 'O', VPP.POL_CD) AS POL_CD       
                      , DECODE( NVL( M.CTRL_LVL, 'X'), 'D', VPP.POD_CD, 'T', VPP.POD_CD, 'X') AS POD_CD       
                      , DECODE( NVL( M.CTRL_LVL, 'X'), 'T', DECODE(A.DEST_LOC_CD, 'XXXXX', 'OTHERS', A.DEST_LOC_CD), 'X') AS DEL_CD       
                      , A.VSL_CD || A.SKD_VOY_NO || A.SKD_DIR_CD AS VVD       
                      , A.ASGN_TTL_QTY AS AP_TEU       
                      , A.ASGN_TTL_WGT AS AP_WGT        
                      , A.TS_FLG       
                      , A.DIR_CD       
                      , M.CTRL_LVL       
                      , BKG_CTRL_ALOC_TP_CD -- spc_aloc_ctrl_opt       
                   FROM SPC_ALOC_POL_POD A       
                      , VVD_POL_POD VPP       
                      , REP_VVDS M       
                  WHERE A.RLANE_CD      = VPP.RLANE_CD       
                    AND A.DIR_CD        = VPP.DIR_CD       
                    AND A.VSL_CD        = VPP.VSL_CD       
                    AND A.SKD_VOY_NO    = VPP.SKD_VOY_NO       
                    AND A.SKD_DIR_CD    = VPP.SKD_DIR_CD       
                    AND A.POL_YD_CD     = VPP.POL_CD 
                    AND A.POD_YD_CD     = VPP.POD_CD 
                    AND A.POL_YD_IND_SEQ = VPP.POL_YD_SEQ 
                    AND A.POD_YD_IND_SEQ = VPP.POD_YD_SEQ 
                    AND ( ( VPP.POL_CONTI = VPP.OFC_CONTI AND ( ( A.TS_FLG = 'N' AND A.SLS_OFC_CD = A.SLS_RGN_OFC_CD ) OR A.SLS_RGN_OFC_CD IS NULL ) )       
                        OR VPP.RLANE_CD = 'WAFIE'       
                        OR (VPP.OFC_CD = 'SINRS' AND VPP.RLANE_CD = 'WAXIA')       
                        OR ( A.SLS_RHQ_CD = VPP.OFC_CD AND A.SLS_OFC_CD = A.SLS_RGN_OFC_CD )       
                        OR ( A.SLS_RHQ_CD = 'SINRS' AND A.SLS_OFC_CD = A.SLS_RGN_OFC_CD ) )       
                    AND M.RLANE_CD        = VPP.RLANE_CD       
                    AND M.VSL_CD          = VPP.VSL_CD       
                    AND M.SKD_VOY_NO      = VPP.SKD_VOY_NO       
                    AND M.DIR_CD          = VPP.DIR_CD       
                )       
          GROUP BY REP_TRD_CD       
              , REP_SUB_TRD_CD       
              , TRD_CD       
              , SUB_TRD_CD       
              , RLANE_CD       
              , IOC_CD       
              , CUST_CTRL_CD       
              , BASE_RHQ_CD       
              , RHQ_CD       
              , OFC_CD       
              , US_MOD       
              , ACCOUNT_CD       
              , POL_CD       
              , POD_CD       
              , DEL_CD       
              , VVD       
              , TS_FLG       
              , DIR_CD       
              , BKG_CTRL_ALOC_TP_CD       
        )       
        , SPC_RTO AS (       
         SELECT BKG_CTRL_TP_CD       
              , BKG_CTRL_DTL_CD       
              , NVL(BKG_CTRL_RTO, 100) BKG_CTRL_RTO       
              , NVL(BKG_CTRL_ACCT_FLG, 'N') AS BKG_CTRL_ACCT_FLG       
           FROM SPC_BKG_CTRL_OPT_DTL D       
          WHERE D.TRD_CD          = bkg_list.trd_cd     --var       
            AND D.SUB_TRD_CD      = bkg_list.sub_trd_cd --var       
            AND D.RLANE_CD        = bkg_list.rlane_cd   --var       
            AND D.DIR_CD          = bkg_list.dir_cd     --var       
            AND D.BKG_CTRL_TP_CD <> 'S'            --default       
        )       
         SELECT BKG_CTRL_ALOC_TP_CD       
              , 'IOC:' || IOC_CD        
              || ', RHQ OFC:' || BASE_RHQ_CD        
              || ', L.OFC:' ||SLS_OFC_CD        
              || ', US MODE:' || US_MOD        
              || ', TRADE:' || TRD_CD        
              || ', SUB TRADE:' || SUB_TRD_CD        
              || ', LANE:' || RLANE_CD        
              || ', VVD:' || VVD        
              || ', ACCOUNT_CD:' || ACCOUNT_CD        
              || ', YIELD GROUP:' || CUST_CTRL_CD       
              || ', POL_CD:' || POL_CD        
              || ' ,POD_CD:' || POD_CD        
              || ' ,DEL_CD:' || DEL_CD        
              || ', RATIO:' || RTO        
              || ', ALOC QTY:' || AP_TEU        
              || ', BKG TTL QTY:' || BKG_TTL_QTY        
              || ', BKG QTY:' || BKG_QTY       
              || ', WT Control:' || CTRL_WGT_FLG         
              || ', TTL WT:' || AP_WGT        
              || ', BKG WT:' || BKG_WGT         
              , NULL       
              , NULL       
              , ACCOUNT_CD       
              , SUB_TRD_CD       
              , VVD       
              , SLS_OFC_CD       
          INTO v_aloc_aloc_sts_cd, v_aloc_reason, v_sc_no, v_rfa_no, v_acct_cd, v_sub_trd_cd, v_vvd_cd, v_ofc_cd       
          FROM (       
                 SELECT B.REP_TRD_CD       
                      , B.REP_SUB_TRD_CD       
                      , B.TRD_CD       
                      , B.SUB_TRD_CD       
                      , B.RLANE_CD       
                      , B.BASE_RHQ_CD       
                      , B.SLS_OFC_CD       
                      , B.ACCOUNT_CD       
                      , A.AP_TEU       
                      , (SUM(B.BKG_TTL_QTY) OVER () ) AS BKG_TTL_QTY       
                      , NVL( (SELECT BKG_CTRL_RTO FROM SPC_RTO R WHERE DECODE(R.BKG_CTRL_TP_CD, 'O', B.SLS_OFC_CD, B.CUST_CTRL_CD) = R.BKG_CTRL_DTL_CD), 0 ) RTO       
                      , B.IOC_CD       
                      , B.CUST_CTRL_CD       
                      , B.BKG_NO QTY_BKG_NO       
                      , BKG.BKG_NO TGT_BKG_NO       
                      , B.VVD       
                      , B.US_MOD       
                      , A.POL_CD       
                      , A.POD_CD       
                      , A.DEL_CD       
                      , BKG.BKG_TTL_QTY AS BKG_QTY       
                      , B.CTRL_WGT_FLG       
                      , A.AP_WGT       
                      , (SUM(B.BKG_WGT) OVER () ) AS BKG_TTL_WGT       
                      , B.BKG_WGT         
                      , BKG_CTRL_ALOC_TP_CD       
                  FROM ( SELECT * FROM BKG_DATA WHERE BKG_NO = v_appl_info) BKG       
                      , BKG_DATA B       
                      , ALOC_TOT A       
                  WHERE B.REP_TRD_CD              = A.REP_TRD_CD       
                    AND B.REP_SUB_TRD_CD          = A.REP_SUB_TRD_CD       
                    AND B.TRD_CD                  = A.TRD_CD       
                    AND B.SUB_TRD_CD              = A.SUB_TRD_CD       
                    AND B.DIR_CD                  = A.DIR_CD       
                    AND B.IOC_CD                  = A.IOC_CD       
                    AND B.RLANE_CD                = A.RLANE_CD       
                    AND B.BASE_RHQ_CD             = A.BASE_RHQ_CD       
                    AND B.SLS_OFC_CD              = A.OFC_CD       
                    AND B.US_MOD                  = A.US_MOD       
                    AND B.ACCOUNT_CD              = A.ACCOUNT_CD       
                    AND B.POL_CD                  = A.POL_CD       
                    AND B.POD_CD                  = A.POD_CD       
                    AND B.DEL_CD                  = A.DEL_CD       
                    AND B.TS_FLG                  = A.TS_FLG       
                    AND B.VVD                     = A.VVD       
                    AND BKG.REP_TRD_CD            = A.REP_TRD_CD       
                    AND BKG.REP_SUB_TRD_CD        = A.REP_SUB_TRD_CD       
                    AND BKG.TRD_CD                = A.TRD_CD       
                    AND BKG.SUB_TRD_CD            = A.SUB_TRD_CD       
                    AND BKG.DIR_CD                = A.DIR_CD       
                    AND BKG.IOC_CD                = A.IOC_CD       
                    AND BKG.RLANE_CD              = A.RLANE_CD       
                    AND NVL(BKG.BASE_RHQ_CD, 'A') = NVL(A.BASE_RHQ_CD, 'A')       
                    AND BKG.SLS_OFC_CD            = A.OFC_CD       
                    AND BKG.US_MOD                = A.US_MOD       
                    AND BKG.ACCOUNT_CD            = A.ACCOUNT_CD       
                    AND BKG.POL_CD                = A.POL_CD       
                    AND BKG.POD_CD                = A.POD_CD       
                    AND BKG.DEL_CD                = A.DEL_CD       
                    AND BKG.TS_FLG                = A.TS_FLG       
                    AND BKG.VVD                   = A.VVD       
                )       
          WHERE TGT_BKG_NO = QTY_BKG_NO       
            AND ((AP_TEU * RTO)/100 < BKG_TTL_QTY  OR (AP_TEU IS NULL AND CTRL_WGT_FLG = 'Y' AND AP_WGT < BKG_TTL_WGT))       
            AND RTO        > 0       
            AND ROWNUM     = 1       
            ;       
                
        EXCEPTION              
              
                WHEN NO_DATA_FOUND THEN                
                 v_aloc_aloc_sts_cd := '';                
                enis_log_prc(SYSDATE, v_prc_nm, v_step || ' 3. Allocation check null', v_appl_info);              
                              
                WHEN OTHERS THEN              
                    enis_log_prc(SYSDATE, v_prc_nm, v_step || ' 3. Allocation error' || SQLERRM, v_appl_info);              
                              
        END;    --  match BEGIN in IF statement        
                  
              
        IF ( v_aloc_aloc_sts_cd = '' ) THEN                
            v_aloc_reason := '';                
        END IF;                
        IF(v_sb_ck_rlst='N' AND v_aloc_aloc_sts_cd = 'A') THEN               
            a_sb_ck_rlst := 'A';               
        END IF;                              
        IF(v_sb_ck_rlst='N' AND v_aloc_aloc_sts_cd = 'S') THEN                
            v_sb_ck_rlst := 'S';                
        END IF;      
                   
        enis_log_prc(SYSDATE, v_prc_nm, v_step || ' END', v_appl_info);                
                  
--Must 이거나, v_lf_cnt = 0 이면 BKG Control 수행                
END IF;     
    
/************************************************************************                
SPC_SB_BKG 테이블에 DATA MERGE(BKG 단건 처리시)                
************************************************************************/                
        v_step := '4. SPC_SB_BKG UPDATE';                
        enis_log_prc(SYSDATE, v_prc_nm, v_step || ' START', v_appl_info);                
----------------------------------------------------------------------                
--  수정 필요 테이블 변경으로 주석처리 함                
----------------------------------------------------------------------                
        --BKG별 수행 결과                
        -- [2015.10.16]           
        -- Confirm 은 STANDBY 상태에서 Firm 처리되면 무조건 업데이트됨.           
        --     Compulsory Firm, 또는 제약조건 완화 및 VVD 변경으로 FIRM 처리되었을 때           
        --            
        -- BKG_BOOKING 의 ALOC_STS_CD 가 'F' 일때           
        --     BKG VVD 정보가 변경되면 ALOC_STS_CD 가 업데이트되며, STANDBY 발생시 BKG에 'S'로 업데이트 되지만           
        --     이외에는 업데이트 되지 않기 때문에 아무리 STANDBY가 발생하더라도 BKG_BOOKING 의 ALOC_STS_CD는 'F' 상태임.           
        --         BKG 정보는 Firm 이고 SPC 는 STANDBY 일 때 화면에서 조회할때는 STATUS = 'F' 로 조회           
        --         BKG 정보는 Firm 이고 SPC 는 STANDBY DELT_FLG='Y' 일 때 화면에서 조회할때는 STATUS = 'S'->'F' 로 조회           
               
        BEGIN                
           SELECT 'Y' INTO v_is_confirm                
             FROM BKG_BOOKING                
            WHERE BKG_NO        = v_appl_info            
              AND ALOC_STS_CD   = 'F';                
        EXCEPTION                
             WHEN NO_DATA_FOUND THEN                
                 v_is_confirm := 'N';                
        END;           
                   
        -- 이전에 STANDBY, ATTENTION REASON 정보가 있었는지 체크한다.           
        -- [2015.10.16]           
        BEGIN             
            SELECT NVL(MAX(DECODE(BKG_CTRL_TP_CD,'S','Y','N')),'N')            
                 , NVL(MAX(DECODE(BKG_CTRL_TP_CD,'A','Y','N')),'N')            
              INTO v_is_standby           
                 , v_is_attention           
              FROM SPC_SB_BKG_DTL                
             WHERE BKG_NO = v_appl_info;    
        EXCEPTION                
              WHEN NO_DATA_FOUND THEN                
                   v_is_standby   := 'N';             
                   v_is_attention := 'N';                   
        END;            
                        
        enis_log_prc(SYSDATE, v_prc_nm, v_step || ': v_is_confirm=' || v_is_confirm  || ', v_sb_ck_rlst=' || v_sb_ck_rlst ||', a_sb_ck_rlst=' ||a_sb_ck_rlst||', in_mode='|| in_mode, v_appl_info);                
            
--[2015.12.16] 임시로 bkg 이 firm 이더라도 standby 발생할경우 spc에 저장하도록 처리 , 대신 화면에서 standby-> firm 처리못하도록 버튼 비활성화         
--[2016.02.22] 배치 호출시에는 이전데이터가 Standby 상태에서 호출되는 것이기 때문에 Firm 처리되지 않는한 spc bkg 테이블을 수정하지 않는다.    
        IF (in_mode IN ('B','R') AND (v_sb_ck_rlst='S' OR a_sb_ck_rlst='A' )) THEN               
            --Standby 상태인 경우                
            MERGE INTO SPC_SB_BKG O                
            USING (SELECT v_appl_info BKG_NO                
                         , SYSDATE LST_SB_DT                
                        , DECODE(v_is_confirm,'Y','Y','N') BKG_CFM_FLG -- [2015.12.24] BKG이 'F'->'S' 변환될때 화면상에 보여주기 위함       
                     FROM DUAL ) N                 
            ON (O.BKG_NO = N.BKG_NO)                 
            WHEN MATCHED THEN                 
            UPDATE SET                 
                   O.LST_SB_DT  = SYSDATE                 
                 , O.UPD_USR_ID = v_user_info                 
                 , O.UPD_DT     = SYSDATE                 
                 , O.INIT_CMPB_AMT = v_init_cmpb        
                 , O.BKG_CFM_FLG   = N.BKG_CFM_FLG       
            WHEN NOT MATCHED THEN                 
            INSERT (   BKG_NO                 
                     , LST_SB_DT                 
                     , CRE_USR_ID                 
                     , CRE_DT                 
                     , UPD_USR_ID                 
                     , UPD_DT                  
                     , INIT_CMPB_AMT          
                     , BKG_CFM_FLG       
                     )                 
            VALUES (   N.BKG_NO                 
                     , N.LST_SB_DT                 
                     , v_user_info                 
                     , SYSDATE                 
                     , v_user_info                 
                     , SYSDATE                  
                     , v_init_cmpb       
                     , N.BKG_CFM_FLG       
                   );              
            ------------------------------------------------------------           
            -- 이전에 STANDBY 가 존재했었고, 제약조건 완화 및 BKG 정보 변경으로 STANDBY 가 없어 졌을 경우는 FIRM 처리           
            -- [2015.10.16]           
            IF(v_sb_ck_rlst = 'N' AND v_is_standby = 'Y') THEN                            
                 UPDATE SPC_SB_BKG             
                    SET CFM_USR_ID       ='SPC_SYSTEM'             
                      , CFM_DT           = SYSDATE              
                      , UPD_USR_ID       = v_user_info           
                      , UPD_DT           = SYSDATE               
                  WHERE BKG_NO           = v_appl_info;            
                                                 
                 UPDATE SPC_SB_BKG_DTL             
                    SET DELT_FLG         = 'Y'            
                      , UPD_USR_ID       = v_user_info            
                      , UPD_DT           = SYSDATE            
                  WHERE BKG_NO           = v_appl_info           
                    AND BKG_CTRL_TP_CD   = 'S';                                   
             ELSE           
                 DELETE FROM SPC_SB_BKG_DTL WHERE BKG_NO = v_appl_info;           
             END IF;            
            ----------------------------------------------------------------------           
                                     
            -- INSERT 문은 ATTENTION 또는 STANDBY 존재 체크하므로 별도 IF 조건이 필요없음.            
            -- BKG_ALOC_SEQ, MODI_SEQ, SC_NO, RFA_NO, ACCT_CD, SUB_TRD_CD, VVD_CD, OFC_CD                 
            INSERT INTO SPC_SB_BKG_DTL                
                (BKG_NO, LST_SB_RSN_TP_CD, LST_SB_SUB_RSN_CD, ALOC_SVC_CD, LST_SB_RSN, CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT, BKG_ALOC_SEQ, MODI_SEQ, LST_SB_OTR_RSN, SC_NO, RFA_NO, ACCT_CD, SUB_TRD_CD, VVD_CD, OFC_CD, RLANE_CD,BKG_CTRL_TP_CD,DELT_FLG)                
                --Master Reason 추가 컬럼 반영 되면 Reason  재작업                
                SELECT v_appl_info BKG_NO, 'M' LST_SB_RSN_TP_CD, B.LST_SB_SUB_RSN_CD, B.ALOC_SVC_CD,                
                MAX(''	                
--                    ||	NVL2(AL.BKG_ALOC_SEQ,			'Seq:'          		||AL.BKG_ALOC_SEQ                                       ||', ','')                
                    ||	NVL2(AL.SLS_RHQ_CD,				'RHQ:'          		||AL.SLS_RHQ_CD                                         ||', ','')                
                    ||	NVL2(AL.BKG_ALOC_TP_CD,			'TYPE:'         		||AL.BKG_ALOC_TP_CD                                     ||', ','')                
                    ||	NVL2(AL.SUB_TRD_CD,				'SubTrade:'     		||AL.SUB_TRD_CD                                         ||', ','')                
                    ||	NVL2(AL.TRNK_SLAN_CD,			'T.LANE:'       		||AL.TRNK_SLAN_CD                                       ||', ','')                
                    ||	NVL2(AL.HUL_BND_CD,				'HAULBOUND:'    		||AL.HUL_BND_CD                                         ||', ','')                
                    ||	NVL2(AL.TRNK_DIR_CD,			'BD:'           		||AL.TRNK_DIR_CD                                        ||', ','')                
                    ||	NVL2(PL.BKG_ALOC_SEQ,			'TrunkPOL:'     		||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = PL.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = PL.SB_LOC_DIV_CD AND LENGTH(D.SB_LOC_CD) = 5)||', ','')                
                    ||	NVL2(PD.BKG_ALOC_SEQ,			'TrunkPOD:'     		||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = PD.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = PD.SB_LOC_DIV_CD AND LENGTH(D.SB_LOC_CD) = 5)||', ','')                
                    ||	NVL2(POR2.BKG_ALOC_SEQ,			'POR-Country:'  		||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = POR2.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = POR2.SB_LOC_DIV_CD AND LENGTH(D.SB_LOC_CD) = 2)||', ','')                
                    ||	NVL2(POR.BKG_ALOC_SEQ,			'POR-LOC:'      		||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = POR.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = POR.SB_LOC_DIV_CD AND LENGTH(D.SB_LOC_CD) = 5)||', ','')                
                    ||	NVL2(AL.POR_NOD_CD,				'POR-NODE:'     		||AL.POR_NOD_CD                                         ||', ','')                
                    ||	NVL2(AL.BKG_POR_SCC_CD,			'POR-SCC:'      		||AL.BKG_POR_SCC_CD                                     ||', ','')                
                    ||	NVL2(POL2.BKG_ALOC_SEQ,			'POL-Country:'  		||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = POL2.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = POL2.SB_LOC_DIV_CD AND LENGTH(D.SB_LOC_CD) = 2)||', ','')                
                    ||	NVL2(POL.BKG_ALOC_SEQ,			'POL-LOC:'      		||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = POL.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = POL.SB_LOC_DIV_CD AND LENGTH(D.SB_LOC_CD) = 5)||', ','')                
                    ||	NVL2(AL.POL_NOD_CD,				'POL-NODE:'     		||AL.POL_NOD_CD                                         ||', ','')                
                    -- [2015.10.23]        
                    ||	NVL2(SAY1.BKG_ALOC_SEQ,			'T/S-Port:'		        ||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = SAY1.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = SAY1.SB_LOC_DIV_CD)||', ','')                
                    ||	NVL2(AL.N1ST_TS_SLAN_CD,		'T/SLANE:'      		||AL.N1ST_TS_SLAN_CD                                    ||', ','')                
                    ||	NVL2(AL.N1ST_TS_DIR_CD,			'T/SBD:'        		||AL.N1ST_TS_DIR_CD                                     ||', ','')                
                    ||	NVL2(PL4.BKG_ALOC_SEQ,			'T/SPOL-Country:'		||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = PL4.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = PL4.SB_LOC_DIV_CD AND LENGTH(D.SB_LOC_CD) = 2)||', ','')                
                    ||	NVL2(PL2.BKG_ALOC_SEQ,			'T/SPOL:'       		||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = PL2.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = PL2.SB_LOC_DIV_CD AND LENGTH(D.SB_LOC_CD) = 5)||', ','')                
                    -- [2015.10.23]        
                    ||	NVL2(SLY1.BKG_ALOC_SEQ,			'T/S-POL-NODE:'		        ||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = SLY1.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = SLY1.SB_LOC_DIV_CD)||', ','')                
                    ||	NVL2(PD4.BKG_ALOC_SEQ,			'T/SPOD-Country:'		||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = PD4.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = PD4.SB_LOC_DIV_CD AND LENGTH(D.SB_LOC_CD) = 2)||', ','')                
                    ||	NVL2(PD2.BKG_ALOC_SEQ,			'T/SPOD:'       		||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = PD2.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = PD2.SB_LOC_DIV_CD AND LENGTH(D.SB_LOC_CD) = 5)||', ','')                
                    -- [2015.10.23]        
                    ||	NVL2(SDY1.BKG_ALOC_SEQ,			'T/S-POD-NODE:'		        ||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = SDY1.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = SDY1.SB_LOC_DIV_CD)||', ','')                
                    ||	NVL2(POD2.BKG_ALOC_SEQ,			'POD-Country:'  		||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = POD2.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = POD2.SB_LOC_DIV_CD AND LENGTH(D.SB_LOC_CD) = 2)||', ','')                
                    ||	NVL2(POD.BKG_ALOC_SEQ,			'POD-LOC:'      		||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = POD.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = POD.SB_LOC_DIV_CD AND LENGTH(D.SB_LOC_CD) = 5)||', ','')                
                    ||	NVL2(AL.POD_NOD_CD,				'POD-NODE:'     		||AL.POD_NOD_CD                                         ||', ','')                
                    ||	NVL2(DEL2.BKG_ALOC_SEQ,			'DEL-Country:'  		||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = DEL2.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = DEL2.SB_LOC_DIV_CD AND LENGTH(D.SB_LOC_CD) = 2)||', ','')                
                    ||	NVL2(DEL.BKG_ALOC_SEQ,			'DEL-LOC:'      		||(SELECT REPLACE(WM_CONCAT(D.SB_LOC_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_NOD_DTL D WHERE D.BKG_ALOC_SEQ = DEL.BKG_ALOC_SEQ AND D.SB_LOC_DIV_CD = DEL.SB_LOC_DIV_CD AND LENGTH(D.SB_LOC_CD) = 5)||', ','')                
                    ||	NVL2(AL.DEL_NOD_CD,				'DEL/NODE NODE:'		||AL.DEL_NOD_CD                                         ||', ','')                
                    ||	NVL2(AL.BKG_DEL_SCC_CD,			'DEL/NODE SCC:' 		||AL.BKG_DEL_SCC_CD                                     ||', ','')                
                    ||	NVL2(AL.USA_BKG_MOD_CD,			'US Mode:'      		||AL.USA_BKG_MOD_CD                                     ||', ','')                
                    ||	NVL2(AL.VSL_CD,					'VVD:'          		||AL.VSL_CD||SKD_VOY_NO||SKD_DIR_CD                     ||', ','')                
                    ||	NVL2(TP.BKG_ALOC_SEQ,			'CNTR TYPE:'    		||(SELECT REPLACE(WM_CONCAT(D.CNTR_TPSZ_CD ), ',', ' ') FROM SPC_BKG_ALOC_MGMT_TP_SZ_DTL D WHERE D.BKG_ALOC_SEQ = TP.BKG_ALOC_SEQ)||', ','')                
                    ||	NVL2(AL.DCGO_FLG,				'DG:'           		||AL.DCGO_FLG                                           ||', ','')                
                    ||	NVL2(AL.RD_CGO_FLG,				'RD:'           		||AL.RD_CGO_FLG		                                    ||', ','')                
                    ||	NVL2(AL.OB_SLS_OFC_CD,			'L.OFC:'        		||AL.OB_SLS_OFC_CD                                      ||', ','')                
                    ||	NVL2(AL.SC_NO,					'S/CNo.:'       		||AL.SC_NO		                                        ||', ','')                
                    ||	NVL2(AL.RFA_NO,					'RFANo.:'       		||AL.RFA_NO                                             ||', ','')                
                    ||	NVL2(AL.RVIS_CNTR_CUST_TP_CD,	'BCO/NVO:'      		||AL.RVIS_CNTR_CUST_TP_CD                               ||', ','')                
                    ||	NVL2(AL.CUST_GRP_ID, 		    'Group Customer:'   	||AL.CUST_GRP_ID 	                                    ||', ','')                
                    ||	NVL2(AL.CTRT_CUST_CNT_CD, 		'C.CustCode:'   		||AL.CTRT_CUST_CNT_CD||LPAD(AL.CTRT_CUST_SEQ, 6, '0')	||', ','')                
                    ||	NVL2(A.BKG_ALOC_SEQ,			'ActualCustomer:'		||(SELECT REPLACE(WM_CONCAT(D.CUST_CNT_CD||LPAD(D.CUST_SEQ, 6, '0')), ',', ' ') FROM SPC_BKG_ALOC_MGMT_CUST_DTL D WHERE D.BKG_ALOC_SEQ = A.BKG_ALOC_SEQ AND D.BKG_CUST_TP_CD = A.BKG_CUST_TP_CD)||', ','')                
                    ||	NVL2(AL.CUST_CNT_CD,			'BKGShipperCode:'		||AL.CUST_CNT_CD||LPAD(AL.CUST_SEQ, 6, '0')				||', ','')                
                    ||	NVL2(AL.OFT_CHG_AMT,			'ChargeOFT:'    		||AL.OFT_CHG_AMT                            			||', ','')                
                    ||	NVL2(AL.CMPB_AMT,				'CMPBAmount:'   		||AL.CMPB_AMT                               			||', ','')                
                    ||	NVL2(AL.ALOC_LOD_QTY,			'ALLOCATION-TEU:'		||AL.ALOC_LOD_QTY                           			||', ','')                
                    ||	NVL2(AL.OP_CNTR_QTY,			'ALLOCATION-BOX:'		||AL.OP_CNTR_QTY                            			||', ','')                
                    ||	NVL2(AL.ASGN_TTL_WGT,			'ALLOCATION-WGT:'		||AL.ASGN_TTL_WGT                           			||', ','')                
                    ||	NVL2(AL.ALOC_LOD_QTY_RTO,		'%THRESHOLD-TEU/BOX:'	||AL.ALOC_LOD_QTY_RTO                       			||', ','')                
                    ||	NVL2(AL.ASGN_WGT_RTO,			'%THRESHOLD-WGT:'		||AL.ASGN_WGT_RTO                           			||', ','')                
                    ||	NVL2(AL.SCG_GRP_CMDT_SEQ,		'GroupCOMMODITY-CODE:'	||AL.SCG_GRP_CMDT_SEQ                       			||', ','')                
                    ||	NVL2(CMDT.BKG_ALOC_SEQ,			'COMMODITY-CODE:'		||(SELECT REPLACE(WM_CONCAT(D.CMDT_CD), ',', ' ') FROM SPC_BKG_ALOC_MGMT_CMDT_DTL D WHERE D.BKG_ALOC_SEQ = AL.BKG_ALOC_SEQ)||', ','')                
                    ||	NVL2(AL.APLY_FM_YRWK,			'ApplyWK-From:' 		||AL.APLY_FM_YRWK                                       ||', ','')                
                    ||	NVL2(AL.APLY_TO_YRWK,			'ApplyWK-To:'   		||AL.APLY_TO_YRWK                                       ||', ','')                
                    ||	NVL2(AL.BKG_CTRL_TP_CD,			'ControlType:'  		||AL.BKG_CTRL_TP_CD                                     ||', ','')                
                    ||	NVL2(AL.ALOC_SVC_CD,			'SVC:'          		||AL.ALOC_SVC_CD                                        ||', ','')                
                    ||	NVL2(AL.BKG_ALOC_RMK,			'REMARK:'       		||AL.BKG_ALOC_RMK                                       ||', ','')                
                    ||	NVL2(AL.RFA_CTRT_TP_CD,			'RFA_CTRT_TP_CD:'       ||AL.RFA_CTRT_TP_CD                                     ||', ','')                
                    ||	NVL2(AL.CMPB_PER_TON_AMT,		'CMPB_PER_TON_AMT:'     ||AL.CMPB_PER_TON_AMT                                   ||', ','')                
                    ||	NVL2(AL.TON_PER_TEU_WGT,		'TON_PER_TEU_WGT:'      ||AL.TON_PER_TEU_WGT                                   ||', ','')               
--                    ||	NVL2(AL.ALOC_USE_FLG,			'UseYN:'        		||AL.ALOC_USE_FLG                                     ||', ','')                  
                    ||	DECODE(in_mode, 'R', 'ReProcess: Y', '')                
                    ) AS LST_SB_RSN, v_user_info CRE_USR_ID, SYSDATE CRE_DT, v_user_info UPD_USR_ID, SYSDATE UPD_DT, AL.BKG_ALOC_SEQ, B.MODI_SEQ, B.LST_SB_OTR_RSN, NULL, NULL, NULL, NULL, NULL, NULL, NULL,B.BKG_CTRL_TP_CD,'N'            
                FROM (  SELECT 'T' LST_SB_SUB_RSN_CD, v_mst_t_svc_cd ALOC_SVC_CD, v_mst_t_rs LST_SB_OTR_RSN, v_mst_t_seq BKG_ALOC_SEQ, v_modi_t_seq MODI_SEQ ,v_mst_t_rlst BKG_CTRL_TP_CD FROM DUAL WHERE v_mst_t_rlst = 'S' UNION ALL                
                        SELECT 'S' LST_SB_SUB_RSN_CD, v_mst_s_svc_cd ALOC_SVC_CD, v_mst_s_rs LST_SB_OTR_RSN, v_mst_s_seq BKG_ALOC_SEQ, v_modi_s_seq MODI_SEQ ,v_mst_s_rlst BKG_CTRL_TP_CD FROM DUAL WHERE v_mst_s_rlst = 'S' UNION ALL                
                        SELECT 'C' LST_SB_SUB_RSN_CD, v_mst_c_svc_cd ALOC_SVC_CD, v_mst_c_rs LST_SB_OTR_RSN, v_mst_c_seq BKG_ALOC_SEQ, v_modi_c_seq MODI_SEQ ,v_mst_c_rlst BKG_CTRL_TP_CD FROM DUAL WHERE v_mst_c_rlst = 'S' UNION ALL                
                        SELECT 'E' LST_SB_SUB_RSN_CD, v_mst_e_svc_cd ALOC_SVC_CD, v_mst_e_rs LST_SB_OTR_RSN, v_mst_e_seq BKG_ALOC_SEQ, v_modi_e_seq MODI_SEQ ,v_mst_e_rlst BKG_CTRL_TP_CD FROM DUAL WHERE v_mst_e_rlst = 'S' UNION ALL                
                        SELECT 'M' LST_SB_SUB_RSN_CD, v_mst_m_svc_cd ALOC_SVC_CD, v_mst_m_rs LST_SB_OTR_RSN, v_mst_m_seq BKG_ALOC_SEQ, v_modi_m_seq MODI_SEQ ,v_mst_m_rlst BKG_CTRL_TP_CD FROM DUAL WHERE v_mst_m_rlst = 'S' UNION ALL                
                        SELECT 'F' LST_SB_SUB_RSN_CD, v_mst_f_svc_cd ALOC_SVC_CD, v_mst_f_rs LST_SB_OTR_RSN, v_mst_f_seq BKG_ALOC_SEQ, v_modi_f_seq MODI_SEQ ,v_mst_f_rlst BKG_CTRL_TP_CD FROM DUAL WHERE v_mst_f_rlst = 'S' UNION ALL                
                        SELECT 'T' LST_SB_SUB_RSN_CD, a_mst_t_svc_cd ALOC_SVC_CD, a_mst_t_rs LST_SB_OTR_RSN, a_mst_t_seq BKG_ALOC_SEQ, a_modi_t_seq MODI_SEQ ,a_mst_t_rlst BKG_CTRL_TP_CD FROM DUAL WHERE a_mst_t_rlst = 'A' UNION ALL                
                        SELECT 'S' LST_SB_SUB_RSN_CD, a_mst_s_svc_cd ALOC_SVC_CD, a_mst_s_rs LST_SB_OTR_RSN, a_mst_s_seq BKG_ALOC_SEQ, a_modi_s_seq MODI_SEQ ,a_mst_s_rlst BKG_CTRL_TP_CD FROM DUAL WHERE a_mst_s_rlst = 'A' UNION ALL                
                        SELECT 'C' LST_SB_SUB_RSN_CD, a_mst_c_svc_cd ALOC_SVC_CD, a_mst_c_rs LST_SB_OTR_RSN, a_mst_c_seq BKG_ALOC_SEQ, a_modi_c_seq MODI_SEQ ,a_mst_c_rlst BKG_CTRL_TP_CD FROM DUAL WHERE a_mst_c_rlst = 'A' UNION ALL                
                        SELECT 'E' LST_SB_SUB_RSN_CD, a_mst_e_svc_cd ALOC_SVC_CD, a_mst_e_rs LST_SB_OTR_RSN, a_mst_e_seq BKG_ALOC_SEQ, a_modi_e_seq MODI_SEQ ,a_mst_e_rlst BKG_CTRL_TP_CD FROM DUAL WHERE a_mst_e_rlst = 'A' UNION ALL                
                        SELECT 'M' LST_SB_SUB_RSN_CD, a_mst_m_svc_cd ALOC_SVC_CD, a_mst_m_rs LST_SB_OTR_RSN, a_mst_m_seq BKG_ALOC_SEQ, a_modi_m_seq MODI_SEQ ,a_mst_m_rlst BKG_CTRL_TP_CD FROM DUAL WHERE a_mst_m_rlst = 'A' UNION ALL                
                        SELECT 'F' LST_SB_SUB_RSN_CD, a_mst_f_svc_cd ALOC_SVC_CD, a_mst_f_rs LST_SB_OTR_RSN, a_mst_f_seq BKG_ALOC_SEQ, a_modi_f_seq MODI_SEQ ,a_mst_f_rlst BKG_CTRL_TP_CD FROM DUAL WHERE a_mst_f_rlst = 'A'              
                        ) B              
                     , SPC_BKG_ALOC_MGMT AL                
                     , SPC_BKG_ALOC_MGMT_NOD_DTL PL                
                     , SPC_BKG_ALOC_MGMT_NOD_DTL PD                
                     , SPC_BKG_ALOC_MGMT_NOD_DTL PL2                
                     , SPC_BKG_ALOC_MGMT_NOD_DTL PD2                
                     , SPC_BKG_ALOC_MGMT_NOD_DTL PL3                
                     , SPC_BKG_ALOC_MGMT_NOD_DTL PD3                
                     , SPC_BKG_ALOC_MGMT_NOD_DTL PL4                
                     , SPC_BKG_ALOC_MGMT_NOD_DTL PD4                
                     , SPC_BKG_ALOC_MGMT_NOD_DTL POR                
                     , SPC_BKG_ALOC_MGMT_NOD_DTL POL                
                     , SPC_BKG_ALOC_MGMT_NOD_DTL POD                
                     , SPC_BKG_ALOC_MGMT_NOD_DTL DEL                
                     , SPC_BKG_ALOC_MGMT_NOD_DTL POR2                
                     , SPC_BKG_ALOC_MGMT_NOD_DTL POL2                
                     , SPC_BKG_ALOC_MGMT_NOD_DTL POD2                
                     , SPC_BKG_ALOC_MGMT_NOD_DTL DEL2        
                                     
                     , SPC_BKG_ALOC_MGMT_NOD_DTL SAY1               
                     , SPC_BKG_ALOC_MGMT_NOD_DTL SLY1                
                     , SPC_BKG_ALOC_MGMT_NOD_DTL SDY1        
                             
                     , SPC_BKG_ALOC_MGMT_CUST_DTL A                
                     , SPC_BKG_ALOC_MGMT_TP_SZ_DTL TP                
                     , SPC_BKG_ALOC_MGMT_CMDT_DTL CMDT                
                WHERE 1=1                 
                   AND B.BKG_ALOC_SEQ = AL.BKG_ALOC_SEQ                
                   AND AL.BKG_ALOC_SEQ = PL.BKG_ALOC_SEQ(+) AND PL.SB_LOC_DIV_CD(+) = 'TPL' AND LENGTH(PL.SB_LOC_CD(+)) = 5                
                   AND AL.BKG_ALOC_SEQ = PD.BKG_ALOC_SEQ(+) AND PD.SB_LOC_DIV_CD(+) = 'TPD' AND LENGTH(PD.SB_LOC_CD(+)) = 5                
                   AND AL.BKG_ALOC_SEQ = PL2.BKG_ALOC_SEQ(+) AND PL2.SB_LOC_DIV_CD(+) = 'SPL' AND LENGTH(PL2.SB_LOC_CD(+)) = 5                
                   AND AL.BKG_ALOC_SEQ = PD2.BKG_ALOC_SEQ(+) AND PD2.SB_LOC_DIV_CD(+) = 'SPD' AND LENGTH(PD2.SB_LOC_CD(+)) = 5                   
                   AND AL.BKG_ALOC_SEQ = PL3.BKG_ALOC_SEQ(+) AND PL3.SB_LOC_DIV_CD(+) = 'TPL' AND LENGTH(PL3.SB_LOC_CD(+)) = 2                
                   AND AL.BKG_ALOC_SEQ = PD3.BKG_ALOC_SEQ(+) AND PD3.SB_LOC_DIV_CD(+) = 'TPD' AND LENGTH(PD3.SB_LOC_CD(+)) = 2                
                   AND AL.BKG_ALOC_SEQ = PL4.BKG_ALOC_SEQ(+) AND PL4.SB_LOC_DIV_CD(+) = 'SPL' AND LENGTH(PL4.SB_LOC_CD(+)) = 2                
                   AND AL.BKG_ALOC_SEQ = PD4.BKG_ALOC_SEQ(+) AND PD4.SB_LOC_DIV_CD(+) = 'SPD' AND LENGTH(PD4.SB_LOC_CD(+)) = 2                               
                   AND AL.BKG_ALOC_SEQ = POR.BKG_ALOC_SEQ(+) AND POR.SB_LOC_DIV_CD(+) = 'POR' AND LENGTH(POR.SB_LOC_CD(+)) = 5                
                   AND AL.BKG_ALOC_SEQ = POL.BKG_ALOC_SEQ(+) AND POL.SB_LOC_DIV_CD(+) = 'POL' AND LENGTH(POL.SB_LOC_CD(+)) = 5                
                   AND AL.BKG_ALOC_SEQ = POD.BKG_ALOC_SEQ(+) AND POD.SB_LOC_DIV_CD(+) = 'POD' AND LENGTH(POD.SB_LOC_CD(+)) = 5                
                   AND AL.BKG_ALOC_SEQ = DEL.BKG_ALOC_SEQ(+) AND DEL.SB_LOC_DIV_CD(+) = 'DEL' AND LENGTH(DEL.SB_LOC_CD(+)) = 5                
                   AND AL.BKG_ALOC_SEQ = POR2.BKG_ALOC_SEQ(+) AND POR2.SB_LOC_DIV_CD(+) = 'POR' AND LENGTH(POR2.SB_LOC_CD(+)) = 2                
                   AND AL.BKG_ALOC_SEQ = POL2.BKG_ALOC_SEQ(+) AND POL2.SB_LOC_DIV_CD(+) = 'POL' AND LENGTH(POL2.SB_LOC_CD(+)) = 2                
                   AND AL.BKG_ALOC_SEQ = POD2.BKG_ALOC_SEQ(+) AND POD2.SB_LOC_DIV_CD(+) = 'POD' AND LENGTH(POD2.SB_LOC_CD(+)) = 2                
                   AND AL.BKG_ALOC_SEQ = DEL2.BKG_ALOC_SEQ(+) AND DEL2.SB_LOC_DIV_CD(+) = 'DEL' AND LENGTH(DEL2.SB_LOC_CD(+)) = 2           
                           
                   -- [2015.10.23]          
                   AND AL.BKG_ALOC_SEQ = SAY1.BKG_ALOC_SEQ(+) AND SAY1.SB_LOC_DIV_CD(+) = 'SAY'        
                   AND AL.BKG_ALOC_SEQ = SLY1.BKG_ALOC_SEQ(+) AND SLY1.SB_LOC_DIV_CD(+) = 'SLY' AND LENGTH(SLY1.SB_LOC_CD(+)) = 7         
                   AND AL.BKG_ALOC_SEQ = SDY1.BKG_ALOC_SEQ(+) AND SDY1.SB_LOC_DIV_CD(+) = 'SDY' AND LENGTH(SDY1.SB_LOC_CD(+)) = 7          
                           
                   AND AL.BKG_ALOC_SEQ = A.BKG_ALOC_SEQ(+) AND A.BKG_CUST_TP_CD(+) = 'B'                 
                   AND AL.BKG_ALOC_SEQ = TP.BKG_ALOC_SEQ(+)                
                   AND AL.BKG_ALOC_SEQ = CMDT.BKG_ALOC_SEQ(+)                
                GROUP BY AL.BKG_ALOC_SEQ, B.LST_SB_SUB_RSN_CD, B.ALOC_SVC_CD, B.LST_SB_OTR_RSN, B.MODI_SEQ, B.LST_SB_OTR_RSN, B.BKG_CTRL_TP_CD            
                UNION ALL                    
                SELECT v_appl_info, 'S', 'X', NULL, 'L.OFC:'|| v_ofc_cd ||', SC NO:'|| v_sc_no ||', RFA NO:'|| v_rfa_no ||' ACCOUNT CD:' || v_acct_cd, v_user_info, SYSDATE, v_user_info, SYSDATE, NULL, v_modi_seq, v_smp_reason, v_sc_no, v_rfa_no, v_acct_cd, v_sub_trd_cd, v_vvd_cd, v_ofc_cd, v_rlane_cd ,v_smp_aloc_sts_cd,'N'             
                FROM DUAL WHERE v_smp_aloc_sts_cd = 'S'              
                UNION ALL                
				SELECT v_appl_info, 'S', 'X', NULL, 'L.OFC:'|| v_ofc_cd ||', SC NO:'|| v_sc_no ||', RFA NO:'|| v_rfa_no ||' ACCOUNT CD:' || v_acct_cd, v_user_info, SYSDATE, v_user_info, SYSDATE, NULL, v_modi_seq, v_smp_reason, v_sc_no, v_rfa_no, v_acct_cd, v_sub_trd_cd, v_vvd_cd, v_ofc_cd, v_rlane_cd ,v_smp_aloc_sts_cd,'N'              
                FROM DUAL WHERE v_smp_aloc_sts_cd = 'A'              
                UNION ALL                
                SELECT v_appl_info, 'A', 'X', NULL, 'SUB Trade:'||v_sub_trd_cd ||', VVD:' || v_vvd_cd, v_user_info, SYSDATE, v_user_info, SYSDATE, NULL, v_modi_seq, v_aloc_reason, v_sc_no, v_rfa_no, v_acct_cd, v_sub_trd_cd, v_vvd_cd, v_ofc_cd, v_rlane_cd ,v_aloc_aloc_sts_cd,'N'           
                FROM DUAL WHERE v_aloc_aloc_sts_cd = 'S'               
				UNION ALL                
                SELECT v_appl_info, 'A', 'X', NULL, 'SUB Trade:'||v_sub_trd_cd ||', VVD:' || v_vvd_cd, v_user_info, SYSDATE, v_user_info, SYSDATE, NULL, v_modi_seq, v_aloc_reason, v_sc_no, v_rfa_no, v_acct_cd, v_sub_trd_cd, v_vvd_cd, v_ofc_cd, v_rlane_cd ,v_aloc_aloc_sts_cd,'N'           
                FROM DUAL WHERE v_aloc_aloc_sts_cd = 'A'               
            ;                
                            
        --==============================================================================             
        -- 기존에 STANDBY가 존재하고, 이후 BKG 정보 변경등 FIRM 처리되었을때 기존 정보는 유지하고 DELT FLG 처리             
        -- [2015.10.16]           
       
              
-- [2015.12.16] 임시로 bkg 이 firm 이더라도 standby 발생할경우 spc에 저장하도록 처리 , 대신 화면에서 standby-> firm 처리못하도록 버튼 비활성화         
-- [2016.02.22] 로직상 Firm일경우 master table 변경으로 인한 배치 수행때도 자동으로 spc bkg firm 처리해준다.    
-- 1. BKG정보변경, Reprocess 요청시 호출    
-- 2. 배치 호출시 Mastertable변경, SMP변경, ALOC 대상 BKG 이 STANDBY -> FIRM 처리되었을경우 호출    
        ELSIF (in_mode IN ('B','R') AND (v_sb_ck_rlst = 'N' AND a_sb_ck_rlst = 'N')) THEN       
            -- REASON 정보 존재하면 업데이트            
            IF (v_is_standby = 'Y') THEN                     
                UPDATE SPC_SB_BKG              
                   SET CFM_USR_ID   ='SPC_SYSTEM'              
                     , CFM_DT       = SYSDATE               
                     , UPD_USR_ID   = v_user_info            
                     , UPD_DT       = SYSDATE                
                 WHERE BKG_NO       = v_appl_info ;              
                              
                UPDATE SPC_SB_BKG_DTL             
                   SET DELT_FLG         = 'Y'            
                     , UPD_USR_ID       = v_user_info            
                     , UPD_DT           = SYSDATE            
                 WHERE BKG_NO           = v_appl_info           
                   AND BKG_CTRL_TP_CD   = 'S';      
            END IF;         
                
            -- REASON 정보 존재하면 삭제           
            IF (v_is_attention = 'Y') THEN                   
                DELETE FROM SPC_SB_BKG_DTL WHERE BKG_NO = v_appl_info AND BKG_CTRL_TP_CD   = 'A';           
            END IF;     
                
                
        ELSIF (in_mode = 'W' AND (v_sb_ck_rlst = 'N' AND a_sb_ck_rlst = 'N') AND v_is_confirm = 'N'    
                AND (v_mst_raply_cnt > 0 OR v_smp_raply_cnt > 0 OR v_aloc_must_flg='Y' OR (v_aloc_fcst_flg='Y' AND v_aloc_lf_cnt=0))) THEN   
            -- 이전 BKG이 STANDBY 이면서 현재 STANDBY->FIRM 처리되었을때           
            IF (v_is_standby = 'Y') THEN                     
                UPDATE SPC_SB_BKG              
                   SET CFM_USR_ID   ='SPC_SYSTEM'              
                     , CFM_DT       = SYSDATE               
                     , UPD_USR_ID   = v_user_info            
                     , UPD_DT       = SYSDATE                
                 WHERE BKG_NO       = v_appl_info ;              
                              
                UPDATE SPC_SB_BKG_DTL             
                   SET DELT_FLG         = 'Y'            
                     , UPD_USR_ID       = v_user_info            
                     , UPD_DT           = SYSDATE            
                 WHERE BKG_NO           = v_appl_info           
                   AND BKG_CTRL_TP_CD   = 'S';      
                       
                -- BKG UPDATE 로직 호출하기 위해서 BATCH TABLE에 저장후 프로시저 실행완료되면 다음 로직 태운다.    
                -- STANDBY 테이블 수정 로직은 BATCH에 존재    
                 MERGE INTO SPC_SB_BAT_MNTR M1 USING    
                 (    
                        SELECT v_appl_info AS BKG_NO    
                             , 'S' AS BAT_STS_CD  -- SUCCESSED    
                             , 'F' AS ALOC_STS_CD    
                             , 'BATCH S->F:'||SYSDATE AS RAPLY_RMK    
                          FROM DUAL    
                 ) S1    
                 ON (M1.BKG_NO = S1.BKG_NO)    
                 WHEN MATCHED THEN     
                        UPDATE     
                           SET M1.BAT_STS_CD  = S1.BAT_STS_CD    
                             , M1.ALOC_STS_CD = S1.ALOC_STS_CD    
                             , M1.RAPLY_RMK   = SUBSTR(S1.RAPLY_RMK || ' <- '|| M1.RAPLY_RMK,1,1000)    
                             , M1.UPD_USR_ID  = v_user_info    
                             , M1.UPD_DT      = SYSDATE    
                 WHEN NOT MATCHED THEN     
                        INSERT (    
                            M1.BKG_NO    
                          , M1.BAT_STS_CD    
                          , M1.ALOC_STS_CD    
                          , M1.RAPLY_RMK    
                          , M1.CRE_USR_ID    
                          , M1.CRE_DT    
                          , M1.UPD_USR_ID    
                          , M1.UPD_DT    
                        ) VALUES (    
                            S1.BKG_NO    
                          , S1.BAT_STS_CD    
                          , S1.ALOC_STS_CD    
                          , S1.RAPLY_RMK     
                          , v_user_info    
                          , SYSDATE    
                          , v_user_info    
                          , SYSDATE    
                        );     
                            
             enis_log_prc(SYSDATE, v_prc_nm, v_step || ' Mode:W, Standby->Firmed', v_appl_info);    
                          
            END IF;     
                
                
            -- REASON 정보 존재하면 삭제           
            IF (v_is_attention = 'Y') THEN                   
                DELETE FROM SPC_SB_BKG_DTL WHERE BKG_NO = v_appl_info AND BKG_CTRL_TP_CD   = 'A';           
            END IF;      
                
-- [2016.02.22] 사용안함. - (노란색 바탕에 빨간색 폰트)                       
--        ELSIF (v_sb_ck_rlst = 'N' AND in_mode IN ('W', 'V', 'T') ) THEN                
--                            
--            --Candidate Confirm 대상인 경우                
--            UPDATE SPC_SB_BKG                
--                SET CNDDT_CFM_FLG = '1', CNDDT_CFM_DT = SYSDATE, UPD_USR_ID = v_user_info, UPD_DT = SYSDATE                
--            WHERE BKG_NO = v_appl_info                
--            AND ( (CASE WHEN (v_old_lst_sb_rsn_tp_cd = 'M' AND v_mst_raply_cnt > 0) THEN 1 ELSE 0 END = 1)                
--                 OR (CASE WHEN (v_old_smp_rsn_tp_cd = 'S'    AND v_smp_raply_cnt > 0) THEN 1 ELSE 0 END = 1))                
--            ;                
                  
                            
        END IF;                
              
             
        enis_log_prc(SYSDATE, v_prc_nm, v_step || ' END', v_appl_info);                
                        
        --BKG 한건당 COMMIT;                
        COMMIT;                
                
--Must 이거나, v_lf_cnt = 0 이면 BKG Control 수행                
--END IF;                
                
    --Loop 종료                
    END;                
                    
    <<continue_loop>>  -- not allowed unless an executable statement follows                
    NULL; -- add NULL statement to avoid error                
                    
    END LOOP;                
                    
        /************************************************************************                
        5. REAPPLY FLAG INIT                
        배치에서 Call한경우 RAPLY_CFM_FLG 초기화                
        SPC_ALOC_CTRL_OPT, SPC_BKG_ALOC_MGMT, SPC_MDL_CUST_REV_LANE 테이블에 RAPLY_CFM_FLG 초기화                
        ************************************************************************/                
                        
        IF(in_mode = 'W' AND in_rlane IS NULL AND in_vvd IS NULL) THEN                
                        
            v_step := '5. REAPPLY FLAG INIT';                
            v_appl_info := 'WK:'||in_wk ||', Duration:' || in_duration;                
            enis_log_prc(SYSDATE, v_prc_nm, v_step || ' START', v_appl_info);                
                            
            --Master Table 초기화                
            UPDATE SPC_BKG_ALOC_MGMT SET RAPLY_CFM_FLG = '0' WHERE RAPLY_CFM_FLG = '1';                
                            
            --Allocation Control Option 초기화                
            UPDATE SPC_ALOC_CTRL_OPT SET RAPLY_CFM_FLG = '0'                
            WHERE (RLANE_CD, DIR_CD, VSL_CD, SKD_VOY_NO, SKD_DIR_CD )                
            IN (SELECT RLANE_CD, DIR_CD, VSL_CD, SKD_VOY_NO, DIR_CD                
                FROM MAS_MON_VVD V                
                WHERE SUBSTR(V.SLS_YRMON,1,4)||V.COST_WK IN (SELECT COST_YR||COST_WK                
                                                          FROM MAS_WK_PRD PRD1                
                                                          WHERE PRD1.COST_YR||PRD1.COST_WK >=                
                                                           (SELECT PRD.COST_YR || TO_CHAR(CEIL((TO_CHAR(SYSDATE + ( 7 * in_wk ), 'DDD') + 7 - TO_CHAR(TO_DATE(PRD.SLS_TO_DT, 'YYYYMMDD'), 'DDD')) / 7), 'FM00') AS COST_WK                
                                                             FROM MAS_WK_PRD PRD                
                                                            WHERE PRD.COST_YR = TO_CHAR(SYSDATE + ( 7 * in_wk ), 'YYYY')                
                                                            AND PRD.COST_WK = '01' )                
                                                          AND ROWNUM <= in_duration)                
                AND V.TRD_CD         = (SELECT SPC_GET_REP_TRD_FNC(V.RLANE_CD) FROM DUAL)                
                AND V.SUB_TRD_CD     = (SELECT SPC_GET_REP_SUB_TRD_FNC(V.RLANE_CD) FROM DUAL)                
                AND V.DELT_FLG       = 'N');                
                            
            --SMP 초기화                
            UPDATE SPC_MDL_CUST_REV_LANE                
            SET RAPLY_CFM_FLG = '0'                
            WHERE                
            (COST_YRWK||'-'||VER_SEQ, TRD_CD, SUB_TRD_CD, RLANE_CD, NVL(RAPLY_CFM_FLG, 0))                
            IN (                
                    SELECT                
                    (SELECT/*+ INDEX_DESC (M XPKSPC_MDL_VER_MST) */                
                        DECODE(NVL((SELECT 'Y' FROM SPC_HD_HUL_MST WHERE TRD_CD = V.trd_cd AND RLANE_CD=V.rlane_cd AND DIR_CD=V.dir_cd), 'N'), 'Y', COST_YRWK||'-'||VER_SEQ, '200001-1')                
                          FROM SPC_MDL_VER_MST M                
                         WHERE SUBSTR(V.SLS_YRMON,1,4)||V.COST_WK BETWEEN M.VER_ST_YRWK AND M.VER_END_YRWK                
                           AND M.TRD_CD  = V.trd_cd                
                           AND M.CFM_FLG = 'Y'                
                           AND ROWNUM = 1) SEASON                
                     , V.TRD_CD, V.SUB_TRD_CD, V.RLANE_CD, '1'                
                    FROM MAS_MON_VVD V                
                    WHERE                
                    SUBSTR(V.SLS_YRMON,1,4)||V.COST_WK IN (SELECT COST_YR||COST_WK                
                                                              FROM MAS_WK_PRD PRD1                
                                                              WHERE PRD1.COST_YR||PRD1.COST_WK >=                
                                                               (SELECT PRD.COST_YR || TO_CHAR(CEIL((TO_CHAR(SYSDATE + ( 7 * in_wk ), 'DDD') + 7 - TO_CHAR(TO_DATE(PRD.SLS_TO_DT, 'YYYYMMDD'), 'DDD')) / 7), 'FM00') AS COST_WK                
                                                                 FROM MAS_WK_PRD PRD                
                                                                WHERE PRD.COST_YR = TO_CHAR(SYSDATE + ( 7 * in_wk ), 'YYYY')                
                                                                AND PRD.COST_WK = '01' )                
                                                              AND ROWNUM <= in_duration)                
                    AND V.TRD_CD         = (SELECT SPC_GET_REP_TRD_FNC(V.RLANE_CD) FROM DUAL)                
                    AND V.SUB_TRD_CD     = (SELECT SPC_GET_REP_SUB_TRD_FNC(V.RLANE_CD) FROM DUAL)                
                    AND V.DELT_FLG       = 'N'                
            );                
                           
           COMMIT;                
           enis_log_prc(SYSDATE, v_prc_nm, v_step || ' END', v_appl_info);                
                           
        END IF;                
                        
        enis_log_prc(SYSDATE, v_prc_nm, 'END', '');                
    EXCEPTION                
        WHEN OTHERS                
        THEN                
            enis_log_prc(SYSDATE, v_prc_nm, 'error' || SQLERRM , v_step);                
    END;                
END;