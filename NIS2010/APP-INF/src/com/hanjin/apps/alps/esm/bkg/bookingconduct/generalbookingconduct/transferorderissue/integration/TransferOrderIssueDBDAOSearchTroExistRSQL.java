/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TransferOrderIssueDBDAOSearchTroExistRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.19
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2009.11.19 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOSearchTroExistRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransferOrderIssueDBDAOSearchTroExistRSQL
	  * </pre>
	  */
	public TransferOrderIssueDBDAOSearchTroExistRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOSearchTroExistRSQL").append("\n"); 
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
		query.append("SELECT 'GENERAL' STR_RETURN" ).append("\n"); 
		query.append("FROM BKG_TRO TRO" ).append("\n"); 
		query.append(", BKG_BL_DOC BL" ).append("\n"); 
		query.append("WHERE TRO.BKG_NO      = BL.BKG_NO" ).append("\n"); 
		query.append("AND TRO.BKG_NO      = @[bkg_no]" ).append("\n"); 
		query.append("AND TRO.IO_BND_CD   = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND TRO.RTN_TRO_FLG = 'N'" ).append("\n"); 
		query.append("AND ROWNUM          = 1" ).append("\n"); 
		query.append("UNION" ).append("\n"); 
		query.append("SELECT 'EUROPE' STR_RETURN" ).append("\n"); 
		query.append("FROM BKG_EUR_TRO TRO" ).append("\n"); 
		query.append(", BKG_BL_DOC BL" ).append("\n"); 
		query.append("WHERE TRO.BKG_NO      = BL.BKG_NO" ).append("\n"); 
		query.append("AND TRO.BKG_NO      = @[bkg_no]" ).append("\n"); 
		query.append("AND TRO.IO_BND_CD   = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND ROWNUM          = 1" ).append("\n"); 

	}
}