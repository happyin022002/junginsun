/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLDocumentationBLDBDAOmodifyBKGBDRRHQUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.07.04
*@LastModifier : 
*@LastVersion : 1.0
* 2016.07.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLDocumentationBLDBDAOmodifyBKGBDRRHQUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * RHQ를 위한 update 
	  * cancel 한 id, date, reason code, remark를 업데이트 한다
	  * </pre>
	  */
	public BLDocumentationBLDBDAOmodifyBKGBDRRHQUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bdr_rsn_rmk",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bdr_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.integration ").append("\n"); 
		query.append("FileName : BLDocumentationBLDBDAOmodifyBKGBDRRHQUSQL").append("\n"); 
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
		query.append(",       BDR_CXL_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",       BDR_CXL_DT = SYSDATE" ).append("\n"); 
		query.append(",       BDR_RSN_CD = @[bdr_rsn_cd]" ).append("\n"); 
		query.append(",       BDR_RSN_RMK = @[bdr_rsn_rmk]" ).append("\n"); 
		query.append(",		UPD_DT = SYSDATE  " ).append("\n"); 
		query.append(",		BDR_FLG  =  DECODE(@[ibflag],'D','N','Y')" ).append("\n"); 
		query.append(",      	BDR_DT   =	DECODE(@[ibflag],'D','',SYSDATE)" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${hisFlg} == 'Y') " ).append("\n"); 
		query.append(" AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}