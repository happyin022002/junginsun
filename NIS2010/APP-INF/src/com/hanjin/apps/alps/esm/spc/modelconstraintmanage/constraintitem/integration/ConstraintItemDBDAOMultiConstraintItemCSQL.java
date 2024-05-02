/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ConstraintItemDBDAOMultiConstraintItemCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.03
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2010.02.03 최윤성
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.constraintitem.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI Yun Sung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ConstraintItemDBDAOMultiConstraintItemCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SAQ_MDL_CNST   정보 INSERT
	  * </pre>
	  */
	public ConstraintItemDBDAOMultiConstraintItemCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yqta_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqta_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mdl_cnst_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mdl_cnst_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("raloc_edit_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("raloc_use_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yqta_edit_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mqta_edit_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.spc.modelconstraintmanage.constraintitem.integration").append("\n"); 
		query.append("FileName : ConstraintItemDBDAOMultiConstraintItemCSQL").append("\n"); 
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
		query.append("INSERT INTO SAQ_MDL_CNST (" ).append("\n"); 
		query.append("    MDL_CNST_CD   ," ).append("\n"); 
		query.append("    MDL_CNST_NM   ," ).append("\n"); 
		query.append("    YQTA_EDIT_FLG ," ).append("\n"); 
		query.append("    YQTA_USE_FLG  ," ).append("\n"); 
		query.append("    RALOC_EDIT_FLG," ).append("\n"); 
		query.append("    MQTA_EDIT_FLG ," ).append("\n"); 
		query.append("    MQTA_USE_FLG  ," ).append("\n"); 
		query.append("    RALOC_USE_FLG ," ).append("\n"); 
		query.append("    CRE_USR_ID    ," ).append("\n"); 
		query.append("    CRE_DT        ," ).append("\n"); 
		query.append("    UPD_USR_ID    ," ).append("\n"); 
		query.append("    UPD_DT" ).append("\n"); 
		query.append(") VALUES (" ).append("\n"); 
		query.append("    @[mdl_cnst_cd]   ," ).append("\n"); 
		query.append("    @[mdl_cnst_nm]   ," ).append("\n"); 
		query.append("    @[yqta_edit_flg] ," ).append("\n"); 
		query.append("    @[yqta_use_flg]  ," ).append("\n"); 
		query.append("    @[raloc_edit_flg]," ).append("\n"); 
		query.append("    @[mqta_edit_flg] ," ).append("\n"); 
		query.append("    @[mqta_use_flg]  ," ).append("\n"); 
		query.append("    @[raloc_use_flg] ," ).append("\n"); 
		query.append("    @[cre_usr_id]    ," ).append("\n"); 
		query.append("    SYSDATE          ," ).append("\n"); 
		query.append("    @[upd_usr_id]    ," ).append("\n"); 
		query.append("    SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}