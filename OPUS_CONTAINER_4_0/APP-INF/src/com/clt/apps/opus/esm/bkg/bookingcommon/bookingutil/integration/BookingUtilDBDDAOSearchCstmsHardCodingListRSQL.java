/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BookingUtilDBDDAOSearchCstmsHardCodingListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.04
*@LastModifier : 
*@LastVersion : 1.0
* 2014.09.04 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDDAOSearchCstmsHardCodingListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *  ANCS Main Menu 관련 ESM_BKG_0044,0494,0965,0970 화면의 POD조회
	  * </pre>
	  */
	public BookingUtilDBDDAOSearchCstmsHardCodingListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("cstms_div_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDDAOSearchCstmsHardCodingListRSQL").append("\n"); 
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
		query.append("SELECT CSTMS_DIV_ID,CNT_CD,ATTR_CTNT1 AS POD_CD" ).append("\n"); 
		query.append("FROM BKG_CSTMS_CD_CONV_CTNT " ).append("\n"); 
		query.append("WHERE CNT_CD =@[cnt_cd]" ).append("\n"); 
		query.append("AND CSTMS_DIV_ID = @[cstms_div_id]" ).append("\n"); 
		query.append("AND CSTMS_DIV_ID_SEQ > 0 " ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 

	}
}