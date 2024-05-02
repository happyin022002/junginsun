/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : QtaAdjustmentDBDAORemoveCfmQtaIasSector2DSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.06.16
*@LastModifier : 최성민
*@LastVersion : 1.0
* 2016.06.16 최성민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author CHOI SUNGMIN
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class QtaAdjustmentDBDAORemoveCfmQtaIasSector2DSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * [CMCB adjust for IAS Sector]을 [생성] 합니다.
	  * SQM_CFM_QTA Insert (overall report에서 조회되도록)
	  * 2015.08.13 [CHM-201537594] CMCB Adjust Creation시 Year, Quarter만을 조건으로 데이터 생성, 삭제 및 수정 되도록 함
	  * 2016.04.22 CHM-201641278 [SQM] IAS Trade 판매목표 수립 Portion 연결 시스템 수정 요청 CSR
	  * </pre>
	  */
	public QtaAdjustmentDBDAORemoveCfmQtaIasSector2DSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_qtr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("f_bse_yr",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.sqm.adjustment.qtaadjustment.integration").append("\n"); 
		query.append("FileName : QtaAdjustmentDBDAORemoveCfmQtaIasSector2DSQL").append("\n"); 
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
		query.append("DELETE " ).append("\n"); 
		query.append("FROM SQM_CFM_QTA" ).append("\n"); 
		query.append("WHERE BSE_TP_CD                = 'Q'" ).append("\n"); 
		query.append("AND SUBSTR(QTA_RLSE_VER_NO,-2) = '02'" ).append("\n"); 
		query.append("AND TRD_CD                     = 'IAS'" ).append("\n"); 
		query.append("AND BSE_YR                     = @[f_bse_yr]" ).append("\n"); 
		query.append("AND BSE_QTR_CD                 = @[f_bse_qtr_cd]" ).append("\n"); 

	}
}