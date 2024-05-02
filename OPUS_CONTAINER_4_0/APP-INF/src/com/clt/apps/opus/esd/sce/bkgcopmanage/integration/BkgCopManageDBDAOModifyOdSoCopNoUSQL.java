/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BkgCopManageDBDAOModifyOdSoCopNoUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.20
*@LastModifier : 박찬우
*@LastVersion : 1.0
* 2016.04.20 박찬우
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Chanwoo Park
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOModifyOdSoCopNoUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * od -so 의 cop_no 를 to_cop_no 로 변경한다.
	  * 이는 tro 정보 이동 시에만 사용된다.
	  * </pre>
	  */
	public BkgCopManageDBDAOModifyOdSoCopNoUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fm_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOModifyOdSoCopNoUSQL").append("\n"); 
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
		query.append("UPDATE TRS_TRSP_SVC_ORD" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("	COP_NO = @[to_cop_no]," ).append("\n"); 
		query.append("    CNTR_SLT_NO = BKG_GET_SLOT_NO_FNC(@[to_cop_no])" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("	COP_NO = @[fm_cop_no]" ).append("\n"); 
		query.append("	AND COST_ACT_GRP_CD LIKE 'OD%'" ).append("\n"); 
		query.append("	AND NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 

	}
}