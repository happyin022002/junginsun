/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DisposalMgtDBDAOmodifyDisposalDetailAmountDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.27
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.11.27 박명신
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOmodifyDisposalDetailAmountDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyDisposalDetailAmountData
	  * </pre>
	  */
	public DisposalMgtDBDAOmodifyDisposalDetailAmountDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.integration").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOmodifyDisposalDetailAmountDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_DISP_DTL MDD" ).append("\n"); 
		query.append("SET MDD.PART_AMT = ( SELECT PART_UT_AMT * MDD.DISP_QTY" ).append("\n"); 
		query.append("FROM MNR_DISP_BUYR_DTL_PART MPD" ).append("\n"); 
		query.append("WHERE MDD.DISP_NO = MPD.DISP_NO" ).append("\n"); 
		query.append("AND   MDD.DISP_DTL_SEQ = MPD.DISP_DTL_SEQ" ).append("\n"); 
		query.append("AND   MPD.MNR_DISP_CFM_STS_CD = 'C'" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE MDD.DISP_NO = @[disp_no]" ).append("\n"); 
		query.append("AND EXISTS ( SELECT 'X'" ).append("\n"); 
		query.append("FROM MNR_DISP_BUYR_DTL_PART MPD" ).append("\n"); 
		query.append("WHERE MDD.DISP_NO = MPD.DISP_NO" ).append("\n"); 
		query.append("AND   MDD.DISP_DTL_SEQ = MPD.DISP_DTL_SEQ" ).append("\n"); 
		query.append("AND   MPD.MNR_DISP_CFM_STS_CD = 'C'" ).append("\n"); 
		query.append("AND   ROWNUM = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}