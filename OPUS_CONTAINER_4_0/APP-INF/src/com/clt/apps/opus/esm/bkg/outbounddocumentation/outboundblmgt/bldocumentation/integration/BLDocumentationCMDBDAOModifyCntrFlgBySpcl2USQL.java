/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOModifyCntrFlgBySpcl2USQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.08.10
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2016.08.10 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationCMDBDAOModifyCntrFlgBySpcl2USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCntrFlgBySpcl2
	  * </pre>
	  */
	public BLDocumentationCMDBDAOModifyCntrFlgBySpcl2USQL(){
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
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOModifyCntrFlgBySpcl2USQL").append("\n"); 
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
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	UPDATE BKG_CNTR_HIS SET " ).append("\n"); 
		query.append("	#if (${spcl_tp} == 'DG')" ).append("\n"); 
		query.append("		DCGO_FLG = 'N'" ).append("\n"); 
		query.append("	#elseif (${spcl_tp} == 'RF')" ).append("\n"); 
		query.append("		RC_FLG = 'N'" ).append("\n"); 
		query.append("		, RD_CGO_FLG = DECODE(SUBSTR(CNTR_TPSZ_CD,1,1),'R','Y','N')" ).append("\n"); 
		query.append("	#elseif (${spcl_tp} == 'BB')" ).append("\n"); 
		query.append("		BB_CGO_FLG = 'N'" ).append("\n"); 
		query.append("	#elseif (${spcl_tp} == 'AWK')" ).append("\n"); 
		query.append("		AWK_CGO_FLG = 'N'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${spcl_tp} == 'BB')" ).append("\n"); 
		query.append("		AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	UPDATE BKG_CONTAINER SET " ).append("\n"); 
		query.append("	#if (${spcl_tp} == 'DG')" ).append("\n"); 
		query.append("		DCGO_FLG = 'N'" ).append("\n"); 
		query.append("	#elseif (${spcl_tp} == 'RF')" ).append("\n"); 
		query.append("		RC_FLG = 'N'" ).append("\n"); 
		query.append("		, RD_CGO_FLG = DECODE(SUBSTR(CNTR_TPSZ_CD,1,1),'R','Y','N')" ).append("\n"); 
		query.append("	#elseif (${spcl_tp} == 'BB')" ).append("\n"); 
		query.append("		BB_CGO_FLG = 'N'" ).append("\n"); 
		query.append("	#elseif (${spcl_tp} == 'AWK')" ).append("\n"); 
		query.append("		AWK_CGO_FLG = 'N'" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("	#if (${spcl_tp} == 'BB')" ).append("\n"); 
		query.append("		AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}