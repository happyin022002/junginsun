/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOUpdateVGMForOnlyMVMTUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.14
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.14 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOUpdateVGMForOnlyMVMTUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CTM에서 같은 MVMT로 VGM이 없는 EDI를 보냈다가
	  * 그 후 한 번 VGM 값이 있는 EDI를 재전송할 때를 위한 업데이트문
	  * 이미 BKG에 VGM값이 있으면 업데이트 해주지 않음
	  * </pre>
	  */
	public BLDocumentationCMDBDAOUpdateVGMForOnlyMVMTUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_wgt_ut_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_wgt_qty",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_sig_ctnt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_mzd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOUpdateVGMForOnlyMVMTUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CONTAINER" ).append("\n"); 
		query.append("SET  VGM_WGT           = (CASE WHEN NVL(VGM_WGT,0) = 0 THEN TO_NUMBER(@[vgm_wgt_qty]) ELSE VGM_WGT END) " ).append("\n"); 
		query.append("    ,VGM_WGT_UT_CD     = (CASE WHEN NVL(VGM_WGT,0) = 0 THEN DECODE(@[vgm_wgt_ut_cd], 'KGM', 'KGS','LBR','LBS', @[vgm_wgt_ut_cd]) ELSE VGM_WGT_UT_CD END)" ).append("\n"); 
		query.append("    ,VGM_VRFY_SIG_CTNT = (CASE WHEN NVL(VGM_WGT,0) = 0 THEN @[vgm_sig_ctnt] ELSE VGM_VRFY_SIG_CTNT END)" ).append("\n"); 
		query.append("    ,VGM_MZD_TP_CD     = (CASE WHEN NVL(VGM_WGT,0) = 0 THEN @[vgm_mzd_tp_cd] ELSE VGM_MZD_TP_CD END)" ).append("\n"); 
		query.append("    ,UPD_USR_ID        = (CASE WHEN NVL(VGM_WGT,0) = 0 THEN @[upd_usr_id] ELSE UPD_USR_ID END)" ).append("\n"); 
		query.append("    ,UPD_DT            = (CASE WHEN NVL(VGM_WGT,0) = 0 THEN SYSDATE ELSE UPD_DT END)" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND CNTR_NO = @[cntr_no]" ).append("\n"); 

	}
}