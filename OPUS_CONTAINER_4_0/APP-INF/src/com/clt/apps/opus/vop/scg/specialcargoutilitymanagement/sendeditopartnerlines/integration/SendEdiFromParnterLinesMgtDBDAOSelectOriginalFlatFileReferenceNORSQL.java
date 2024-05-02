/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SendEdiFromParnterLinesMgtDBDAOSelectOriginalFlatFileReferenceNORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.09.14
*@LastModifier : 
*@LastVersion : 1.0
* 2015.09.14 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.sendeditopartnerlines.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SendEdiFromParnterLinesMgtDBDAOSelectOriginalFlatFileReferenceNORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 최초 BKG에 발송된 DG EDI's Reference No 추출하기
	  * </pre>
	  */
	public SendEdiFromParnterLinesMgtDBDAOSelectOriginalFlatFileReferenceNORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.sendeditopartnerlines.integration").append("\n"); 
		query.append("FileName : SendEdiFromParnterLinesMgtDBDAOSelectOriginalFlatFileReferenceNORSQL").append("\n"); 
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
		query.append("SELECT   	H.FLT_FILE_REF_NO" ).append("\n"); 
		query.append("		--, 	H.*" ).append("\n"); 
		query.append("FROM     	SCG_PRNR_SPCL_CGO_TRSM_HDR   H" ).append("\n"); 
		query.append("WHERE    	H.TRSM_BND_CD                = 'O'" ).append("\n"); 
		query.append("AND      	H.SPCL_CGO_CATE_CD           = 'DG'" ).append("\n"); 
		query.append("AND      	H.TRSM_MZD_CD                = 'EDI'" ).append("\n"); 
		query.append("AND      	H.EDI_MSG_STS_CD             = 'N'   						/* N:NEW, U:UPDATE, R:REJECT */" ).append("\n"); 
		query.append("--AND      	H.EDI_RCVR_ID                = [edi_rcvr_id]" ).append("\n"); 
		query.append("AND      	H.BKG_REF_NO                 = @[bkg_no]" ).append("\n"); 
		query.append("AND      	H.VSL_CD                     = @[vsl_cd]" ).append("\n"); 
		query.append("AND      	H.SKD_VOY_NO                 = @[skd_voy_no]" ).append("\n"); 
		query.append("AND      	H.SKD_DIR_CD                 = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND      	H.POL_CD                     = @[pol_cd]" ).append("\n"); 
		query.append("AND      	H.POD_CD                     = @[pod_cd]" ).append("\n"); 
		query.append("AND      	H.PRNR_SPCL_CGO_SEQ          = (SELECT	MAX(HH.PRNR_SPCL_CGO_SEQ)" ).append("\n"); 
		query.append("                                         	FROM    SCG_PRNR_SPCL_CGO_TRSM_HDR 	HH" ).append("\n"); 
		query.append("                                         	WHERE   HH.TRSM_BND_CD             	= H.TRSM_BND_CD" ).append("\n"); 
		query.append("                                         	AND     HH.SPCL_CGO_CATE_CD        	= H.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("                                         	AND     HH.TRSM_MZD_CD             	= H.TRSM_MZD_CD" ).append("\n"); 
		query.append("                                         	AND     HH.BKG_REF_NO              	= H.BKG_REF_NO" ).append("\n"); 
		query.append("                                         	AND     HH.VSL_CD                  	= H.VSL_CD" ).append("\n"); 
		query.append("                                         	AND     HH.SKD_VOY_NO              	= H.SKD_VOY_NO" ).append("\n"); 
		query.append("                                         	AND     HH.SKD_DIR_CD              	= H.SKD_DIR_CD" ).append("\n"); 
		query.append("                                         	AND     HH.POL_CD                  	= H.POL_CD" ).append("\n"); 
		query.append("                                         	AND     HH.POD_CD                  	= H.POD_CD" ).append("\n"); 
		query.append("                                         	AND     HH.CGO_OPR_CD              	= H.CGO_OPR_CD" ).append("\n"); 
		query.append("											AND		HH.EDI_MSG_STS_CD			= H.EDI_MSG_STS_CD	" ).append("\n"); 
		query.append("                                         	)" ).append("\n"); 

	}
}