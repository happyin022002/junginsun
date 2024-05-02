/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : BookingInterfaceMgtDAOSearchBkgInfoForINV_2RSQL.java
*@FileTitle : 11111
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.22
*@LastModifier : 김기종
*@LastVersion : 1.0
* 2009.10.22 김기종
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinginterfacemgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Ki Jong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BookingInterfaceMgtDAOSearchBkgInfoForINV_2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG ==> INV
	  * CONTAINER 정보 조회
	  * </pre>
	  */
	public BookingInterfaceMgtDAOSearchBkgInfoForINV_2RSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinginterfacemgt.integration").append("\n"); 
		query.append("FileName : BookingInterfaceMgtDAOSearchBkgInfoForINV_2RSQL").append("\n"); 
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
		query.append("SELECT	BKG_NO" ).append("\n"); 
		query.append(",		BKG_NO_SEQ" ).append("\n"); 
		query.append(",		CNTR_NO" ).append("\n"); 
		query.append(",		CNTR_NO_SEQ" ).append("\n"); 
		query.append(",		CNTR_TPSZ_CD" ).append("\n"); 
		query.append("FROM	table(BKG_INV_IF_PKG.BKG_IF_CONTAINER_TBL_FUNC(@[bkg_no]))" ).append("\n"); 

	}
}