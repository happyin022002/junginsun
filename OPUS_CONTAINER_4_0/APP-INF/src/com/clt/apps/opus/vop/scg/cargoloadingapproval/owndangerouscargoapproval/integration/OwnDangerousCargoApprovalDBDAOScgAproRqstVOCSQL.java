/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOScgAproRqstVOCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.12
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.12 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOScgAproRqstVOCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BOOKING로부터 SCG_APRO_RQST를 생성한다.
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOScgAproRqstVOCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bb_cgo_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("awk_cgo_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.FLOAT + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rc_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_bkg_rqst_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_de_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eml_snd_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_rcv_term_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOScgAproRqstVOCSQL").append("\n"); 
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
		query.append("INSERT INTO SCG_APRO_RQST (" ).append("\n"); 
		query.append("	SPCL_BKG_RQST_FLG" ).append("\n"); 
		query.append(",	EML_SND_NO" ).append("\n"); 
		query.append(",	SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append(",	SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append(",	POR_CD" ).append("\n"); 
		query.append(",	DEL_CD" ).append("\n"); 
		query.append(",	BKG_NO" ).append("\n"); 
		query.append(",	SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append(",	AWK_CGO_QTY" ).append("\n"); 
		query.append(",	BB_CGO_QTY" ).append("\n"); 
		query.append(",	DCGO_QTY" ).append("\n"); 
		query.append(",	RC_QTY" ).append("\n"); 
		query.append(",	LST_RQST_DAT_FLG" ).append("\n"); 
		query.append(",	BKG_RCV_TERM_CD" ).append("\n"); 
		query.append(",	BKG_DE_TERM_CD" ).append("\n"); 
		query.append(",	RQST_USR_ID" ).append("\n"); 
		query.append(",	RQST_OFC_CD" ).append("\n"); 
		query.append(",	RQST_DT" ).append("\n"); 
		query.append(",	RQST_GDT" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES( " ).append("\n"); 
		query.append("	@[spcl_bkg_rqst_flg]" ).append("\n"); 
		query.append(",	@[eml_snd_no]" ).append("\n"); 
		query.append(",	@[spcl_cgo_cate_cd]" ).append("\n"); 
		query.append(",(	SELECT NVL(MAX(SPCL_CGO_RQST_SEQ)+1,1) FROM SCG_APRO_RQST WHERE BKG_NO = @[bkg_no]	AND SPCL_CGO_CATE_CD = @[spcl_cgo_cate_cd] )" ).append("\n"); 
		query.append(",	@[por_cd]" ).append("\n"); 
		query.append(",	@[del_cd]" ).append("\n"); 
		query.append(",	@[bkg_no]" ).append("\n"); 
		query.append(",(	SELECT NVL(MAX(SPCL_CGO_APRO_RQST_SEQ)+1,1) FROM SCG_APRO_RQST WHERE BKG_NO = @[bkg_no]	)" ).append("\n"); 
		query.append(",	@[awk_cgo_qty]" ).append("\n"); 
		query.append(",	@[bb_cgo_qty]" ).append("\n"); 
		query.append(",	@[dcgo_qty]" ).append("\n"); 
		query.append(",	@[rc_qty]" ).append("\n"); 
		query.append(",	'Y'" ).append("\n"); 
		query.append(",	@[bkg_rcv_term_cd]" ).append("\n"); 
		query.append(",	@[bkg_de_term_cd]" ).append("\n"); 
		query.append(",	@[rqst_usr_id]" ).append("\n"); 
		query.append(",	@[rqst_ofc_cd]" ).append("\n"); 
		query.append(",	NVL(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(),SYSDATE,BKG_COM_USER_LOC_FNC(@[cre_usr_id])), SYSDATE)" ).append("\n"); 
		query.append(",	NVL(GLOBALDATE_PKG.TIME_CONV_FNC(COM_ConstantMgr_PKG.COM_getBaseLocationCode_FNC(),SYSDATE,'GMT'), SYSDATE)" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(",	@[cre_usr_id]" ).append("\n"); 
		query.append(",	sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}