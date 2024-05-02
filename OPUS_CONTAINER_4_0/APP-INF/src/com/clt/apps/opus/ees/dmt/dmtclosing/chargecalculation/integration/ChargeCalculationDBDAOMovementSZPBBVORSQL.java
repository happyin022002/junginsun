/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCalculationDBDAOMovementSZPBBVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.20
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.10.20 황효근
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hwang HyoKeun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChargeCalculationDBDAOMovementSZPBBVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public ChargeCalculationDBDAOMovementSZPBBVORSQL(){
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
		params.put("seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration").append("\n"); 
		query.append("FileName : ChargeCalculationDBDAOMovementSZPBBVORSQL").append("\n"); 
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
		query.append("SELECT	@[seq] AS SEQ" ).append("\n"); 
		query.append(",CNTR_NO" ).append("\n"); 
		query.append(",BKG_NO" ).append("\n"); 
		query.append(",ORG_YD_CD		AS TO_MVMT_YD_CD" ).append("\n"); 
		query.append(",TO_CHAR(M.CNMV_EVNT_DT, 'YYYYMMDD') TO_MVMT_DT" ).append("\n"); 
		query.append(",CNMV_YR		AS TO_MVMT_YR" ).append("\n"); 
		query.append(",CNMV_SEQ		AS TO_MVMT_SEQ" ).append("\n"); 
		query.append(",CNMV_SPLIT_NO	AS TO_MVMT_SPLIT_NO" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("FROM CTM_MOVEMENT M" ).append("\n"); 
		query.append("WHERE M.CNTR_NO	= @[cntr_no]" ).append("\n"); 
		query.append("AND M.BKG_NO		= @[bkg_no]" ).append("\n"); 
		query.append("AND M.MVMT_STS_CD = 'ID'" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}