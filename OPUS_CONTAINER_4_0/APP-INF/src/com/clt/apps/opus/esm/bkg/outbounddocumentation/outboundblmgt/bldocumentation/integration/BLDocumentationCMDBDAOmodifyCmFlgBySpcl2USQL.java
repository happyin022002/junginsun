/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOmodifyCmFlgBySpcl2USQL.java
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

public class BLDocumentationCMDBDAOmodifyCmFlgBySpcl2USQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Modify Container Manifest Flag by Special Cargo
	  * </pre>
	  */
	public BLDocumentationCMDBDAOmodifyCmFlgBySpcl2USQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationCMDBDAOmodifyCmFlgBySpcl2USQL").append("\n"); 
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
		query.append("	UPDATE BKG_CNTR_MF_DESC_HIS MF SET " ).append("\n"); 
		query.append("	#if (${spcl_tp} == 'RF')" ).append("\n"); 
		query.append("		(RC_FLG, RD_CGO_FLG) = (SELECT NVL(CT.RC_FLG, MF.RC_FLG), NVL(CT.RD_CGO_FLG, MF.RD_CGO_FLG)" ).append("\n"); 
		query.append("								FROM BKG_CNTR_HIS CT" ).append("\n"); 
		query.append("								WHERE CT.BKG_NO = MF.BKG_NO " ).append("\n"); 
		query.append("								AND CT.CNTR_NO = MF.CNTR_NO" ).append("\n"); 
		query.append("								AND CT.CORR_NO = 'TMP0000001')" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("	UPDATE BKG_CNTR_MF_DESC MF SET " ).append("\n"); 
		query.append("	#if (${spcl_tp} == 'RF')" ).append("\n"); 
		query.append("		(RC_FLG, RD_CGO_FLG) = (SELECT NVL(CT.RC_FLG, MF.RC_FLG), NVL(CT.RD_CGO_FLG, MF.RD_CGO_FLG)" ).append("\n"); 
		query.append("								FROM BKG_CONTAINER CT" ).append("\n"); 
		query.append("								WHERE CT.BKG_NO = MF.BKG_NO " ).append("\n"); 
		query.append("								AND CT.CNTR_NO = MF.CNTR_NO)" ).append("\n"); 
		query.append("	#end" ).append("\n"); 
		query.append("	WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}