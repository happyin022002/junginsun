/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAODgPackageVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.07.23
*@LastModifier : 
*@LastVersion : 1.0
* 2010.07.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAODgPackageVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DgPackageVO
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAODgPackageVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_pck_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_pck_desc",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAODgPackageVORSQL").append("\n"); 
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
		query.append("IMDG_PCK_CD" ).append("\n"); 
		query.append(",	IMDG_PCK_DESC" ).append("\n"); 
		query.append(",	IMDG_PCK_TP_CD" ).append("\n"); 
		query.append(",	DELT_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append("FROM SCG_IMDG_PCK_CD" ).append("\n"); 
		query.append("WHERE IMDG_PCK_CD LIKE '%'||@[imdg_pck_cd]||'%'" ).append("\n"); 
		query.append("AND UPPER(IMDG_PCK_DESC) LIKE '%'||UPPER(@[imdg_pck_desc])||'%'" ).append("\n"); 
		query.append("#if (${imdg_pck_tp_cd} =='O' )" ).append("\n"); 
		query.append("AND IMDG_PCK_TP_CD = 'O'" ).append("\n"); 
		query.append("#elseif(${imdg_pck_tp_cd} =='M' )" ).append("\n"); 
		query.append("AND IMDG_PCK_TP_CD = 'M'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND IMDG_PCK_TP_CD = 'I'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND DELT_FLG = 'N'" ).append("\n"); 
		query.append("ORDER BY IMDG_PCK_CD" ).append("\n"); 

	}
}