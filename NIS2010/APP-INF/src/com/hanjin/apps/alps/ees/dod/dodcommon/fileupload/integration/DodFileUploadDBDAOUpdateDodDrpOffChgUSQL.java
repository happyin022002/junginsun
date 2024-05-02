/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : DodFileUploadDBDAOUpdateDodDrpOffChgUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.01.07
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2016.01.07 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodcommon.fileupload.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Son, Jin-Hwan
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DodFileUploadDBDAOUpdateDodDrpOffChgUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DOD_DRP_OFF_CHG > ATCH_FILE_LNK_ID Update
	  * </pre>
	  */
	public DodFileUploadDBDAOUpdateDodDrpOffChgUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("atch_file_lnk_id",new String[]{arrTmp[0],arrTmp[1]});

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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drp_off_chg_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.dod.dodcommon.fileupload.integration").append("\n"); 
		query.append("FileName : DodFileUploadDBDAOUpdateDodDrpOffChgUSQL").append("\n"); 
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
		query.append("UPDATE DOD_DRP_OFF_CHG" ).append("\n"); 
		query.append("   SET ATCH_FILE_LNK_ID = @[atch_file_lnk_id]" ).append("\n"); 
		query.append(" WHERE 1=1" ).append("\n"); 
		query.append("   AND BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND CNTR_NO = @[cntr_no]" ).append("\n"); 
		query.append("   AND DRP_OFF_CHG_SEQ = @[drp_off_chg_seq]" ).append("\n"); 

	}
}