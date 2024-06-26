/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BLDocumentationBLDBDAOBkgBlMndCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.04
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOBkgBlMndCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * insert
	  * </pre>
	  */
	public BLDocumentationBLDBDAOBkgBlMndCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_desc",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("mk_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOBkgBlMndCSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y') " ).append("\n"); 
		query.append("INSERT INTO BKG_BL_MK_DESC_HIS(BKG_NO" ).append("\n"); 
		query.append(",   CORR_NO" ).append("\n"); 
		query.append(",	MK_SEQ" ).append("\n"); 
		query.append(",	MK_DESC" ).append("\n"); 
		query.append(",	CMDT_DESC" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES(@[bkg_no]" ).append("\n"); 
		query.append(",        'TMP0000001'" ).append("\n"); 
		query.append(",        1" ).append("\n"); 
		query.append(",        @[mk_desc]" ).append("\n"); 
		query.append(",        @[cmdt_desc]" ).append("\n"); 
		query.append(",        @[cre_usr_id]" ).append("\n"); 
		query.append(",        sysdate" ).append("\n"); 
		query.append(",        @[cre_usr_id]" ).append("\n"); 
		query.append(",        sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("INSERT INTO BKG_BL_MK_DESC(BKG_NO" ).append("\n"); 
		query.append(",	MK_SEQ" ).append("\n"); 
		query.append(",	MK_DESC" ).append("\n"); 
		query.append(",	CMDT_DESC" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append(") VALUES(@[bkg_no]" ).append("\n"); 
		query.append(",        1" ).append("\n"); 
		query.append(",        @[mk_desc]" ).append("\n"); 
		query.append(",        @[cmdt_desc]" ).append("\n"); 
		query.append(",        @[cre_usr_id]" ).append("\n"); 
		query.append(",        sysdate" ).append("\n"); 
		query.append(",        @[cre_usr_id]" ).append("\n"); 
		query.append(",        sysdate" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}