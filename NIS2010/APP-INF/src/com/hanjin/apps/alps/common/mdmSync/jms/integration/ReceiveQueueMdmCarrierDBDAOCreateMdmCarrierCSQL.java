/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ReceiveQueueMdmCarrierDBDAOCreateMdmCarrierCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.08
*@LastModifier : 김민아
*@LastVersion : 1.0
* 2010.07.08 김민아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.common.mdmSync.jms.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Min Ah
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveQueueMdmCarrierDBDAOCreateMdmCarrierCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateMdmCarrier
	  * </pre>
	  */
	public ReceiveQueueMdmCarrierDBDAOCreateMdmCarrierCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_edi_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eai_if_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("delt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mapg_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.common.mdmSync.jms.integration").append("\n"); 
		query.append("FileName : ReceiveQueueMdmCarrierDBDAOCreateMdmCarrierCSQL").append("\n"); 
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
		query.append("INSERT INTO MDM_CARRIER(" ).append("\n"); 
		query.append("    CRR_CD," ).append("\n"); 
		query.append("    CRR_NM," ).append("\n"); 
		query.append("    BKG_EDI_CD," ).append("\n"); 
		query.append("    MAPG_CRR_CD," ).append("\n"); 
		query.append("    DELT_FLG," ).append("\n"); 
		query.append("    CRE_USR_ID," ).append("\n"); 
		query.append("    CRE_DT," ).append("\n"); 
		query.append("	UPD_USR_ID," ).append("\n"); 
		query.append("	UPD_DT," ).append("\n"); 
		query.append("    EAI_EVNT_DT," ).append("\n"); 
		query.append("    EAI_IF_ID)" ).append("\n"); 
		query.append("VALUES(" ).append("\n"); 
		query.append("    @[crr_cd]," ).append("\n"); 
		query.append("    @[crr_nm]," ).append("\n"); 
		query.append("    @[bkg_edi_cd]," ).append("\n"); 
		query.append("    @[mapg_crr_cd]," ).append("\n"); 
		query.append("    NVL(@[delt_flg],'N')," ).append("\n"); 
		query.append("    @[cre_usr_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("	@[upd_usr_id]," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    SYSDATE," ).append("\n"); 
		query.append("    @[eai_if_id])" ).append("\n"); 

	}
}