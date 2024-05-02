/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : InterfaceMgtDBDAOaddFASendEAIDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.02
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.02 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class InterfaceMgtDBDAOaddFASendEAIDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public InterfaceMgtDBDAOaddFASendEAIDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_if_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_grp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_trc_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_if_msg_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mnr_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.integration ").append("\n"); 
		query.append("FileName : InterfaceMgtDBDAOaddFASendEAIDataCSQL").append("\n"); 
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
		query.append("INSERT INTO MNR_IF_TRC(" ).append("\n"); 
		query.append("	IF_TRC_SEQ" ).append("\n"); 
		query.append("	, MNR_GRP_TP_CD" ).append("\n"); 
		query.append("	, MNR_REF_NO" ).append("\n"); 
		query.append("	, MNR_IF_MSG_CTNT" ).append("\n"); 
		query.append("	, RPR_RQST_SEQ" ).append("\n"); 
		query.append("	, PAY_INV_SEQ" ).append("\n"); 
		query.append("	, RCV_INV_SEQ" ).append("\n"); 
		query.append("	, MNR_IF_DT" ).append("\n"); 
		query.append("	, CRE_USR_ID" ).append("\n"); 
		query.append("	, CRE_DT" ).append("\n"); 
		query.append("	, UPD_USR_ID" ).append("\n"); 
		query.append("	, UPD_DT" ).append("\n"); 
		query.append(")VALUES(" ).append("\n"); 
		query.append("	@[if_trc_seq]" ).append("\n"); 
		query.append("	, @[mnr_grp_tp_cd]" ).append("\n"); 
		query.append("	, @[mnr_ref_no]" ).append("\n"); 
		query.append("	, @[mnr_if_msg_ctnt]" ).append("\n"); 
		query.append("	, 0" ).append("\n"); 
		query.append("	, 0" ).append("\n"); 
		query.append("	, 0" ).append("\n"); 
		query.append("	, TO_DATE(@[mnr_if_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("	, @[cre_usr_id]" ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append("	, @[cre_usr_id]" ).append("\n"); 
		query.append("	, SYSDATE" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}