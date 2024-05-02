/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TOTFindCodeDBDAODeliveryNRedeliveryVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.21
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2010.01.21 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Chang Soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TOTFindCodeDBDAODeliveryNRedeliveryVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 선박명, 계약시작일자, 종료일자를 가져옴
	  * </pre>
	  */
	public TOTFindCodeDBDAODeliveryNRedeliveryVORSQL(){
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
		query.append("Path : com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.integration").append("\n"); 
		query.append("FileName : TOTFindCodeDBDAODeliveryNRedeliveryVORSQL").append("\n"); 
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
		query.append("SELECT A.VSL_ENG_NM" ).append("\n"); 
		query.append(",TO_CHAR(B.EFF_DT,'YYYYMMDD') EFF_DT" ).append("\n"); 
		query.append(",TO_CHAR(B.EXP_DT,'YYYYMMDD') EXP_DT" ).append("\n"); 
		query.append("FROM MDM_VSL_CNTR A," ).append("\n"); 
		query.append("(SELECT FLET_CTRT_NO, VSL_CD, EFF_DT, EXP_DT" ).append("\n"); 
		query.append("FROM  FMS_CONTRACT" ).append("\n"); 
		query.append("WHERE FLET_CTRT_NO = (SELECT MAX(FLET_CTRT_NO) FROM FMS_CONTRACT WHERE VSL_CD = @[vsl_cd])" ).append("\n"); 
		query.append(") B" ).append("\n"); 
		query.append("WHERE A.VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("AND A.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND A.VSL_CD = B.VSL_CD(+)" ).append("\n"); 

	}
}