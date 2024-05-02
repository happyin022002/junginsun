/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ExternalInterface301FullDGApprovalDBDAOCheckEffectivenessForEurope301FRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.13
*@LastModifier : 
*@LastVersion : 1.0
* 2015.10.13 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.scgcommon.externalinterface301fulldgapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ExternalInterface301FullDGApprovalDBDAOCheckEffectivenessForEurope301FRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Checking Effectiveness for Target of 301F EDI
	  * </pre>
	  */
	public ExternalInterface301FullDGApprovalDBDAOCheckEffectivenessForEurope301FRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("spcl_cgo_apro_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("vsl_pre_pst_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.scgcommon.externalinterface301fulldgapproval.integration").append("\n"); 
		query.append("FileName : ExternalInterface301FullDGApprovalDBDAOCheckEffectivenessForEurope301FRSQL").append("\n"); 
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
		query.append("SELECT     '*'" ).append("\n"); 
		query.append("FROM       SCG_APRO_RQST            X" ).append("\n"); 
		query.append("       ,   SCG_VVD_APRO_RQST        Y" ).append("\n"); 
		query.append("       ,   BKG_BOOKING              B" ).append("\n"); 
		query.append("       ,   MDM_LOCATION             ML" ).append("\n"); 
		query.append("WHERE      1 = 1" ).append("\n"); 
		query.append("AND        X.BKG_NO                 = Y.BKG_NO" ).append("\n"); 
		query.append("AND        X.SPCL_CGO_APRO_RQST_SEQ = Y.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("AND        X.SPCL_CGO_CATE_CD       = 'DG'" ).append("\n"); 
		query.append("AND        X.LST_RQST_DAT_FLG       = 'Y'" ).append("\n"); 
		query.append("AND        X.BKG_NO                 = B.BKG_NO" ).append("\n"); 
		query.append("AND        Y.POL_CD                 = B.POL_CD    	/* MATCH POL of DG AND POL of BKG 	*/" ).append("\n"); 
		query.append("AND        Y.POL_CD                 = ML.LOC_CD" ).append("\n"); 
		query.append("AND        ML.CONTI_CD              = 'E'         	/* EUROPE ONLY 						*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND        B.RCV_TERM_CD            <> 'D'			/* EXCEPT DOOR FOR RECEIVING TERM	*/" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND        Y.BKG_NO                 = @[bkg_no]" ).append("\n"); 
		query.append("AND        Y.SPCL_CGO_APRO_RQST_SEQ = @[spcl_cgo_apro_rqst_seq]" ).append("\n"); 
		query.append("AND        Y.VSL_PRE_PST_CD         = @[vsl_pre_pst_cd]" ).append("\n"); 
		query.append("AND        Y.VSL_SEQ                = @[vsl_seq]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND        'OK'                      = CASE WHEN (SELECT COUNT(1) " ).append("\n"); 
		query.append("                                                 FROM   SCG_DG_CGO                DG " ).append("\n"); 
		query.append("                                                 WHERE  DG.BKG_NO                 = Y.BKG_NO" ).append("\n"); 
		query.append("                                                 AND    DG.SPCL_CGO_APRO_RQST_SEQ = Y.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("                                                 ) " ).append("\n"); 
		query.append("                                                 =" ).append("\n"); 
		query.append("                                                (SELECT COUNT(1)" ).append("\n"); 
		query.append("                                                 FROM   SCG_AUTHORIZATION         AU" ).append("\n"); 
		query.append("                                                 WHERE  AU.BKG_NO                 = Y.BKG_NO" ).append("\n"); 
		query.append("                                                 AND    AU.SPCL_CGO_APRO_RQST_SEQ = Y.SPCL_CGO_APRO_RQST_SEQ" ).append("\n"); 
		query.append("                                                 AND    AU.VSL_PRE_PST_CD         = Y.VSL_PRE_PST_CD" ).append("\n"); 
		query.append("                                                 AND    AU.VSL_SEQ                = Y.VSL_SEQ" ).append("\n"); 
		query.append("                                                 AND    AU.SPCL_CGO_AUTH_CD       = 'Y'" ).append("\n"); 
		query.append("                                                 ) THEN 'OK'" ).append("\n"); 
		query.append("                                            ELSE ''" ).append("\n"); 
		query.append("                                      END" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("-- ::2015-10-13:Adding Check Logic for existing container number:: --" ).append("\n"); 
		query.append("AND        EXISTS                     (SELECT    ''" ).append("\n"); 
		query.append("                                       FROM      BKG_DG_CGO      				BD" ).append("\n"); 
		query.append("                                       WHERE     BD.BKG_NO       				= X.BKG_NO" ).append("\n"); 
		query.append("                                       AND       BD.CNTR_NO      				IS NOT NULL" ).append("\n"); 
		query.append("                                       )   " ).append("\n"); 

	}
}