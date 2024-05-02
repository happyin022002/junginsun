/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BlRatingDBDAOMoidfyOftPrecheckResultUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.12.07
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.12.07 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BlRatingDBDAOMoidfyOftPrecheckResultUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OFT Rating 가능여부, 사용자, 날짜를 BKG RATE에 저장한다.
	  * </pre>
	  */
	public BlRatingDBDAOMoidfyOftPrecheckResultUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("oft_mss_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.blrating.blrating.integration ").append("\n"); 
		query.append("FileName : BlRatingDBDAOMoidfyOftPrecheckResultUSQL").append("\n"); 
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
		query.append("#if(${ca_flg} == 'Y') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    UPDATE BKG_RT_HIS" ).append("\n"); 
		query.append("       SET OFT_MSS_FLG = @[oft_mss_flg]," ).append("\n"); 
		query.append("           OFT_CHK_USR_ID = @[usr_id]," ).append("\n"); 
		query.append("           OFT_CHK_DT = sysdate" ).append("\n"); 
		query.append("    WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("      " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("    UPDATE BKG_RATE" ).append("\n"); 
		query.append("       SET OFT_MSS_FLG = @[oft_mss_flg]," ).append("\n"); 
		query.append("           OFT_CHK_USR_ID = @[usr_id]," ).append("\n"); 
		query.append("           OFT_CHK_DT = sysdate" ).append("\n"); 
		query.append("    WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    " ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}