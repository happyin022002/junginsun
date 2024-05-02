/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DisposalMgtDBDAOremoveDisposalSoldDetailbyDTLSeqDataDSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.23
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.11.23 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author park myoung sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class DisposalMgtDBDAOremoveDisposalSoldDetailbyDTLSeqDataDSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * removeDisposalSoldDetailbyDTLSeqData
	  * </pre>
	  */
	public DisposalMgtDBDAOremoveDisposalSoldDetailbyDTLSeqDataDSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_dtl_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.integration ").append("\n"); 
		query.append("FileName : DisposalMgtDBDAOremoveDisposalSoldDetailbyDTLSeqDataDSQL").append("\n"); 
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
		query.append("DELETE FROM MNR_DISP_DTL A" ).append("\n"); 
		query.append("WHERE DISP_NO = @[disp_no]" ).append("\n"); 
		query.append("AND   DISP_DTL_SEQ = @[disp_dtl_seq]" ).append("\n"); 

	}
}