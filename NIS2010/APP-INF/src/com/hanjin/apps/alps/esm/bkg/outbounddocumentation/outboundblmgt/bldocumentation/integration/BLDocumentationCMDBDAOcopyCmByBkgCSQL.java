/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOcopyCmByBkgCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.19
*@LastModifier : 
*@LastVersion : 1.0
* 2016.01.19 
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

public class BLDocumentationCMDBDAOcopyCmByBkgCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert
	  * </pre>
	  */
	public BLDocumentationCMDBDAOcopyCmByBkgCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_bkg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_bkg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOcopyCmByBkgCSQL").append("\n"); 
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
		query.append("insert into bkg_cntr_mf_desc(BKG_NO " ).append("\n"); 
		query.append(",CNTR_MF_SEQ " ).append("\n"); 
		query.append(",CNTR_NO " ).append("\n"); 
		query.append(",CMDT_HS_CD" ).append("\n"); 
		query.append(",PCK_QTY " ).append("\n"); 
		query.append(",PCK_TP_CD " ).append("\n"); 
		query.append(",CNTR_MF_WGT " ).append("\n"); 
		query.append(",WGT_UT_CD " ).append("\n"); 
		query.append(",MEAS_QTY " ).append("\n"); 
		query.append(",MEAS_UT_CD " ).append("\n"); 
		query.append(",DCGO_FLG " ).append("\n"); 
		query.append(",BB_CGO_FLG " ).append("\n"); 
		query.append(",AWK_CGO_FLG " ).append("\n"); 
		query.append(",RC_FLG " ).append("\n"); 
		query.append(",RD_CGO_FLG " ).append("\n"); 
		query.append(",HNGR_FLG " ).append("\n"); 
		query.append(",CNTR_MF_MK_DESC " ).append("\n"); 
		query.append(",CNTR_MF_GDS_DESC " ).append("\n"); 
		query.append(",HBL_SEQ " ).append("\n"); 
		query.append(",HAMO_TRF_CD " ).append("\n"); 
		query.append(",NCM_NO " ).append("\n"); 
		query.append(",PO_NO " ).append("\n"); 
		query.append(",CNTR_MF_NO " ).append("\n"); 
		query.append(",CSTMS_DECL_NO " ).append("\n"); 
		query.append(",WPM_TRT_CD" ).append("\n"); 
		query.append(",CRE_USR_ID " ).append("\n"); 
		query.append(",CRE_DT " ).append("\n"); 
		query.append(",UPD_USR_ID " ).append("\n"); 
		query.append(",UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("select @[to_bkg] BKG_NO " ).append("\n"); 
		query.append("		,(select /*+index_desc ( bkg_cntr_mf_desc XPKBKG_CNTR_MF_DESC)*/ " ).append("\n"); 
		query.append("					nvl(sum(CNTR_MF_SEQ),0)+cm.cntr_mf_seq " ).append("\n"); 
		query.append("					from bkg_cntr_mf_desc" ).append("\n"); 
		query.append("					where CNTR_MF_SEQ  >= 0 " ).append("\n"); 
		query.append("					and rownum <= 1 " ).append("\n"); 
		query.append("    				and cntr_no =@[cntr_no]" ).append("\n"); 
		query.append("					and bkg_no = @[to_bkg]) CNTR_MF_SEQ " ).append("\n"); 
		query.append("		,CNTR_NO " ).append("\n"); 
		query.append("		,CMDT_HS_CD " ).append("\n"); 
		query.append("		,PCK_QTY " ).append("\n"); 
		query.append("		,PCK_TP_CD " ).append("\n"); 
		query.append("		,CNTR_MF_WGT " ).append("\n"); 
		query.append("		,WGT_UT_CD " ).append("\n"); 
		query.append("		,MEAS_QTY " ).append("\n"); 
		query.append("		,MEAS_UT_CD " ).append("\n"); 
		query.append("		,DCGO_FLG " ).append("\n"); 
		query.append("		,BB_CGO_FLG " ).append("\n"); 
		query.append("		,AWK_CGO_FLG " ).append("\n"); 
		query.append("		,RC_FLG " ).append("\n"); 
		query.append("		,RD_CGO_FLG " ).append("\n"); 
		query.append("		,HNGR_FLG " ).append("\n"); 
		query.append("		,CNTR_MF_MK_DESC " ).append("\n"); 
		query.append("		,CNTR_MF_GDS_DESC " ).append("\n"); 
		query.append("		,HBL_SEQ " ).append("\n"); 
		query.append("		,HAMO_TRF_CD " ).append("\n"); 
		query.append("		,NCM_NO " ).append("\n"); 
		query.append("		,PO_NO " ).append("\n"); 
		query.append("#if(${copy_mode_cd} == 'S')" ).append("\n"); 
		query.append("		,'' CNTR_MF_NO " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("		, CNTR_MF_NO " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("		,CSTMS_DECL_NO " ).append("\n"); 
		query.append("        ,WPM_TRT_CD" ).append("\n"); 
		query.append("		,@[usr_id] CRE_USR_ID " ).append("\n"); 
		query.append("		,sysdate CRE_DT " ).append("\n"); 
		query.append("		,@[usr_id] UPD_USR_ID " ).append("\n"); 
		query.append("		,sysdate UPD_DT" ).append("\n"); 
		query.append("	from bkg_cntr_mf_desc cm" ).append("\n"); 
		query.append("	where bkg_no = @[from_bkg]" ).append("\n"); 
		query.append("    and cntr_no =@[cntr_no]" ).append("\n"); 

	}
}