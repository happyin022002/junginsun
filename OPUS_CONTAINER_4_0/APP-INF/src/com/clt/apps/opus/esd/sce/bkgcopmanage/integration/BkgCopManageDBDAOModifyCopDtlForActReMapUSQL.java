/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BkgCopManageDBDAOModifyCopDtlForActReMapUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.24
*@LastModifier : 김인수
*@LastVersion : 1.0
* 2010.02.24 김인수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.bkgcopmanage.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim In-soo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BkgCopManageDBDAOModifyCopDtlForActReMapUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * split 에서 bkg_no 만 cop 에서 변경 될 때 Actual 을 재 mapping 하고 edi 재 전송을 시도하기 위하여 cop detail 의 actual mapping 내역을
	  * null 로 update
	  * </pre>
	  */
	public BkgCopManageDBDAOModifyCopDtlForActReMapUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cop_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.bkgcopmanage.integration ").append("\n"); 
		query.append("FileName : BkgCopManageDBDAOModifyCopDtlForActReMapUSQL").append("\n"); 
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
		query.append("UPDATE SCE_COP_DTL" ).append("\n"); 
		query.append("SET ACT_DT = '' ," ).append("\n"); 
		query.append("ACT_STS_CD = (CASE WHEN COP_DTL_SEQ=(" ).append("\n"); 
		query.append("SELECT MIN(COP_DTL_SEQ)" ).append("\n"); 
		query.append("FROM SCE_COP_DTL" ).append("\n"); 
		query.append("WHERE cop_no = @[cop_no]) THEN 'C' ELSE 'N' END) ," ).append("\n"); 
		query.append("ACT_RCV_TP_CD = '' ," ).append("\n"); 
		query.append("EDI_SND_TP_CD = '' ," ).append("\n"); 
		query.append("VNDR_SEQ = '' ," ).append("\n"); 
		query.append("EDI_MSG_TP_CD='' ," ).append("\n"); 
		query.append("ACT_STS_MAPG_CD = '' ," ).append("\n"); 
		query.append("EDI_ACT_SND_DT = '' ," ).append("\n"); 
		query.append("ACT_DAT_RCV_DT = ''" ).append("\n"); 
		query.append("WHERE cop_no = @[cop_no]" ).append("\n"); 

	}
}