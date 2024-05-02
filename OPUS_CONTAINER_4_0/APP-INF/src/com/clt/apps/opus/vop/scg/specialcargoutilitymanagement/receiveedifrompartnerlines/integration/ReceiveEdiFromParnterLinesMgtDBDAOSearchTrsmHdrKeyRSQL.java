/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : ReceiveEdiFromParnterLinesMgtDBDAOSearchTrsmHdrKeyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.11
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.11 
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

public class ReceiveEdiFromParnterLinesMgtDBDAOSearchTrsmHdrKeyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchTrsmHdrKey
	  * </pre>
	  */
	public ReceiveEdiFromParnterLinesMgtDBDAOSearchTrsmHdrKeyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org_msg_key",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.specialcargoutilitymanagement.receiveedifrompartnerlines.integration").append("\n"); 
		query.append("FileName : ReceiveEdiFromParnterLinesMgtDBDAOSearchTrsmHdrKeyRSQL").append("\n"); 
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
		query.append("SELECT 		H.TRSM_BND_CD" ).append("\n"); 
		query.append("     	, 	TO_CHAR(H.TRSM_DT, 'YYYYMMDD') TRSM_DT" ).append("\n"); 
		query.append("     	, 	H.SPCL_CGO_CATE_CD" ).append("\n"); 
		query.append("     	, 	H.PRNR_SPCL_CGO_SEQ" ).append("\n"); 
		query.append("     	, 	H.BKG_REF_NO" ).append("\n"); 
		query.append("FROM 		SCG_PRNR_SPCL_CGO_TRSM_HDR		H" ).append("\n"); 
		query.append("WHERE 		1 = 1" ).append("\n"); 
		query.append("AND   		H.TRSM_MZD_CD              		= 'EDI'										--::EDI, EML::--" ).append("\n"); 
		query.append("AND   		H.EDI_MSG_REF_NO 				= @[org_msg_key]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("--:2016-03-11:--AND		H.PRNR_SPCL_CGO_SEQ	= (	SELECT	MAX(HH.PRNR_SPCL_CGO_SEQ)" ).append("\n"); 
		query.append("--:2016-03-11:--								FROM	SCG_PRNR_SPCL_CGO_TRSM_HDR		HH" ).append("\n"); 
		query.append("--:2016-03-11:--								WHERE	HH.EDI_MSG_REF_NO				= H.EDI_MSG_REF_NO" ).append("\n"); 
		query.append("--:2016-03-11:--								AND		HH.TRSM_MZD_CD					= H.TRSM_MZD_CD" ).append("\n"); 
		query.append("--:2016-03-11:--							  )" ).append("\n"); 

	}
}