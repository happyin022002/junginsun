/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOaddUsCgoRlsLogSceRsltCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.11
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOaddUsCgoRlsLogSceRsltCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ....
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOaddUsCgoRlsLogSceRsltCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_rcv_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("his_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sce_scs_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sce_msg_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOaddUsCgoRlsLogSceRsltCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CGO_RLSE_EDI_SND_LOG" ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("            BL_NO," ).append("\n"); 
		query.append("            HIS_SEQ," ).append("\n"); 
		query.append("            HIS_DTL_SEQ," ).append("\n"); 
		query.append("            CGOR_EDI_RCVR_TP_CD," ).append("\n"); 
		query.append("            EDI_RCV_ID         ," ).append("\n"); 
		query.append("            CGOR_EDI_SND_CD    ," ).append("\n"); 
		query.append("            CGOR_EDI_MSG_ID    ," ).append("\n"); 
		query.append("            CGOR_EDI_SCS_FLG   ," ).append("\n"); 
		query.append("            CGOR_EDI_SND_ID    ," ).append("\n"); 
		query.append("            CRE_USR_ID         ," ).append("\n"); 
		query.append("            CRE_DT             ," ).append("\n"); 
		query.append("            UPD_USR_ID         ," ).append("\n"); 
		query.append("            UPD_DT             " ).append("\n"); 
		query.append("            )      " ).append("\n"); 
		query.append("    (SELECT @[bl_no]," ).append("\n"); 
		query.append("            @[his_seq]," ).append("\n"); 
		query.append("            NVL(MAX(HIS_DTL_SEQ) + 1,1)," ).append("\n"); 
		query.append("            'C'," ).append("\n"); 
		query.append("            @[edi_rcv_id],  " ).append("\n"); 
		query.append("            Null," ).append("\n"); 
		query.append("            @[sce_msg_id],  " ).append("\n"); 
		query.append("            @[sce_scs_cd]," ).append("\n"); 
		query.append("            @[edi_snd_id]," ).append("\n"); 
		query.append("            @[usr_id]," ).append("\n"); 
		query.append("            SYSDATE," ).append("\n"); 
		query.append("            @[usr_id]," ).append("\n"); 
		query.append("            SYSDATE" ).append("\n"); 
		query.append("       FROM BKG_CGO_RLSE_EDI_SND_LOG" ).append("\n"); 
		query.append("      WHERE BL_NO   = @[bl_no]  " ).append("\n"); 
		query.append("        AND HIS_SEQ = @[his_seq]) " ).append("\n"); 

	}
}