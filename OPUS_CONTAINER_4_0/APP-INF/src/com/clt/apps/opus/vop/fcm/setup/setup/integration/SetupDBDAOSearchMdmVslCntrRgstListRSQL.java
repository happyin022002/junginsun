/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SetupDBDAOSearchMdmVslCntrRgstListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.19
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.04.19 진마리아
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.fcm.setup.setup.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SetupDBDAOSearchMdmVslCntrRgstListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MDM의 Vessel 정보를 조회합니다.
	  * 
	  * History
	  * 2012.04.19 진마리아 CHM-201217192-01 Vessel Registration내 선박 추가 로직 변경 요청건-CRR_CD추가
	  * </pre>
	  */
	public SetupDBDAOSearchMdmVslCntrRgstListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.fcm.setup.setup.integration").append("\n"); 
		query.append("FileName : SetupDBDAOSearchMdmVslCntrRgstListRSQL").append("\n"); 
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
		query.append("SELECT VSL_CD" ).append("\n"); 
		query.append("      ,VSL_ENG_NM" ).append("\n"); 
		query.append("      ,DWT_WGT" ).append("\n"); 
		query.append("      ,GRS_RGST_TONG_WGT" ).append("\n"); 
		query.append("      ,NET_RGST_TONG_WGT" ).append("\n"); 
		query.append("      ,LLOYD_NO" ).append("\n"); 
		query.append("      ,CNTR_DZN_CAPA CNTR_VSL_CLSS_CAPA" ).append("\n"); 
		query.append("      ,CRR_CD" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR" ).append("\n"); 
		query.append("WHERE VSL_CD=@[vsl_cd]" ).append("\n"); 
		query.append("AND NVL(VSL_CLSS_FLG, ' ')='N'" ).append("\n"); 
		query.append("AND DELT_FLG='N'" ).append("\n"); 
		query.append("AND FDR_DIV_CD='T'" ).append("\n"); 
		query.append("--AND CRR_CD='HJS'" ).append("\n"); 

	}
}