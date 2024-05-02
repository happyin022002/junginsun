/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : OperationNPerformMasterDataMgtDBDAOCODDiversionCodeRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.13
*@LastModifier : 백승일
*@LastVersion : 1.0
* 2012.04.13 백승일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Baek Seungil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OperationNPerformMasterDataMgtDBDAOCODDiversionCodeRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CODDiversionCode Select Query
	  * </pre>
	  */
	public OperationNPerformMasterDataMgtDBDAOCODDiversionCodeRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("conti_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dvs_fee_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.integration").append("\n"); 
		query.append("FileName : OperationNPerformMasterDataMgtDBDAOCODDiversionCodeRSQL").append("\n"); 
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
		query.append("SELECT CONTI_CD, " ).append("\n"); 
		query.append("       DVS_FEE_TP_CD, " ).append("\n"); 
		query.append("       DELT_FLG" ).append("\n"); 
		query.append(" FROM OPF_COD_DVS_FEE" ).append("\n"); 
		query.append("WHERE CONTI_CD = @[conti_cd]" ).append("\n"); 
		query.append("AND   DVS_FEE_TP_CD = @[dvs_fee_tp_cd]" ).append("\n"); 

	}
}