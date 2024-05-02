/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationBLDBDAOModifyXterVgmUploadRsltUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.22
*@LastModifier : 문동선
*@LastVersion : 1.0
* 2016.06.22 문동선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dongsun Moon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOModifyXterVgmUploadRsltUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * XTER VGM Upload 결과를 BKG_XTER_VRFD_WGT_RQST 에 저장한다.
	  * </pre>
	  */
	public BLDocumentationBLDBDAOModifyXterVgmUploadRsltUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vgm_upld_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_vgm_rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_sndr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rjct_rsn_rmk",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("xter_vgm_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOModifyXterVgmUploadRsltUSQL").append("\n"); 
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
		query.append("UPDATE BKG_XTER_VRFD_WGT_RQST  " ).append("\n"); 
		query.append("   SET VGM_UPLD_STS_CD  = @[vgm_upld_sts_cd]" ).append("\n"); 
		query.append("     , UPLD_USR_ID      = DECODE(@[vgm_upld_sts_cd],'F',@[usr_id],UPLD_USR_ID)" ).append("\n"); 
		query.append("     , UPLD_DT          = DECODE(@[vgm_upld_sts_cd],'F',SYSDATE,UPLD_DT)" ).append("\n"); 
		query.append("     , UPLD_GDT         = DECODE(@[vgm_upld_sts_cd],'F',GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', sysdate, 'GMT'),UPLD_GDT)" ).append("\n"); 
		query.append("     , RJCT_RSN_RMK     = @[rjct_rsn_rmk]" ).append("\n"); 
		query.append("     , UPD_USR_ID       = @[usr_id]" ).append("\n"); 
		query.append("     , UPD_DT           = SYSDATE" ).append("\n"); 
		query.append(" WHERE XTER_SNDR_ID     = @[xter_sndr_id]  " ).append("\n"); 
		query.append("   AND XTER_VGM_RQST_NO = @[xter_vgm_rqst_no]" ).append("\n"); 
		query.append("   AND XTER_VGM_SEQ     = @[xter_vgm_seq]" ).append("\n"); 
		query.append("   AND CNTR_NO          = @[cntr_no]" ).append("\n"); 

	}
}