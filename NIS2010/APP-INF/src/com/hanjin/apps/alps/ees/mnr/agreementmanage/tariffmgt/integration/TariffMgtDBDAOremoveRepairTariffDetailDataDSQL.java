/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TariffMgtDAOremoveRepairTariffDetailDataDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.09
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.06.09 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author WanGyu Kim 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TariffMgtDBDAOremoveRepairTariffDetailDataDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 삭제
	  * </pre>
	  */
	public TariffMgtDBDAOremoveRepairTariffDetailDataDSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("trf_no",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("DELETE FROM MNR_RPR_TRF_DTL" ).append("\n"); 
		query.append("WHERE	TRF_NO = @[trf_no]" ).append("\n"); 
		query.append("AND	TRF_DTL_SEQ = @[trf_dtl_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.agreementmanage.tariffmgt.integration ").append("\n"); 
		query.append("FileName : TariffMgtDAOremoveRepairTariffDetailDataDSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}