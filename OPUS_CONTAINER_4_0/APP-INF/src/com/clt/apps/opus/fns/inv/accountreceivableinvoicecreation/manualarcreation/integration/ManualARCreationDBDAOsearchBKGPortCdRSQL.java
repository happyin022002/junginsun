/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ManualARCreationDBDAOsearchBKGPortCdRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.23
*@LastModifier : 정휘택
*@LastVersion : 1.0
* 2009.06.23 정휘택
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jung Hwi Taek
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualARCreationDBDAOsearchBKGPortCdRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBKGPortCd
	  * </pre>
	  */
	public ManualARCreationDBDAOsearchBKGPortCdRSQL(){
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
		params.put("bnd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT NVL(DECODE(@[bnd], 'O', BV.POL_CD, BV.POD_CD), '') PORT" ).append("\n"); 
		query.append("FROM   BKG_VVD BV, BKG_BOOKING BKG" ).append("\n"); 
		query.append("WHERE  BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    BKG.BKG_NO = BV.BKG_NO" ).append("\n"); 
		query.append("AND    DECODE(@[bnd], 'O', BKG.POL_CD, BKG.POD_CD) = DECODE(@[bnd], 'O', BV.POL_CD, BV.POD_CD)" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.manualarcreation.integration").append("\n"); 
		query.append("FileName : ManualARCreationDBDAOsearchBKGPortCdRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}