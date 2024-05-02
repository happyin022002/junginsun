/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationCMDBDAOSearchBkgDgCgoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.10.12
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2016.10.12 Maeda Atsushi
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

public class BLDocumentationCMDBDAOSearchBkgDgCgoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public BLDocumentationCMDBDAOSearchBkgDgCgoRSQL(){
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
		query.append("FileName : BLDocumentationCMDBDAOSearchBkgDgCgoRSQL").append("\n"); 
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
		query.append("SELECT 'Seq'||DG_CNTR_SEQ||'-'||'Un No: '||IMDG_UN_NO||',Dcgo Seq : '||DISPLAY_SEQ" ).append("\n"); 
		query.append("       || ',Class : '||IMDG_CLSS_CD DIFF_RMK" ).append("\n"); 
		query.append("      ,DCGO_SEQ " ).append("\n"); 
		query.append("      ,CNTR_NO" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("	SELECT DG_CNTR_SEQ" ).append("\n"); 
		query.append("		  ,IMDG_UN_NO" ).append("\n"); 
		query.append("		  ,ROW_NUMBER() OVER(PARTITION BY DG_CNTR_SEQ ORDER BY DCGO_SEQ) DISPLAY_SEQ" ).append("\n"); 
		query.append("		  ,IMDG_CLSS_CD" ).append("\n"); 
		query.append("		  ,DCGO_SEQ" ).append("\n"); 
		query.append("		  ,CNTR_NO" ).append("\n"); 
		query.append("		  ,SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("	FROM BKG_DG_CGO" ).append("\n"); 
		query.append("	WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE NVL(SPCL_CGO_APRO_CD, ' ') <> 'C'" ).append("\n"); 
		query.append("ORDER BY CNTR_NO,DCGO_SEQ" ).append("\n"); 

	}
}