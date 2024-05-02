/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : DOFChgTrfmanageDBDAOmultiDrffChgTrfDtlDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.04.04
*@LastModifier : 민정호
*@LastVersion : 1.0
* 2012.04.04 민정호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.eas.transportmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Min Jung Ho
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DOFChgTrfmanageDBDAOmultiDrffChgTrfDtlDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Drop Off Charge Tariff 삭제
	  * </pre>
	  */
	public DOFChgTrfmanageDBDAOmultiDrffChgTrfDtlDSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drff_chg_trf_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drff_chg_trf_ver_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("drff_chg_trf_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.eas.transportmanage.integration").append("\n"); 
		query.append("FileName : DOFChgTrfmanageDBDAOmultiDrffChgTrfDtlDSQL").append("\n"); 
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
		query.append("delete from EAS_DRFF_CHG_TRF_DTL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND DRFF_CHG_TRF_SEQ = @[drff_chg_trf_seq]" ).append("\n"); 
		query.append("AND DRFF_CHG_TRF_VER_NO = @[drff_chg_trf_ver_no]" ).append("\n"); 
		query.append("#if (${isUpload} == 'N')" ).append("\n"); 
		query.append("AND DRFF_CHG_TRF_DTL_SEQ = @[drff_chg_trf_dtl_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}