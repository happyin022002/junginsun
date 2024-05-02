/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOSearchIsDirFirstView2RSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.22
*@LastModifier : 오현경
*@LastVersion : 1.0
* 2010.03.22 오현경
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Oh hyun-kyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOSearchIsDirFirstView2RSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchIsDirFirstView2
	  * </pre>
	  */
	public Edi315SendDBDAOSearchIsDirFirstView2RSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_sts_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("chk_sts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_group_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOSearchIsDirFirstView2RSQL").append("\n"); 
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
		query.append("select  nvl(count(EDI_GRP_CD), 0) send_cnt" ).append("\n"); 
		query.append("from    SCE_EDI_SND_RSLT" ).append("\n"); 
		query.append("where   EDI_GRP_CD  = @[edi_group_cd]" ).append("\n"); 
		query.append("and     EDI_STS_CD  = @[chk_sts]" ).append("\n"); 
		query.append("and     CNTR_NO     = @[cntr_no]" ).append("\n"); 
		query.append("AND     BKG_NO      = @[bkg_no]" ).append("\n"); 
		query.append("AND     case when @[sub_sts_cd] = 'OA' and EDI_SUB_STS_CD <> 'OA'" ).append("\n"); 
		query.append("THEN 'N'" ).append("\n"); 
		query.append("WHEN @[sub_sts_cd] = 'OA' and EDI_SUB_STS_CD = 'OA'" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("WHEN @[sub_sts_cd] <> 'OA' AND EDI_SUB_STS_CD <> 'OA'" ).append("\n"); 
		query.append("THEN 'Y'" ).append("\n"); 
		query.append("WHEN @[sub_sts_cd] <> 'OA' AND EDI_SUB_STS_CD = 'OA'" ).append("\n"); 
		query.append("THEN 'N'" ).append("\n"); 
		query.append("END = 'Y'" ).append("\n"); 
		query.append("" ).append("\n"); 

	}
}