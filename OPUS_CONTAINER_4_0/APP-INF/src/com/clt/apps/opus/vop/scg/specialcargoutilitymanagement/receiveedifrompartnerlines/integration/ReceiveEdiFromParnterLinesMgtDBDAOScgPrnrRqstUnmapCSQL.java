/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ReceiveEdiFromParnterLinesMgtDBDAOScgPrnrRqstUnmapCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.02.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ReceiveEdiFromParnterLinesMgtDBDAOScgPrnrRqstUnmapCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SCG_PRNR_RQST_UNMAP 데이터 INSERT
	  * </pre>
	  */
	public ReceiveEdiFromParnterLinesMgtDBDAOScgPrnrRqstUnmapCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_ref_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prnr_cgo_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration").append("\n"); 
		query.append("FileName : ReceiveEdiFromParnterLinesMgtDBDAOScgPrnrRqstUnmapCSQL").append("\n"); 
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
		query.append("INSERT INTO SCG_PRNR_RQST_UNMAP" ).append("\n"); 
		query.append("            (  	CRR_CD" ).append("\n"); 
		query.append("            ,  	BKG_REF_NO" ).append("\n"); 
		query.append("            ,  	SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("            ,  	PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("            ,  	EDI_UNMAP_SEQ" ).append("\n"); 
		query.append("            ,  	EDI_UNMAP_DTL_CD" ).append("\n"); 
		query.append("			,	EDI_UNMAP_DTL_DESC" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("			,  	EDI_UNMAP_CORR_RSLT_CD" ).append("\n"); 
		query.append("            --,  	EDI_UNMAP_CORR_DT" ).append("\n"); 
		query.append("            " ).append("\n"); 
		query.append("			,  	CRE_USR_ID" ).append("\n"); 
		query.append("            ,	CRE_DT" ).append("\n"); 
		query.append("            ,	UPD_USR_ID" ).append("\n"); 
		query.append("            ,	UPD_DT" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("SELECT      	X.CRR_CD" ).append("\n"); 
		query.append("        	,   X.BKG_REF_NO" ).append("\n"); 
		query.append("        	,   X.SPCL_CGO_RQST_SEQ" ).append("\n"); 
		query.append("        	,   X.PRNR_CGO_RQST_SEQ" ).append("\n"); 
		query.append("        	,   Y.EDI_UNMAP_SEQ" ).append("\n"); 
		query.append("        	,   Y.EDI_UNMAP_DTL_CD" ).append("\n"); 
		query.append("			,	Y.EDI_UNMAP_DTL_DESC" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("			,	'N'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    		,  	'EDI_AUTO_REQUEST'          /*   CRE_USR_ID                 */   " ).append("\n"); 
		query.append("    		,  	SYSDATE                     /*   CRE_DT                     */   " ).append("\n"); 
		query.append("    		,  	'EDI_AUTO_REQUEST'          /*   UPD_USR_ID                 */   " ).append("\n"); 
		query.append("    		,  	SYSDATE                     /*   UPD_DT                     */" ).append("\n"); 
		query.append("FROM        	SCG_PRNR_APRO_RQST      	X" ).append("\n"); 
		query.append("        	,   SCG_PRNR_TRSM_HDR_UNMAP 	Y" ).append("\n"); 
		query.append("WHERE       	1 = 1" ).append("\n"); 
		query.append("AND         	X.MAPG_PRNR_SPCL_CGO_SEQ	= Y.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND         	X.CRR_CD               		= COM_ConstantMgr_PKG.COM_getCompanyCode_FNC()" ).append("\n"); 
		query.append("AND         	X.BKG_REF_NO            	= @[bkg_ref_no]" ).append("\n"); 
		query.append("AND         	X.SPCL_CGO_RQST_SEQ     	= @[spcl_cgo_rqst_seq]" ).append("\n"); 
		query.append("AND         	X.PRNR_CGO_RQST_SEQ     	= @[prnr_cgo_rqst_seq]" ).append("\n"); 

	}
}