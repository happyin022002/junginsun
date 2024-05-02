/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : CopDetailReceiveDBDAOSearchEdiVEDRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.31
*@LastModifier : 
*@LastVersion : 1.0
* 2013.10.31 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.copdetailreceive.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CopDetailReceiveDBDAOSearchEdiVEDRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchEdiVED
	  * </pre>
	  */
	public CopDetailReceiveDBDAOSearchEdiVEDRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("clpt_ind_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vps_port_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.copdetailreceive.integration").append("\n"); 
		query.append("FileName : CopDetailReceiveDBDAOSearchEdiVEDRSQL").append("\n"); 
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
		query.append("SELECT  a.cop_no" ).append("\n"); 
		query.append("        ,a.cop_dtl_seq " ).append("\n"); 
		query.append("        ,b.cntr_no " ).append("\n"); 
		query.append("        ,DECODE(a.STND_EDI_STS_CD, 'VAD', 'VE', 'VDL', 'VDE', 'VDT', 'VET' ,'VAT', 'VETS') edi_sts" ).append("\n"); 
		query.append("        ,b.bkg_no " ).append("\n"); 
		query.append("        ,a.nod_cd " ).append("\n"); 
		query.append("FROM   sce_cop_dtl a          " ).append("\n"); 
		query.append("      ,sce_cop_hdr b" ).append("\n"); 
		query.append("WHERE  a.vsl_cd       = @[vsl_cd]  " ).append("\n"); 
		query.append("AND    a.skd_voy_no   = @[skd_voy_no] " ).append("\n"); 
		query.append("AND    a.skd_dir_cd   = @[skd_dir_cd]  " ).append("\n"); 
		query.append("AND    SUBSTR(a.nod_cd,1,5)    = @[vps_port_cd] " ).append("\n"); 
		query.append("#if (${event_tp_cd} == 'ETA' )" ).append("\n"); 
		query.append("AND    a.STND_EDI_STS_CD IN ('VAD', 'VAT')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${event_tp_cd} == 'ETD' )" ).append("\n"); 
		query.append("AND    a.STND_EDI_STS_CD IN ('VDL', 'VDT')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND    NVL(a.clpt_ind_seq,'1') = NVL(@[clpt_ind_seq],'1')" ).append("\n"); 
		query.append("AND    b.cop_no       = a.cop_no" ).append("\n"); 
		query.append("AND    b.cop_sts_cd   IN ('C','T')" ).append("\n"); 
		query.append("AND    b.cntr_no      <> 'COMU0000000'" ).append("\n"); 

	}
}