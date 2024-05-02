/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UsaCustomsReportDBDAOsearchReceivedFileRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.29
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.06.29 이수빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Lee Subin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaCustomsReportDBDAOsearchReceivedFileRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ReceivedFileDetailVO
	  * </pre>
	  */
	public UsaCustomsReportDBDAOsearchReceivedFileRSQL(){
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
		params.put("rcv_date",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rcv_seq",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("DTL.CNT_CD" ).append("\n"); 
		query.append(",	DTL.IO_BND_CD" ).append("\n"); 
		query.append(",	DTL.RCV_DT" ).append("\n"); 
		query.append(",	DTL.RCV_SEQ" ).append("\n"); 
		query.append(",	DTL.RCV_MSG_DTL_SEQ AS SEQ_NO" ).append("\n"); 
		query.append(",	DTL.MSG_DESC" ).append("\n"); 
		query.append("FROM BKG_CSTMS_ADV_RCV_LOG LOG, BKG_CSTMS_ADV_RCV_LOG_DTL DTL" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND LOG.CNT_CD = @[cnt_cd]" ).append("\n"); 
		query.append("AND LOG.IO_BND_CD = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND	LOG.RCV_DT = TO_DATE(@[rcv_date], 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("AND	LOG.RCV_SEQ = @[rcv_seq]" ).append("\n"); 
		query.append("AND LOG.CNT_CD = DTL.CNT_CD" ).append("\n"); 
		query.append("AND LOG.IO_BND_CD = DTL.IO_BND_CD" ).append("\n"); 
		query.append("AND	LOG.RCV_DT = DTL.RCV_DT" ).append("\n"); 
		query.append("AND	LOG.RCV_SEQ = DTL.RCV_SEQ" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.esm.bkg.customsdeclaration.customsreport.usa.integration").append("\n"); 
		query.append("FileName : UsaCustomsReportDBDAOsearchReceivedFileRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}