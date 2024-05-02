/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOSearchImdgAmdtNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.29
*@LastModifier : Maeda Atsushi
*@LastVersion : 1.0
* 2015.07.29 Maeda Atsushi
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maeda Atsushi
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOSearchImdgAmdtNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Search IMDG_AMDT_NO
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOSearchImdgAmdtNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOSearchImdgAmdtNoRSQL").append("\n"); 
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
		query.append("SELECT	LISTAGG(IMDG_AMDT_NO, ',') WITHIN GROUP (ORDER BY DECODE(IMDG_AMDT_STND_FLG,'Y','1','N','2','9')) AS IMDG_AMDT_NO" ).append("\n"); 
		query.append("FROM	SCG_IMDG_AMDT_MST" ).append("\n"); 
		query.append("WHERE	ACT_FLG = 'Y' " ).append("\n"); 

	}
}