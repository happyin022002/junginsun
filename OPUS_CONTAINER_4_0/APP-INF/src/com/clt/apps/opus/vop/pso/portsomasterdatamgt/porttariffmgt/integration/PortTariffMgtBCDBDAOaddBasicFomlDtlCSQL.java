/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : PortTariffMgtBCDBDAOaddBasicFomlDtlCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.19
*@LastModifier : 
*@LastVersion : 1.0
* 2012.04.19 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortTariffMgtBCDBDAOaddBasicFomlDtlCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Fomual detail을 등록한다.
	  * </pre>
	  */
	public PortTariffMgtBCDBDAOaddBasicFomlDtlCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pso_foml_dtl_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obj_list_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foml_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("foml_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pso_foml_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rt_obj_list_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.pso.portsomasterdatamgt.porttariffmgt.integration").append("\n"); 
		query.append("FileName : PortTariffMgtBCDBDAOaddBasicFomlDtlCSQL").append("\n"); 
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
		query.append("INSERT INTO PSO_FOML_DTL (" ).append("\n"); 
		query.append("FOML_NO" ).append("\n"); 
		query.append(",	FOML_SEQ" ).append("\n"); 
		query.append(",	PSO_FOML_DTL_TP_CD" ).append("\n"); 
		query.append(",	PSO_FOML_OPR_CD" ).append("\n"); 
		query.append(",	OBJ_LIST_NO" ).append("\n"); 
		query.append(",	RT_OBJ_LIST_NO" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[foml_no]" ).append("\n"); 
		query.append(",	@[foml_seq]" ).append("\n"); 
		query.append(",	@[pso_foml_dtl_tp_cd]" ).append("\n"); 
		query.append(",	@[pso_foml_opr_cd]" ).append("\n"); 
		query.append(", 	@[obj_list_no]" ).append("\n"); 
		query.append(",	@[rt_obj_list_no]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}