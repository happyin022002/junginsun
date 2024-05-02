/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BLDocumentationBLDBDAOmodifyBKGBDRUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.12
*@LastModifier : 
*@LastVersion : 1.0
* 2014.03.12 
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

public class BLDocumentationBLDBDAOmodifyBKGBDRUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_BL_DOC BKG BDR 처리
	  * </pre>
	  */
	public BLDocumentationBLDBDAOmodifyBKGBDRUSQL(){
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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOmodifyBKGBDRUSQL").append("\n"); 
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
		query.append("UPDATE 	BKG_BL_DOC G" ).append("\n"); 
		query.append("SET    	UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",		UPD_DT = SYSDATE  " ).append("\n"); 
		query.append(",       BDR_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",       MNL_BDR_UPD_DT = SYSDATE  " ).append("\n"); 
		query.append("#if (${ibflag} == 'D') " ).append("\n"); 
		query.append(",		BDR_FLG  =  'N'" ).append("\n"); 
		query.append(",      	BDR_DT   =	''" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append(",		BDR_FLG  =  'Y'" ).append("\n"); 
		query.append(",      	BDR_DT   =	SYSDATE" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}