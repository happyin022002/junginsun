/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : JapanTerminalTransmissionDBDAOaddDgCgoforNewBkgInfoMaxCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.21
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2012.03.21 김종옥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Jong Ock
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JapanTerminalTransmissionDBDAOaddDgCgoforNewBkgInfoMaxCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * addDgCgoforNewBkgInfoMax
	  * </pre>
	  */
	public JapanTerminalTransmissionDBDAOaddDgCgoforNewBkgInfoMaxCSQL(){
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
		params.put("max_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.japanterminal.integration").append("\n"); 
		query.append("FileName : JapanTerminalTransmissionDBDAOaddDgCgoforNewBkgInfoMaxCSQL").append("\n"); 
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
		query.append("INSERT INTO BKG_TML_EDI_JP_DG_CGO" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(", BKG_SKD_SEQ" ).append("\n"); 
		query.append(", DCGO_SEQ" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", CNTR_VOL_QTY" ).append("\n"); 
		query.append(", CNTR_NO" ).append("\n"); 
		query.append(", MRN_POLUT_FLG" ).append("\n"); 
		query.append(", IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append(", IMDG_CLSS_CD" ).append("\n"); 
		query.append(", IMDG_UN_NO" ).append("\n"); 
		query.append(", IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT BKG_NO" ).append("\n"); 
		query.append(", @[max_seq]" ).append("\n"); 
		query.append(", DCGO_SEQ" ).append("\n"); 
		query.append(", CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", CNTR_VOL_QTY" ).append("\n"); 
		query.append(", CNTR_NO" ).append("\n"); 
		query.append(", MRN_POLUT_FLG" ).append("\n"); 
		query.append(", IMDG_LMT_QTY_FLG" ).append("\n"); 
		query.append(", IMDG_CLSS_CD" ).append("\n"); 
		query.append(", IMDG_UN_NO" ).append("\n"); 
		query.append(", IMDG_PCK_GRP_CD" ).append("\n"); 
		query.append(", CRE_USR_ID" ).append("\n"); 
		query.append(", CRE_DT" ).append("\n"); 
		query.append(", UPD_USR_ID" ).append("\n"); 
		query.append(", UPD_DT" ).append("\n"); 
		query.append("FROM BKG_TML_EDI_JP_DG_CGO" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND BKG_SKD_SEQ = '0'" ).append("\n"); 

	}
}