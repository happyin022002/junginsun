/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : CgmEdiSendDBDAOChssExceptDaysRSQL.java
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

public class CgmEdiSendDBDAOChssExceptDaysRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * -- CHSS_EXCEPT = 'N' 이면 조회하지 않고 0 으로 처리합니다.
	  * 
	  * CHSS_EXCEPT_DAYS 조회
	  * :bkg_no
	  * :cntr_no
	  * :tpsz_cd
	  * :loc_cd    - IMPORT 일때는 DEL_CD, EXPORT 일때는 POR_CD  
	  * :sc_no
	  * :eff_dt    - BKG 의 OC_DT 없으면 BKG_CRE_DT
	  * </pre>
	  */
	public CgmEdiSendDBDAOChssExceptDaysRSQL(){
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
		params.put("chz_except",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmedisend.integration").append("\n"); 
		query.append("FileName : CgmEdiSendDBDAOChssExceptDaysRSQL").append("\n"); 
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
		query.append("           CASE WHEN  @[chz_except] = 'N' THEN 0" ).append("\n"); 
		query.append("                ELSE" ).append("\n"); 
		query.append("                      (" ).append("\n"); 
		query.append("                                        SELECT FT_DYS  -- exception 조건에 부합" ).append("\n"); 
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
		query.append("                                        AND   B.BKG_NO               = @[bkg_no] " ).append("\n"); 
		query.append("                                        AND   NVL(L.CUST_CNT_CD,'*')         IN ('*',B.AGMT_ACT_CNT_CD) " ).append("\n"); 
		query.append("                                        AND   NVL(L.CUST_SEQ,-1)             IN (-1,B.AGMT_ACT_CUST_SEQ) " ).append("\n"); 
		query.append("                                        AND   NVL(L.CHSS_CNTR_CGO_TP_CD,'*') IN ('*',DECODE(SUBSTR(@[tpsz_cd],1,1),'R','R','D','D','S')) " ).append("\n"); 
		query.append("                                        AND   NVL(L.CMDT_CD,'*')             IN ('*',B.CMDT_CD) " ).append("\n"); 
		query.append("                                        AND   ROWNUM=1" ).append("\n"); 
		query.append("                       )" ).append("\n"); 
		query.append("           END  AS CHZ_EXCEPT_DAYS" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    FROM  BKG_BOOKING  B        " ).append("\n"); 
		query.append("    WHERE B.BKG_NO  = @[bkg_no]" ).append("\n"); 

	}
}