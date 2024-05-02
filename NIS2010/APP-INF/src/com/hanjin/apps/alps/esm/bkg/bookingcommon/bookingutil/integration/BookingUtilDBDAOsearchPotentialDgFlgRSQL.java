/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BookingUtilDBDAOsearchPotentialDgFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.26
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingUtilDBDAOsearchPotentialDgFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Potential DG 화물 목록을 체크한다
	  * </pre>
	  */
	public BookingUtilDBDAOsearchPotentialDgFlgRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.integration").append("\n"); 
		query.append("FileName : BookingUtilDBDAOsearchPotentialDgFlgRSQL").append("\n"); 
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
		query.append("SELECT DECODE(COUNT(*),0,'N','Y') RSLT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT BHCC.*" ).append("\n"); 
		query.append("    FROM BKG_BLCK_KW_LIST BHCC" ).append("\n"); 
		query.append("         ,BKG_BL_DOC BBD" ).append("\n"); 
		query.append("    WHERE	BLCK_KW_TP_CD = 'POT'" ).append("\n"); 
		query.append("    AND BBD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    AND UPPER(BBD.CSTMS_DESC) LIKE '%'||BHCC.BLCK_KW_NM||'%'" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT BHCC.*" ).append("\n"); 
		query.append("    FROM BKG_BLCK_KW_LIST BHCC" ).append("\n"); 
		query.append("         ,BKG_BL_MK_DESC BBM" ).append("\n"); 
		query.append("    WHERE	BLCK_KW_TP_CD = 'POT'" ).append("\n"); 
		query.append("    AND BBM.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    AND UPPER(BBM.CMDT_DESC) LIKE '%'||BHCC.BLCK_KW_NM||'%'" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT BHCC.*" ).append("\n"); 
		query.append("    FROM BKG_BLCK_KW_LIST BHCC" ).append("\n"); 
		query.append("         ,BKG_CNTR_MF_DESC BBMD" ).append("\n"); 
		query.append("    WHERE	BLCK_KW_TP_CD = 'POT'" ).append("\n"); 
		query.append("    AND BBMD.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    AND UPPER(BBMD.CNTR_MF_GDS_DESC) LIKE '%'||BHCC.BLCK_KW_NM||'%'" ).append("\n"); 
		query.append("    )" ).append("\n"); 

	}
}