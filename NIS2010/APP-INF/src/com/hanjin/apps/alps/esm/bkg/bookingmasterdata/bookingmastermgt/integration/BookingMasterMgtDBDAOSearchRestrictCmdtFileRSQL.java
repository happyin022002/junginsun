/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BookingMasterMgtDBDAOSearchRestrictCmdtFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.11.16
*@LastModifier : 
*@LastVersion : 1.0
* 2011.11.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingMasterMgtDBDAOSearchRestrictCmdtFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_IMP_IMG_STO 조회
	  * </pre>
	  */
	public BookingMasterMgtDBDAOSearchRestrictCmdtFileRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("loc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dp_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingmasterdata.bookingmastermgt.integration").append("\n"); 
		query.append("FileName : BookingMasterMgtDBDAOSearchRestrictCmdtFileRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("RGN_OFC_CD" ).append("\n"); 
		query.append(",DECODE(LOC_CD,'*****','ALL',LOC_CD) LOC_CD" ).append("\n"); 
		query.append(",DP_SEQ" ).append("\n"); 
		query.append(",IMG_SEQ" ).append("\n"); 
		query.append(",FILE_NM" ).append("\n"); 
		query.append(",FILE_SIZE" ).append("\n"); 
		query.append(",FILE_SAV_ID" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("MIN(IMG.RGN_OFC_CD) AS RGN_OFC_CD" ).append("\n"); 
		query.append(",MIN(IMG.LOC_CD) AS LOC_CD" ).append("\n"); 
		query.append(",MIN(IMG.DP_SEQ) AS DP_SEQ" ).append("\n"); 
		query.append(",MIN(IMG.IMG_SEQ) AS IMG_SEQ" ).append("\n"); 
		query.append(",MIN(IMG.FILE_NM) AS FILE_NM" ).append("\n"); 
		query.append(",MIN(UPLD.FILE_SZ_CAPA) AS FILE_SIZE" ).append("\n"); 
		query.append(",IMG.FILE_SAV_ID AS FILE_SAV_ID" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("BKG_IMP_IMG_STO IMG, COM_UPLD_FILE UPLD" ).append("\n"); 
		query.append("WHERE    IMG.FILE_SAV_ID = UPLD.FILE_SAV_ID(+)" ).append("\n"); 
		query.append("AND IMG.RGN_OFC_CD = @[rgn_ofc_cd]" ).append("\n"); 
		query.append("AND IMG.LOC_CD     = DECODE(@[loc_cd],'ALL','*****',@[loc_cd])" ).append("\n"); 
		query.append("AND IMG.CNT_CD     = @[cnt_cd]" ).append("\n"); 
		query.append("AND IMG.DP_SEQ     = @[dp_seq]" ).append("\n"); 
		query.append("GROUP BY IMG.FILE_SAV_ID" ).append("\n"); 
		query.append(") MAIN_TABLE" ).append("\n"); 

	}
}