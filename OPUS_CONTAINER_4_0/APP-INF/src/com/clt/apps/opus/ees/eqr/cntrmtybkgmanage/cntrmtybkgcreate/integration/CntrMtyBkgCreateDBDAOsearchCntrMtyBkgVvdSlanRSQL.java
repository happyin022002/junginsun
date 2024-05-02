/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CntrMtyBkgCreateDBDAOsearchCntrMtyBkgVvdSlanRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.08.21
*@LastModifier : 
*@LastVersion : 1.0
* 2013.08.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dong-sun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrMtyBkgCreateDBDAOsearchCntrMtyBkgVvdSlanRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EES_EQR_1018
	  * VSK_VSL_SKD 에서 VSL_SLAN_CD 조회함
	  * </pre>
	  */
	public CntrMtyBkgCreateDBDAOsearchCntrMtyBkgVvdSlanRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.eqr.cntrmtybkgmanage.cntrmtybkgcreate.integration").append("\n"); 
		query.append("FileName : CntrMtyBkgCreateDBDAOsearchCntrMtyBkgVvdSlanRSQL").append("\n"); 
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
		query.append("--  1.정의 " ).append("\n"); 
		query.append("--    VVD 가 FEEDER - TRUNK 여부 확인" ).append("\n"); 
		query.append("--  2.변수 : vvd         (ANGN3309E, HNAA0006E)" ).append("\n"); 
		query.append("--           trsp_mod_cd (W / V)" ).append("\n"); 
		query.append("--  3.메세지 처리       " ).append("\n"); 
		query.append("--    trsp_mod_cd = W 일때 결과값이 없으면 - Please input feeder vvd code!" ).append("\n"); 
		query.append("--    trsp_mod_cd = V 일때 결과값이 없으면 - Please input trunk vvd code!    " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT B.VSL_SLAN_CD -- 이게 LANE" ).append("\n"); 
		query.append("      ,DECODE(C.VSL_SVC_TP_CD, NULL, 'O', 'O', 'O', 'T') SVC_TP_CD" ).append("\n"); 
		query.append("FROM VSK_VSL_SKD      B" ).append("\n"); 
		query.append("    ,MDM_VSL_SVC_LANE C" ).append("\n"); 
		query.append("WHERE B.VSL_SLAN_CD = C.VSL_SLAN_CD(+)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if(${trsp_mod_cd} == 'W')" ).append("\n"); 
		query.append("AND   DECODE(C.VSL_SVC_TP_CD, NULL, 'O', 'O', 'O', 'T') = 'O'" ).append("\n"); 
		query.append("#elseif(${trsp_mod_cd} == 'V')" ).append("\n"); 
		query.append("AND   DECODE(C.VSL_SVC_TP_CD, NULL, 'O', 'O', 'O', 'T') = 'T'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND   B.VSL_CD      = SUBSTR(@[vvd], 0, 4)" ).append("\n"); 
		query.append("AND   B.SKD_VOY_NO  = SUBSTR(@[vvd], 5, 4)" ).append("\n"); 
		query.append("AND   B.SKD_DIR_CD  = SUBSTR(@[vvd], 9, 1)" ).append("\n"); 

	}
}