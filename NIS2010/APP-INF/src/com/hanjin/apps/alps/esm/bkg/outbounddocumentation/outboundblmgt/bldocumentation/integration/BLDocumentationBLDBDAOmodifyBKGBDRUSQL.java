/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : BLDocumentationBLDBDAOmodifyBKGBDRUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.01.15
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2013.01.15 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
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
	  * 2010.09.01 김영철 [CHM-201004943-01] BDR 로직보완 ( Manual BDR이 되면 DB에 로그를 남김 )
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
		params.put("ibflag",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration").append("\n"); 
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
		query.append("#if (${hisFlg} == 'Y') " ).append("\n"); 
		query.append("UPDATE 	BKG_BL_DOC_HIS G" ).append("\n"); 
		query.append("SET     UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("UPDATE 	BKG_BL_DOC G" ).append("\n"); 
		query.append("SET    	BDR_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",       MNL_BDR_UPD_DT = SYSDATE  " ).append("\n"); 
		query.append(",       UPD_USR_ID = @[upd_usr_id] " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(",		UPD_DT = SYSDATE  " ).append("\n"); 
		query.append(",		BDR_FLG  =  DECODE(@[ibflag],'D','N','Y')" ).append("\n"); 
		query.append(",      	BDR_DT   =	DECODE(@[ibflag],'D','',SYSDATE)" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${hisFlg} == 'Y') " ).append("\n"); 
		query.append(" AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}