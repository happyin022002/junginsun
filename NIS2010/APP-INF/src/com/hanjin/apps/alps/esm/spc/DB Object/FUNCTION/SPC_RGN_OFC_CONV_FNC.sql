CREATE OR REPLACE FUNCTION NISADM.SPC_RGN_OFC_CONV_FNC( v_aq_ofc_cd IN VARCHAR2, v_rgn_ofc_cd IN VARCHAR2)
                                                                                                          
RETURN VARCHAR2                                                                                           
authid current_user                                                                                       
                                                                                                          
IS                                                                                                          
/******************************************************************************                           
   Name         :   SPC_RGN_OFC_CONV_FNC                                                                    
   Purpose      :   해당 Office별 Area Code를 찾는 Function                     
   Table        :   none                                                                             
   System       :   ALPS > Sales Management > Space Control                                                                   
   History      :   Ver 1.0 김수정 2011.06.01
                    2011.06.03  김수정
                        SELSA/TYOSC/TPESC -> KOREA/JAPAN/TAIWAN
                        SHADSA/SHADPI -> SINDSA/SINDPI
                    2013.06.28  김시몬
                        'DXBSC'/'AISBA'/'DURBA' => 'SINDPI' -> 'DXBME' 로 변경
					2014.04.18  신자영
                        'AKLBA -> SINRS로 변경
******************************************************************************/                    
                                                                                                          
    v_rtn_ofc_cd VARCHAR2(7);                                                                            
                                                                                                          
BEGIN                                                                                                     
    -- Area Code Mapping                                                                              
    IF v_rgn_ofc_cd IN ('NBOSC','TSNSC','TAOSC','CHGSC','NKGSC','SHASC','DLCSC') THEN
        v_rtn_ofc_cd := 'SHADNC';
    ELSIF v_rgn_ofc_cd IN ('BKKSC','SGNSC','SINSC','PKGSA','JKTSC','JKTBA','SYDSC','AKLBA','PNHBA','MNLSC','MNLBA','RGNBA') THEN
        v_rtn_ofc_cd := 'SINDSA';
    ELSIF v_rgn_ofc_cd IN ('BOMSC','KHIBA','DACBA','DACSC','CMBSC') THEN
        v_rtn_ofc_cd := 'SINDPI';
    ELSIF v_rgn_ofc_cd = 'SELSA' THEN
        v_rtn_ofc_cd := 'KOREA';
    ELSIF v_rgn_ofc_cd = 'TYOSC' THEN
        v_rtn_ofc_cd := 'JAPAN';
    ELSIF v_rgn_ofc_cd = 'TPESC' THEN
        v_rtn_ofc_cd := 'TAIWAN';
    ELSIF v_rgn_ofc_cd IN ('DXBSC','AISBA','DURBA') THEN -- 20130701 변경
        v_rtn_ofc_cd := 'DXBME';
    ELSE
        v_rtn_ofc_cd := v_aq_ofc_cd;
    END IF;
                                                                                                  
                                                                                                          
    RETURN v_rtn_ofc_cd;                                                                                  
END ;
