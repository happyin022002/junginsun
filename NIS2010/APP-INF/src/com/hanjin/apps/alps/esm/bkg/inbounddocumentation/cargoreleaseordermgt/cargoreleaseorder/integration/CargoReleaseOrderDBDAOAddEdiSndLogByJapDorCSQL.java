/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOAddEdiSndLogByJapDorCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.01.11
*@LastModifier : 
*@LastVersion : 1.0
* 2011.01.11 
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

public class CargoReleaseOrderDBDAOAddEdiSndLogByJapDorCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Japan Senacs EDI 승인 전송 로그 저장
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOAddEdiSndLogByJapDorCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_tp_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_evnt_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msg_tp_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_evnt_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_snd_msg_ctnt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("flt_file_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("do_edi_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("grp_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOAddEdiSndLogByJapDorCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_IB_EDI_SND_LOG ( BKG_NO" ).append("\n"); 
		query.append(",EDI_SND_SEQ" ).append("\n"); 
		query.append(",FLT_FILE_REF_NO" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",DO_EDI_TP_CD" ).append("\n"); 
		query.append(",MSG_TP_NM" ).append("\n"); 
		query.append(",MSG_TP_ID" ).append("\n"); 
		query.append(",EDI_EVNT_USR_ID" ).append("\n"); 
		query.append(",EDI_EVNT_OFC_CD" ).append("\n"); 
		query.append(",EDI_EVNT_DT" ).append("\n"); 
		query.append(",EDI_EVNT_GDT" ).append("\n"); 
		query.append(",EDI_SND_MSG_CTNT" ).append("\n"); 
		query.append(",CRE_USR_ID" ).append("\n"); 
		query.append(",CRE_DT" ).append("\n"); 
		query.append(",UPD_USR_ID" ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT BDO.BKG_NO                 AS BKG_NO" ).append("\n"); 
		query.append(",(SELECT NVL(MAX(EDI_SND_SEQ)+ 1, 1) FROM BKG_IB_EDI_SND_LOG WHERE BKG_NO = BDO.BKG_NO) AS EDI_SND_SEQ" ).append("\n"); 
		query.append(",@[flt_file_ref_no]" ).append("\n"); 
		query.append(",'XXXXXXXXXXXX'" ).append("\n"); 
		query.append(",@[do_edi_tp_cd]" ).append("\n"); 
		query.append(",@[msg_tp_nm]" ).append("\n"); 
		query.append(",@[msg_tp_id]" ).append("\n"); 
		query.append(",@[edi_evnt_usr_id]" ).append("\n"); 
		query.append(",@[edi_evnt_ofc_cd]" ).append("\n"); 
		query.append(",GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[edi_evnt_ofc_cd])" ).append("\n"); 
		query.append(",GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',sysdate,'GMT')" ).append("\n"); 
		query.append(",@[edi_snd_msg_ctnt]" ).append("\n"); 
		query.append(",@[cre_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append(",@[upd_usr_id]" ).append("\n"); 
		query.append(",SYSDATE" ).append("\n"); 
		query.append("FROM  BKG_JP_DO_IF DOR" ).append("\n"); 
		query.append(", BKG_DO BDO" ).append("\n"); 
		query.append("WHERE DOR.JP_DO_GRP_NO     = @[grp_no]   -- 전송 대상 그룹 대상" ).append("\n"); 
		query.append("AND   DOR.JP_DO_SND_STS_CD = 'T'" ).append("\n"); 
		query.append("AND   BDO.BKG_NO       = DOR.BKG_NO" ).append("\n"); 
		query.append("AND   BDO.RLSE_SEQ     = DOR.RLSE_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}