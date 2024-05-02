/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CargoReleaseOrderDBDAOAddCgoRlseByFocEventCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.09
*@LastModifier : 임진영
*@LastVersion : 1.0
* 2009.07.09 임진영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lim JinYoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CargoReleaseOrderDBDAOAddCgoRlseByFocEventCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * F.O.C Event 발생 시  U.S. Inbound CARGO RELEASE 정보 저장 Table (CT, CR 정보저장)
	  * </pre>
	  */
	public CargoReleaseOrderDBDAOAddCgoRlseByFocEventCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_yd_edi_lst_scs_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_tml_edi_lst_msg_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_clt_lst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_rdem_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_tml_edi_rcv_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cstms_clr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_yd_edi_snd_flg",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("inlnd_yd_edi_lst_msg_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("cstms_clr_lst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_dspo_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_tml_edi_lst_scs_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no_tp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_tml_edi_snd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_yd_edi_snd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_tml_edi_snd_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_yd_edi_lst_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("hbl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inlnd_yd_edi_rcv_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_tml_edi_lst_snd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_rdem_lst_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no_chk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("frt_clt_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.integration ").append("\n"); 
		query.append("FileName : CargoReleaseOrderDBDAOAddCgoRlseByFocEventCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_CGO_RLSE (" ).append("\n"); 
		query.append("MRN_TML_EDI_LST_SCS_FLG" ).append("\n"); 
		query.append(",	INLND_YD_EDI_SND_FLG" ).append("\n"); 
		query.append(",	INLND_YD_EDI_SND_CD" ).append("\n"); 
		query.append(",	INLND_YD_EDI_LST_SND_DT" ).append("\n"); 
		query.append(",	INLND_YD_EDI_RCV_ID" ).append("\n"); 
		query.append(",	INLND_YD_EDI_LST_MSG_ID" ).append("\n"); 
		query.append(",	INLND_YD_EDI_LST_SCS_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(",	BL_NO" ).append("\n"); 
		query.append(",	BL_NO_TP" ).append("\n"); 
		query.append(",	BL_NO_CHK" ).append("\n"); 
		query.append(",	HBL_FLG" ).append("\n"); 
		query.append(",	FRT_CLT_FLG" ).append("\n"); 
		query.append(",	FRT_CLT_LST_DT" ).append("\n"); 
		query.append(",	OBL_RDEM_FLG" ).append("\n"); 
		query.append(",	OBL_RDEM_LST_DT" ).append("\n"); 
		query.append(",	CSTMS_CLR_CD" ).append("\n"); 
		query.append(",	CSTMS_CLR_LST_DT" ).append("\n"); 
		query.append(",	CSTMS_DSPO_CD" ).append("\n"); 
		query.append(",	MRN_TML_EDI_SND_FLG" ).append("\n"); 
		query.append(",	MRN_TML_EDI_SND_CD" ).append("\n"); 
		query.append(",	MRN_TML_EDI_LST_SND_DT" ).append("\n"); 
		query.append(",	MRN_TML_EDI_RCV_ID" ).append("\n"); 
		query.append(",	MRN_TML_EDI_LST_MSG_ID" ).append("\n"); 
		query.append(") VALUES(" ).append("\n"); 
		query.append("@[mrn_tml_edi_lst_scs_flg]" ).append("\n"); 
		query.append(",	@[inlnd_yd_edi_snd_flg]" ).append("\n"); 
		query.append(",	@[inlnd_yd_edi_snd_cd]" ).append("\n"); 
		query.append(",	TO_DATE(@[inlnd_yd_edi_lst_snd_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	@[inlnd_yd_edi_rcv_id]" ).append("\n"); 
		query.append(",	@[inlnd_yd_edi_lst_msg_id]" ).append("\n"); 
		query.append(",	@[inlnd_yd_edi_lst_scs_flg]" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	TO_DATE(@[cre_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	@[upd_usr_id]" ).append("\n"); 
		query.append(",	TO_DATE(@[upd_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	@[bl_no]" ).append("\n"); 
		query.append(",	@[bl_no_tp]" ).append("\n"); 
		query.append(",	@[bl_no_chk]" ).append("\n"); 
		query.append(",	@[hbl_flg]" ).append("\n"); 
		query.append(",	@[frt_clt_flg]" ).append("\n"); 
		query.append(",	TO_DATE(@[frt_clt_lst_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	@[obl_rdem_flg]" ).append("\n"); 
		query.append(",	TO_DATE(@[obl_rdem_lst_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	@[cstms_clr_cd]" ).append("\n"); 
		query.append(",	TO_DATE(@[cstms_clr_lst_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	@[cstms_dspo_cd]" ).append("\n"); 
		query.append(",	@[mrn_tml_edi_snd_flg]" ).append("\n"); 
		query.append(",	@[mrn_tml_edi_snd_cd]" ).append("\n"); 
		query.append(",	TO_DATE(@[mrn_tml_edi_lst_snd_dt],'YYYY-MM-DD')" ).append("\n"); 
		query.append(",	@[mrn_tml_edi_rcv_id]" ).append("\n"); 
		query.append(",	@[mrn_tml_edi_lst_msg_id]" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}