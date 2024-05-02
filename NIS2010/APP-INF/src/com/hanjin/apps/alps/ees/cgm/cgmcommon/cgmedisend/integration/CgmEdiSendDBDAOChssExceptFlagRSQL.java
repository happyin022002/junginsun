/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CgmEdiSendDBDAOChssExceptFlagRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.09
*@LastModifier : 
*@LastVersion : 1.0
* 2016.08.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CgmEdiSendDBDAOChssExceptFlagRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CHSS_EXCEPT 조회
	  * 변수
	  * :bkg_no
	  * :cntr_no
	  * :ie_ind    - IP : 미국IMPORT, XP : 미국EXPORT
	  * :tpsz_cd
	  * :loc_cd    - IMPORT 일때는 DEL_CD, EXPORT 일때는 POR_CD  
	  * :sc_no
	  * :eff_dt    - BKG 의 OC_DT 없으면 BKG_CRE_DT
	  * </pre>
	  */
	public CgmEdiSendDBDAOChssExceptFlagRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eff_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ie_ind",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmedisend.integration").append("\n"); 
		query.append("FileName : CgmEdiSendDBDAOChssExceptFlagRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("SELECT   " ).append("\n"); 
		query.append("           -- RCV_TERM : 출발지 운송, DE_TERM : 도착지 운송" ).append("\n"); 
		query.append("           CASE WHEN  DECODE(@[ie_ind],'XP',B.RCV_TERM_CD, B.DE_TERM_CD) <> 'D' THEN -- XP : " ).append("\n"); 
		query.append("                      (" ).append("\n"); 
		query.append("                       CASE WHEN      SUBSTR(@[tpsz_cd],1,1) = 'R'  " ).append("\n"); 
		query.append("                                 AND  B.DEL_CD             = 'USOAK' " ).append("\n"); 
		query.append("                                 AND @[ie_ind]               = 'IP'  -- us import" ).append("\n"); 
		query.append("                                 AND (" ).append("\n"); 
		query.append("                                      SELECT C.RD_CGO_FLG " ).append("\n"); 
		query.append("                                      FROM BKG_CONTAINER C " ).append("\n"); 
		query.append("                                      WHERE @[bkg_no] = C.BKG_NO" ).append("\n"); 
		query.append("                                      AND   @[cntr_no] = C.CNTR_NO" ).append("\n"); 
		query.append("                                     ) ='N' " ).append("\n"); 
		query.append("                                 THEN 'Y'" ).append("\n"); 
		query.append("                            WHEN      B.SC_NO    = 'AEN110235' " ).append("\n"); 
		query.append("                                  AND @[ie_ind]               = 'IP'  -- us import" ).append("\n"); 
		query.append("                                  AND B.POD_CD IN ('CAPRR','CAVAN','USSEA','USTIW','USPDX','USOAK','USLAX','USLGB')  " ).append("\n"); 
		query.append("                                THEN 'Y' " ).append("\n"); 
		query.append("                            WHEN      B.SC_NO      = 'AEN110235' " ).append("\n"); 
		query.append("                                  AND @[ie_ind]               = 'IP'  -- us import " ).append("\n"); 
		query.append("                                  AND B.POD_CD NOT IN ('CAPRR','CAVAN','USSEA','USTIW','USPDX','USOAK','USLAX','USLGB')" ).append("\n"); 
		query.append("                                  AND B.DEL_CD IN ('USADV','USCSF','USCHS','USZGB','USGSA','USHGR','USJAX','USISM','USMVP','USNYC','USORF','USNWB','USPFP','USPPY','USPFD','USPWN','USSAV','USSVH','USTHM','USVLD','USBAF','USILM')" ).append("\n"); 
		query.append("                                THEN 'N'" ).append("\n"); 
		query.append("                            ELSE      " ).append("\n"); 
		query.append("                                DECODE( (" ).append("\n"); 
		query.append("                                        SELECT 1" ).append("\n"); 
		query.append("                                        FROM  CGM_SC_EXPT_VER V" ).append("\n"); 
		query.append("                                             ,CGM_SC_EXPT_LIST L" ).append("\n"); 
		query.append("                                             ,BKG_BOOKING B " ).append("\n"); 
		query.append("                                        WHERE V.PROP_NO = (SELECT A.PROP_NO " ).append("\n"); 
		query.append("                                                           FROM  PRI_SP_HDR A " ).append("\n"); 
		query.append("                                                           WHERE A.SC_NO = B.SC_NO" ).append("\n"); 
		query.append("                                                          ) " ).append("\n"); 
		query.append("                                        AND   V.CHSS_EXPT_VER_STS_CD = 'L' -- 하드코딩 " ).append("\n"); 
		query.append("                                        AND   TO_DATE(@[eff_dt], 'YYYYMMDD') BETWEEN V.EFF_DT AND V.EXP_DT               " ).append("\n"); 
		query.append("                                        AND   V.PROP_NO              = L.PROP_NO " ).append("\n"); 
		query.append("                                        AND   V.SC_EXPT_VER_SEQ      = L.SC_EXPT_VER_SEQ " ).append("\n"); 
		query.append("                                        AND   V.DELT_FLG             = 'N'                                         " ).append("\n"); 
		query.append("                                        AND   L.LOC_CD               = @[loc_cd]  -- del(import), por(export)" ).append("\n"); 
		query.append("                                        AND   B.BKG_NO               = @[bkg_no]" ).append("\n"); 
		query.append("                                        AND   NVL(L.CUST_CNT_CD,'*')         IN ('*',B.AGMT_ACT_CNT_CD) " ).append("\n"); 
		query.append("                                        AND   NVL(L.CUST_SEQ,-1)             IN (-1,B.AGMT_ACT_CUST_SEQ) " ).append("\n"); 
		query.append("                                        AND   NVL(L.CHSS_CNTR_CGO_TP_CD,'*') IN ('*',DECODE(SUBSTR(@[tpsz_cd],1,1),'R','R','D','D','S')) " ).append("\n"); 
		query.append("                                        AND   NVL(L.CMDT_CD,'*')             IN ('*',B.CMDT_CD) " ).append("\n"); 
		query.append("                                        AND   ROWNUM=1" ).append("\n"); 
		query.append("                                     ),1, 'Y', 'N'" ).append("\n"); 
		query.append("                                     )" ).append("\n"); 
		query.append("                       END" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("                ELSE 'N' -- N : exception 아님, Y : EXCEPTION" ).append("\n"); 
		query.append("           END  AS CHZ_EXCEPT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    FROM  BKG_BOOKING  B        " ).append("\n"); 
		query.append("    WHERE B.BKG_NO  = @[bkg_no]" ).append("\n"); 

	}
}