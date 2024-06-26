/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : BookingUtilDBDAOSearchBkgBlNoVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.08
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2015.01.08 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOSearchBkgBlNoVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * bkg별 BDR, C/A 상태 조회
	  * </pre>
	  */
	public BookingUtilDBDAOSearchBkgBlNoVORSQL(){
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
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOSearchBkgBlNoVORSQL").append("\n"); 
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
		query.append("SELECT BK.BKG_NO" ).append("\n"); 
		query.append(",      BK.XTER_BKG_RQST_REF_NO" ).append("\n"); 
		query.append(",	   '' NCB_NO" ).append("\n"); 
		query.append(",      BK.BL_NO" ).append("\n"); 
		query.append(",      BL.BDR_FLG" ).append("\n"); 
		query.append(",      DECODE(NVL(BL.CORR_NO, 'N'), 'N', 'N', DECODE(BL.CORR_USR_ID, @[ca_usr_id], 'Y', 'N')) CA_FLG" ).append("\n"); 
		query.append(",	   BL.CORR_USR_ID 	CA_USR_ID" ).append("\n"); 
		query.append(",      BL.CORR_NO 		CA_NO" ).append("\n"); 
		query.append(",      BK.BL_TP_CD" ).append("\n"); 
		query.append(",      BK.BKG_STS_CD" ).append("\n"); 
		query.append(",      '' BL_NO_CHK" ).append("\n"); 
		query.append(",      BK.PCTL_NO" ).append("\n"); 
		query.append(",	   '' MAP_SEQ" ).append("\n"); 
		query.append(",      NVL(( SELECT 'Y' " ).append("\n"); 
		query.append("               FROM BKG_CORRECTION" ).append("\n"); 
		query.append("              WHERE BKG_NO  = BK.BKG_NO" ).append("\n"); 
		query.append("                AND CORR_NO != 'TMP0000001' " ).append("\n"); 
		query.append("                AND ROWNUM = 1), 'N') CA_EXIST_FLG" ).append("\n"); 
		query.append(",      '' POL_CD" ).append("\n"); 
		query.append("FROM   BKG_BOOKING BK" ).append("\n"); 
		query.append("     , BKG_BL_DOC BL" ).append("\n"); 
		query.append("WHERE  BK.BKG_NO = BL.BKG_NO" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("AND    BK.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#else " ).append("\n"); 
		query.append("AND    BK.BL_NO = SUBSTR(@[bl_no], 1, 12)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}